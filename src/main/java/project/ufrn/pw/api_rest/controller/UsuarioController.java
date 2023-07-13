package project.ufrn.pw.api_rest.controller;

import org.springframework.web.bind.annotation.*;

import project.ufrn.pw.api_rest.domain.Usuario;
import project.ufrn.pw.api_rest.domain.Usuario.DtoResponse;
import project.ufrn.pw.api_rest.repository.UsuarioRepository;
import project.ufrn.pw.api_rest.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import java.util.List;

/*
    login token
  "username": "bruno",
  "password": "bruno123"
*/

/*
    cadastrar usuario
  "username": "bruno",
  "login": "bruno",
  "password": "password",
  "isAdmin": true
 */

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    UsuarioService service;
    UsuarioRepository repository;
    ModelMapper mapper;

    public UsuarioController(UsuarioService service, ModelMapper mapper, UsuarioRepository repository) {
        this.service = service;
        this.mapper = mapper;
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario.DtoResponse create(@RequestBody Usuario.DtoRequest u) {
        Usuario usuario = this.service.create(Usuario.DtoRequest.convertToEntity(u, mapper));
        this.service.createUsuario(usuario);
        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
        response.generateLinks(usuario.getId());

        return response;
    }

    @GetMapping
    public List<DtoResponse> list(){
        return this.service.list().stream().map(
                elementoAtual -> {
                    Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(elementoAtual, mapper);
                    response.generateLinks(elementoAtual.getId());
                    return response;
                }).toList();
    }

    @GetMapping("{id}")
    public Usuario.DtoResponse getById(@PathVariable Long id){
        Usuario usuario = this.service.getById(id);
        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
        response.generateLinks(usuario.getId());

        return response;
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return repository.findById(id)
                .map(u -> {
                    if (usuario.getUsername() != null) {
                    u.setUsername(usuario.getUsername());
                    }
                    if (usuario.getLogin() != null) {
                    u.setLogin(usuario.getLogin());
                    }
                    if (usuario.getPassword() != null) {
                    u.setPassword(usuario.getPassword());
                    }
                    return repository.save(u);
                }).orElseThrow();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}

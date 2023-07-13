package project.ufrn.pw.api_rest.repository;

import org.springframework.security.core.userdetails.UserDetails;
import project.ufrn.pw.api_rest.domain.Usuario;

public interface UsuarioRepository extends IGenericRepository<Usuario>{
    UserDetails findByLogin(String login);
 
    // @Query("Select rua from endereco, usuario where usuario.id = ?")
    // String findById(Long id);
}

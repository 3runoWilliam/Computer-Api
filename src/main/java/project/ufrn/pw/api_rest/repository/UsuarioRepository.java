package project.ufrn.pw.api_rest.repository;

import project.ufrn.pw.api_rest.domain.Pedido;
import project.ufrn.pw.api_rest.domain.Usuario;

public interface UsuarioRepository extends IGenericRepository<Usuario>{

    Pedido saveAndFlush(Pedido c);
    
}

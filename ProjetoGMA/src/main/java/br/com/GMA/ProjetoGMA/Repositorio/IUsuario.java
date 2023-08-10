package br.com.GMA.ProjetoGMA.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import br.com.GMA.ProjetoGMA.model.Usuario;


public interface IUsuario extends CrudRepository<Usuario,Integer> {
	@Query(value = "select * from usuario where email = :email and senha = :senha",nativeQuery = true)
	public Usuario login (String email, String senha);
	
	@Query(value = "select * from usuario where email = :email",nativeQuery = true)
	public Usuario cadastroEmail (String email);
	
	@Query(value = "select * from usuario where nick = :nick",nativeQuery = true)
	public Usuario cadastroNick (String nick);
}

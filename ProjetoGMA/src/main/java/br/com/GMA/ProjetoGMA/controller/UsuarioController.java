package br.com.GMA.ProjetoGMA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import br.com.GMA.ProjetoGMA.Repositorio.IUsuario;
import br.com.GMA.ProjetoGMA.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuario repo;
	
	//lista os usuarios cadastrados no banco
	@GetMapping
	public List<Usuario> listaUsuarios (){
		return (List<Usuario>) repo.findAll();
	}
	
	
	//cadastra um usuario no banco
	//ainda falta fazer as validações corretamente 
	@PostMapping("/cadastro")
	public String cadastroUsuario(@RequestBody Usuario usuario) {
		if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || usuario.getNick().isEmpty()) {
			return "preencha os campos obrigatorios";
		}
		Usuario cadastroUsuarioEmail = this.repo.cadastroEmail(usuario.getEmail());
		Usuario cadastroUsuarioNick = this.repo.cadastroNick(usuario.getNick());
		
		if(cadastroUsuarioEmail == null && cadastroUsuarioNick == null) {
		repo.save(usuario);
		return "cadastro feito com sucesso ,redirect:/pagina do front ";
		}else
			if(cadastroUsuarioEmail != null)
				return "email ja existe";
			return "nick ja existe";
		
	}
	
	
	//verifica o login 
	@PostMapping("/login")
	public String loginUsuario(@RequestBody Usuario usuario) {
		Usuario loginUsuario = this.repo.login(usuario.getEmail(),usuario.getSenha());
		if(loginUsuario != null)
		return "login efetuado, redirect:/pagina do front";
		else
			return "usuario ou senha invalidos(vai retorna em um model com o erro)";
	}
	
	
	//altera um dado de um usuario
	@PutMapping("/alterar")
	public String alterarUsuario(@RequestBody Usuario usuario) {
		if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || usuario.getNick().isEmpty()) {
			return "preencha os campos obrigatorios";
		}
		
		
		repo.save(usuario);
		return "alteração feita com sucesso ,redirect:/pagina do front";
	}
	
	//deleta um usuario
	@DeleteMapping("/excluir/{id}")
	public String DeletarUsuario(@PathVariable Integer id) {
		repo.deleteById(id);
		return "usuario removido , redirect:/pagina do front";
	}
	
	
}

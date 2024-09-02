package dsw.primeiro_projeto.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsw.primeiro_projeto.jpa.PostagemRepository;
import dsw.primeiro_projeto.jpa.UsuarioRepository;
import jakarta.validation.Valid;



@RestController
public class UsuarioResource {
	private UsuarioRepository usuarioRepository;
	private PostagemRepository postagemRepository;
	
	
	public UsuarioResource(UsuarioRepository usuarioRepository,
						   PostagemRepository postagemRepository) {
		this.usuarioRepository = usuarioRepository;
		this.postagemRepository = postagemRepository;
	}

	@GetMapping("/users")
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
		
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user) {
		Usuario savedUser = usuarioRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Postagem> listarPostagensDeUsuario(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get().getPostagens();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Postagem> criarPostagemDeUsuario(@PathVariable int id, 
			                                               @RequestBody Postagem postagem){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		postagem.setUsuario(usuario.get());
		Postagem postagemSaved = postagemRepository.save(postagem);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(postagemSaved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

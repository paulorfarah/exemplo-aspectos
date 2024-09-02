package dsw.primeiro_projeto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.primeiro_projeto.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

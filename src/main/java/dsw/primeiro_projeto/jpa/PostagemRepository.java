package dsw.primeiro_projeto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.primeiro_projeto.user.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Integer>{

}

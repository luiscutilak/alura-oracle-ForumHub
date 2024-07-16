package br.com.alura.forumhub.domain.topico;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByStatusTrue(Pageable paginacao);
=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

>>>>>>> origin/main
}

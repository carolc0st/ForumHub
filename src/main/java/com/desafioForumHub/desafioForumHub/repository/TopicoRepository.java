package com.desafioForumHub.desafioForumHub.repository;


import com.desafioForumHub.desafioForumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}


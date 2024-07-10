package com.desafioForumHub.desafioForumHub.service;

import com.desafioForumHub.desafioForumHub.model.Topico;
import com.desafioForumHub.desafioForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico createTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> getAllTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> getTopicoById(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico updateTopico(Long id, Topico topicoDetails) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setTitulo(topicoDetails.getTitulo());
        topico.setMensagem(topicoDetails.getMensagem());
        topico.setAutor(topicoDetails.getAutor());
        return topicoRepository.save(topico);
    }

    public void deleteTopico(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topicoRepository.delete(topico);
    }
}

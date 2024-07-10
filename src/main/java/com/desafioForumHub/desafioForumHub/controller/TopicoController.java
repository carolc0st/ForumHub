package com.desafioForumHub.desafioForumHub.controller;


import com.desafioForumHub.desafioForumHub.model.Topico;
import com.desafioForumHub.desafioForumHub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> createTopico(@RequestBody Topico topico) {
        Topico createdTopico = topicoService.createTopico(topico);
        return ResponseEntity.ok(createdTopico);
    }

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoService.getAllTopicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoById(@PathVariable Long id) {
        Topico topico = topicoService.getTopicoById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topicoDetails) {
        Topico updatedTopico = topicoService.updateTopico(id, topicoDetails);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        topicoService.deleteTopico(id);
        return ResponseEntity.noContent().build();
    }
}


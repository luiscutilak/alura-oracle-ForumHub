package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topico.DadosRegistroTopico;
import br.com.alura.forumhub.domain.topico.DadosRespostaTopico;
import br.com.alura.forumhub.domain.topico.ITopicoRepository;
import br.com.alura.forumhub.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    private ITopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DadosRespostaTopico> registrarTopico(@RequestBody @Valid DadosRegistroTopico dadosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(dadosRegistroTopico));
        DadosRespostaTopico dadosRespostaTopico = new DadosRespostaTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dadosRespostaTopico);
    }




}

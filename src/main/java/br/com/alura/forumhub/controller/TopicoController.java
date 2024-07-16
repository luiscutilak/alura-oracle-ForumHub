package br.com.alura.forumhub.controller;

<<<<<<< HEAD
import br.com.alura.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
=======
import br.com.alura.forumhub.domain.topico.DadosRegistroTopico;
import br.com.alura.forumhub.domain.topico.DadosRespostaTopico;
import br.com.alura.forumhub.domain.topico.ITopicoRepository;
import br.com.alura.forumhub.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/main
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
<<<<<<< HEAD
    public ResponseEntity<DadosRespostaTopico>
    registrarTopico(@RequestBody @Valid DadosRegistroTopico dadosRegistroTopico,
                    UriComponentsBuilder uriComponentsBuilder){
=======
    public ResponseEntity<DadosRespostaTopico> registrarTopico(@RequestBody @Valid DadosRegistroTopico dadosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
>>>>>>> origin/main
        Topico topico = topicoRepository.save(new Topico(dadosRegistroTopico));
        DadosRespostaTopico dadosRespostaTopico = new DadosRespostaTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dadosRespostaTopico);
    }

<<<<<<< HEAD
    @GetMapping("/lista")
    public ResponseEntity<Page<DadosListaTopico>>
    listarTopicos(@PageableDefault(size = 4) Pageable paginacao){
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacao)
                .map(DadosListaTopico::new));
    }
=======


>>>>>>> origin/main

}

package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<DadosRespostaTopico>
    registrarTopico(@RequestBody @Valid DadosRegistroTopico dadosRegistroTopico,
                    UriComponentsBuilder uriComponentsBuilder){
       Topico topico = topicoRepository.save(new Topico(dadosRegistroTopico));
        DadosRespostaTopico dadosRespostaTopico = new DadosRespostaTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dadosRespostaTopico);
    }

    @GetMapping("/lista")
    public ResponseEntity<Page<DadosListaTopico>>
    listarTopicos(@PageableDefault(size = 4) Pageable paginacao){
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacao)
                .map(DadosListaTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosRespostaTopico> modificarTopico(@RequestBody @Valid DadosAtualizarTopico dadosAtualizarTopico){
        Topico topico = topicoRepository.getReferenceById(dadosAtualizarTopico.id());
        topico.atualizarTopico(dadosAtualizarTopico);
        return ResponseEntity.ok(new DadosRespostaTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosRespostaTopico> retornarDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var dadosTopico = new DadosRespostaTopico(topico);
        return ResponseEntity.ok(dadosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.excluirTopico();
        return ResponseEntity.noContent().build();
    }

}

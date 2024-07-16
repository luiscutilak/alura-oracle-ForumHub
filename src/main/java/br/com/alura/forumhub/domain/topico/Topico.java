package br.com.alura.forumhub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    @Entity(name = "Topico")
    @Table(name = "topicos")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Topico {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String mensagem;
        private String data;
        private Boolean status;
        private int autor;
        private String curso;

        public Topico(DadosRegistroTopico dadosRegistroTopico){
            this.titulo = dadosRegistroTopico.titulo();
            this.mensagem = dadosRegistroTopico.mensagem();
            LocalDateTime dataAtual = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
            this.data = dataAtual.format(formatador);
            this.status = true;
            this.autor = dadosRegistroTopico.autor();
            this.curso = dadosRegistroTopico.curso();
        }

        public void atualizarTopico(DadosAtualizarTopico dadosAtualizarTopico) {
            if(dadosAtualizarTopico.titulo() != null)
                this.titulo = dadosAtualizarTopico.titulo();
            if(dadosAtualizarTopico.mensagem() != null)
                this.mensagem = dadosAtualizarTopico.mensagem();
        }
    }

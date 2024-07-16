package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem
) {
}

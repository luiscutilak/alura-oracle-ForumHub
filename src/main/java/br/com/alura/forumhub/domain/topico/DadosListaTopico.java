package br.com.alura.forumhub.domain.topico;

public record DadosListaTopico(
        Long id,
        String titulo,
        String mensagem,
        String data
) {


    public DadosListaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData());
    }
}

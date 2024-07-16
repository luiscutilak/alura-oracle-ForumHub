package br.com.alura.forumhub.domain.topico;

public record DadosRespostaTopico(
        Long id,
        String titulo,
        String mensagem,
        String data,
        int autor,
        String curso
) {
    public DadosRespostaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getAutor(), topico.getCurso());
    }
}

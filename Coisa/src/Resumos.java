/**
 * Representação de um resumo. Todo resumo tem um
 * tema e conteudo correspondente.
 */
public class Resumos {
    private String tema;
    private String conteudo;

    /**
     * Constrói um resumo a partir de seu tema e conteúdo
     *
     * @param tema nome do tema
     * @param conteudo nome do conteudo
     */
    public Resumos(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna a string do tema
     *
     * @return a representação em string do tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna a string do conteúdo
     *
     * @return a representação em string do conteudo
     */
    public String getConteudo() {
        return conteudo;
    }
}

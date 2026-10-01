public class Resumos {
    private String tema;
    private String conteudo;

    public Resumos(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String getTema() {
        return tema;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}

public class RegistroResumos {
    private int MAX_RESUMOS;
    private String[] temas;
    private String[] conteudos;
    private int resumoDaVez = 0;
    private int resumosCadastrados;

    RegistroResumos(int numeroDeResumos) {
        MAX_RESUMOS = numeroDeResumos;
        temas = new String[MAX_RESUMOS];
        conteudos = new String[MAX_RESUMOS];
    }

    public void adiciona(String tema, String conteudo) {
        if (resumoDaVez >= MAX_RESUMOS) {
            resumoDaVez = 0;
        }

        if (resumosCadastrados != MAX_RESUMOS) {
            resumosCadastrados += 1;
        }

        temas[resumoDaVez] = tema;
        conteudos[resumoDaVez] = conteudo;

        resumoDaVez += 1;
    }

    public String[] pegaResumos() {
        String[] resumos = new String[MAX_RESUMOS];
        for (int i = 0; i < resumosCadastrados; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }
        return resumos;
    }

    public String imprimeResumos() {
        String impressao = "- " + resumosCadastrados + " resumo(s) cadastrado(s)\n";

        if (resumosCadastrados >= 1) {
            impressao += "- " + temas[0];
        }
        for (int i = 1; i < resumosCadastrados; i++) {
            impressao += " | " + temas[i];
        }
        return impressao;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < resumosCadastrados; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public int conta() {
        return resumosCadastrados;
    }
}











import java.util.Arrays;

public class RegistroResumos {
    private int MAX_RESUMOS;
    private Resumos[] resumos;
    private int resumoDaVez = 0;
    private int resumosCadastrados;

    public RegistroResumos(int numeroDeResumos) {
        MAX_RESUMOS = numeroDeResumos;
        resumos = new Resumos[MAX_RESUMOS];
    }

    public void adiciona(String tema, String conteudo) {
        if (resumoDaVez >= MAX_RESUMOS) {
            resumoDaVez = 0;
        }

        if (resumosCadastrados != MAX_RESUMOS) {
            resumosCadastrados += 1;
        }

        resumos[resumoDaVez] = new Resumos(tema, conteudo);

        resumoDaVez += 1;
    }

    public String[] pegaResumos() {
        String[] resumos = new String[MAX_RESUMOS];
        for (int i = 0; i < resumosCadastrados; i++) {
            resumos[i] = this.resumos[i].getTema() + ": " + this.resumos[i].getConteudo();
        }
        return resumos;
    }

    public String imprimeResumos() {
        String impressao = "- " + resumosCadastrados + " resumo(s) cadastrado(s)\n";

        if (resumosCadastrados >= 1) {
            impressao += "- " + resumos[0].getTema();
        }
        for (int i = 1; i < resumosCadastrados; i++) {
            impressao += " | " + resumos[i].getTema();
        }
        return impressao;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < resumosCadastrados; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public int conta() {
        return resumosCadastrados;
    }

    public String[] busca(String chaveDeBusca) {
        int nCorrespondentes = 0;
        for (int i = 0; i < resumosCadastrados; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                nCorrespondentes++;
            }
        }

        String[] temasCorrespondentes = new String[nCorrespondentes];
        for (int i = 0; i < nCorrespondentes; i++) {
        if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
            temasCorrespondentes[i] = resumos[i].getTema();
            }
        }
        Arrays.sort(temasCorrespondentes);

        return temasCorrespondentes;
    }
}

import java.util.Arrays;

/**
 * Representa um registro de resumos com capacidade limitada.
 * Quando o registro enche, os novos resumos passam a substituir
 * os mais antigos, em ordem circular.
 *
 * @author Daniel Almeida Leite
 */
public class RegistroResumos {
    /**
     * Quantidade máxima de resumos que o registro guarda.
     */
    private int MAX_RESUMOS;
    /**
     * Resumos cadastrados.
     */
    private Resumos[] resumos;
    /**
     * Posição onde o próximo resumo será guardado.
     */
    private int resumoDaVez = 0;
    /**
     * Quantidade de resumos atualmente cadastrados.
     */
    private int resumosCadastrados;

    /**
     * Cria um registro de resumos com a capacidade informada.
     *
     * @param numeroDeResumos quantidade máxima de resumos
     */
    public RegistroResumos(int numeroDeResumos) {
        MAX_RESUMOS = numeroDeResumos;
        resumos = new Resumos[MAX_RESUMOS];
    }

    /**
     * Adiciona um resumo ao registro. Se o registro estiver cheio,
     * substitui o resumo mais antigo.
     *
     * @param tema     tema do resumo
     * @param conteudo conteúdo do resumo
     */
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

    /**
     * Retorna os resumos cadastrados no formato "tema: conteúdo".
     * As posições não preenchidas do array ficam nulas.
     *
     * @return array com os resumos em texto
     */
    public String[] pegaResumos() {
        String[] resumos = new String[MAX_RESUMOS];
        for (int i = 0; i < resumosCadastrados; i++) {
            resumos[i] = this.resumos[i].getTema() + ": " + this.resumos[i].getConteudo();
        }
        return resumos;
    }

    /**
     * Gera um texto com a quantidade de resumos cadastrados
     * e a lista dos seus temas, separados por " | ".
     *
     * @return a representação textual dos resumos cadastrados
     */
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

    /**
     * Verifica se existe um resumo com o tema informado.
     *
     * @param tema tema a ser procurado
     * @return true se o tema estiver cadastrado, false caso contrário
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < resumosCadastrados; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna a quantidade de resumos cadastrados.
     *
     * @return número de resumos cadastrados
     */
    public int conta() {
        return resumosCadastrados;
    }

    /**
     * Busca os resumos cujo conteúdo contém a chave de busca,
     * sem diferenciar maiúsculas de minúsculas.
     *
     * @param chaveDeBusca texto a ser procurado no conteúdo
     * @return temas dos resumos correspondentes, em ordem alfabética
     */
    public String[] busca(String chaveDeBusca) {
        int nCorrespondentes = 0;
        for (int i = 0; i < resumosCadastrados; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                nCorrespondentes++;
            }
        }

        String[] temasCorrespondentes = new String[nCorrespondentes];
        for (int i = 0; i < resumosCadastrados; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                temasCorrespondentes[i] = resumos[i].getTema();
            }
        }
        Arrays.sort(temasCorrespondentes);

        return temasCorrespondentes;
    }
}
/**
 * Representa o registro do tempo online de um aluno em uma disciplina.
 * Guarda o tempo já acumulado e o tempo esperado, ambos em horas,
 * para verificar se a meta foi atingida.
 *
 * @author Daniel Almeida Leite
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;
    /**
     * Tempo online acumulado.
     */
    private int tempoOnline;
    /**
     * Tempo online esperado para a disciplina em horas.
     */
    private int tempoOnlineEsperado;

    /**
     * Cria um registro com o tempo online esperado padrão de 120.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Cria um registro com o tempo online esperado informado.
     *
     * @param nomeDisciplina      nome da disciplina
     * @param tempoOnlineEsperado tempo online esperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Soma um tempo ao total de tempo online acumulado.
     *
     * @param tempo tempo a ser adicionado
     */
    public void adicionaTempoOnline(int tempo) {
        tempoOnline += tempo;
    }

    /**
     * Verifica se o tempo online acumulado atingiu o tempo esperado.
     *
     * @return true se a meta foi atingida, false caso contrário
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnline >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a representação em String do registro:
     * nome da disciplina e tempo online no formato "acumulado/esperado".
     *
     * @return a representação textual do registro
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}
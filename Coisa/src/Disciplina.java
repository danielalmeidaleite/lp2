import java.util.Arrays;

/**
 * Representa uma disciplina cursada por um aluno.
 * Guarda as horas de estudo, as notas e seus pesos,
 * e calcula a média ponderada para verificar a aprovação.
 *
 * @author Daniel Almeida Leite
 */
public class Disciplina {
    /**
     * Nome da disciplina.
     */
    private final String nomeDisciplina;
    /**
     * Total de horas de estudo.
     */
    private int horasDeEstudo;
    /**
     * Quantidade de notas da disciplina.
     */
    private final int nDeNotas;
    /**
     * Notas cadastradas, uma por posição.
     */
    private final double[] notas;
    /**
     * Pesos de cada nota, na mesma ordem do array de notas.
     */
    private final int[] pesos;

    /**
     * Cria uma disciplina com 4 notas de peso 1.
     *
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Cria uma disciplina com a quantidade de notas informada, todas com peso 1.
     *
     * @param nomeDisciplina nome da disciplina
     * @param nDeNotas       quantidade de notas
     */
    public Disciplina(String nomeDisciplina, int nDeNotas) {
        this(nomeDisciplina, nDeNotas, pesosIguais(nDeNotas));
    }

    /**
     * Cria uma disciplina com a quantidade de notas e os pesos informados.
     *
     * @param nomeDisciplina nome da disciplina
     * @param nDeNotas       quantidade de notas
     * @param pesos          pesos de cada nota
     */
    public Disciplina(String nomeDisciplina, int nDeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.nDeNotas = nDeNotas;
        this.notas = new double[nDeNotas];
        this.pesos = pesos;
    }

    /**
     * Cria um array de pesos com valor 1 em todas as posições.
     *
     * @param nDeNotas quantidade de notas
     * @return array de pesos iguais a 1
     */
    private static int[] pesosIguais(int nDeNotas) {
        int[] pesos = new int[nDeNotas];
        Arrays.fill(pesos, 1);
        return pesos;
    }

    /**
     * Soma horas ao total de horas de estudo.
     *
     * @param horas horas a serem adicionadas
     */
    public void cadastraHoras(int horas) {
        horasDeEstudo += horas;
    }

    /**
     * Cadastra o valor de uma nota.
     *
     * @param nota      número da nota (começando em 1)
     * @param valorNota valor da nota
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota-1] = valorNota;
    }

    /**
     * Calcula a média ponderada das notas.
     *
     * @return a média ponderada
     */
    private double calculaMedia() {
        int somaDosPesos = 0;
        for (int peso : pesos) {
            somaDosPesos += peso;
        }
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
        }
        return soma / somaDosPesos;
    }

    /**
     * Verifica se o aluno foi aprovado, ou seja, se a média é pelo menos 7.0.
     *
     * @return true se aprovado, false caso contrário
     */
    public boolean aprovado(){
        double media = calculaMedia();
        return media >= 7.0;
    }

    /**
     * Retorna a representação em String da disciplina:
     * nome, horas de estudo, média e notas.
     *
     * @return a representação textual da disciplina
     */
    @Override
    public String toString() {
        return String.format("%s %d %.1f %s", nomeDisciplina, horasDeEstudo, calculaMedia(), Arrays.toString(notas));
    }
}
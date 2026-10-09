import java.util.Arrays;

public class Disciplina {
    private final String nomeDisciplina;
    private int horasDeEstudo;
    private final int nDeNotas;
    private double[] notas;
    private final int[] pesos;

    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    public Disciplina(String nomeDisciplina, int nDeNotas) {
        this(nomeDisciplina, nDeNotas, pesosIguais(nDeNotas));
    }

    public Disciplina(String nomeDisciplina, int nDeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.nDeNotas = nDeNotas;
        this.notas = new double[nDeNotas];
        this.pesos = pesos;
    }

    private static int[] pesosIguais(int nDeNotas) {
        int[] pesos = new int[nDeNotas];
        Arrays.fill(pesos, 1);
        return pesos;
    }

    public void cadastraHoras(int horas) {
        horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota-1] = valorNota;
    }

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

    public boolean aprovado(){
        double media = calculaMedia();
        return media >= 7.0;
    }

    @Override
    public String toString() {
        return String.format("%s %d %.1f %s", nomeDisciplina, horasDeEstudo, calculaMedia(), Arrays.toString(notas));
    }
}

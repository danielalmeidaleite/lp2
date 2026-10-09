import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private int nDeNotas;
    private double[] notas;
    private int[] pesos;

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
        for (int i = 0; i < pesos.length; i++) {
            somaDosPesos += pesos[i];
        }
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
        }
        return soma / somaDosPesos;
    }

    public boolean aprovado(){
        double media = calculaMedia();
        if (media >= 7.0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %.1f %s", nomeDisciplina, horasDeEstudo, calculaMedia(), Arrays.toString(notas));
    }
}

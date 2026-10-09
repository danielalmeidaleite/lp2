import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private static int nDeNotas = 4;
    private double[] notas = new double[nDeNotas];
    private static int[] pesos = {1, 1, 1, 1};
    private int somaDosPesos;

    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, nDeNotas, pesos);
    }

    public Disciplina(String nomeDisciplina, int nDeNotas) {
        this(nomeDisciplina, nDeNotas, pesos);
    }

    public Disciplina(String nomeDisciplina, int nDeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.nDeNotas = nDeNotas;
        this.notas = new double[nDeNotas];
        this.pesos = pesos;
        for (int i = 0; i < pesos.length; i++) {
            this.somaDosPesos += pesos[i];
        }
    }


    public void cadastraHoras(int horas) {
        horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota-1] = valorNota;
    }

    private double calculaMedia() {
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
        }
        double media = soma / somaDosPesos;
        return media;
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

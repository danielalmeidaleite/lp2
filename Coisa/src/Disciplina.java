import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private double[] notas = {0, 0, 0, 0};

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
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
            soma += notas[i];
        }
        double media = soma / 4;
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
        // PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]
        return nomeDisciplina + " " + horasDeEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}

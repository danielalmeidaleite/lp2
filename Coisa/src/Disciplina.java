public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private double[] notas = {0, 0, 0, 0};

    public void cadastraHoras(int horas) {
        horasDeEstudo += horas;
    }

    public void cadastraNotas(int nota, double valorNota) {
        notas[nota] = valorNota;
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
        if (media > 7.0) {
            return true;
        }
        return false;
    }
}

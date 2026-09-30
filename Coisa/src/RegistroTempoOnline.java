public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        tempoOnline += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        if (tempoOnline >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}

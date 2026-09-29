public class Descanso {
    private int horasDescanso;
    private int numsSemana;

    public void defineHorasDescanso (int valor) {
        horasDescanso = valor;
    }

    public void defineNumsSemana (int valor) {
        numsSemana = valor;
    }

    public String getStatusGeral () {
        if (horasDescanso / numsSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}

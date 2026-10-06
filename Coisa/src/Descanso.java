/**
 * Representa o estado de cansaço de um aluno.
 * Por meio do número de horas de descaso e o número de semanas
 *
 * @author Daniel Almeida Leite
 */

public class Descanso {
    /**
     * Horas de descanso totais.
     */
    private int horasDescanso;
    /**
     * Número de semanas.
     */
    private int numsSemana = 1;

    /**
     * Define o número total de horas de descanso
     *
     * @param valor horas totais de descanso
     */
    public void defineHorasDescanso (int valor) {
        horasDescanso = valor;
    }

    /**
     * Define o número total de semanas.
     *
     * @param valor número de semanas
     */
    public void defineNumeroSemanas (int valor) {
        numsSemana = valor;
    }

    /**
     * Verifica se o aluno tem pelo menos 26 horas de descanso por semana
     * e retorna a string correspondente.
     *
     * @return o estado de descanso do aluno
     */
    public String getStatusGeral () {
        if (horasDescanso / numsSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}


/**
 * Classe que representa o resumo de um dado processo eleitoral.
 * 
 * @author Lenin Medeiros
 */
public class ResumoVotos {
    int totalEleitores;
    int votosValidos;
    int votosBrancos;
    int votosNulos;

    /**
     * Construtor da classe.
     * 
     * @param totalEleitores int que representa o total de eleitores cadastrados.
     * @param votosValidos   int que representa a quantidade total de votos válidos
     *                       computados.
     * @param votosBrancos   int que representa a quantidade total de votos brancos
     *                       computados.
     * @param votosNulos     int que representa a quantidade total de votos nulos
     *                       computados.
     * @throws Exception caso a soma dos votos computados, incluindo nulos e
     *                   brancos, não seja igual ao total de eleitores cadastrados.
     */
    public ResumoVotos(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) throws Exception {
        if (totalEleitores != votosValidos + votosBrancos + votosNulos) {
            throw new Exception();
        }
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    /**
     * Proporção de votos válidos.
     * 
     * @return string representando a porcentagem com duas casas decimais de votos
     *         válidos em relação ao total de eleitores.
     */
    public String getProporcaoVotosValidos() {
        return "VOTOS VÁLIDOS: ".concat(
                String.format("%2.02f", this.getPorcentagem(this.votosValidos, this.totalEleitores)).concat("%"));
    }

    /**
     * Proporção de votos brancos.
     * 
     * @return string representando a porcentagem com duas casas decimais de votos
     *         brancos em relação ao total de eleitores.
     */
    public String getProporcaoVotosBrancos() {
        return "VOTOS BRANCOS: ".concat(
                String.format("%2.02f", this.getPorcentagem(this.votosBrancos, this.totalEleitores)).concat("%"));
    }

    /**
     * Proporção de votos nulos.
     * 
     * @return string representando a porcentagem com duas casas decimais de votos
     *         nulos em relação ao total de eleitores.
     */
    public String getProporcaoVotosNulos() {
        return "VOTOS NULOS: "
                .concat(String.format("%2.02f", this.getPorcentagem(this.votosNulos, this.totalEleitores)).concat("%"));
    }

    /**
     * Proporção entre dois inteiros.
     * 
     * @param a int
     * @param b int
     *
     * @return a porcentagem que representa a proporção de a em b (a/b).
     */
    private float getPorcentagem(int a, int b) {
        float percentage = ((float) a) / b;
        return percentage * 100;
    }

    public static void main(String[] args) {
        // ##### Regras de Execução #####
        // O usuário deve executar este programa de duas formas:
        // 1) Não passando nenhum parâmetro de entrada;
        // 2) Informando apenas 4 valores inteiros como parâmetros para construir um
        // objeto da classe ResumoVotos.

        // Valores default da votação caso o usuário não informe parâmetros de entrada.
        final int TOTAL_ELEITORES_DEFAULT = 1000;
        final int TOTAL_VOTOS_VALIDOS_DEFAULT = 800;
        final int TOTAL_VOTOS_BRANCOS_DEFAULT = 150;
        final int TOTAL_VOTOS_NULOS = 50;

        ResumoVotos resumoVotos;

        try {
            if (args.length == 0) {
                // Caso o usuário não tenha informado nenhuma entrada, o código utiliza os
                // valores default declarados anteriormente.
                resumoVotos = new ResumoVotos(TOTAL_ELEITORES_DEFAULT, TOTAL_VOTOS_VALIDOS_DEFAULT,
                        TOTAL_VOTOS_BRANCOS_DEFAULT, TOTAL_VOTOS_NULOS);
            } else if (args.length != 4) {
                // O programa não irá executar se o usuário não seguir as regras de execução.
                throw new Exception();
            } else {
                //  Se o código abaixo lançar exceção, significa que o usuário não seguiu as
                // regras de execução.
                resumoVotos = new ResumoVotos(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            }

            System.out.println(resumoVotos.getProporcaoVotosValidos());
            System.out.println(resumoVotos.getProporcaoVotosBrancos());
            System.out.println(resumoVotos.getProporcaoVotosNulos());
        } catch (Exception e) {
            String mensagem = "Erro! Os dados estão inconsistentes!\n"
                    + "Por favor, caso deseje informar as entradas, passe apenas 4 inteiros (sem casas decimais) como parâmetros.\n"
                    + "Os inteiros são: total de eleitores, total de votos válidos, total de votos brancos e total de votos nulos.\n"
                    + "Além disso, a soma dos votos válidos, brancos e nulos deve ser igual ao total de eleitores.";
            System.out.println(mensagem);
        }
    }
}

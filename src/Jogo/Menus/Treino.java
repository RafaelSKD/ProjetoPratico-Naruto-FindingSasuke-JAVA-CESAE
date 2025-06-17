package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Treino {

    // Limite máximo de treinos que podem ser realizados
    private static int maxTreinosRealizados = 5;

    /**
     * Retorna o número máximo de treinos restantes que o jogador pode realizar.
     * @return int número de treinos restantes
     */
    public static int getMaxTreinosRealizados() {
        return maxTreinosRealizados;
    }

    /**
     * Atualiza o número de treinos restantes permitidos.
     * @param maxTreinosRealizados novo valor de treinos restantes
     */
    public static void setMaxTreinosRealizados(int maxTreinosRealizados) {
        Treino.maxTreinosRealizados = maxTreinosRealizados;
    }

    /**
     * Mostra o menu de treino e aplica os efeitos caso o jogador opte por treinar.
     * Cada treino custa 10 dias fictícios e aumenta o ataque de Naruto em 10%.
     * Há um limite máximo de 5 treinos.
     *
     * @throws FileNotFoundException caso a imagem de treino não seja encontrada
     * @throws InterruptedException caso o programa seja interrompido durante os sleeps
     */
    public static void treino() throws FileNotFoundException, InterruptedException {
        Scanner input = new Scanner(System.in);

        while (true) {
            cleanConsole(); // limpa o terminal
            imprimirFicheiro("src/imagens/Treino.txt"); // exibe arte ASCII do treino

            System.out.println("\n                                          ::::: Desejas Treinar :::::                                                           ");
            System.out.println("                                                 \uD83D\uDE34\uD83D\uDECC\uD83C\uDF19\uD83D\uDCA4\uD83D\uDE2A");
            System.out.println("                                      10D = + 10% Ataque - Max5 Treinos");
            System.out.println("                                                Ataque: " + Jogo.getNaruto().getAtaque());
            System.out.println("\n\n\n");
            System.out.println("       ✅ Sim -         PREMIR: S                                              ❌ Nao  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                    OPCAO: ");

            if (input.hasNextLine()) {
                char opcao = input.nextLine().toUpperCase().charAt(0); // lê e converte para maiúsculo

                if (opcao == 'S') {
                    // Verifica se ainda há treinos disponíveis
                    if (Treino.getMaxTreinosRealizados() <= 0) {
                        System.out.println("Você já treinou o máximo de vezes permitido.");
                        sleep(1500);
                        break;
                    }

                    System.out.println("Treinar por 10 longos dias...");
                    sleep(10000); // simula o tempo de treino
                    System.out.println("Você ficou mais forte!");
                    sleep(1000);

                    // Aumenta o ataque em 10%
                    double novoAtaque = Jogo.getNaruto().getAtaque() * 1.10;
                    Jogo.getNaruto().setAtaque(novoAtaque);

                    // Decrementa o número de treinos restantes
                    Treino.setMaxTreinosRealizados(Treino.getMaxTreinosRealizados() - 1);

                } else if (opcao == 'N') {
                    // Jogador opta por não treinar
                    sleep(1000);
                    break;
                } else {
                    // Entrada inválida
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(1500);
                }
            }
        }
    }
}

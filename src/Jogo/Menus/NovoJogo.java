package Jogo.Menus;

import Jogo.Jogo;
import Utils.Som;
import java.util.Scanner;

import static Jogo.Menus.Utils.headerNovoJogo;
import static Utils.Som.stopLose;
import static Utils.Som.stopWin;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class NovoJogo {

    /**
     * Mostra o menu para iniciar um novo jogo e retorna a decisão do jogador.
     *
     * @return 1 se o jogador escolher iniciar um novo jogo, 0 se optar por não iniciar
     * @throws InterruptedException se ocorrer uma interrupção durante o sleep
     */
    public static int menuNovoJogo() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            cleanConsole(); // Limpa o terminal
            headerNovoJogo(); // Mostra o cabeçalho estilizado do novo jogo

            // Interface visual e instruções
            System.out.println("                                                                                                                                      \uD83D\uDCDCMANUAL: PREMIR 0       ");
            System.out.println("\n\n                                                        ::::: Desejas Iniciar um Novo Jogo :::::                                                           ");
            System.out.println("                                                                      \uD83E\uDDE9\uD83D\uDCA1\uD83C\uDFAE\uD83D\uDD79\uFE0F\uD83D\uDDFA\uFE0F");
            System.out.println("\n\n\n");
            System.out.println("                           ✅ Sim -         PREMIR: S                                              ❌ Nao  -         PREMIR N                           ");
            System.out.println("\n\n\n\n                                                                   OPCAO: ");

            if (input.hasNextLine()) {
                // Lê a primeira letra da opção e converte para maiúscula
                opcao = input.nextLine().toUpperCase().charAt(0);

                if (opcao == 'S') {
                    // Jogador aceita iniciar um novo jogo
                    stopWin(); // Para música de vitória, se estiver a tocar
                    stopLose(); // Para música de derrota
                    return 1;
                } else if (opcao == 'N') {
                    // Jogador decide não iniciar novo jogo
                    stopWin();
                    stopLose();
                    return 0;
                } else {
                    // Entrada inválida
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(1500); // Pequena pausa para leitura da mensagem
                }
            }
        }
    }
}

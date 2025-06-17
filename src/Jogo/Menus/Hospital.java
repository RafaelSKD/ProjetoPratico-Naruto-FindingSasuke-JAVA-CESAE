package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Cores.ConsoleColors.RESET;
import static Utils.Cores.ConsoleColors.YELLOW_BOLD;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

/**
 * Menu do Hospital Ninja.
 * Permite que Naruto recupere até 1000 pontos de vida ao custo de 400 moedas.
 * Vida máxima possível: 2000.
 */
public class Hospital {

    /**
     * Exibe o menu do hospital e realiza o tratamento se o jogador aceitar e tiver dinheiro suficiente.
     * Cada tratamento recupera 1000 pontos de vida por 400 moedas.
     */
    public static void hospitalNinja() throws FileNotFoundException, InterruptedException {
        Scanner input = new Scanner(System.in);

        while (true) {
            cleanConsole(); // Limpa o terminal
            char opcao;

            // Exibe arte ASCII e informações principais
            imprimirFicheiro("src/imagens/cruz.txt");
            System.out.println("\n                                                                  \uD83E\uDE99\uD83E\uDE99\uD83E\uDE99   MOEDAS : " + YELLOW_BOLD + Jogo.getNaruto().getDinheiro() + RESET);
            System.out.println("\n\n                                                                     ::::: Tratamento :::::                                                           ");
            System.out.println("                                                                           \uD83C\uDFE5\uD83D\uDC89\uD83E\uDE7A\uD83D\uDECF\uFE0F\uD83D\uDE91");
            System.out.println("                                                    1 tratamento = +1000 Vida = 400 MOEDAS - MAX 2000 Vida!");
            System.out.println("                                                                         Vida: " + Jogo.getNaruto().getVida());
            System.out.println("\n\n\n");
            System.out.println("             ✅ RECEBER TRATAMENTO -         PREMIR: S                                              ❌ NAO RECEBER TRATAMENTO  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                                    OPCAO: ");

            if (input.hasNextLine()) {
                opcao = input.nextLine().toUpperCase().charAt(0);

                if (opcao == 'S') {
                    // Verifica se há moedas suficientes
                    if (Jogo.getNaruto().getDinheiro() < 400) {
                        System.out.println("Você não tem moedas suficientes para receber tratamento.");
                        sleep(1500);
                        break;
                    }

                    cleanConsole();
                    imprimirFicheiro("src/imagens/NarutoHospital.txt"); // Mostra arte visual do hospital
                    System.out.println("Receber tratamento...");
                    sleep(2000);
                    System.out.println("Você recuperou 1000 de vida!");
                    sleep(3000);

                    // Aplica o tratamento, garantindo que não ultrapasse a vida máxima (2000)
                    double vidaAtual = Jogo.getNaruto().getVida();
                    double vidaRecuperada = Math.min(1000, 2000 - vidaAtual);
                    Jogo.getNaruto().setVida(vidaAtual + vidaRecuperada);

                    // Deduz o custo do tratamento
                    Jogo.getNaruto().setDinheiro(Jogo.getNaruto().getDinheiro() - 400);

                } else if (opcao == 'N') {
                    // Jogador opta por não se tratar
                    sleep(1000);
                    break;

                } else {
                    // Entrada inválida
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(2000);
                }
            }
        }
    }
}

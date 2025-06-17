package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Cores.ConsoleColors.RESET;
import static Utils.Cores.ConsoleColors.YELLOW_BOLD;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Restaurante {

    /**
     * Menu do restaurante Ramen Ichiraku, onde Naruto pode recuperar vida em troca de moedas.
     *
     * @throws InterruptedException se a thread for interrompida durante pausas
     * @throws FileNotFoundException se os ficheiros de imagem não forem encontrados
     */
    public static void restaurante() throws InterruptedException, FileNotFoundException {

        int flag = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            cleanConsole(); // Limpa o terminal
            char opcao;

            // Imagem do restaurante
            imprimirFicheiro("src/imagens/ramen.txt");

            // Mostra moedas e status de vida
            System.out.println("\n                                                                \uD83E\uDE99\uD83E\uDE99\uD83E\uDE99   MOEDAS : " + YELLOW_BOLD + (Jogo.getNaruto()).getDinheiro() + RESET);
            System.out.println("\n\n                                                                 ::::: Especial Naruto Ramen :::::                                                           ");
            System.out.println("                                                                           \uD83C\uDF65\uD83C\uDF72\uD83C\uDF5C\uD83E\uDD62\uD83D\uDD25");
            System.out.println("                                                                  1 ramen = +100 Vida = 50 MOEDAS");
            System.out.println("                                                                            Vida: " + Jogo.getNaruto().getVida());
            System.out.println("\n\n\n");
            System.out.println("                             ✅ COMER -         PREMIR: S                                              ❌ NAO COMER  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                                    OPCAO: ");

            if (input.hasNextLine()) {
                opcao = input.nextLine().toUpperCase().charAt(0); // Lê a primeira letra

                if (opcao == 'S') {
                    // Verifica se há moedas suficientes
                    if ((Jogo.getNaruto()).getDinheiro() < 50) {
                        System.out.println("Você não tem moedas suficientes para comprar um ramen.");
                        sleep(1500);
                        break;
                    }

                    cleanConsole();
                    imprimirFicheiro("src/imagens/comer.txt"); // Animação de comer
                    System.out.println("Comendo um delicioso ramen...");
                    sleep(1000);
                    System.out.println("Você recuperou 100 de vida!");
                    sleep(1000);

                    // Aplica os efeitos do ramen
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() + 100);
                    Jogo.getNaruto().setDinheiro(Jogo.getNaruto().getDinheiro() - 50);

                } else if (opcao == 'N') {
                    // Jogador decide não comer
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

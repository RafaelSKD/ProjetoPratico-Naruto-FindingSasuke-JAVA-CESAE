package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Restaurante {
    public static void restaurante() throws InterruptedException, FileNotFoundException {

    int flag = 0;
    Scanner input = new Scanner(System.in);
        while (true) {
        cleanConsole();
        char opcao;
        imprimirFicheiro("src/imagens/ramen.txt");
        System.out.println("\n\n                                                                 ::::: Especial Naruto Ramen :::::                                                           ");
        System.out.println("                                                                           \uD83C\uDF65\uD83C\uDF72\uD83C\uDF5C\uD83E\uDD62\uD83D\uDD25");
        System.out.println("                                                                  1 ramen = +100 Vida = 50 MOEDAS");
        System.out.println("\n\n\n");
        System.out.println("                             ✅ COMER -         PREMIR: S                                              ❌ NAO COMER  -         PREMIR N                           ");
        System.out.print("\n\n\n\n                                                                    OPCAO: ");
        if (input.hasNextLine()) {
            opcao = input.nextLine().toUpperCase().charAt(0);
            if (opcao == 'S') {
                if ((Jogo.getNaruto()).getDinheiro() < 50) {
                    System.out.println("Você não tem moedas suficientes para comprar um ramen.");
                    sleep(1500);
                    break;
                }
                cleanConsole();
                imprimirFicheiro("src/imagens/comer.txt");
                System.out.println("Comendo um delicioso ramen...");
                sleep(1000);
                System.out.println("Você recuperou 100 de vida!");
                sleep(1000);
                Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() + 100);
                Jogo.getNaruto().setDinheiro(Jogo.getNaruto().getDinheiro() - 50);
            } else if (opcao == 'N') {
                System.out.println("Você decidiu não comer.");
                sleep(1500);
                break;
            } else {
                System.out.println("Opção inválida. Por favor, tente novamente.");
                sleep(1500);
            }
        }
    }
}
}

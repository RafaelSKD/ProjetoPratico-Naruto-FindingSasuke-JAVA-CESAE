package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Hospital {
    public static void hospitalNinja() throws FileNotFoundException, InterruptedException {
        int flag = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            cleanConsole();
            char opcao;
            imprimirFicheiro("src/imagens/cruz.txt");
            System.out.println("\n\n                                                                     ::::: Tratamento :::::                                                           ");
            System.out.println("                                                                           \uD83C\uDFE5\uD83D\uDC89\uD83E\uDE7A\uD83D\uDECF\uFE0F\uD83D\uDE91");
            System.out.println("                                                             1 tratamento = +1000 Vida = 400 MOEDAS");
            System.out.println("\n\n\n");
            System.out.println("             ✅ RECEBER TRATAMENTO -         PREMIR: S                                              ❌ NAO RECEBER TRATAMENTO  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                                    OPCAO: ");
            if (input.hasNextLine()) {
                opcao = input.nextLine().toUpperCase().charAt(0);
                if (opcao == 'S') {
                    if ((Jogo.getNaruto()).getDinheiro() < 400) {
                        System.out.println("Você não tem moedas suficientes para receber tratamento.");
                        sleep(1500);
                        break;
                    }
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NarutoHospital.txt");
                    System.out.println("Receber tratamento...");
                    sleep(2000);
                    System.out.println("Você recuperou 1000 de vida!");
                    sleep(3000);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() + 1000);
                    Jogo.getNaruto().setDinheiro(Jogo.getNaruto().getDinheiro() - 400);
                } else if (opcao == 'N') {
                    System.out.println("A ir embora.");
                    sleep(2000);
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(2000);
                }
            }
        }
    }
}


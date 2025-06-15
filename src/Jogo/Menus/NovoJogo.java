package Jogo.Menus;

import java.util.Scanner;

import static Jogo.Menus.Utils.headerNovoJogo;
import static Utils.Utils.cleanConsole;
import static java.lang.Thread.sleep;

public class NovoJogo {
    public static int menuNovoJogo() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            cleanConsole();
            headerNovoJogo();
            System.out.println("                                                                                                                                      \uD83D\uDCDCMANUAL: PREMIR 0       ");
            System.out.println("\n\n                                                        ::::: Desejas Iniciar um Novo Jogo :::::                                                           ");
            System.out.println("                                                                      \uD83E\uDDE9\uD83D\uDCA1\uD83C\uDFAE\uD83D\uDD79\uFE0F\uD83D\uDDFA\uFE0F");
            System.out.println("\n\n\n");
            System.out.println("                           ✅ Sim -         PREMIR: 1                                              ❌ Nao  -         PREMIR 2                           ");
            System.out.println("\n\n\n\n                                                                   OPCAO: ");

            if (input.hasNextInt()) {
                opcao = input.nextInt();
                if (opcao == 1 || opcao == 2) {
                    break;
                } else {
                    System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 6. ⛔\n");
                }
            } else {
                System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                input.next(); // consome o valor incorreto para evitar loop infinito
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return opcao;
    }
}

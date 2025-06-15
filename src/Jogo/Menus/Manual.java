package Jogo.Menus;

import java.util.Scanner;

import static Jogo.Menus.Utils.headerManual;
import static Utils.Utils.cleanConsole;
import static java.lang.Thread.sleep;

public class Manual {

    public static void manual() throws InterruptedException {
        dispacherManual(manualMenu());
    }

    private static void dispacherManual(int i) throws InterruptedException {
        switch (i) {
            case 0:
                System.out.println("A sair do manual...");
                sleep(2000);
                break;
            case 1:
                System.out.println("Abrindo página de NARUTO STATS...");
                // Aqui você pode chamar a função que exibe os stats do Naruto
                break;
            case 2:
                System.out.println("Abrindo página de MOCHILA...");
                // Aqui você pode chamar a função que exibe a mochila
                break;
            case 3:
                System.out.println("Abrindo página de HISTÓRIA...");
                // Aqui você pode chamar a função que exibe a história
                break;
            case 4:
                System.out.println("Abrindo página de JOGO...");
                // Aqui você pode chamar a função que inicia o jogo
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }


    public static int manualMenu(){
        Scanner input = new Scanner(System.in);
        while (true){
            cleanConsole();
            headerManual();
            System.out.println("\n\n\n\n                      📊 NARUTO STATS   -  PRIMA 1");
            System.out.println("                      🎒 MOCHILA        -  PRIMA 2");
            System.out.println("                      📖 HISTÓRIA       -  PRIMA 3");
            System.out.println("                      🎮 JOGO           -  PRIMA 4");
            System.out.println("\n\n                      Escolha uma opcao (0 para sair): ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    int option = Integer.parseInt(line);
                    if (option >= 0 && option <= 4) {
                        return option;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 4 . ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
        }
    }

}

package Jogo.Menus;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Menus.Utils.headerKonoha;
import static Jogo.Menus.Utils.headerNavegacao;
import static Jogo.Paginas.Manual.manual;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Konoha {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        konoha();
    }

    public static void konoha() throws InterruptedException, FileNotFoundException {
        int flag = 0;
        while (true) {
            flag = dispacher(menuKonoha());
            if (flag == 1)
                break;
        }
    }

    private static int dispacher(int opcao) throws FileNotFoundException, InterruptedException {
        switch (opcao) {
            case 0:
                //System.out.println("Abrindo o manual...");
                manual();
                return 0;
            case 1:
                System.out.println("Você está na sua casa, aproveite para descansar e se preparar para a jornada!");
                sleep(2000);
                return 0;
            case 2:
                System.out.println("Você está no local de treino, onde pode aprimorar suas habilidades ninja!");
                sleep(2000);
                return 0;
            case 3:
                System.out.println("Você está no Ichiraku Ramen, desfrutando de um delicioso ramen!");
                sleep(2000);
                return 0;
            case 4:
                System.out.println("Você está na loja, onde pode comprar itens e equipamentos!");
                sleep(2000);
                return 0;
            case 5:
                System.out.println("Você está no hospital ninja, onde pode se curar e tratar ferimentos!");
                sleep(2000);
                return 0;
            case 6:
                //System.out.println("Você decidiu continuar sua jornada, boa sorte!");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(1500);
                return 1; // volta ao menu da navegacao
        }
        return 0;
    }
    private static int menuKonoha() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            cleanConsole();
            headerKonoha();
            System.out.println("                                                                                                                                       \uD83D\uDCDCMANUAL: PREMIR 0       ");
            System.out.println("\n\n                                                             ::::: VILA DA FOLHA - KONOHA :::::                                                           ");
            System.out.println("                                                                      \uD83C\uDFEE⛩\uFE0F\uD83C\uDFF5\uD83C\uDF3F\uD83C\uDF65\uD83C\uDF5C\uD83C\uDFEF\uD83C\uDF00");
            System.out.println("\n\n\n");
            System.out.println("                           Casa -         PREMIR: 1                                                    Loja  -         PREMIR 4                           ");
            System.out.println("                         \uD83C\uDFE0\uD83D\uDECC\uD83C\uDFFB\uD83D\uDEC1\uD83D\uDE34                                                                 \uD808\uDD52\uD808\uDE14\uD808\uDD52\uD808\uDDEB\uD808\uDD06");
            System.out.println();
            System.out.println();
            System.out.println("                           Treino -       PREMIR: 2                                          Hospital Ninja  -         PREMIR 5                           ");
            System.out.println("                         \uD83D\uDCA5\uD83C\uDFCB\u200D♀\uD83E\uDDD8\uD83C\uDFFD\u200D♀\uFE0F\uD83D\uDD25\uD83D\uDCAA\uD83C\uDFFC                                                          \uD83D\uDC8A\uD83C\uDF21\uFE0F\uD83E\uDE79\uD83D\uDC89\uD83E\uDE7A");
            System.out.println();
            System.out.println();
            System.out.println("                   Ichiraku Ramen -       PREMIR: 3                                     Continuar a Jornada  -         PREMIR 6                           ");
            System.out.println("                    \uD83C\uDF90\uD83C\uDF5C\uD83C\uDF5B\uD83C\uDF59\uD83C\uDF63\uD83C\uDF71                                                                ᯓ\uD83C\uDFC3\uD83C\uDFFB\u200D♀\uFE0F\u200D➡\uFE0F");
            System.out.println();
            System.out.println();
            System.out.println("\n\n\n");
            System.out.print("\n                                                                       Opcao (0-6):    ");

            if (input.hasNextInt()) {
                opcao = input.nextInt();
                if (opcao >= 0 && opcao <= 6) {
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


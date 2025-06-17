package Jogo.Menus;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Menus.Cama.cama;
import static Jogo.Menus.Hospital.hospitalNinja;
import static Jogo.Menus.Loja.lojaArmas;
import static Jogo.Menus.Manual.manual;
import static Jogo.Menus.Restaurante.restaurante;
import static Jogo.Menus.Treino.treino;
import static Jogo.Menus.Utils.headerKonoha;
import static Utils.Som.*;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Konoha {

    /**
     * Método principal que gerencia o menu da Vila da Folha (Konoha).
     * Exibe o menu até que o jogador decida continuar a jornada.
     */
    public static void konoha() throws InterruptedException, FileNotFoundException {
        int flag = 0;
        while (true) {
            flag = dispacher(menuKonoha()); // Exibe menu e executa a ação selecionada
            if (flag == 1) { // Jogador escolheu "Continuar a Jornada"
                stopKonoha();
                playNav();
                break;
            }
        }
    }

    /**
     * Executa a função correspondente à opção escolhida no menu.
     * @param opcao número da opção escolhida
     * @return 1 se o jogador escolheu continuar a jornada, 0 caso contrário
     */
    private static int dispacher(int opcao) throws FileNotFoundException, InterruptedException {
        switch (opcao) {
            case 0:
                manual(); // Exibe o manual do jogo
                return 0;
            case 1:
                cama(); // Dormir para recuperar chakra
                sleep(2000);
                return 0;
            case 2:
                treino(); // Realizar treino para melhorar atributos
                sleep(2000);
                return 0;
            case 3:
                cleanConsole();
                imprimirFicheiro("src/imagens/restaurante.txt"); // Imagem do restaurante
                sleep(2000);
                cleanConsole();
                restaurante(); // Restaurar vida parcialmente
                return 0;
            case 4:
                cleanConsole();
                imprimirFicheiro("src/imagens/Loja.txt"); // Imagem da loja
                sleep(1500);
                lojaArmas(); // Comprar armas
                return 0;
            case 5:
                cleanConsole();
                imprimirFicheiro("src/imagens/hospital.txt"); // Imagem do hospital
                sleep(2000);
                hospitalNinja(); // Recuperar vida com custo
                return 0;
            case 6:
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt"); // Imagem de Naruto
                sleep(1500);
                return 1; // Indica saída do menu de Konoha
        }
        return 0;
    }

    /**
     * Exibe o menu visual com opções disponíveis em Konoha.
     * Trata entradas inválidas e garante que apenas valores de 0 a 6 sejam aceitos.
     * @return a opção escolhida (0 a 6)
     */
    private static int menuKonoha() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            cleanConsole();
            headerKonoha(); // Cabeçalho visual com arte
            System.out.println("                                                                                                                                       \uD83D\uDCDCMANUAL: PREMIR 0       ");
            System.out.println("\n\n                                                             ::::: VILA DA FOLHA - KONOHA :::::                                                           ");
            System.out.println("                                                                      \uD83C\uDFEE⛩\uFE0F\uD83C\uDFF5\uD83C\uDF3F\uD83C\uDF65\uD83C\uDF5C\uD83C\uDFEF\uD83C\uDF00");
            System.out.println("\n\n\n");
            System.out.println("                           Casa -         PREMIR: 1                                                    Loja  -         PREMIR 4                           ");
            System.out.println("                         \uD83C\uDFE0\uD83D\uDECC\uD83C\uDFFB\uD83D\uDEC1\uD83D\uDE34                                                                 \uD808\uDD52\uD808\uDE14\uD808\uDD52\uD808\uDDEB\uD808\uDD06");
            System.out.println();
            System.out.println("                           Treino -       PREMIR: 2                                          Hospital Ninja  -         PREMIR 5                           ");
            System.out.println("                         \uD83D\uDCA5\uD83C\uDFCB\u200D♀\uD83E\uDDD8\uD83C\uDFFD\u200D♀\uFE0F\uD83D\uDD25\uD83D\uDCAA\uD83C\uDFFC                                                          \uD83D\uDC8A\uD83C\uDF21\uFE0F\uD83E\uDE79\uD83D\uDC89\uD83E\uDE7A");
            System.out.println();
            System.out.println("                   Ichiraku Ramen -       PREMIR: 3                                     Continuar a Jornada  -         PREMIR 6                           ");
            System.out.println("                    \uD83C\uDF90\uD83C\uDF5C\uD83C\uDF5B\uD83C\uDF59\uD83C\uDF63\uD83C\uDF71                                                                ᯓ\uD83C\uDFC3\uD83C\uDFFB\u200D♀\uFE0F\u200D➡\uFE0F");
            System.out.println();
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
                input.next(); // consome a entrada inválida
            }
            sleep(2500); // tempo para leitura do erro
        }
        return opcao;
    }
}

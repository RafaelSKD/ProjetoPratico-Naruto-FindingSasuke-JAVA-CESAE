package Jogo.Menus;

import Ninjas.Enum.Localizacao;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Menus.Konoha.konoha;
import static Jogo.Menus.Utils.headerNavegacao;
import static Jogo.Navegacao.EntrarVilaAleatoriaDaZona.entrarNaVila;
import static Jogo.Paginas.Manual.manual;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Navegacao {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        menuNavegacao();
    }
    public static void menuNavegacao() throws InterruptedException, FileNotFoundException {
        while (true) {
            dispacher(menu());
        }
    }
    private static int menu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            cleanConsole();
            headerNavegacao();
            System.out.println("                                                                                                                                       \uD83D\uDCDCMANUAL: PREMIR 0       ");
            System.out.println("\n\n                                                            :::::ESCOLHA O SEU DESTINO:::::                                                           ");
            System.out.println("                                                                       ᯓ\uD83C\uDFC3\uD83C\uDFFB\u200D♀\uFE0F\u200D➡\uFE0Eજ⁀➴⛰\uFE0E");
            System.out.println("\n\n\n");
            System.out.println("                 Central- Coração Político e Comercial PREMIR: 1                         Sudoeste - Deserto  -                    PREMIR 4                ");
            System.out.println();
            System.out.println("                                 \uD83C\uDFEF\uD83C\uDFEF\uD83C\uDFEF \uD83E\uDEF8⛩\uFE0F\uD83E\uDEF7                                                           \uD83C\uDFDC\uFE0F☀\uFE0F\uD83D\uDC2B\uD83C\uDF35⚱\uFE0F⌛");
            System.out.println();
            System.out.println();
            System.out.println("                 Noroeste - Montanhosa/Rochosa         PREMIR: 2                         Nordeste - Montanhas e Nuvens  -         PREMIR 5                ");
            System.out.println();
            System.out.println("                                 \uD83C\uDFD5\uFE0F\uD83C\uDF3F\uD83C\uDF32\uD83C\uDF33☘\uD83D\uDDFF\uD83E\uDEA8                                                          \uD83C\uDFD4\uFE0F☁\uFE0F\uD83C\uDF3F\uD83C\uDF43✨\uFE0F\uD83D\uDDFB\uD83C\uDF33");
            System.out.println();
            System.out.println();
            System.out.println("                 Sudeste - Ilhas e Litoral             PREMIR: 3                         Central-Oriental - Instável e Chuvosa  - PREMIR 6                ");
            System.out.println();
            System.out.println("                                 \uD83C\uDFDD\uFE0F\uD83C\uDF79⛱\uFE0F\uD83C\uDF1E\uD83C\uDF0A\uD83E\uDEE7\uD83C\uDF90                                                        \uD83C\uDF43\uD83C\uDF27☔\uD83D\uDCA6\uD83C\uDF29\uFE0F⛈\uFE0F\uD83C\uDF27\uFE0F\uD83D\uDCA7");
            System.out.println("\n\n\n");
            System.out.println("                                                            Concentre-se... e decida o rumo");
            System.out.print("\n                                                          Opcao de rota (0-6):    ");

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

    private static void dispacher(int opcao) throws FileNotFoundException, InterruptedException {
        switch (opcao) {
            case 0:
                //System.out.println("Abrindo o manual...");
                cleanConsole();
                manual();
                break;
            case 1:
                //System.out.println("Você escolheu a Central - Coração Político e Comercial.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Central.txt");
                sleep(1500);
                konoha();
                break;
            case 2:
                //System.out.println("Você escolheu o Noroeste - Montanhosa/Rochosa.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Noroeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.NOROESTE);
                break;
            case 3:
                // System.out.println("Você escolheu o Sudeste - Ilhas e Litoral.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDESTE);
                break;
            case 4:
                // System.out.println("Você escolheu o Sudoeste - Deserto.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudoeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDOESTE);
                break;
            case 5:
                // System.out.println("Você escolheu o Nordeste - Montanhas e Nuvens.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Nordeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.NORDESTE);
                break;
            case 6:
                //System.out.println("Você escolheu o Central-Oriental - Instável e Chuvosa.");
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/CentralOriente.txt");
                sleep(1500);
                entrarNaVila(Localizacao.CENTRALORIENTE);
                break;
        }
    }
}


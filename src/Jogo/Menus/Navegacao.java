package Jogo.Menus;

import Jogo.Jogo;
import Ninjas.Enum.Localizacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Jogo.Menus.Konoha.konoha;
import static Jogo.Menus.Manual.manual;
import static Jogo.Menus.Utils.headerNavegacao;
import static Jogo.Navegacao.EntrarVilaAleatoriaDaZona.entrarNaVila;
import static Jogo.Paginas.Apresentacao.lose;
import static Jogo.Paginas.Apresentacao.win;
import static Utils.Som.*;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Navegacao {
    public static void main(String[] args) throws InterruptedException, IOException {
        menuNavegacao();
    }

    public static void menuNavegacao() throws InterruptedException, IOException {
        playNav();
        while ((Jogo.getNaruto()).getVida() > 0 && (Jogo.getSasuke()).getVida() > 0) {
            dispacher(menu());
            stopNav();
            stopFight();
            stopSasuke();
        }

        if ((Jogo.getNaruto()).getVida() < 0) {
            stopNav();
            cleanConsole();
            lose();
        }

        if ((Jogo.getSasuke()).getVida() < 0) {
            stopNav();
            cleanConsole();
            win();
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
            System.out.println("                                                                       ᯓ🏃🏻‍♀️‍➡️જ⁀➴⛰️");
            System.out.println("\n\n\n");
            System.out.println("                             KONOHA                    PREMIR: 1                         Sudoeste - Deserto  -                    PREMIR 4                ");
            System.out.println();
            System.out.println("                                 🏯🏯🏯 🧸⛩️🧷                                                           🏜️☀️🐫🌵⚱️⌛");
            System.out.println();
            System.out.println();
            System.out.println("                 Noroeste - Montanhosa/Rochosa         PREMIR: 2                         Nordeste - Montanhas e Nuvens  -         PREMIR 5                ");
            System.out.println();
            System.out.println("                                 🗕🌿🌲🌳☘️🗿🪨                                                          🏔️☁️🌿🍃✨️🗻🌳");
            System.out.println();
            System.out.println();
            System.out.println("                 Sudeste - Ilhas e Litoral             PREMIR: 3                         Central-Oriental - Instável e Chuvosa  - PREMIR 6                ");
            System.out.println();
            System.out.println("                                 🗝️🍹⛱️🌞🌊🛧🎐                                                        🍃🌧☔💦🌩️⛈️🌧️💧");
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
                input.next();
            }
            sleep(2500);
        }

        return opcao;
    }

    private static void dispacher(int opcao) throws FileNotFoundException, InterruptedException {
        stopNav();
        switch (opcao) {
            case 0:
                cleanConsole();
                manual();
                break;
            case 1:
                playKonoha();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Central.txt");
                sleep(1500);
                konoha();
                stopKonoha();
                break;
            case 2:
                playFight();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Noroeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.NOROESTE);
                stopFight();
                break;
            case 3:
                playFight();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDESTE);
                stopFight();
                break;
            case 4:
                playFight();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudoeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDOESTE);
                stopFight();
                break;
            case 5:
                playFight();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Nordeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.NORDESTE);
                stopFight();
                break;
            case 6:
                playFight();
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/CentralOriente.txt");
                sleep(1500);
                entrarNaVila(Localizacao.CENTRALORIENTE);
                stopFight();
                break;
        }
    }
}

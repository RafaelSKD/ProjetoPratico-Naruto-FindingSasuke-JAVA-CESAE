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
    /**
     * Inicia o menu de navegação principal do jogo, permitindo ao jogador explorar,
     * enquanto Naruto e Sasuke ainda estão vivos.
     * Garante também o fim adequado do jogo, dependendo de quem perder a batalha.
     *
     * @throws InterruptedException caso a execução pause durante sleep().
     * @throws IOException caso ocorra erro ao ler ficheiros de imagem/texto.
     */
    public static void menuNavegacao() throws InterruptedException, IOException {
        // Enquanto ambos os personagens principais estiverem vivos, o jogo continua
        while ((Jogo.getNaruto()).getVida() > 0 && (Jogo.getSasuke()).getVida() > 0) {
            dispacher(menu()); // Despacha a ação escolhida pelo jogador
        }

        // Verifica se Naruto morreu
        if ((Jogo.getNaruto()).getVida() < 0) {
            stopAll(); // Para todos os sons/movimentos
            playLose(); // Toca som de derrota
            cleanConsole();
            imprimirFicheiro("src/imagens/NarutoDie.txt"); // Exibe imagem da derrota de Naruto
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/gameOver.txt"); // Exibe imagem de fim de jogo
            sleep(2000);
            cleanConsole();
            lose(); // Finaliza com rotina de derrota
        }

        // Verifica se Sasuke morreu
        if ((Jogo.getSasuke()).getVida() < 0) {
            cleanConsole();
            stopAll(); // Para todos os sons/movimentos
            playWin(); // Toca som de vitória
            cleanConsole();
            imprimirFicheiro("src/imagens/sasukelose.txt"); // Exibe derrota de Sasuke
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/NarutoWin.txt"); // Exibe Naruto vitorioso
            sleep(4000);
            cleanConsole();
            imprimirFicheiro("src/imagens/wingame.txt"); // Exibe mensagem final de vitória
            sleep(6000);

            win(); // Finaliza com rotina de vitória
        }
    }


    /**
     * Exibe o menu de navegação para o jogador escolher uma região do mundo ninja.
     * Retorna a opção escolhida pelo jogador para ser processada posteriormente.
     *
     * @return int representando a escolha do utilizador (de 0 a 6)
     * @throws InterruptedException caso ocorra pausa entre mensagens
     */
    private static int menu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            // Parar sons antigos e iniciar novo som ambiente de navegação
            stopNav();
            stopNav();
            stopNav();
            stopNav();
            playNav();

            cleanConsole(); // Limpar o ecrã antes de imprimir novo menu
            headerNavegacao(); // Cabeçalho gráfico de navegação

            // Menu visual com regiões e suas respetivas opções
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

            // Verifica se o input é válido
            if (input.hasNextInt()) {
                opcao = input.nextInt();
                if (opcao >= 0 && opcao <= 6) {
                    break; // Sai do loop se a opção for válida
                } else {
                    System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 6. ⛔\n");
                }
            } else {
                System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                input.next(); // Limpa input inválido
            }

            sleep(2500); // Dá tempo para o jogador ler as mensagens de erro
        }

        return opcao; // Retorna a escolha feita
    }


    /**
     * Direciona a execução para o local ou ação correspondente à opção escolhida no menu de navegação.
     *
     * @param opcao valor inteiro de 0 a 6 que representa a escolha do jogador
     * @throws FileNotFoundException caso o ficheiro de imagem textual não seja encontrado
     * @throws InterruptedException caso ocorra interrupção durante pausas com sleep
     */
    private static void dispacher(int opcao) throws FileNotFoundException, InterruptedException {
        switch (opcao) {
            case 0:
                // Acede ao manual de jogo
                cleanConsole();
                manual();
                break;
            case 1:
                // Entra em Konoha (porto seguro)
                stopAll(); // para música anterior
                playKonoha(); // som de Konoha
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt"); // mostra Naruto a partir
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Central.txt"); // imagem da região central
                sleep(1500);
                konoha(); // entra na vila de Konoha
                stopAll(); // limpa som ambiente
                break;
            case 2:
                // Vai para a região Noroeste
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Noroeste.txt"); // imagem da vila
                sleep(1500);
                entrarNaVila(Localizacao.NOROESTE);
                stopAll();
                break;
            case 3:
                // Vai para a região Sudeste
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDESTE);
                stopAll();
                break;
            case 4:
                // Vai para a região Sudoeste
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Sudoeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.SUDOESTE);
                stopAll();
                break;
            case 5:
                // Vai para a região Nordeste
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/Nordeste.txt");
                sleep(1500);
                entrarNaVila(Localizacao.NORDESTE);
                stopAll();
                break;
            case 6:
                // Vai para a região Central-Oriente
                cleanConsole();
                imprimirFicheiro("src/imagens/NarutoBag.txt");
                sleep(800);
                cleanConsole();
                imprimirFicheiro("src/imagens/CentralOriente.txt");
                sleep(1500);
                entrarNaVila(Localizacao.CENTRALORIENTE);
                stopAll();
                break;
        }
    }

}

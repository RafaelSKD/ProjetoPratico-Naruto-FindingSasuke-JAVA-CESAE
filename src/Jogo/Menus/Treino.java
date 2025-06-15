package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Treino {

    private static int maxTreinosRealizados = 10; // Limite de treinos que podem ser realizados

    public static int getMaxTreinosRealizados() {
        return maxTreinosRealizados;
    }

    public static void setMaxTreinosRealizados(int maxTreinosRealizados) {
        Treino.maxTreinosRealizados = maxTreinosRealizados;
    }

    public static void treino() throws FileNotFoundException, InterruptedException {
        Scanner input = new Scanner(System.in);
        while (true){
            cleanConsole();
            imprimirFicheiro("src/imagens/Treino.txt");
            char opcao;
            System.out.println("\n                                          ::::: Desejas Treinar :::::                                                           ");
            System.out.println("                                                 \uD83D\uDE34\uD83D\uDECC\uD83C\uDF19\uD83D\uDCA4\uD83D\uDE2A");
            System.out.println("                                      10D = + 10% Ataque - Max10 Treinos");
            System.out.println("\n\n\n");
            System.out.println("       ✅ Sim -         PREMIR: S                                              ❌ Nao  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                    OPCAO: ");
            if (input.hasNextLine()) {
                opcao = input.nextLine().toUpperCase().charAt(0);
                if (opcao == 'S') {
                    if (Treino.getMaxTreinosRealizados() <= 0) {
                        System.out.println("Você já treinou o máximo de vezes permitido.");
                        sleep(1500);
                        break;
                    }
                    System.out.println("Treinar por 10 longos dias...");
                    sleep(10000);
                    System.out.println("Você ficou mais forte!");
                    sleep(1000);
                    (Jogo.getNaruto()).setAtaque((Jogo.getNaruto()).getAtaque() * 1.10); // Aumenta o ataque em 10%
                    Treino.setMaxTreinosRealizados(Treino.getMaxTreinosRealizados() - 1);
                } else if (opcao == 'N') {
                    System.out.println("Você decidiu não treinar.");
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

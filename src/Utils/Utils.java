package Utils;

import Itens.Consumiveis.Consumivel;
import Jogo.Jogo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;
import Ninjas.Ninja;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static Jogo.Menus.Manual.manual;
import static java.lang.Thread.sleep;

/**
 * Classe utilitária com funções auxiliares para o jogo Naruto - Finding Sasuke.
 */
public class Utils {

    /**
     * Gera um número aleatório entre 0 (inclusive) e quantidade (exclusive).
     */
    public static int random(int quantidade) {
        return new Random().nextInt(quantidade);
    }

    /**
     * Aguarda o pressionar da tecla Enter pelo utilizador.
     */
    public static void stop() {
        System.out.print("\nPressionar Enter para continuar...  ");
        new Scanner(System.in).nextLine();
    }

    /**
     * Imprime o conteúdo de um ficheiro linha por linha.
     */
    public static void imprimirFicheiro(String src) throws FileNotFoundException {
        Scanner data = new Scanner(new File(src));
        while (data.hasNextLine()) {
            System.out.println(data.nextLine());
        }
        data.close();
    }

    /**
     * Imprime o conteúdo de um ficheiro com efeito de digitação, linha a linha.
     */
    public static void imprimirFicheiroComDelay(String src, long delayMillis) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(new File(src));
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            for (char c : linha.toCharArray()) {
                System.out.print(c);
                Thread.sleep(delayMillis);
            }
            System.out.println();
        }
        scanner.close();
    }

    /**
     * Limpa o ecrã simulando múltiplas quebras de linha.
     */
    public static void cleanConsole() {
        System.out.println("\n".repeat(60));
    }

    /**
     * Retorna um emoji correspondente à afinidade de chakra de um ninja.
     */
    public static String emogiAfinidade(Ninja inimigo) {
        return switch (inimigo.getAfinidade()) {
            case FOGO -> "🔥";
            case VENTO -> "🌪️";
            case RELAMPAGO -> "⚡";
            case AGUA -> "💧";
            case TERRA -> "🪨";
            default -> "❓";
        };
    }

    /**
     * Adiciona espaços à direita de um texto para alinhar visualmente.
     */
    public static String colocarEspacos(int texto, int espacos) {
        return " ".repeat(Math.max(0, espacos - texto));
    }

    /**
     * Retorna o nome da arma de um ninja ou "Nenhuma" se não possuir.
     */
    public static String getNomeArmaOuNenhuma(Ninja ninja) {
        if (ninja instanceof Inimigo inimigo) {
            return inimigo.getArma() != null ? inimigo.getArma().getNome() : "Nenhuma";
        } else if (ninja instanceof Naruto naruto) {
            return naruto.getArma() != null ? naruto.getArma().getNome() : "Nenhuma";
        } else if (ninja instanceof Sasuke sasuke) {
            return sasuke.getArma() != null ? sasuke.getArma().getNome() : "Nenhuma";
        }
        return "Nenhuma";
    }

    /**
     * Aplica o efeito de um consumível na personagem Naruto.
     *
     * @param i índice do item na bolsa de Naruto (1-based index; 0 abre o manual)
     */
    public static void aplicarConsumivel(int i) throws FileNotFoundException, InterruptedException {
        Naruto naruto = Jogo.getNaruto();

        if (i == 0) {
            cleanConsole();
            manual();
        } else if (i > 0 && i <= naruto.getBolsa().size()) {
            Consumivel consumivel = naruto.getBolsa().get(i - 1);
            double efeito = consumivel.getEfeito();

            switch (consumivel.getTipoConsumivel()) {
                case ATAQUE -> {
                    double atual = naruto.getAtaque();
                    naruto.setAtaque(atual + efeito);
                    System.out.printf("Ganhou mais %.0f de força de ataque!%n", naruto.getAtaque() - atual);
                }
                case VIDA -> {
                    double atual = naruto.getVida();
                    naruto.setVida(atual + efeito);
                    System.out.printf("Ganhou mais %.0f de vida!%n", naruto.getVida() - atual);
                }
                case CHAKRA -> {
                    double atual = naruto.getChakra();
                    naruto.setChakra(atual + efeito);
                    System.out.printf("Ganhou mais %.0f de chakra!%n", naruto.getChakra() - atual);
                }
            }

            sleep(2000);
            naruto.getBolsa().remove(i - 1);
        }
    }
}

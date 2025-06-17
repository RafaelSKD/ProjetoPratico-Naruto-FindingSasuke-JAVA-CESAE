package Jogo.Luta;

import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Jogo.Jogo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;

import java.io.FileNotFoundException;

import static Jogo.Luta.Defesa.calcularDefesaSasuke;
import static Jogo.Luta.Utils.influenciaNatureza;
import static Utils.Som.playDattebayo;
import static Utils.Som.stopDattebayo;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

/**
 * Classe que contém a lógica de combate entre Naruto e seus inimigos ou Sasuke.
 * Suporta diferentes tipos de ataque: normal, com arma ou com ataque de chakra.
 */
public class Combate {

    /**
     * Realiza um ataque contra um inimigo comum (Inimigo).
     *
     * @param inimigo Inimigo a ser atacado.
     * @param tipo Tipo de ataque: "normal", "arma", "chakra1" ou "chakra2".
     * @return 1 se o ataque foi executado com sucesso, 0 caso contrário.
     */
    public static int ataque(Inimigo inimigo, String tipo) throws FileNotFoundException, InterruptedException {
        Naruto naruto = Jogo.getNaruto();
        boolean vantagemNatureza = influenciaNatureza(inimigo);
        double ataqueBase = naruto.getAtaque();
        double dano = 0;
        String descricaoAtaque = "";

        switch (tipo) {
            case "normal":
                dano = ataqueBase - inimigo.getDefesa();
                descricaoAtaque = "um ataque normal";
                break;

            case "arma":
                Arma arma = naruto.getArma();
                if (arma == null) return 0;
                dano = ataqueBase + arma.getAtaqueArma() - inimigo.getDefesa();
                descricaoAtaque = "a arma " + arma.getNome();
                break;

            case "chakra1":
            case "chakra2":
                AtaqueChakra ataqueEspecial = tipo.equals("chakra1") ? naruto.getAtaqueEspecial1() : naruto.getAtaqueEspecial2();
                if (ataqueEspecial == null) {
                    System.out.println("Você não tem um ataque especial equipado!");
                    sleep(2000);
                    return 0;
                }
                if (naruto.getChakra() < ataqueEspecial.getChakraNecessario()) {
                    System.out.println("Chakra insuficiente para realizar o ataque especial!");
                    sleep(2000);
                    return 0;
                }
                dano = ataqueBase + ataqueEspecial.getForcaExtra() - inimigo.getDefesa();
                naruto.setChakra(naruto.getChakra() - ataqueEspecial.getChakraNecessario());
                descricaoAtaque = "o ataque especial " + ataqueEspecial.getNome();
                break;

            default:
                return 0;
        }

        // Aplica vantagem de afinidade elemental
        if (vantagemNatureza) {
            dano *= 1.2;
        }

        // Evita cura do inimigo por dano negativo
        dano = Math.max(0, dano);
        inimigo.setVida(inimigo.getVida() - dano);

        // Exibe animação de ataque
        imprimirFicheiro("src/imagens/ataque.txt");
        System.out.printf("Você atacou %s com %s causando %.1f de dano.%n", inimigo.getNome(), descricaoAtaque, dano);

        // Efeito sonoro
        playDattebayo();
        sleep(2000);
        stopDattebayo();

        return 1;
    }

    /**
     * Realiza um ataque contra Sasuke (boss final).
     * A defesa dele é calculada separadamente via função dedicada.
     *
     * @param inimigo Sasuke.
     * @param tipo Tipo de ataque: "normal", "arma", "chakra1" ou "chakra2".
     * @return 1 se o ataque foi executado com sucesso, 0 caso contrário.
     */
    public static int ataqueFinal(Sasuke inimigo, String tipo) throws FileNotFoundException, InterruptedException {
        Naruto naruto = Jogo.getNaruto();
        double ataqueBase = naruto.getAtaque();
        double dano;
        String descricaoAtaque = "";

        switch (tipo) {
            case "normal":
                dano = ataqueBase - calcularDefesaSasuke(inimigo);
                descricaoAtaque = "um ataque normal";
                break;

            case "arma":
                Arma arma = naruto.getArma();
                if (arma == null) return 0;
                dano = ataqueBase + arma.getAtaqueArma() - calcularDefesaSasuke(inimigo);
                descricaoAtaque = "a arma " + arma.getNome();
                break;

            case "chakra1":
            case "chakra2":
                AtaqueChakra ataqueEspecial = tipo.equals("chakra1") ? naruto.getAtaqueEspecial1() : naruto.getAtaqueEspecial2();
                if (ataqueEspecial == null) {
                    System.out.println("Você não tem um ataque especial equipado!");
                    sleep(2000);
                    return 0;
                }
                if (naruto.getChakra() < ataqueEspecial.getChakraNecessario()) {
                    System.out.println("Chakra insuficiente para realizar o ataque especial!");
                    sleep(2000);
                    return 0;
                }
                dano = ataqueBase + ataqueEspecial.getForcaExtra() - calcularDefesaSasuke(inimigo);
                naruto.setChakra(naruto.getChakra() - ataqueEspecial.getChakraNecessario());
                descricaoAtaque = "o ataque especial " + ataqueEspecial.getNome();
                break;

            default:
                return 0;
        }

        // Garante que o dano não seja negativo
        dano = Math.max(0, dano);
        inimigo.setVida(inimigo.getVida() - dano);

        imprimirFicheiro("src/imagens/ataque.txt");
        System.out.printf("Você atacou %s com %s causando %.1f de dano.%n", inimigo.getNome(), descricaoAtaque, dano);

        playDattebayo();
        sleep(2000);
        stopDattebayo();

        return 1;
    }
}

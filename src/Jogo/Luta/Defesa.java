package Jogo.Luta;

import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Jogo.Jogo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;

import java.io.FileNotFoundException;

import static Jogo.Luta.Utils.influenciaNaturezaInimigo;
import static Utils.Som.playHit;
import static Utils.Som.stopHit;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

/**
 * Classe responsável por lidar com a lógica de defesa do Naruto durante o combate.
 * Contém métodos para lidar com ataques de inimigos comuns e com Sasuke (boss final),
 * bem como métodos auxiliares para cálculo de defesa.
 */
public class Defesa {

    /**
     * Executa a defesa contra um ataque aleatório de um inimigo comum.
     * O ataque pode ser normal, com arma ou ataque especial.
     *
     * @param inimigo Inimigo atacante.
     * @return true se o ataque foi realizado com sucesso, false caso o inimigo não tenha ataque disponível.
     */
    public static boolean defesa(Inimigo inimigo) throws FileNotFoundException, InterruptedException {
        int opcao = random(4); // Escolhe aleatoriamente um tipo de ataque (0 a 3)
        double dano;

        switch (opcao) {
            case 0: // Ataque normal
                dano = inimigo.getAtaque() - calcularDefesaNaruto(Jogo.getNaruto());
                if (influenciaNaturezaInimigo(inimigo)) dano *= 1.2;
                dano = Math.max(0, dano);
                Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                cleanConsole();
                imprimirFicheiro("src/imagens/ataque.txt");
                System.out.println(inimigo.getNome() + " atacou você com um ataque normal!");
                System.out.println("Você recebeu " + dano + " de dano.");
                sleep(2000);
                return true;

            case 1: // Ataque com arma
                Arma arma = inimigo.getArma();
                if (arma != null) {
                    dano = inimigo.getAtaque() + arma.getAtaqueArma() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo)) dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    playHit();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println(inimigo.getNome() + " atacou você com a arma " + getNomeArmaOuNenhuma(inimigo) + "!");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;

            case 2: // Ataque especial 1
                AtaqueChakra ataqueEspecial = inimigo.getAtaqueEspecial1();
                if (ataqueEspecial != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo)) dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    playHit();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;

            case 3: // Ataque especial 2
                AtaqueChakra ataqueEspecial2 = inimigo.getAtaqueEspecial2();
                if (ataqueEspecial2 != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial2.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial2.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo)) dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    playHit();
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;
        }

        return false;
    }

    /**
     * Executa a defesa contra um ataque de Sasuke (boss final).
     * Todos os ataques de Sasuke têm multiplicador fixo de 1.2.
     *
     * @param inimigo Sasuke.
     * @return true se o ataque foi executado, false se não havia ataque disponível.
     */
    public static boolean defesaFinal(Sasuke inimigo) throws FileNotFoundException, InterruptedException {
        int opcao = random(4);
        double dano;

        switch (opcao) {
            case 0: // Ataque normal
                dano = inimigo.getAtaque() - calcularDefesaNaruto(Jogo.getNaruto());
                dano *= 1.2;
                dano = Math.max(0, dano);
                Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                cleanConsole();
                playHit();
                imprimirFicheiro("src/imagens/ataque.txt");
                System.out.println(inimigo.getNome() + " atacou você com um ataque normal!");
                System.out.println("Você recebeu " + dano + " de dano.");
                sleep(2000);
                stopHit();
                return true;

            case 1: // Ataque com arma
                Arma arma = inimigo.getArma();
                if (arma != null) {
                    dano = inimigo.getAtaque() + arma.getAtaqueArma() - calcularDefesaNaruto(Jogo.getNaruto());
                    dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    playHit();
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println(inimigo.getNome() + " atacou você com a arma " + getNomeArmaOuNenhuma(inimigo) + "!");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;

            case 2: // Ataque especial 1
                AtaqueChakra ataqueEspecial = inimigo.getAtaqueEspecial1();
                if (ataqueEspecial != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    playHit();
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;

            case 3: // Ataque especial 2
                AtaqueChakra ataqueEspecial2 = inimigo.getAtaqueEspecial2();
                if (ataqueEspecial2 != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial2.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial2.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    playHit();
                    sleep(2000);
                    stopHit();
                    return true;
                } else return false;
        }

        return false;
    }

    /**
     * Calcula a defesa total de Naruto com base nas armaduras equipadas.
     *
     * @param naruto Objeto Naruto atual.
     * @return Defesa total considerando equipamentos.
     */
    public static double calcularDefesaNaruto(Naruto naruto) {
        double defesa = naruto.getDefesa();
        if (naruto.getBaixo() != null) {
            defesa += naruto.getBaixo().getDefesaArmadura();
        }
        if (naruto.getCima() != null) {
            defesa += naruto.getCima().getDefesaArmadura();
        }
        return defesa;
    }

    /**
     * Calcula a defesa total de Sasuke com base nas armaduras equipadas.
     *
     * @param sasuke Objeto Sasuke atual.
     * @return Defesa total considerando equipamentos.
     */
    public static double calcularDefesaSasuke(Sasuke sasuke) {
        double defesa = sasuke.getDefesa();
        if (sasuke.getBaixo() != null) {
            defesa += sasuke.getBaixo().getDefesaArmadura();
        }
        if (sasuke.getCima() != null) {
            defesa += sasuke.getCima().getDefesaArmadura();
        }
        return defesa;
    }
}

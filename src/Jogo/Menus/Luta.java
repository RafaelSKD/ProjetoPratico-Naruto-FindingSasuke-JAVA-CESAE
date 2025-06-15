package Jogo.Menus;

import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;
import Itens.Enum.HabilidadeArma;
import Itens.Enum.TipoConsumivel;
import Itens.Enum.TipoItem;
import Jogo.Jogo;
import Mapa.Vila;
import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;
import Ninjas.Ninja;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Paginas.Manual.manual;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class Luta {
    public static void main(String[] args) {
        Inimigo gara = new Inimigo("Gaara", Afinidade.TERRA, 500, 400, 350, 1000, 869.57, Localizacao.SUDOESTE);
        Naruto naruto = new Naruto(
                "Naruto Uzumaki",
                Afinidade.VENTO,
                1000.0, // chakra
                350.0,  // defesa
                400.0,  // ataque
                900.0,  // vida
                500 // dinheiro
        );
        Arma arma = new Arma("Cabaça de Areia", TipoItem.ARMA, HabilidadeArma.DEFESA, 40, 80, 0, 1000);
        AtaqueChakra ataque1 = new AtaqueChakra("Rasengan", TipoItem.ATAQUEESPECIAL, 120.0, 80.0);
        AtaqueChakra ataque2 = new AtaqueChakra("Rasen-Shuriken", TipoItem.ATAQUEESPECIAL, 200.0, 140.0);
        gara.setArma(arma);
        naruto.setAtaqueEspecial1(ataque1);
        naruto.setAtaqueEspecial2(ataque2);
        menuLutaTestes(gara, naruto);
    }
    public static void menuLutaTestes(Inimigo inimigo, Naruto naruto){  //para testes
        System.out.println("▄     ▜     ▖ ▖▘   ▘                                                                                                                                         ▓█████████░                     ");
        System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                                                                                                                                     ███          ██    █░              ");
        System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌                                                                      " + inimigo.getNome().toUpperCase() + colocarEspacos(inimigo.getNome().length(), 60) + "██░             ▒█░███▒              ");
        System.out.println("MANUAL: PREMIR 0  ▙▌                                                                                    " + "❤\uFE0F Saude: " + inimigo.getVida() + colocarEspacos((String.valueOf(inimigo.getVida()).length()), 37) + "█▒                ░██ █▓              ");
        System.out.println("                                                                                                        " + "\uD83D\uDCA0 Chakra: " + inimigo.getChakra() + colocarEspacos(String.valueOf(inimigo.getChakra()).length(), 35) + "█▓▒███████████████▒ ██ █░              ");
        System.out.println("                                                                                                        " + emogiAfinidade(inimigo) + " Afinidade: " + inimigo.getAfinidade() + colocarEspacos((emogiAfinidade(inimigo).length() + inimigo.getAfinidade().name().length()), 33) + " ██▒   █             ████▒              ");
        System.out.println("                                                                                                        " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(inimigo) + colocarEspacos(getNomeArmaOuNenhuma(inimigo).length(), 37) + "█     █░           ░▒████              ");
        System.out.println("                                                                                                                                                      █░  ███████████████▒▒▒██▓█▓             ");
        System.out.println("                                                                                                                                                      ███▓██▒   ▒█   ██▒█▓  ███ ██            ");
        System.out.println("                                                                                                                                                       █████░▒    █▓██▓░▒█  █ ░████           ");
        System.out.println("                                        NARUTO                                                                                                         ░█  ▒       █▒ ▓▓▓█ ██░    ░           ");
        System.out.println("          " + "❤\uFE0F Saude: " + naruto.getVida() + colocarEspacos((String.valueOf(naruto.getVida()).length()), 131) + "█▒▒▓██████▒     ▒████▒██              ");
        System.out.println("          " + "\uD83D\uDCA0 Chakra: " + naruto.getChakra() + colocarEspacos(String.valueOf(naruto.getChakra()).length(), 103) + "░░                       ██           ▒███▓  █▒ ██              ");
        System.out.println("          " + emogiAfinidade(naruto) + " Afinidade: " + naruto.getAfinidade() + colocarEspacos((emogiAfinidade(naruto).length() + naruto.getAfinidade().name().length()), 104) + "███    ▓██               ▓█           ▒█░ ▒█▒   ██▓░          ");
        System.out.println("          " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(naruto) + colocarEspacos(getNomeArmaOuNenhuma(naruto).length(), 107) + "█▓▒██████░                ▓█         ██ ░██    ▓█░  ███░      ");
        System.out.println("                                                                                                                              ░█░█░███▒                  ██      ██████     ██       ▒██    ");
        System.out.println("                                                                                                                              █▒ █████░                   ██  ██████▒     ▒█         ████▒  ");
        System.out.println("                                                                                                                             █▓█████▒ ░░██                 ░▓▓████░      ██       ██▓    ██ ");
        System.out.println("                                                                                                                             ██▓  ▓█ ▓██▓  ██                ▒█▒██░██   ▓█▒       ██       ██");
        System.out.println("                                                                                                                                 ░███████  ██              ▒█░  ▒█▓██ ██        ██         █░");
        System.out.println("             ░ ░░░░   ░░░░░  ░                                ░                                                                   ███████   █              ██ █   ▓███          █▒         █▓");
        System.out.println("       ▓ ░▒░▒               ▓▒▒▒▒▒░                         ▒▓░                                                                   █▓ ░░▓██  ██░          ▒███ █▓   ██           █░         ██");
        System.out.println("       ░                        ▒                        ░▒ █▒                                                                     ███░     ████        ██  ░█▒█   ▓█         █ █▒         ▒█");
        System.out.println("        ░                      ░░                      ░░ ░█▒                                                                        ▒███▒██░  ███    ██      ██░  ░█         ▒███         ░█");
        System.out.println("    ░░         ██████████         ▒▒                  ▒▒ ▓█░                                                                             █▓   ██ ░███████▒     ▓█   █░          ███         █░");
        System.out.println("       ▓    ░ ▒▒   ▒▒▒░   ░ ▒ ░ ▒                 ▒ ░▓ ░██▒                                                                               ████░  ▓█ ██░█        █▓  ▒█           ░█         █▒");
        System.out.println("     ░░  ░ █▒▒█     ▓░▓▒   ░▒█▓░ ░░             ░  ▒▒▓█▒▒                                                                                  ██   ██  ██  █      ███▒  █▒           █▒        █▓");
        System.out.println("     ░░▒░▒█████▓░░▒▒▒▓▓▓▓▒▓████░            ░░▓░     ▒▒  ░                                                                             ");
        System.out.println("       ▓▒█████▓▓▓▓▒░     ▒▓▒░▓█            ▒░▒    ▒▒░▒▒▒░░                                                                           ");
        System.out.println("         ██ ▒ ▒  ████▒ ▒█▒██ ▒▒          ▒  ░  ░▒▓▓▒   ▒▓          ::::::::::::::::::::::::::::::::::::::::::::::::::: MENU DE COMBATE ::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("         ▒▓▓░    ░░    ░ ░░  ▒░        ░░   ░   ██▒░░ ▒▒                                                                            ");
        System.out.println("         ▒░▓▓ ░░       ░     ▓░      ▒░░     ▒ ░███▓░                                                                                         ");
        System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                         Murro Ascendente -        PREMIR: 1" + colocarEspacos(((naruto.getAtaqueEspecial1()).getNome()).length(), 34) + (naruto.getAtaqueEspecial1()).getNome() + "(" + (naruto.getAtaqueEspecial1()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf((naruto.getAtaqueEspecial1()).getChakraNecessario()).length(), 12) + "PREMIR 4");
        System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
        System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░                            Varrimento de Perna -     PREMIR: 2" + colocarEspacos(((naruto.getAtaqueEspecial2()).getNome()).length(), 34) + (naruto.getAtaqueEspecial2()).getNome() + "(" + (naruto.getAtaqueEspecial2()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf((naruto.getAtaqueEspecial2()).getChakraNecessario()).length(), 12) + "PREMIR 5");
        System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
        System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                               Atacar com Arma -         PREMIR: 3                         Mochila de Itens -        PREMIR 6");
        System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
        System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
        System.out.println("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                   O que o naruto vai fazer? -  ");
    }

    public static String emogiAfinidade(Ninja inimigo) {
        switch (inimigo.getAfinidade()) {
            case FOGO:
                return "🔥";
            case VENTO:
                return "🌪️";
            case RELAMPAGO:
                return "⚡";
            case AGUA:
                return "💧";
            case TERRA:
                return "🪨";
            default:
                return "❓"; // Caso inesperado
        }
    }

    public static String colocarEspacos(int texto, int espacos){
        int spaces = espacos - texto;
        return " ".repeat(Math.max(0, spaces));
    }

    public static String getNomeArmaOuNenhuma(Ninja ninja) {
        if (ninja instanceof Inimigo) {
            Inimigo inimigo = (Inimigo) ninja;
            return inimigo.getArma() != null ? inimigo.getArma().getNome() : "Nenhuma";
        } else if (ninja instanceof Naruto) {
            Naruto naruto = (Naruto) ninja;
            return naruto.getArma() != null ? naruto.getArma().getNome() : "Nenhuma";
        } else if (ninja instanceof Sasuke) {
            Sasuke sasuke = (Sasuke) ninja;
            return sasuke.getArma() != null ? sasuke.getArma().getNome() : "Nenhuma";
        } else {
            return "Nenhuma";
        }
    }

    public static void menuLuta(Inimigo inimigo, Vila vila) throws InterruptedException, FileNotFoundException {
        int flag = 0;

        while ((Jogo.getNaruto()).getVida() > 0 && inimigo.getVida() > 0){
            cleanConsole();
            int option = layoutMenuLuta(inimigo);
            flag = dispacher(option, inimigo, flag);
        }
        if ((Jogo.getNaruto()).getVida() <= 0){
            cleanConsole();
            imprimirFicheiro("src/imagens/NarutoDie.txt");
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/gameOver.txt");
            sleep(2000);
            return;
        }
        if (inimigo.getVida() <= 0){
            cleanConsole();
            imprimirFicheiro("src/imagens/InimigoMorto.txt");
            System.out.println("+ " + inimigo.getDinheiro() + " moedas!");
            sleep(2000);
            (Jogo.getNaruto()).setDinheiro((Jogo.getNaruto()).getDinheiro() + inimigo.getDinheiro());
            vila.morto(inimigo);
        }
    }

    public static void menuLutaFinal(Sasuke sasuke, Vila vila) throws InterruptedException, FileNotFoundException {
        int flag = 0;

        while ((Jogo.getNaruto()).getVida() > 0 && sasuke.getVida() > 0){
            cleanConsole();
            int option = layoutMenuLutaFinal(sasuke);
            flag = dispacherLutaFinal(option, sasuke, flag);
        }
        if ((Jogo.getNaruto()).getVida() <= 0){
            cleanConsole();
            imprimirFicheiro("src/imagens/NarutoDie.txt");
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/gameOver.txt");
            sleep(4000);
            return;
        }
        if (sasuke.getVida() <= 0){
            cleanConsole();
            imprimirFicheiro("src/imagens/sasukelose.txt");
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/narutowin.txt");
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/wingame.txt");
            sleep(2000);
        }
    }

    private static int dispacher(int opcao, Inimigo inimigo, int flag) throws FileNotFoundException, InterruptedException {
        boolean narutoAgiu = false;

        switch (opcao) {
            case 0:
                cleanConsole();
                manual();
                break;
            case 1:
                cleanConsole();
                narutoAgiu = ataque(inimigo, "normal") != 0;
                break;
            case 2:
                cleanConsole();
                narutoAgiu = ataque(inimigo, "normal") != 0;
                break;
            case 3:
                cleanConsole();
                narutoAgiu = ataque(inimigo, "arma") != 0;
                break;
            case 4:
                cleanConsole();
                narutoAgiu = ataque(inimigo, "chakra1") != 0;
                break;
            case 5:
                cleanConsole();
                narutoAgiu = ataque(inimigo, "chakra2") != 0;
                break;
            case 6:
                cleanConsole();
                aplicarConsumivel(layoutMenuItem());
                return 0;
        }

        if (narutoAgiu && inimigo.getVida() > 0) {
            boolean inimigoAtacou = false;
            do{
                cleanConsole();
                menuInimigo(inimigo);
                sleep(1500);
                inimigoAtacou = defesa(inimigo);
            } while (!inimigoAtacou);
        }

        return 0;
    }

    private static void aplicarConsumivel(int i) throws FileNotFoundException, InterruptedException {
        Naruto naruto = Jogo.getNaruto();
        if (i == 0) {
            cleanConsole();
            manual();
        } else if (i > 0){
            Consumivel consumivel = naruto.getBolsa().get(i - 1);
            double percentagem = consumivel.getPercentagemEfeito();
            double multiplicador = (percentagem / 100.0) + 1;

            switch (consumivel.getTipoConsumivel()) {
                case ATAQUE:
                    double novoAtaque = naruto.getAtaque() * multiplicador;
                    double ganhoAtaque = novoAtaque - naruto.getAtaque();
                    System.out.println("Ganhou mais " + ganhoAtaque + " de força de ataque!");
                    sleep(2000);
                    naruto.setAtaque(novoAtaque);
                    break;

                case VIDA:
                    double novaVida = naruto.getVida() * multiplicador;
                    double ganhoVida = novaVida - naruto.getVida();
                    System.out.println("Ganhou mais " + ganhoVida + " de vida!");
                    sleep(2000);
                    naruto.setVida(novaVida);
                    break;

                case CHAKRA:
                    double novoChakra = naruto.getChakra() * multiplicador;
                    double ganhoChakra = novoChakra - naruto.getChakra();
                    System.out.println("Ganhou mais " + ganhoChakra + " de chakra!");
                    sleep(2000);
                    naruto.setChakra(novoChakra);
                    break;
            }

            naruto.getBolsa().remove(i - 1);
        }
    }

    private static int dispacherLutaFinal(int opcao, Sasuke inimigo, int flag) throws FileNotFoundException, InterruptedException {
        boolean narutoAgiu = false;

        switch (opcao) {
            case 0:
                cleanConsole();
                manual();
                break;
            case 1:
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "normal") != 0;
                break;
            case 2:
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "normal") != 0;
                break;
            case 3:
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "arma") != 0;
                break;
            case 4:
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "chakra1") != 0;
                break;
            case 5:
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "chakra2") != 0;
                break;
            case 6:
                cleanConsole();
                aplicarConsumivel(layoutMenuItem());
                return 0;
        }

        if (narutoAgiu && inimigo.getVida() > 0) {
            boolean inimigoAtacou = false;
            do{
                cleanConsole();
                menuInimigoFinal(inimigo);
                sleep(1500);
                inimigoAtacou = defesaFinal(inimigo);
            } while (!inimigoAtacou);
        }

        return 0;
    }

    private static boolean defesa(Inimigo inimigo) throws FileNotFoundException, InterruptedException {
        int opcao = random(4);
        double dano;

        switch (opcao) {
            case 0:
                // Ataque normal
                dano = inimigo.getAtaque() - calcularDefesaNaruto(Jogo.getNaruto());
                if (influenciaNaturezaInimigo(inimigo))
                    dano *= 1.2;
                dano = Math.max(0, dano);
                Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                cleanConsole();
                imprimirFicheiro("src/imagens/ataque.txt");
                System.out.println(inimigo.getNome() + " atacou você com um ataque normal!");
                System.out.println("Você recebeu " + dano + " de dano.");
                sleep(2000);
                return true;

            case 1:
                // Ataque com arma
                Arma arma = inimigo.getArma();
                if (arma != null) {
                    dano = inimigo.getAtaque() + arma.getAtaqueArma() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo))
                        dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println(inimigo.getNome() + " atacou você com a arma " + getNomeArmaOuNenhuma(inimigo) + "!");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem uma arma equipada!");
                    sleep(2000);
                    return false;
                }

            case 2:
                // Ataque especial
                AtaqueChakra ataqueEspecial = inimigo.getAtaqueEspecial1();
                if (ataqueEspecial != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo))
                        dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem um ataque especial equipado!");
                    sleep(2000);
                    return false;
                }

            case 3:
                // Ataque especial 2
                AtaqueChakra ataqueEspecial2 = inimigo.getAtaqueEspecial2();
                if (ataqueEspecial2 != null) {
                    System.out.println(inimigo.getNome() + " usou o ataque especial " + ataqueEspecial2.getNome() + "!");
                    dano = inimigo.getAtaque() + ataqueEspecial2.getForcaExtra() - calcularDefesaNaruto(Jogo.getNaruto());
                    if (influenciaNaturezaInimigo(inimigo))
                        dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem um ataque especial equipado!");
                    sleep(2000);
                    return false;
                }
        }
        return false;
    }

    private static boolean defesaFinal(Sasuke inimigo) throws FileNotFoundException, InterruptedException {
        int opcao = random(4);
        double dano;

        switch (opcao) {
            case 0:
                // Ataque normal
                dano = inimigo.getAtaque() - calcularDefesaNaruto(Jogo.getNaruto());
                dano *= 1.2;
                dano = Math.max(0, dano);
                Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                cleanConsole();
                imprimirFicheiro("src/imagens/ataque.txt");
                System.out.println(inimigo.getNome() + " atacou você com um ataque normal!");
                System.out.println("Você recebeu " + dano + " de dano.");
                sleep(2000);
                return true;

            case 1:
                // Ataque com arma
                Arma arma = inimigo.getArma();
                if (arma != null) {
                    dano = inimigo.getAtaque() + arma.getAtaqueArma() - calcularDefesaNaruto(Jogo.getNaruto());
                    dano *= 1.2;
                    dano = Math.max(0, dano);
                    Jogo.getNaruto().setVida(Jogo.getNaruto().getVida() - dano);
                    cleanConsole();
                    imprimirFicheiro("src/imagens/ataque.txt");
                    System.out.println(inimigo.getNome() + " atacou você com a arma " + getNomeArmaOuNenhuma(inimigo) + "!");
                    System.out.println("Você recebeu " + dano + " de dano.");
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem uma arma equipada!");
                    sleep(2000);
                    return false;
                }

            case 2:
                // Ataque especial
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
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem um ataque especial equipado!");
                    sleep(2000);
                    return false;
                }

            case 3:
                // Ataque especial 2
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
                    sleep(2000);
                    return true;
                } else {
                    System.out.println(inimigo.getNome() + " não tem um ataque especial equipado!");
                    sleep(2000);
                    return false;
                }
        }
        return false;
    }

    private static int ataque(Inimigo inimigo, String tipo) throws FileNotFoundException, InterruptedException {
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
                if (arma == null) {
                    System.out.println("Você não tem uma arma equipada!");
                    sleep(2000);
                    return 0;
                }
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

        // Aplicar vantagem elemental se houver
        if (vantagemNatureza) {
            dano *= 1.2;
        }

        // Evita dano negativo (cura)
        dano = Math.max(0, dano);
        inimigo.setVida(inimigo.getVida() - dano);

        imprimirFicheiro("src/imagens/ataque.txt");
        System.out.printf("Você atacou %s com %s causando %.1f de dano.%n", inimigo.getNome(), descricaoAtaque, dano);
        sleep(2000);

        return 1;
    }

    private static int ataqueFinal(Sasuke inimigo, String tipo) throws FileNotFoundException, InterruptedException {
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
                if (arma == null) {
                    System.out.println("Você não tem uma arma equipada!");
                    sleep(2000);
                    return 0;
                }
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

        // Garante que o dano mínimo seja 0 (não cura o inimigo)
        dano = Math.max(0, dano);
        inimigo.setVida(inimigo.getVida() - dano);

        imprimirFicheiro("src/imagens/ataque.txt");
        System.out.printf("Você atacou %s com %s causando %.1f de dano.%n", inimigo.getNome(), descricaoAtaque, dano);
        sleep(2000);
        return 1;
    }

    private static boolean influenciaNatureza(Inimigo inimigo) {
        Afinidade afinidadeNaruto = Jogo.getNaruto().getAfinidade();
        Afinidade afinidadeInimigo = inimigo.getAfinidade();

        switch (afinidadeNaruto) {
            case FOGO:
                return afinidadeInimigo == Afinidade.VENTO;
            case VENTO:
                return afinidadeInimigo == Afinidade.RELAMPAGO;
            case RELAMPAGO:
                return afinidadeInimigo == Afinidade.TERRA;
            case TERRA:
                return afinidadeInimigo == Afinidade.AGUA;
            case AGUA:
                return afinidadeInimigo == Afinidade.FOGO;
            default:
                return false;
        }
    }

    private static boolean influenciaNaturezaInimigo(Inimigo inimigo) {
        Afinidade afinidadeInimigo = inimigo.getAfinidade();
        Afinidade afinidadeNaruto = Jogo.getNaruto().getAfinidade();

        switch (afinidadeInimigo) {
            case FOGO:
                return afinidadeNaruto == Afinidade.VENTO;
            case VENTO:
                return afinidadeNaruto == Afinidade.RELAMPAGO;
            case RELAMPAGO:
                return afinidadeNaruto == Afinidade.TERRA;
            case TERRA:
                return afinidadeNaruto == Afinidade.AGUA;
            case AGUA:
                return afinidadeNaruto == Afinidade.FOGO;
            default:
                return false;
        }
    }

    public static int layoutMenuLuta(Inimigo inimigo) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("▄     ▜     ▖ ▖▘   ▘                                                                                                                                         ▓█████████░                     ");
            System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                                                                                                                                     ███          ██    █░              ");
            System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌                                                                      " + inimigo.getNome().toUpperCase() + colocarEspacos(inimigo.getNome().length(), 60) + "██░             ▒█░███▒              ");
            System.out.println("MANUAL: PREMIR 0  ▙▌                                                                                    " + "❤\uFE0F Saude: " + inimigo.getVida() + colocarEspacos((String.valueOf(inimigo.getVida()).length()), 37) + "█▒                ░██ █▓              ");
            System.out.println("                                                                                                        " + "\uD83D\uDCA0 Chakra: " + inimigo.getChakra() + colocarEspacos(String.valueOf(inimigo.getChakra()).length(), 35) + "█▓▒███████████████▒ ██ █░              ");
            System.out.println("                                                                                                        " + emogiAfinidade(inimigo) + " Afinidade: " + inimigo.getAfinidade() + colocarEspacos((emogiAfinidade(inimigo).length() + inimigo.getAfinidade().name().length()), 33) + " ██▒   █             ████▒              ");
            System.out.println("                                                                                                        " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(inimigo) + colocarEspacos(getNomeArmaOuNenhuma(inimigo).length(), 37) + "█     █░           ░▒████              ");
            System.out.println("                                                                                                                                                      █░  ███████████████▒▒▒██▓█▓             ");
            System.out.println("                                                                                                                                                      ███▓██▒   ▒█   ██▒█▓  ███ ██            ");
            System.out.println("                                                                                                                                                       █████░▒    █▓██▓░▒█  █ ░████           ");
            System.out.println("                                        NARUTO                                                                                                         ░█  ▒       █▒ ▓▓▓█ ██░    ░           ");
            System.out.println("          " + "❤\uFE0F Saude: " + (Jogo.getNaruto()).getVida() + colocarEspacos((String.valueOf((Jogo.getNaruto()).getVida()).length()), 131) + "█▒▒▓██████▒     ▒████▒██              ");
            System.out.println("          " + "\uD83D\uDCA0 Chakra: " + (Jogo.getNaruto()).getChakra() + colocarEspacos(String.valueOf((Jogo.getNaruto()).getChakra()).length(), 103) + "░░                       ██           ▒███▓  █▒ ██              ");
            System.out.println("          " + emogiAfinidade((Jogo.getNaruto())) + " Afinidade: " + (Jogo.getNaruto()).getAfinidade() + colocarEspacos((emogiAfinidade((Jogo.getNaruto())).length() + (Jogo.getNaruto()).getAfinidade().name().length()), 104) + "███    ▓██               ▓█           ▒█░ ▒█▒   ██▓░          ");
            System.out.println("          " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma((Jogo.getNaruto())) + colocarEspacos(getNomeArmaOuNenhuma((Jogo.getNaruto())).length(), 107) + "█▓▒██████░                ▓█         ██ ░██    ▓█░  ███░      ");
            System.out.println("                                                                                                                              ░█░█░███▒                  ██      ██████     ██       ▒██    ");
            System.out.println("                                                                                                                              █▒ █████░                   ██  ██████▒     ▒█         ████▒  ");
            System.out.println("                                                                                                                             █▓█████▒ ░░██                 ░▓▓████░      ██       ██▓    ██ ");
            System.out.println("                                                                                                                             ██▓  ▓█ ▓██▓  ██                ▒█▒██░██   ▓█▒       ██       ██");
            System.out.println("                                                                                                                                 ░███████  ██              ▒█░  ▒█▓██ ██        ██         █░");
            System.out.println("             ░ ░░░░   ░░░░░  ░                                ░                                                                   ███████   █              ██ █   ▓███          █▒         █▓");
            System.out.println("       ▓ ░▒░▒               ▓▒▒▒▒▒░                         ▒▓░                                                                   █▓ ░░▓██  ██░          ▒███ █▓   ██           █░         ██");
            System.out.println("       ░                        ▒                        ░▒ █▒                                                                     ███░     ████        ██  ░█▒█   ▓█         █ █▒         ▒█");
            System.out.println("        ░                      ░░                      ░░ ░█▒                                                                        ▒███▒██░  ███    ██      ██░  ░█         ▒███         ░█");
            System.out.println("    ░░         ██████████         ▒▒                  ▒▒ ▓█░                                                                             █▓   ██ ░███████▒     ▓█   █░          ███         █░");
            System.out.println("       ▓    ░ ▒▒   ▒▒▒░   ░ ▒ ░ ▒                 ▒ ░▓ ░██▒                                                                               ████░  ▓█ ██░█        █▓  ▒█           ░█         █▒");
            System.out.println("     ░░  ░ █▒▒█     ▓░▓▒   ░▒█▓░ ░░             ░  ▒▒▓█▒▒                                                                                  ██   ██  ██  █      ███▒  █▒           █▒        █▓");
            System.out.println("     ░░▒░▒█████▓░░▒▒▒▓▓▓▓▒▓████░            ░░▓░     ▒▒  ░                                                                             ");
            System.out.println("       ▓▒█████▓▓▓▓▒░     ▒▓▒░▓█            ▒░▒    ▒▒░▒▒▒░░                                                                           ");
            System.out.println("         ██ ▒ ▒  ████▒ ▒█▒██ ▒▒          ▒  ░  ░▒▓▓▒   ▒▓          ::::::::::::::::::::::::::::::::::::::::::::::::::: MENU DE COMBATE ::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("         ▒▓▓░    ░░    ░ ░░  ▒░        ░░   ░   ██▒░░ ▒▒                                                                            ");
            System.out.println("         ▒░▓▓ ░░       ░     ▓░      ▒░░     ▒ ░███▓░                                                                                         ");
            System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                         Murro Ascendente -        PREMIR: 1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial1()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial1()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario()).length(), 12) + "PREMIR 4");
            System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
            System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░                            Varrimento de Perna -     PREMIR: 2" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial2()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial2()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario()).length(), 12) + "PREMIR 5");
            System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
            System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                               Atacar com Arma -         PREMIR: 3                         Mochila de Itens -        PREMIR 6");
            System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
            System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
            System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                   O que o naruto vai fazer? -  ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    option = Integer.parseInt(line);
                    if (option >= 0 && option <= 6) {
                        break;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 6. ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return option;
    }

    public static int layoutMenuLutaFinal(Sasuke inimigo) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("▄     ▜     ▖ ▖▘   ▘                                                                                                                                         ▓█████████░                     ");
            System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                                                                                                                                     ███          ██    █░              ");
            System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌                                                                      " + inimigo.getNome().toUpperCase() + colocarEspacos(inimigo.getNome().length(), 60) + "██░             ▒█░███▒              ");
            System.out.println("MANUAL: PREMIR 0  ▙▌                                                                                    " + "❤\uFE0F Saude: " + inimigo.getVida() + colocarEspacos((String.valueOf(inimigo.getVida()).length()), 37) + "█▒                ░██ █▓              ");
            System.out.println("                                                                                                        " + "\uD83D\uDCA0 Chakra: " + inimigo.getChakra() + colocarEspacos(String.valueOf(inimigo.getChakra()).length(), 35) + "█▓▒███████████████▒ ██ █░              ");
            System.out.println("                                                                                                        " + emogiAfinidade(inimigo) + " Afinidade: " + inimigo.getAfinidade() + colocarEspacos((emogiAfinidade(inimigo).length() + inimigo.getAfinidade().name().length()), 33) + " ██▒   █             ████▒              ");
            System.out.println("                                                                                                        " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(inimigo) + colocarEspacos(getNomeArmaOuNenhuma(inimigo).length(), 37) + "█     █░           ░▒████              ");
            System.out.println("                                                                                                                                                      █░  ███████████████▒▒▒██▓█▓             ");
            System.out.println("                                                                                                                                                      ███▓██▒   ▒█   ██▒█▓  ███ ██            ");
            System.out.println("                                                                                                                                                       █████░▒    █▓██▓░▒█  █ ░████           ");
            System.out.println("                                        NARUTO                                                                                                         ░█  ▒       █▒ ▓▓▓█ ██░    ░           ");
            System.out.println("          " + "❤\uFE0F Saude: " + (Jogo.getNaruto()).getVida() + colocarEspacos((String.valueOf((Jogo.getNaruto()).getVida()).length()), 131) + "█▒▒▓██████▒     ▒████▒██              ");
            System.out.println("          " + "\uD83D\uDCA0 Chakra: " + (Jogo.getNaruto()).getChakra() + colocarEspacos(String.valueOf((Jogo.getNaruto()).getChakra()).length(), 103) + "░░                       ██           ▒███▓  █▒ ██              ");
            System.out.println("          " + emogiAfinidade((Jogo.getNaruto())) + " Afinidade: " + (Jogo.getNaruto()).getAfinidade() + colocarEspacos((emogiAfinidade((Jogo.getNaruto())).length() + (Jogo.getNaruto()).getAfinidade().name().length()), 104) + "███    ▓██               ▓█           ▒█░ ▒█▒   ██▓░          ");
            System.out.println("          " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma((Jogo.getNaruto())) + colocarEspacos(getNomeArmaOuNenhuma((Jogo.getNaruto())).length(), 107) + "█▓▒██████░                ▓█         ██ ░██    ▓█░  ███░      ");
            System.out.println("                                                                                                                              ░█░█░███▒                  ██      ██████     ██       ▒██    ");
            System.out.println("                                                                                                                              █▒ █████░                   ██  ██████▒     ▒█         ████▒  ");
            System.out.println("                                                                                                                             █▓█████▒ ░░██                 ░▓▓████░      ██       ██▓    ██ ");
            System.out.println("                                                                                                                             ██▓  ▓█ ▓██▓  ██                ▒█▒██░██   ▓█▒       ██       ██");
            System.out.println("                                                                                                                                 ░███████  ██              ▒█░  ▒█▓██ ██        ██         █░");
            System.out.println("             ░ ░░░░   ░░░░░  ░                                ░                                                                   ███████   █              ██ █   ▓███          █▒         █▓");
            System.out.println("       ▓ ░▒░▒               ▓▒▒▒▒▒░                         ▒▓░                                                                   █▓ ░░▓██  ██░          ▒███ █▓   ██           █░         ██");
            System.out.println("       ░                        ▒                        ░▒ █▒                                                                     ███░     ████        ██  ░█▒█   ▓█         █ █▒         ▒█");
            System.out.println("        ░                      ░░                      ░░ ░█▒                                                                        ▒███▒██░  ███    ██      ██░  ░█         ▒███         ░█");
            System.out.println("    ░░         ██████████         ▒▒                  ▒▒ ▓█░                                                                             █▓   ██ ░███████▒     ▓█   █░          ███         █░");
            System.out.println("       ▓    ░ ▒▒   ▒▒▒░   ░ ▒ ░ ▒                 ▒ ░▓ ░██▒                                                                               ████░  ▓█ ██░█        █▓  ▒█           ░█         █▒");
            System.out.println("     ░░  ░ █▒▒█     ▓░▓▒   ░▒█▓░ ░░             ░  ▒▒▓█▒▒                                                                                  ██   ██  ██  █      ███▒  █▒           █▒        █▓");
            System.out.println("     ░░▒░▒█████▓░░▒▒▒▓▓▓▓▒▓████░            ░░▓░     ▒▒  ░                                                                             ");
            System.out.println("       ▓▒█████▓▓▓▓▒░     ▒▓▒░▓█            ▒░▒    ▒▒░▒▒▒░░                                                                           ");
            System.out.println("         ██ ▒ ▒  ████▒ ▒█▒██ ▒▒          ▒  ░  ░▒▓▓▒   ▒▓          ::::::::::::::::::::::::::::::::::::::::::::::::::: MENU DE COMBATE ::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("         ▒▓▓░    ░░    ░ ░░  ▒░        ░░   ░   ██▒░░ ▒▒                                                                            ");
            System.out.println("         ▒░▓▓ ░░       ░     ▓░      ▒░░     ▒ ░███▓░                                                                                         ");
            System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                         Murro Ascendente -        PREMIR: 1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial1()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial1()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario()).length(), 12) + "PREMIR 4");
            System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
            System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░                            Varrimento de Perna -     PREMIR: 2" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial2()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial2()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario()).length(), 12) + "PREMIR 5");
            System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
            System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                               Atacar com Arma -         PREMIR: 3                         Mochila de Itens -        PREMIR 6");
            System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
            System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
            System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                   O que o naruto vai fazer? -  ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    option = Integer.parseInt(line);
                    if (option >= 0 && option <= 6) {
                        break;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 6. ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return option;
    }

    public static int layoutMenuItem() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option = -1;
        int consumivel = 0;
        while (true) {
            cleanConsole();
            System.out.println("▄     ▜     ▖ ▖▘   ▘                  ");
            System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                      ");
            System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌        ");
            System.out.println("MANUAL: PREMIR 0  ▙▌                            ");
            System.out.println("\n\n\n\n");
            System.out.println("                                              Lista de Consumiveis da mochila:\n\n");
            while (consumivel < Jogo.getNaruto().getBolsa().size()){
                Consumivel consumivelAtual = Jogo.getNaruto().getBolsa().get(consumivel);
                System.out.println("\n                                              Item " + (consumivel + 1) + ":\n");
                System.out.println("                                              Nome : " + consumivelAtual.getNome());
                System.out.println("                                              Forca: " + consumivelAtual.getPercentagemEfeito());
                System.out.println("                                              Tipo : " + consumivelAtual.getTipoConsumivel());
                consumivel++;
            }
            if (Jogo.getNaruto().getBolsa().isEmpty()){
                System.out.println("Upsss... Sem Items na mochila");
                sleep(2000);
                break;
            }
            System.out.print("\n                                              Escolha um item para usar (-1 para sair):");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    option = Integer.parseInt(line);
                    if (option >= -1 && option <= consumivel) {
                        return option;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a " + consumivel + " . ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
            sleep(2500); // para dar tempo de ler a mensagem!
            consumivel = 0; // Resetar o contador de consumíveis para a próxima iteração
        }
        return option;
    }

    public static void menuInimigo(Inimigo inimigo){
        System.out.println("▄     ▜     ▖ ▖▘   ▘                                                                                                                                         ▓█████████░                     ");
        System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                                                                                                                                     ███          ██    █░              ");
        System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌                                                                      " + inimigo.getNome().toUpperCase() + colocarEspacos(inimigo.getNome().length(), 60) + "██░             ▒█░███▒              ");
        System.out.println("MANUAL: PREMIR 0  ▙▌                                                                                    " + "❤\uFE0F Saude: " + inimigo.getVida() + colocarEspacos((String.valueOf(inimigo.getVida()).length()), 37) + "█▒                ░██ █▓              ");
        System.out.println("                                                                                                        " + "\uD83D\uDCA0 Chakra: " + inimigo.getChakra() + colocarEspacos(String.valueOf(inimigo.getChakra()).length(), 35) + "█▓▒███████████████▒ ██ █░              ");
        System.out.println("                                                                                                        " + emogiAfinidade(inimigo) + " Afinidade: " + inimigo.getAfinidade() + colocarEspacos((emogiAfinidade(inimigo).length() + inimigo.getAfinidade().name().length()), 33) + " ██▒   █             ████▒              ");
        System.out.println("                                                                                                        " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(inimigo) + colocarEspacos(getNomeArmaOuNenhuma(inimigo).length(), 37) + "█     █░           ░▒████              ");
        System.out.println("                                                                                                                                                      █░  ███████████████▒▒▒██▓█▓             ");
        System.out.println("                                                                                                                                                      ███▓██▒   ▒█   ██▒█▓  ███ ██            ");
        System.out.println("                                                                                                                                                       █████░▒    █▓██▓░▒█  █ ░████           ");
        System.out.println("                                        NARUTO                                                                                                         ░█  ▒       █▒ ▓▓▓█ ██░    ░           ");
        System.out.println("          " + "❤\uFE0F Saude: " + (Jogo.getNaruto()).getVida() + colocarEspacos((String.valueOf((Jogo.getNaruto()).getVida()).length()), 131) + "█▒▒▓██████▒     ▒████▒██              ");
        System.out.println("          " + "\uD83D\uDCA0 Chakra: " + (Jogo.getNaruto()).getChakra() + colocarEspacos(String.valueOf((Jogo.getNaruto()).getChakra()).length(), 103) + "░░                       ██           ▒███▓  █▒ ██              ");
        System.out.println("          " + emogiAfinidade((Jogo.getNaruto())) + " Afinidade: " + (Jogo.getNaruto()).getAfinidade() + colocarEspacos((emogiAfinidade((Jogo.getNaruto())).length() + (Jogo.getNaruto()).getAfinidade().name().length()), 104) + "███    ▓██               ▓█           ▒█░ ▒█▒   ██▓░          ");
        System.out.println("          " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma((Jogo.getNaruto())) + colocarEspacos(getNomeArmaOuNenhuma((Jogo.getNaruto())).length(), 107) + "█▓▒██████░                ▓█         ██ ░██    ▓█░  ███░      ");
        System.out.println("                                                                                                                              ░█░█░███▒                  ██      ██████     ██       ▒██    ");
        System.out.println("                                                                                                                              █▒ █████░                   ██  ██████▒     ▒█         ████▒  ");
        System.out.println("                                                                                                                             █▓█████▒ ░░██                 ░▓▓████░      ██       ██▓    ██ ");
        System.out.println("                                                                                                                             ██▓  ▓█ ▓██▓  ██                ▒█▒██░██   ▓█▒       ██       ██");
        System.out.println("                                                                                                                                 ░███████  ██              ▒█░  ▒█▓██ ██        ██         █░");
        System.out.println("             ░ ░░░░   ░░░░░  ░                                ░                                                                   ███████   █              ██ █   ▓███          █▒         █▓");
        System.out.println("       ▓ ░▒░▒               ▓▒▒▒▒▒░                         ▒▓░                                                                   █▓ ░░▓██  ██░          ▒███ █▓   ██           █░         ██");
        System.out.println("       ░                        ▒                        ░▒ █▒                                                                     ███░     ████        ██  ░█▒█   ▓█         █ █▒         ▒█");
        System.out.println("        ░                      ░░                      ░░ ░█▒                                                                        ▒███▒██░  ███    ██      ██░  ░█         ▒███         ░█");
        System.out.println("    ░░         ██████████         ▒▒                  ▒▒ ▓█░                                                                             █▓   ██ ░███████▒     ▓█   █░          ███         █░");
        System.out.println("       ▓    ░ ▒▒   ▒▒▒░   ░ ▒ ░ ▒                 ▒ ░▓ ░██▒                                                                               ████░  ▓█ ██░█        █▓  ▒█           ░█         █▒");
        System.out.println("     ░░  ░ █▒▒█     ▓░▓▒   ░▒█▓░ ░░             ░  ▒▒▓█▒▒                                                                                  ██   ██  ██  █      ███▒  █▒           █▒        █▓");
        System.out.println("     ░░▒░▒█████▓░░▒▒▒▓▓▓▓▒▓████░            ░░▓░     ▒▒  ░                                                                             ");
        System.out.println("       ▓▒█████▓▓▓▓▒░     ▒▓▒░▓█            ▒░▒    ▒▒░▒▒▒░░                                                                           ");
        System.out.println("         ██ ▒ ▒  ████▒ ▒█▒██ ▒▒          ▒  ░  ░▒▓▓▒   ▒▓          ::::::::::::::::::::::::::::::::::::::::::::::::::: MENU DE COMBATE ::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("         ▒▓▓░    ░░    ░ ░░  ▒░        ░░   ░   ██▒░░ ▒▒                                                                            ");
        System.out.println("         ▒░▓▓ ░░       ░     ▓░      ▒░░     ▒ ░███▓░                                                                                         ");
        System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                                                                   VEZ DO INIMIGO");
        System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
        System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░      ");
        System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
        System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                       ");
        System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
        System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
        System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                 ");
    }

    public static void menuInimigoFinal(Sasuke inimigo){
        System.out.println("▄     ▜     ▖ ▖▘   ▘                                                                                                                                         ▓█████████░                     ");
        System.out.println("▌▌▌▌█▌▐ ▛▌  ▛▖▌▌▛▌ ▌▀▌                                                                                                                                     ███          ██    █░              ");
        System.out.println("▙▘▙▌▙▖▐▖▙▌  ▌▝▌▌▌▌ ▌█▌                                                                      " + inimigo.getNome().toUpperCase() + colocarEspacos(inimigo.getNome().length(), 60) + "██░             ▒█░███▒              ");
        System.out.println("MANUAL: PREMIR 0  ▙▌                                                                                    " + "❤\uFE0F Saude: " + inimigo.getVida() + colocarEspacos((String.valueOf(inimigo.getVida()).length()), 37) + "█▒                ░██ █▓              ");
        System.out.println("                                                                                                        " + "\uD83D\uDCA0 Chakra: " + inimigo.getChakra() + colocarEspacos(String.valueOf(inimigo.getChakra()).length(), 35) + "█▓▒███████████████▒ ██ █░              ");
        System.out.println("                                                                                                        " + emogiAfinidade(inimigo) + " Afinidade: " + inimigo.getAfinidade() + colocarEspacos((emogiAfinidade(inimigo).length() + inimigo.getAfinidade().name().length()), 33) + " ██▒   █             ████▒              ");
        System.out.println("                                                                                                        " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma(inimigo) + colocarEspacos(getNomeArmaOuNenhuma(inimigo).length(), 37) + "█     █░           ░▒████              ");
        System.out.println("                                                                                                                                                      █░  ███████████████▒▒▒██▓█▓             ");
        System.out.println("                                                                                                                                                      ███▓██▒   ▒█   ██▒█▓  ███ ██            ");
        System.out.println("                                                                                                                                                       █████░▒    █▓██▓░▒█  █ ░████           ");
        System.out.println("                                        NARUTO                                                                                                         ░█  ▒       █▒ ▓▓▓█ ██░    ░           ");
        System.out.println("          " + "❤\uFE0F Saude: " + (Jogo.getNaruto()).getVida() + colocarEspacos((String.valueOf((Jogo.getNaruto()).getVida()).length()), 131) + "█▒▒▓██████▒     ▒████▒██              ");
        System.out.println("          " + "\uD83D\uDCA0 Chakra: " + (Jogo.getNaruto()).getChakra() + colocarEspacos(String.valueOf((Jogo.getNaruto()).getChakra()).length(), 103) + "░░                       ██           ▒███▓  █▒ ██              ");
        System.out.println("          " + emogiAfinidade((Jogo.getNaruto())) + " Afinidade: " + (Jogo.getNaruto()).getAfinidade() + colocarEspacos((emogiAfinidade((Jogo.getNaruto())).length() + (Jogo.getNaruto()).getAfinidade().name().length()), 104) + "███    ▓██               ▓█           ▒█░ ▒█▒   ██▓░          ");
        System.out.println("          " + "⚔\uFE0F Arma: " + getNomeArmaOuNenhuma((Jogo.getNaruto())) + colocarEspacos(getNomeArmaOuNenhuma((Jogo.getNaruto())).length(), 107) + "█▓▒██████░                ▓█         ██ ░██    ▓█░  ███░      ");
        System.out.println("                                                                                                                              ░█░█░███▒                  ██      ██████     ██       ▒██    ");
        System.out.println("                                                                                                                              █▒ █████░                   ██  ██████▒     ▒█         ████▒  ");
        System.out.println("                                                                                                                             █▓█████▒ ░░██                 ░▓▓████░      ██       ██▓    ██ ");
        System.out.println("                                                                                                                             ██▓  ▓█ ▓██▓  ██                ▒█▒██░██   ▓█▒       ██       ██");
        System.out.println("                                                                                                                                 ░███████  ██              ▒█░  ▒█▓██ ██        ██         █░");
        System.out.println("             ░ ░░░░   ░░░░░  ░                                ░                                                                   ███████   █              ██ █   ▓███          █▒         █▓");
        System.out.println("       ▓ ░▒░▒               ▓▒▒▒▒▒░                         ▒▓░                                                                   █▓ ░░▓██  ██░          ▒███ █▓   ██           █░         ██");
        System.out.println("       ░                        ▒                        ░▒ █▒                                                                     ███░     ████        ██  ░█▒█   ▓█         █ █▒         ▒█");
        System.out.println("        ░                      ░░                      ░░ ░█▒                                                                        ▒███▒██░  ███    ██      ██░  ░█         ▒███         ░█");
        System.out.println("    ░░         ██████████         ▒▒                  ▒▒ ▓█░                                                                             █▓   ██ ░███████▒     ▓█   █░          ███         █░");
        System.out.println("       ▓    ░ ▒▒   ▒▒▒░   ░ ▒ ░ ▒                 ▒ ░▓ ░██▒                                                                               ████░  ▓█ ██░█        █▓  ▒█           ░█         █▒");
        System.out.println("     ░░  ░ █▒▒█     ▓░▓▒   ░▒█▓░ ░░             ░  ▒▒▓█▒▒                                                                                  ██   ██  ██  █      ███▒  █▒           █▒        █▓");
        System.out.println("     ░░▒░▒█████▓░░▒▒▒▓▓▓▓▒▓████░            ░░▓░     ▒▒  ░                                                                             ");
        System.out.println("       ▓▒█████▓▓▓▓▒░     ▒▓▒░▓█            ▒░▒    ▒▒░▒▒▒░░                                                                           ");
        System.out.println("         ██ ▒ ▒  ████▒ ▒█▒██ ▒▒          ▒  ░  ░▒▓▓▒   ▒▓          ::::::::::::::::::::::::::::::::::::::::::::::::::: MENU DE COMBATE ::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("         ▒▓▓░    ░░    ░ ░░  ▒░        ░░   ░   ██▒░░ ▒▒                                                                            ");
        System.out.println("         ▒░▓▓ ░░       ░     ▓░      ▒░░     ▒ ░███▓░                                                                                         ");
        System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                                                                   VEZ DO SASUKE !");
        System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
        System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░      ");
        System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
        System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                       ");
        System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
        System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
        System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                 ");
    }

    public static double calcularDefesaNaruto(Naruto naruto){
        double defesa = naruto.getDefesa();
        if (naruto.getBaixo() != null){
            defesa += (naruto.getBaixo()).getDefesaArmadura();
        }
        if (naruto.getCima() != null){
            defesa += (naruto.getCima()).getDefesaArmadura();
        }
        return defesa;
    }

    public static double calcularDefesaSasuke(Sasuke sasuke){
        double defesa = sasuke.getDefesa();
        if (sasuke.getBaixo() != null){
            defesa += (sasuke.getBaixo()).getDefesaArmadura();
        }
        if (sasuke.getCima() != null){
            defesa += (sasuke.getCima()).getDefesaArmadura();
        }
        return defesa;
    }
}

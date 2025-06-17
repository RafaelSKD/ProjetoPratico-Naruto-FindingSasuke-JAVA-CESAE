package Jogo.Menus;

import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;
import Itens.Enum.HabilidadeArma;
import Utils.Som;
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

import static Jogo.Luta.Combate.ataque;
import static Jogo.Luta.Combate.ataqueFinal;
import static Jogo.Luta.Defesa.defesa;
import static Jogo.Luta.Defesa.defesaFinal;
import static Jogo.Menus.Manual.manual;
import static Utils.Som.*;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class Luta {


    /**
     * Menu principal de combate entre Naruto e um inimigo.
     * Controla o loop da luta enquanto ambos estiverem vivos, tratando ações do jogador e do inimigo.
     *
     * @param inimigo Inimigo com quem Naruto está lutando.
     * @param vila    Vila onde o inimigo pertence (necessária para marcar como morto ao fim da luta).
     * @throws InterruptedException Caso a thread seja pausada.
     * @throws FileNotFoundException Caso os ficheiros de imagem/texto não sejam encontrados.
     */
    public static void menuLuta(Inimigo inimigo, Vila vila) throws InterruptedException, FileNotFoundException {
        // Loop de combate: continua enquanto ambos tiverem vida
        while ((Jogo.getNaruto()).getVida() > 0 && inimigo.getVida() > 0){
            cleanConsole();
            int option = layoutMenuLuta(inimigo); // Mostra opções de combate e retorna escolha do jogador

            // Se a escolha não for fugir (-1), processa a opção
            if (option != -1)
                dispacher(option, inimigo);

            // Tentativa de fuga
            if (option == -1){
                int ramdom = random(2); // 50% de chance de fugir com sucesso

                if (ramdom == 0){
                    stopAll();
                    System.out.println("\n\n                                                                                  Covarde!\n");
                    sleep(1500);
                    break; // Sai do combate
                }

                if (ramdom == 1){
                    // Fuga falhou, inimigo ataca
                    System.out.println("\n\n                                                                                  Oh nao!, Tentativa de Fugir falhada\n");
                    sleep(1500);
                    boolean inimigoAtacou = false;

                    while (!inimigoAtacou){
                        cleanConsole();
                        menuInimigo(inimigo); // Mostra ação do inimigo
                        sleep(1500);
                        inimigoAtacou = defesa(inimigo); // Trata da defesa e define se o ataque foi realizado
                    }
                }
            }
        }

        // Verifica se Naruto morreu
        if ((Jogo.getNaruto()).getVida() <= 0){
            stopAll();
            return;
        }

        // Verifica se o inimigo foi derrotado
        if (inimigo.getVida() <= 0){
            stopAll();
            cleanConsole();
            imprimirFicheiro("src/imagens/InimigoMorto.txt"); // Mostra imagem de inimigo derrotado
            System.out.println("+ " + inimigo.getDinheiro() + " moedas!");
            sleep(2000);
            (Jogo.getNaruto()).setDinheiro((Jogo.getNaruto()).getDinheiro() + inimigo.getDinheiro()); // Adiciona recompensa
            vila.morto(inimigo); // Marca inimigo como morto na vila
        }
    }

    /**
     * Luta final contra Sasuke. Controla as ações durante o combate, incluindo tentativa de fuga
     * e turnos alternados entre Naruto e Sasuke.
     *
     * @param sasuke Oponente final do jogo.
     * @throws InterruptedException Caso haja pausas com `sleep`.
     * @throws FileNotFoundException Caso ocorra erro na leitura de ficheiros.
     */
    public static void menuLutaFinal(Sasuke sasuke) throws InterruptedException, FileNotFoundException {
        // Loop de combate: enquanto ambos estiverem vivos
        while ((Jogo.getNaruto()).getVida() > 0 && sasuke.getVida() > 0){
            cleanConsole(); // Limpa a consola para nova ronda
            int option = layoutMenuLutaFinal(sasuke); // Mostra menu de opções de combate final

            // Se jogador não escolheu fugir
            if (option != -1)
                dispacherLutaFinal(option, sasuke); // Processa ação do jogador

            // Tentativa de fuga
            if (option == -1){
                int ramdom = random(2); // 50% de chance de fuga bem-sucedida

                if (ramdom == 0){
                    stopAll();
                    System.out.println("\n\n                                                                                  Covarde!\n");
                    sleep(1500);
                    break; // Sai da luta
                }

                if (ramdom == 1){
                    // Fuga falhada: Sasuke ataca
                    System.out.println("\n\n                                                                                  Oh nao!, Tentativa de Fugir falhada!!!\n");
                    sleep(1500);
                    boolean inimigoAtacou = false;

                    while (!inimigoAtacou){
                        cleanConsole();
                        menuInimigoFinal(sasuke); // Mostra ação do Sasuke
                        sleep(1500);
                        inimigoAtacou = defesaFinal(sasuke); // Naruto defende e luta continua
                    }
                }
            }
        }
    }

    /**
     * Responsável por tratar as ações escolhidas por Naruto durante o combate.
     * Após a ação de Naruto, se o inimigo ainda estiver vivo, ele contra-ataca.
     *
     * @param opcao  A opção escolhida no menu de combate.
     * @param inimigo O inimigo atual em combate.
     * @return 0 sempre, pois não há retorno funcional neste contexto.
     * @throws FileNotFoundException Se ocorrer erro ao carregar imagens ou arquivos.
     * @throws InterruptedException  Se houver interrupções durante chamadas sleep.
     */
    private static int dispacher(int opcao, Inimigo inimigo) throws FileNotFoundException, InterruptedException {
        boolean narutoAgiu = false;

        switch (opcao) {
            case 0:
                // Abrir manual durante o combate
                cleanConsole();
                manual();
                break;
            case -1:
                // Tentativa de fuga — Naruto age, mas não ataca
                cleanConsole();
                narutoAgiu = true;
                break;
            case 1:
                // Ataque normal
                cleanConsole();
                narutoAgiu = ataque(inimigo, "normal") != 0;
                break;
            case 2:
                // Ataque com arma
                cleanConsole();
                narutoAgiu = ataque(inimigo, "arma") != 0;
                break;
            case 3:
                // Ataque com chakra 1
                cleanConsole();
                narutoAgiu = ataque(inimigo, "chakra1") != 0;
                break;
            case 4:
                // Ataque com chakra 2
                cleanConsole();
                narutoAgiu = ataque(inimigo, "chakra2") != 0;
                break;
            case 5:
                // Uso de item consumível
                cleanConsole();
                aplicarConsumivel(layoutMenuItem());
                return 0;
        }

        // Se Naruto agiu e o inimigo ainda está vivo, o inimigo ataca
        if (narutoAgiu && inimigo.getVida() > 0) {
            boolean inimigoAtacou = false;

            // Se a opção foi fuga, o inimigo não ataca nessa iteração
            if (opcao == -1){
                inimigoAtacou = true;
            }

            // Loop de ataque inimigo até ele completar a ação
            while (!inimigoAtacou){
                cleanConsole();
                menuInimigo(inimigo);
                sleep(1500);
                inimigoAtacou = defesa(inimigo);
            }
        }

        return 0;
    }

    /**
     * Gerencia as ações de Naruto durante a luta final contra Sasuke.
     * Após a escolha de ação, Sasuke pode contra-atacar se ainda estiver vivo.
     *
     * @param opcao   A opção selecionada no menu de luta final.
     * @param inimigo Oponente da luta final (Sasuke).
     * @return Retorna 0 após a execução da ação.
     * @throws FileNotFoundException Se arquivos visuais (ex: manuais) não forem encontrados.
     * @throws InterruptedException  Caso ocorra interrupção durante o uso do sleep().
     */
    private static int dispacherLutaFinal(int opcao, Sasuke inimigo) throws FileNotFoundException, InterruptedException {
        boolean narutoAgiu = false;

        switch (opcao) {
            case 0:
                // Abre o manual durante o combate final
                cleanConsole();
                manual();
                break;
            case -1:
                // Naruto tenta fugir (ação inválida na prática, mas registrada)
                cleanConsole();
                narutoAgiu = true;
                break;
            case 1:
                // Ataque normal
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "normal") != 0;
                break;
            case 2:
                // Ataque com arma
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "arma") != 0;
                break;
            case 3:
                // Ataque com chakra tipo 1
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "chakra1") != 0;
                break;
            case 4:
                // Ataque com chakra tipo 2
                cleanConsole();
                narutoAgiu = ataqueFinal(inimigo, "chakra2") != 0;
                break;
            case 5:
                // Uso de item consumível
                cleanConsole();
                aplicarConsumivel(layoutMenuItem());
                return 0;
        }

        // Se Naruto atacou e Sasuke ainda tem vida, ele contra-ataca
        if (narutoAgiu && inimigo.getVida() > 0) {
            boolean inimigoAtacou = false;

            // Caso de fuga — impede o contra-ataque direto
            if (opcao == -1){
                inimigoAtacou = true;
            }

            // Loop até Sasuke executar com sucesso o contra-ataque
            while (!inimigoAtacou){
                cleanConsole();
                menuInimigoFinal(inimigo); // exibe ação de Sasuke
                sleep(1500);
                inimigoAtacou = defesaFinal(inimigo); // executa defesa de Naruto contra Sasuke
            }
        }

        return 0;
    }

    /**
     * Exibe o menu de combate durante a luta contra um inimigo comum.
     * Mostra os dados de Naruto e do inimigo, incluindo vida, chakra, arma e afinidade,
     * além das opções de ataque, fuga ou uso de item.
     *
     * @param inimigo O inimigo atual contra quem Naruto está lutando.
     * @return A opção escolhida pelo jogador (-1 para fugir, 0 para manual, 1-5 para ações).
     * @throws InterruptedException Caso ocorra interrupção durante a pausa (sleep).
     */
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
            System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                         Fugir Amedrontado! -      PREMIR:-1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial1()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial1()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario()).length(), 12) + "PREMIR 3");
            System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
            System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░                            Ataque normal -           PREMIR: 1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial2()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial2()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario()).length(), 12) + "PREMIR 4");
            System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
            System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                               Atacar com Arma -         PREMIR: 2                         Mochila de Itens -        PREMIR 5");
            System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
            System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
            System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                   O que o naruto vai fazer? -  ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    option = Integer.parseInt(line);
                    if (option >= -1 && option <= 5) {
                        break;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de -1 a 5. ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return option;
    }

    /**
     * Exibe o menu de combate durante a luta contra o Sasuke.
     * Mostra os dados de Naruto e do Sasuke, incluindo vida, chakra, arma e afinidade,
     * além das opções de ataque, fuga ou uso de item.
     *
     * @param inimigo O Sasuke contra quem Naruto está lutando.
     * @return A opção escolhida pelo jogador (-1 para fugir, 0 para manual, 1-5 para ações).
     * @throws InterruptedException Caso ocorra interrupção durante a pausa (sleep).
     */
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
            System.out.println("         ░▒     ░           ▒▒   ▒▒▒░ ░       ░▓  ░▒                         Fugir Amedrontado! -      PREMIR:-1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial1()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial1()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial1()).getChakraNecessario()).length(), 12) + "PREMIR 3");
            System.out.println("         ░░▒░▒░    ▒▒▒▒▒▒░  ▒▒▒░   ░              ▒                                                                                 ");
            System.out.println("           ▒▒░▒░   ░      ░░▒░░   ░             ░                            Ataque normal -           PREMIR: 1" + colocarEspacos((((Jogo.getNaruto()).getAtaqueEspecial2()).getNome()).length(), 34) + ((Jogo.getNaruto()).getAtaqueEspecial2()).getNome() + "(" + ((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario() + "\uD83D\uDCA0)-" + colocarEspacos(String.valueOf(((Jogo.getNaruto()).getAtaqueEspecial2()).getChakraNecessario()).length(), 12) + "PREMIR 4");
            System.out.println("            ▒░▒▒ ░▒     ▒▒ ░▒  ░ ░           ░▓                                                                                     ");
            System.out.println("          ▒  ░░ ░   ▒▒░ ░ ░▒   ░           ░▒░                               Atacar com Arma -         PREMIR: 2                         Mochila de Itens -        PREMIR 5");
            System.out.println("          ▒░▓▒▒░▓▒  ▒ ░ ░ ░░   ░         ▒ ░                                                                                        ");
            System.out.println("        ░▒▒ ░░  ▓  ░   ░▒░  ░░░         ░░                                                                                          ");
            System.out.print("        ░░  ▓ ░░  ▒░  ░ ▒█     ░▒       ░░                                   O que o naruto vai fazer? -  ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    option = Integer.parseInt(line);
                    if (option >= -1 && option <= 5) {
                        break;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 6. ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                      ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return option;
    }

    /**
     * Exibe o menu de seleção de consumíveis disponíveis na bolsa de Naruto durante a luta.
     * O jogador pode escolher qual consumível deseja usar, visualizar seus efeitos e tipos.
     *
     * @return O número do item selecionado (1 a N), 0 para manual, ou -1 para sair sem usar item.
     * @throws InterruptedException Se a thread for interrompida durante o sleep.
     */
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
                System.out.println("                                              Forca: " + consumivelAtual.getEfeito());
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

    /**
     * Exibe o turno do inimigo durante o combate.
     * Mostra os status detalhados do inimigo e de Naruto, incluindo saúde, chakra, afinidade e arma.
     * Este método apenas imprime o layout visual sem realizar ações do inimigo.
     *
     * @param inimigo O inimigo atual em combate.
     */
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

    /**
     * Exibe o turno do Sasuke durante o combate.
     * Mostra os status detalhados do Sasuke e de Naruto, incluindo saúde, chakra, afinidade e arma.
     * Este método apenas imprime o layout visual sem realizar ações do Sasuke.
     *
     * @param inimigo O Sasuke em combate.
     */
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

}

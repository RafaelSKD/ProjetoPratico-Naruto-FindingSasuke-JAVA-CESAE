package Jogo.Navegacao;

import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.Consumiveis.Consumivel;
import Itens.Enum.TipoArmadura;
import Itens.Especial.Especial;
import Itens.Item;
import Jogo.Jogo;
import Mapa.Vila;
import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;
import Ninjas.Ninja;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Jogo.Menus.Luta.menuLuta;
import static Jogo.Menus.Luta.menuLutaFinal;
import static Jogo.Menus.Utils.getSpaces;
import static Utils.Som.*;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class EntrarVilaAleatoriaDaZona {

    /**
     * Método responsável por entrar em uma vila com base na localização informada.
     * Tenta encontrar uma vila com ninjas. Se não houver, exibe mensagem apropriada.
     * Se encontrar um ninja, define se é aliado ou inimigo.
     *
     * @param localizacao Localização escolhida pelo jogador.
     * @throws FileNotFoundException Se algum ficheiro de imagem não for encontrado.
     * @throws InterruptedException  Se o processo for interrompido durante espera.
     */
    public static void entrarNaVila(Localizacao localizacao) throws FileNotFoundException, InterruptedException {
        // Seleciona aleatoriamente uma vila com ninjas na localização dada
        Vila vilaAleatoria = vilaAleatoriaComNinjas(localizacao);

        // Se nenhuma vila com ninjas for encontrada, mostra uma imagem e retorna
        if (vilaAleatoria == null) {
            cleanConsole();
            imprimirFicheiro("src/imagens/NoNinjas.txt");
            stop();       // Espera o jogador pressionar Enter
            stopNav();    // Para a música de navegação
            return;
        }

        // Escolhe um ninja aleatório da vila
        Ninja ninja = ninjaEncontrado(vilaAleatoria);

        // Se não encontrar ninja (possível recursão para repetir tentativa)
        if (ninja == null) {
            stopNav();                     // Para a música antes de nova tentativa
            entrarNaVila(localizacao);     // Tenta novamente com a mesma localização
            return;
        }

        // Determina se o ninja é amigo ou inimigo e toma ação apropriada
        inimigoOuAmigo(ninja, vilaAleatoria);
    }

    /**
     * Seleciona aleatoriamente um ninja de uma vila.
     *
     * @param vila A vila de onde se quer obter um ninja.
     * @return Um Ninja aleatório, ou null se a vila não tiver ninjas.
     */
    private static Ninja ninjaEncontrado(Vila vila) {
        ArrayList<Ninja> listaNinjasPossiveis = vila.getListaNinjas();

        // Retorna null se não houver nenhum ninja disponível na vila
        if (listaNinjasPossiveis.isEmpty()) return null;

        // Seleciona e retorna um ninja aleatório da lista
        return listaNinjasPossiveis.get(random(listaNinjasPossiveis.size()));
    }


    /**
     * Retorna uma vila aleatória localizada na região indicada,
     * desde que tenha pelo menos um ninja disponível.
     *
     * @param localizacao A localização (enum) para filtrar as vilas.
     * @return Uma vila com ninjas, ou null se nenhuma estiver disponível.
     */
    private static Vila vilaAleatoriaComNinjas(Localizacao localizacao) {
        ArrayList<Vila> vilas = Jogo.getListaVilas();                // Todas as vilas do jogo
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();          // Lista temporária para armazenar vilas válidas

        // Filtra as vilas que estão na localização desejada e têm pelo menos um ninja
        for (Vila vila : vilas) {
            if (vila.getLocalizacao() == localizacao && !vila.getListaNinjas().isEmpty()) {
                vilasPossiveis.add(vila);
            }
        }

        // Retorna null se não houver nenhuma vila elegível
        if (vilasPossiveis.isEmpty()) {
            return null;
        }

        // Retorna uma vila aleatória da lista de possíveis
        return vilasPossiveis.get(random(vilasPossiveis.size()));
    }

    /**
     * Método responsável por tratar o encontro de Naruto com um ninja numa vila.
     * Pode ser um amigo (que oferece itens) ou um inimigo (que inicia combate).
     * Ou o Sasuke!!!
     */
    private static void inimigoOuAmigo(Ninja ninja, Vila vila) throws FileNotFoundException, InterruptedException {
        Scanner input = new Scanner(System.in);
        char opcao;
        Naruto naruto = Jogo.getNaruto();

        // Se o ninja encontrado for um aliado
        if (ninja instanceof Amigo) {
            cleanConsole();
            imprimirFicheiro("src/imagens/Amigo.txt");
            sleep(1000);
            Amigo amigo = (Amigo) ninja;
            Item item = amigo.getItem();

            // Caso o item recebido seja uma arma
            if (item instanceof Arma) {
                Arma arma = (Arma) item;

                // Se Naruto não tiver arma, equipa automaticamente
                if (naruto.getArma() == null) {
                    naruto.setArma(arma);
                    System.out.println("                                                                             🎴🎁");
                    System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a arma " + arma.getNome() + "!!!");
                    System.out.println("                                                                              ⚔️");
                    System.out.println("                                                " + arma.getNome() + " equipada com sucesso!");
                    System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                    System.out.println("                                                Arma da mais " + arma.getAtaqueArma() + " de ataque");
                    stop();
                    stopNav();
                    vila.morto(ninja);
                    return;
                } else {
                    // Comparação entre arma atual e nova, com opção de troca
                    Arma arma1 = naruto.getArma();
                    System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a arma " + arma.getNome() + "!!!\n\n");
                    System.out.println("                               Arma Equipada                                            Arma Nova         \n");
                    System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + arma1.getNome() + getSpaces(arma1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + arma.getNome());
                    System.out.println("                               ░░ Ataque Extra ░░ :  " + arma1.getAtaqueArma() + getSpaces(String.valueOf(arma1.getAtaqueArma())) + "░░ Ataque Extra ░░ :  " + arma.getAtaqueArma());
                    System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + arma1.getTipo() + getSpaces(arma1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + arma.getTipo());
                    System.out.println("                               ░ Forca do Efeito░ :  " + arma1.getForcaDoEfeito() + getSpaces(String.valueOf(arma1.getForcaDoEfeito())) + "░ Forca do Efeito░ :  " + arma.getForcaDoEfeito());
                    System.out.println("\n\n");
                    System.out.println("                                                                    Queres trocar? (S/N)");
                    do {
                        System.out.print("");
                        opcao = input.nextLine().charAt(0);
                    } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                    if (opcao == 'n' || opcao == 'N') {
                        vila.morto(ninja);
                        System.out.println("                                                        Arma nao equipada !!!  ");
                        stop();
                        stopNav();
                        return;
                    } else {
                        naruto.setArma(arma);
                        System.out.println("                                                         " + arma.getNome() + " equipada com sucesso!");
                        vila.morto(ninja);
                        stop();
                        stopNav();
                        return;
                    }
                }
            }

            // Caso o item recebido seja uma armadura (tipo CIMA ou BAIXO)
            if (item instanceof Armadura) {
                Armadura armadura = (Armadura) item;

                // Armadura do tipo CIMA
                if (armadura.getTipoArmadura() == TipoArmadura.CIMA) {
                    Armadura armaduraCima = armadura;

                    // Se Naruto não tiver armadura equipada
                    if (naruto.getCima() == null) {
                        naruto.setCima(armaduraCima);
                        System.out.println("                                                                             🎴🎁");
                        System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!");
                        System.out.println("                                                                              ⚔️");
                        System.out.println("                                                " + armadura.getNome() + " equipada com sucesso!");
                        System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                        System.out.println("                                                Armadura da mais " + armadura.getDefesaArmadura() + " de defesa");
                        stop();
                        stopNav();
                        vila.morto(ninja);
                        return;
                    } else {
                        // Comparação de armaduras com opção de troca
                        Armadura armadura1 = naruto.getCima();
                        System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!\n\n");
                        System.out.println("                               Armadura Equipada                                        Armadura Nova         \n");
                        System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + armadura1.getNome() + getSpaces(armadura1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + armaduraCima.getNome());
                        System.out.println("                               ░░ Defesa Extra ░░ :  " + armadura1.getDefesaArmadura() + getSpaces(String.valueOf(armadura1.getDefesaArmadura())) + "░░ Defesa Extra ░░ :  " + armaduraCima.getDefesaArmadura());
                        System.out.println("\n\n");
                        System.out.println("                                                                    Queres trocar? (S/N)");
                        do {
                            System.out.print("");
                            opcao = input.nextLine().charAt(0);
                        } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                        if (opcao == 'n' || opcao == 'N') {
                            vila.morto(ninja);
                            System.out.println("                                                        Armadura nao equipada !!!  ");
                            stop();
                            stopNav();
                            return;
                        } else {
                            naruto.setCima(armaduraCima);
                            System.out.println("                                                         " + armaduraCima.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            stop();
                            stopNav();
                            return;
                        }
                    }
                }

                // Armadura do tipo BAIXO (mesma lógica que acima)
                if (armadura.getTipoArmadura() == TipoArmadura.BAIXO) {
                    Armadura armaduraBaixo = armadura;
                    if (naruto.getBaixo() == null) {
                        naruto.setBaixo(armaduraBaixo);
                        System.out.println("                                                                             🎴🎁");
                        System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!");
                        System.out.println("                                                                              ⚔️");
                        System.out.println("                                                " + armadura.getNome() + " equipada com sucesso!");
                        System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                        System.out.println("                                                Armadura da mais " + armadura.getDefesaArmadura() + " de defesa");
                        stop();
                        stopNav();
                        vila.morto(ninja);
                        return;
                    } else {
                        Armadura armadura1 = naruto.getBaixo();
                        System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!\n\n");
                        System.out.println("                               Armadura Equipada                                        Armadura Nova         \n");
                        System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + armadura1.getNome() + getSpaces(armadura1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + armaduraBaixo.getNome());
                        System.out.println("                               ░░ Defesa Extra ░░ :  " + armadura1.getDefesaArmadura() + getSpaces(String.valueOf(armadura1.getDefesaArmadura())) + "░░ Defesa Extra ░░ :  " + armaduraBaixo.getDefesaArmadura());
                        System.out.println("\n\n");
                        System.out.println("                                                                    Queres trocar? (S/N)");
                        do {
                            System.out.print("");
                            opcao = input.nextLine().charAt(0);
                        } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                        if (opcao == 'n' || opcao == 'N') {
                            vila.morto(ninja);
                            System.out.println("                                                        Armadura nao equipada !!!  ");
                            stop();
                            stopNav();
                            return;
                        } else {
                            naruto.setBaixo(armaduraBaixo);
                            System.out.println("                                                         " + armaduraBaixo.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            stop();
                            stopNav();
                            return;
                        }
                    }
                }
            }

            // Caso o item recebido seja um consumível
            if (item instanceof Consumivel) {
                Consumivel consumivel = (Consumivel) item;
                naruto.addConsumivel(consumivel);
                System.out.println("                                               " + consumivel.getNome() + " adicionado com sucesso a bolsa de itens 🎒 ✅");
                vila.morto(ninja);
                stop();
                stopNav();
                return;
            }

            // Caso o item recebido seja especial
            if (item instanceof Especial) {
                Especial especial = (Especial) item;
                if (naruto.getEspecial() == null) {
                    naruto.setEspecial(especial);
                    System.out.println("                                               " + especial.getNome() + " adicionado com sucesso a slot especial 🌟 ✅");
                    vila.morto(ninja);
                    stop();
                    stopNav();
                    return;
                } else {
                    Especial especial1 = naruto.getEspecial();
                    System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te um item especial " + especial.getNome() + "!!!\n\n");
                    System.out.println("                               Especial Equipado                                        Especial Novo         \n");
                    System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + especial1.getNome() + getSpaces(especial1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + especial.getNome());
                    System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + especial1.getTipo() + getSpaces(especial1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + especial.getTipo());
                    System.out.println("                               ░ Forca do Efeito░ :  " + especial1.getEfeito() + getSpaces(String.valueOf(especial1.getEfeito())) + "░ Forca do Efeito░ :  " + especial.getEfeito());
                    System.out.println("\n\n");
                    System.out.println("                                                                    Queres trocar? (S/N)");
                    do {
                        System.out.print("");
                        opcao = input.nextLine().charAt(0);
                    } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                    if (opcao == 'n' || opcao == 'N') {
                        vila.morto(ninja);
                        System.out.println("                                                        Especial nao equipado !!!  ");
                        stop();
                        stopNav();
                        return;
                    } else {
                        naruto.setEspecial(especial);
                        System.out.println("                                                         " + especial.getNome() + " equipado com sucesso!");
                        vila.morto(ninja);
                        stop();
                        stopNav();
                        return;
                    }
                }
            }
        }

        // Se o ninja for inimigo comum
        stopAll();
        if (ninja instanceof Inimigo) {
            playFight();
            int flag = 0;
            if (naruto.getEspecial() != null){
                aplicarEfeitosEspecial();
                flag = 1;
            }
            cleanConsole();
            imprimirFicheiro("src/imagens/InimigoEncontrado.txt");
            sleep(2000);
            cleanConsole();
            menuLuta((Inimigo) ninja, vila);
            if (flag == 1)
                retirarEfeitosEspecial();
        }

        // Se for o Sasuke, luta final
        if (ninja instanceof Sasuke) {
            playSasuke();
            int flag = 0;
            if (naruto.getEspecial() != null){
                aplicarEfeitosEspecial();
                flag = 1;
            }
            cleanConsole();
            imprimirFicheiro("src/imagens/SasukeEncontrado.txt");
            sleep(2000);
            cleanConsole();
            imprimirFicheiro("src/imagens/LutaFinal.txt");
            sleep(2000);
            menuLutaFinal((Sasuke) ninja);
            if (flag == 1)
                retirarEfeitosEspecial();
        }
    }

    /**
     * Aplica os efeitos do item especial atualmente equipado por Naruto.
     * Dependendo do tipo do item, pode aumentar atributos como ataque, defesa, vida ou chakra.
     */
    private static void aplicarEfeitosEspecial() {
        Naruto naruto = Jogo.getNaruto();
        Especial especial = naruto.getEspecial();

        // Se o efeito for de ataque, aumenta o ataque de Naruto
        if (especial.isAtaque())
            naruto.setAtaque(naruto.getAtaque() + especial.getEfeito());

        // Se o efeito for de defesa, aumenta a defesa de Naruto
        if (especial.isDefesa())
            naruto.setDefesa(naruto.getDefesa() + especial.getEfeito());

        // Se o efeito for de vida, aumenta a vida de Naruto
        if (especial.isVida())
            naruto.setVida(naruto.getVida() + especial.getEfeito());

        // Se o efeito for de chakra, aumenta o chakra de Naruto
        if (especial.isChakra())
            naruto.setChakra(naruto.getChakra() + especial.getEfeito());
    }

    /**
     * Remove os efeitos temporários do item especial equipado por Naruto.
     * Usado após o término de uma luta onde o item especial teve efeito.
     */
    private static void retirarEfeitosEspecial() {
        Naruto naruto = Jogo.getNaruto();
        Especial especial = naruto.getEspecial();

        // Se o efeito foi de ataque, reverte o aumento de ataque
        if (especial.isAtaque())
            naruto.setAtaque(naruto.getAtaque() - especial.getEfeito());

        // Se o efeito foi de defesa, reverte o aumento de defesa
        if (especial.isDefesa())
            naruto.setDefesa(naruto.getDefesa() - especial.getEfeito());

        // Se o efeito foi de vida, reverte o aumento de vida
        if (especial.isVida())
            naruto.setVida(naruto.getVida() - especial.getEfeito());

        // Se o efeito foi de chakra, reverte o aumento de chakra
        if (especial.isChakra())
            naruto.setChakra(naruto.getChakra() - especial.getEfeito());
    }
}

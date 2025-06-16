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
import static Utils.Som.playSasuke;
import static Utils.Som.stopFight;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class EntrarVilaAleatoriaDaZona {

    public static void entrarNaVila(Localizacao localizacao) throws FileNotFoundException, InterruptedException {
        Vila vilaAleatoria = vilaAleatoriaComNinjas(localizacao);
        if (vilaAleatoria == null) {
            cleanConsole();
            imprimirFicheiro("src/imagens/NoNinjas.txt");
            stop();
            return;
        }

        Ninja ninja = ninjaEncontrado(vilaAleatoria);
        if (ninja == null) {
            entrarNaVila(localizacao);
            return;
        }

        inimigoOuAmigo(ninja, vilaAleatoria);
    }

    private static Ninja ninjaEncontrado(Vila vila) {
        ArrayList<Ninja> listaNinjasPossiveis = vila.getListaNinjas();
        if (listaNinjasPossiveis.isEmpty()) return null;
        return listaNinjasPossiveis.get(random(listaNinjasPossiveis.size()));
    }

    private static Vila vilaAleatoriaComNinjas(Localizacao localizacao) {
        ArrayList<Vila> vilas = Jogo.getListaVilas();
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();

        for (Vila vila : vilas) {
            if (vila.getLocalizacao() == localizacao && !vila.getListaNinjas().isEmpty()) {
                vilasPossiveis.add(vila);
            }
        }

        if (vilasPossiveis.isEmpty()) {
            return null;
        }

        return vilasPossiveis.get(random(vilasPossiveis.size()));
    }

    private static void inimigoOuAmigo(Ninja ninja, Vila vila) throws FileNotFoundException, InterruptedException {
        Scanner input = new Scanner(System.in);
        char opcao;
        Naruto naruto = Jogo.getNaruto();

        if (ninja instanceof Amigo) {
            cleanConsole();
            imprimirFicheiro("src/imagens/Amigo.txt");
            sleep(1000);
            Amigo amigo = (Amigo) ninja;
            Item item = amigo.getItem();

            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                if (naruto.getArma() == null) {
                    naruto.setArma(arma);
                    System.out.println("                                                                             🎴🎁");
                    System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a arma " + arma.getNome() + "!!!");
                    System.out.println("                                                                              ⚔️");
                    System.out.println("                                                " + arma.getNome() + " equipada com sucesso!");
                    System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                    System.out.println("                                                Arma da mais " + arma.getAtaqueArma() + " de ataque");
                    stop();
                    return;
                } else {
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
                        return;
                    } else {
                        naruto.setArma(arma);
                        System.out.println("                                                         " + arma.getNome() + " equipada com sucesso!");
                        vila.morto(ninja);
                        stop();
                        return;
                    }
                }
            }

            if (item instanceof Armadura) {
                Armadura armadura = (Armadura) item;
                if (armadura.getTipoArmadura() == TipoArmadura.CIMA) {
                    Armadura armaduraCima = armadura;
                    if (naruto.getCima() == null) {
                        naruto.setCima(armaduraCima);
                        System.out.println("                                                                             🎴🎁");
                        System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!");
                        System.out.println("                                                                              ⚔️");
                        System.out.println("                                                " + armadura.getNome() + " equipada com sucesso!");
                        System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                        System.out.println("                                                Armadura da mais " + armadura.getDefesaArmadura() + " de defesa");
                        stop();
                        return;
                    } else {
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
                            return;
                        } else {
                            naruto.setCima(armaduraCima);
                            System.out.println("                                                         " + armaduraCima.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            stop();
                            return;
                        }
                    }
                }

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
                            return;
                        } else {
                            naruto.setBaixo(armaduraBaixo);
                            System.out.println("                                                         " + armaduraBaixo.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            stop();
                            return;
                        }
                    }
                }
            }

            if (item instanceof Consumivel) {
                Consumivel consumivel = (Consumivel) item;
                naruto.addConsumivel(consumivel);
                System.out.println("                                               " + consumivel.getNome() + " adicionado com sucesso a bolsa de itens 🎒 ✅");
                vila.morto(ninja);
                stop();
                return;
            }

            if (item instanceof Especial) {
                Especial especial = (Especial) item;
                if (naruto.getEspecial() == null) {
                    naruto.setEspecial(especial);
                    System.out.println("                                               " + especial.getNome() + " adicionado com sucesso a slot especial 🌟 ✅");
                    vila.morto(ninja);
                    stop();
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
                        return;
                    } else {
                        naruto.setEspecial(especial);
                        System.out.println("                                                         " + especial.getNome() + " equipado com sucesso!");
                        vila.morto(ninja);
                        stop();
                        return;
                    }
                }
            }
        }

        if (ninja instanceof Inimigo) {
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

        if (ninja instanceof Sasuke) {
            stopFight();
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
            menuLutaFinal((Sasuke) ninja, vila);
            if (flag == 1)
                retirarEfeitosEspecial();
        }
    }

    private static void aplicarEfeitosEspecial(){
        Naruto naruto = Jogo.getNaruto();
        Especial especial = naruto.getEspecial();

        if (especial.isAtaque())
            naruto.setAtaque(naruto.getAtaque() + especial.getEfeito());
        if (especial.isDefesa())
            naruto.setDefesa(naruto.getDefesa() + especial.getEfeito());
        if (especial.isVida())
            naruto.setVida(naruto.getVida() + especial.getEfeito());
        if (especial.isChakra())
            naruto.setChakra(naruto.getChakra() + especial.getEfeito());
    }

    private static void retirarEfeitosEspecial(){
        Naruto naruto = Jogo.getNaruto();
        Especial especial = naruto.getEspecial();

        if (especial.isAtaque())
            naruto.setAtaque(naruto.getAtaque() - especial.getEfeito());
        if (especial.isDefesa())
            naruto.setDefesa(naruto.getDefesa() - especial.getEfeito());
        if (especial.isVida())
            naruto.setVida(naruto.getVida() - especial.getEfeito());
        if (especial.isChakra())
            naruto.setChakra(naruto.getChakra() - especial.getEfeito());
    }
}

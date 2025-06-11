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
import Ninjas.Ninja;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Jogo.Menus.Utils.getSpaces;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class EntrarVilaAleatoriaDaZona{

    public static void entrarNaVila(Localizacao localizacao) throws FileNotFoundException, InterruptedException {
        Ninja ninja;
        Vila vilaAleatoria;
        switch (localizacao) {
            case CENTRALORIENTE:
                vilaAleatoria = vilaAleatoria(Localizacao.CENTRALORIENTE);
                ninja = ninjaEncontrado(vilaAleatoria);
                if (ninja == null){
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NoNinjas.txt");
                    sleep(1000);
                    break;
                }
                inimigoOuAmigo(ninja, vilaAleatoria);
                break;
            case NORDESTE:
                vilaAleatoria = vilaAleatoria(Localizacao.NORDESTE);
                ninja = ninjaEncontrado(vilaAleatoria);
                if (ninja == null){
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NoNinjas.txt");
                    sleep(1000);
                    break;
                }
                inimigoOuAmigo(ninja, vilaAleatoria);
                break;
            case NOROESTE:
                vilaAleatoria = vilaAleatoria(Localizacao.NOROESTE);
                ninja = ninjaEncontrado(vilaAleatoria);
                if (ninja == null){
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NoNinjas.txt");
                    sleep(1000);
                    break;
                }
                inimigoOuAmigo(ninja, vilaAleatoria);
                break;
            case SUDESTE:
                vilaAleatoria = vilaAleatoria(Localizacao.SUDESTE);
                ninja = ninjaEncontrado(vilaAleatoria);
                if (ninja == null){
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NoNinjas.txt");
                    sleep(1000);
                    break;
                }
                inimigoOuAmigo(ninja, vilaAleatoria);
                break;
            case SUDOESTE:
                vilaAleatoria = vilaAleatoria(Localizacao.SUDOESTE);
                ninja = ninjaEncontrado(vilaAleatoria);
                if (ninja == null){
                    cleanConsole();
                    imprimirFicheiro("src/imagens/NoNinjas.txt");
                    sleep(1000);
                    break;
                }
                inimigoOuAmigo(ninja, vilaAleatoria);
                break;
        }
    }

    private static Ninja ninjaEncontrado(Vila vila) {
        ArrayList<Ninja> listaNinjasPossiveis = vila.getListaNinjas();
        if (listaNinjasPossiveis.isEmpty()) {
            return null;
        }
        return listaNinjasPossiveis.get(random(listaNinjasPossiveis.size()));
    }

    private static Vila vilaAleatoria(Localizacao localizacao){
        ArrayList<Vila> vilas = Jogo.getListaVilas();
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();

        for (Vila vila : vilas){
            if (vila.getLocalizacao() == localizacao)
                vilasPossiveis.add(vila);
        }

        return vilasPossiveis.get(random(vilasPossiveis.size()));
    }

    private static void inimigoOuAmigo(Ninja ninja, Vila vila) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        char opcao;
        if (ninja instanceof Amigo) {
            cleanConsole();
            imprimirFicheiro("src/imagens/Amigo.txt");
            Amigo amigo = (Amigo) ninja;
            Naruto naruto = Jogo.getNaruto();
            Item item = amigo.getItem();
            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                if (naruto.getArma() == null) {
                    naruto.setArma(arma);
                    System.out.println("                                                                             \uD83E\uDEF4\uD83C\uDFFC\uD83C\uDF81");
                    System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a arma " + arma.getNome() + "!!!");
                    System.out.println("                                                                              ⚔\uFE0F");
                    System.out.println("                                                " + arma.getNome() + " equipada com sucesso!");
                    System.out.println("                                                                        ⚔\uFE0E⛊STATS  ⚔\uFE0E⛊");
                    System.out.println("                                                Arma da mais " + arma.getAtaqueArma() + " de ataque");
                    return;
                } else {
                    Arma arma1 = naruto.getArma();
                    System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a arma " + arma.getNome() + "!!!\n\n");
                    System.out.println("                               " + "Arma Equipada                                            Arma Nova         \n");
                    System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + arma1.getNome() + getSpaces(arma1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + arma.getNome());
                    System.out.println("                               ░░ Ataque Extra ░░ :  " + arma1.getAtaqueArma() + getSpaces(String.valueOf(arma1.getAtaqueArma())) + "░░ Ataque Extra ░░ :  " + arma.getAtaqueArma());
                    System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + arma1.getTipo() + getSpaces(arma1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + arma.getTipo());
                    System.out.println("                               ░ Forca do Efeito░ :  " + arma1.getForcaDoEfeito() + getSpaces(String.valueOf(arma1.getForcaDoEfeito())) + "░ Forca do Efeito░ :  " + arma.getForcaDoEfeito());
                    System.out.println("\n\n");
                    System.out.println("                                                                    Queres trocar? (S/N)");
                    do{
                        System.out.print("");
                        opcao = input.nextLine().charAt(0);
                    }while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                    if (opcao == 'n' || opcao == 'N'){
                        vila.morto(ninja);
                        System.out.println("                                                        Arma nao equipada !!!  ");
                        return;
                    }
                    else{
                        naruto.setArma(arma);
                        System.out.println("                                                         " + arma.getNome() + " equipada com sucesso!");
                        vila.morto(ninja);
                        return;
                    }
                }
            }

            if (item instanceof Armadura) {
                Armadura armadura = (Armadura) item;
                if (armadura.getTipoArmadura() == TipoArmadura.CIMA) {
                    Armadura armaduraCima = (Armadura) item;
                    if (naruto.getCima() == null) {
                        naruto.setCima(armaduraCima);
                        System.out.println("                                                                             \uD83E\uDEF4\uD83C\uDFFC\uD83C\uDF81");
                        System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!");
                        System.out.println("                                                                              ⚔\uFE0F");
                        System.out.println("                                                " + armadura.getNome() + " equipada com sucesso!");
                        System.out.println("                                                                        ⚔\uFE0E⛊STATS  ⚔\uFE0E⛊");
                        System.out.println("                                                Armadura da mais " + armadura.getDefesaArmadura() + " de defesa");
                        return;
                    } else {
                        Armadura armadura1 = naruto.getCima();
                        System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!\n\n");
                        System.out.println("                               " + "Armadura Equipada                                        Armadura Nova         \n");
                        System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + armadura1.getNome() + getSpaces(armadura1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + armaduraCima.getNome());
                        System.out.println("                               ░░ Defesa Extra ░░ :  " + armadura1.getDefesaArmadura() + getSpaces(String.valueOf(armadura1.getDefesaArmadura())) + "░░ Ataque Extra ░░ :  " + armaduraCima.getDefesaArmadura());
                        System.out.println("\n\n");
                        System.out.println("                                                                    Queres trocar? (S/N)");
                        do{
                            System.out.print("");
                            opcao = input.nextLine().charAt(0);
                        }while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                        if (opcao == 'n' || opcao == 'N'){
                            vila.morto(ninja);
                            System.out.println("                                                        Armadura nao equipada !!!  ");
                            return;
                        }
                        else{
                            naruto.setCima(armaduraCima);
                            System.out.println("                                                         " + armaduraCima.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            return;
                        }
                    }
                }
                if (armadura.getTipoArmadura() == TipoArmadura.BAIXO) {
                    Armadura armaduraBaixo = (Armadura) item;
                    if (naruto.getBaixo() == null) {
                        naruto.setBaixo(armaduraBaixo);
                        System.out.println("                                                                             \uD83E\uDEF4\uD83C\uDFFC\uD83C\uDF81");
                        System.out.println("                                                " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!");
                        System.out.println("                                                                              ⚔\uFE0F");
                        System.out.println("                                                " + armadura.getNome() + " equipada com sucesso!");
                        System.out.println("                                                                        ⚔\uFE0E⛊STATS  ⚔\uFE0E⛊");
                        System.out.println("                                                Armadura da mais " + armadura.getDefesaArmadura() + " de defesa");
                        return;
                    } else {
                        Armadura armadura1 = naruto.getBaixo();
                        System.out.println("                                                  " + amigo.getNome() + " e um aliado e cedeu te a armadura " + armadura.getNome() + "!!!\n\n");
                        System.out.println("                               " + "Armadura Equipada                                        Armadura Nova         \n");
                        System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + armadura1.getNome() + getSpaces(armadura1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + armaduraBaixo.getNome());
                        System.out.println("                               ░░ Defesa Extra ░░ :  " + armadura1.getDefesaArmadura() + getSpaces(String.valueOf(armadura1.getDefesaArmadura())) + "░░ Ataque Extra ░░ :  " + armaduraBaixo.getDefesaArmadura());
                        System.out.println("\n\n");
                        System.out.println("                                                                    Queres trocar? (S/N)");
                        do{
                            System.out.print("");
                            opcao = input.nextLine().charAt(0);
                        }while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                        if (opcao == 'n' || opcao == 'N'){
                            vila.morto(ninja);
                            System.out.println("                                                        Armadura nao equipada !!!  ");
                            return;
                        }
                        else{
                            naruto.setBaixo(armaduraBaixo);
                            System.out.println("                                                         " + armaduraBaixo.getNome() + " equipada com sucesso!");
                            vila.morto(ninja);
                            return;
                        }
                    }
            }

            if (item instanceof Consumivel) {
                Consumivel consumivel = (Consumivel) item;
                naruto.addConsumivel(consumivel);
                // todo mensagem sucesso
                return;
            }

            if (item instanceof Especial) {
                if (naruto.getEspecial() == null) {
                    Especial especial = (Especial) item;
                    naruto.setEspecial(especial);
                    // todo mensagem sucesso
                    return;
                } else {
                    //todo perguntar se quer trocar ou nao
                }
            }
        }
        if (ninja instanceof Inimigo){
            // inicia a luta
        }
    }
}

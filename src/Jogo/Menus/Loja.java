package Jogo.Menus;

import Itens.Armas.Arma;
import Itens.Consumiveis.Consumivel;
import Itens.Especial.Especial;
import Itens.Item;
import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Jogo.Menus.Luta.colocarEspacos;
import static Jogo.Menus.Manual.manual;
import static Jogo.Menus.Utils.getSpaces;
import static Jogo.Menus.Utils.headerTenTen;
import static Utils.Utils.cleanConsole;
import static java.lang.Thread.sleep;

public class Loja {
    
    static void lojaArmas() throws InterruptedException, FileNotFoundException {
        int opcao;
        while (true) {
            opcao = lojaMenu();
            if (opcao == -1) {
                System.out.println("\n\n                                                  ⛔ Sair da loja... ⛔\n");
                sleep(1500);
                break;
            }
            if (opcao == 0) {
                System.out.println("\n\n                                                  ⛔ Abrir o manual... ⛔\n");
                sleep(1500);
                manual();
            }
        }
    }

    public static int lojaMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao;
        String[][] itensDisponiveis = preencherItens(Jogo.getLojaTenTen());

        while (true) {
            cleanConsole();
            headerTenTen();
            System.out.println("\n                                                               \uD83E\uDE99\uD83E\uDE99\uD83E\uDE99   MOEDAS : " + (Jogo.getNaruto()).getDinheiro());
            System.out.println(" ________________________________________________________________________________________________________________________________________________________");
            System.out.println("|    ITEM  1                                        |    ITEM  2                                        |    ITEM  3                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[0][0] + colocarEspacos(itensDisponiveis[0][0].length(), 40) + "|    Nome:  " + itensDisponiveis[1][0] + colocarEspacos(itensDisponiveis[1][0].length(), 40) + "|    Nome:  " + itensDisponiveis[2][0] + colocarEspacos(itensDisponiveis[2][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[0][1] + colocarEspacos(itensDisponiveis[0][1].length(), 40) + "|    Forca: " + itensDisponiveis[1][1] + colocarEspacos(itensDisponiveis[1][1].length(), 40) + "|    Forca: " + itensDisponiveis[2][1] + colocarEspacos(itensDisponiveis[2][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[0][2] + colocarEspacos(itensDisponiveis[0][2].length(), 40) + "|    Preco: " + itensDisponiveis[1][2] + colocarEspacos(itensDisponiveis[1][2].length(), 40) + "|    Preco: " + itensDisponiveis[2][2] + colocarEspacos(itensDisponiveis[2][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[0][3] + colocarEspacos(itensDisponiveis[0][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[1][3] + colocarEspacos(itensDisponiveis[1][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[2][3] + colocarEspacos(itensDisponiveis[2][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    ITEM  4                                        |    ITEM  5                                        |    ITEM  6                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[3][0] + colocarEspacos(itensDisponiveis[3][0].length(), 40) + "|    Nome:  " + itensDisponiveis[4][0] + colocarEspacos(itensDisponiveis[4][0].length(), 40) + "|    Nome:  " + itensDisponiveis[5][0] + colocarEspacos(itensDisponiveis[5][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[3][1] + colocarEspacos(itensDisponiveis[3][1].length(), 40) + "|    Forca: " + itensDisponiveis[4][1] + colocarEspacos(itensDisponiveis[4][1].length(), 40) + "|    Forca: " + itensDisponiveis[5][1] + colocarEspacos(itensDisponiveis[5][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[3][2] + colocarEspacos(itensDisponiveis[3][2].length(), 40) + "|    Preco: " + itensDisponiveis[4][2] + colocarEspacos(itensDisponiveis[4][2].length(), 40) + "|    Preco: " + itensDisponiveis[5][2] + colocarEspacos(itensDisponiveis[5][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[3][3] + colocarEspacos(itensDisponiveis[3][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[4][3] + colocarEspacos(itensDisponiveis[4][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[5][3] + colocarEspacos(itensDisponiveis[5][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    ITEM  7                                        |    ITEM  8                                        |    ITEM  9                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[6][0] + colocarEspacos(itensDisponiveis[6][0].length(), 40) + "|    Nome:  " + itensDisponiveis[7][0] + colocarEspacos(itensDisponiveis[7][0].length(), 40) + "|    Nome:  " + itensDisponiveis[8][0] + colocarEspacos(itensDisponiveis[8][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[6][1] + colocarEspacos(itensDisponiveis[6][1].length(), 40) + "|    Forca: " + itensDisponiveis[7][1] + colocarEspacos(itensDisponiveis[7][1].length(), 40) + "|    Forca: " + itensDisponiveis[8][1] + colocarEspacos(itensDisponiveis[8][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[6][2] + colocarEspacos(itensDisponiveis[6][2].length(), 40) + "|    Preco: " + itensDisponiveis[7][2] + colocarEspacos(itensDisponiveis[7][2].length(), 40) + "|    Preco: " + itensDisponiveis[8][2] + colocarEspacos(itensDisponiveis[8][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[6][3] + colocarEspacos(itensDisponiveis[6][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[7][3] + colocarEspacos(itensDisponiveis[7][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[8][3] + colocarEspacos(itensDisponiveis[8][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    ITEM  10                                       |    ITEM  11                                       |    Opcoes:                                     |");
            System.out.println("|                                                   |                                                   |    \uD83D\uDCB4 Para comprar, digite o número do item.   |");
            System.out.println("|    Nome:  " + itensDisponiveis[9][0] + colocarEspacos(itensDisponiveis[9][0].length(), 40) + "|    Nome:  " + itensDisponiveis[10][0] + colocarEspacos(itensDisponiveis[10][0].length(), 40) + "|    \uD83D\uDEAA Para sair, digite -1.                    |");
            System.out.println("|    Forca: " + itensDisponiveis[9][1] + colocarEspacos(itensDisponiveis[9][1].length(), 40) + "|    Forca: " + itensDisponiveis[10][1] + colocarEspacos(itensDisponiveis[10][1].length(), 40) + "|    \uD83D\uDCD6 Para ver o manual, digite 0.             |");
            System.out.println("|    Preco: " + itensDisponiveis[9][2] + colocarEspacos(itensDisponiveis[9][2].length(), 40) + "|    Preco: " + itensDisponiveis[10][2] + colocarEspacos(itensDisponiveis[10][2].length(), 40) + "|                                                |");
            System.out.println("|    Tipo:  " + itensDisponiveis[9][3] + colocarEspacos(itensDisponiveis[9][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[10][3] + colocarEspacos(itensDisponiveis[10][3].length(), 40) + "|                                   ... Escolha  |");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.print("                                                                                                                            Digite a opção desejada: ");
            if (input.hasNextInt()) {
                opcao = input.nextInt();
                if (opcao >= -1 && opcao <= 11) {
                    if (opcao <= 0)
                        return opcao;
                    compra(itensDisponiveis[opcao - 1][0]);
                    break;
                } else {
                    System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de -1 a 11. ⛔\n");
                }
            } else {
                System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                input.next(); // consome o valor incorreto para evitar loop infinito
            }
            sleep(2500); // para dar tempo de ler a mensagem!
        }
        return opcao;
    }

    private static void compra(String itemNome) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Item item = procurarItemLoja(itemNome);

        if (item instanceof Arma) {
            Arma arma = (Arma) item;
            if ((Jogo.getNaruto()).getDinheiro() < arma.getPreco()){
                System.out.println("Fundos insuficientes!");
                sleep(3000);
                return;
            }
            if ((Jogo.getNaruto()).getArma() == null) {
                (Jogo.getNaruto()).setArma(arma);
                (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - arma.getPreco());
                System.out.println("                                                                              ⚔\uFE0F");
                System.out.println("                                                " + arma.getNome() + " equipada com sucesso!");
                System.out.println("                                                                        ⚔\uFE0E⛊STATS  ⚔\uFE0E⛊");
                System.out.println("                                                Arma da mais " + arma.getAtaqueArma() + " de ataque");
                sleep(3000);
                return;
            } else {
                Arma arma1 = (Jogo.getNaruto()).getArma();
                System.out.println("                               " + "Arma Equipada                                            Arma Nova         \n");
                System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + arma1.getNome() + getSpaces(arma1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + arma.getNome());
                System.out.println("                               ░░ Ataque Extra ░░ :  " + arma1.getAtaqueArma() + getSpaces(String.valueOf(arma1.getAtaqueArma())) + "░░ Ataque Extra ░░ :  " + arma.getAtaqueArma());
                System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + arma1.getTipo() + getSpaces(arma1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + arma.getTipo());
                System.out.println("                               ░ Forca do Efeito░ :  " + arma1.getForcaDoEfeito() + getSpaces(String.valueOf(arma1.getForcaDoEfeito())) + "░ Forca do Efeito░ :  " + arma.getForcaDoEfeito());
                System.out.println("\n\n");
                System.out.println("                                                                    Queres trocar? (S/N)");
                char opcao;
                do {
                    System.out.print("");
                    opcao = input.nextLine().charAt(0);
                } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                if (opcao == 'n' || opcao == 'N') {
                    System.out.println("                                                        Arma nao equipada !!!  ");
                    sleep(3000);
                    return;
                } else {
                    (Jogo.getNaruto()).setArma(arma);
                    (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - arma.getPreco());

                    System.out.println("                                                         " + arma.getNome() + " equipada com sucesso!");
                    sleep(3000);
                    return;
                }
            }
        }

        if (item instanceof Consumivel) {
            Consumivel consumivel = (Consumivel) item;
            if ((Jogo.getNaruto()).getDinheiro() < consumivel.getPreco()){
                System.out.println("Fundos insuficientes!");
                sleep(3000);
                return;
            }
            (Jogo.getNaruto()).addConsumivel(consumivel);
            (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - consumivel.getPreco());

            System.out.println("                                               " + consumivel.getNome() + "adicionado com sucesso a bolsa de itens \uD83C\uDF92 ✅");
            sleep(3000);
            return;
        }

        if (item instanceof Especial) {
            Especial especial = (Especial) item;
            if ((Jogo.getNaruto()).getDinheiro() < especial.getPreco()){
                System.out.println("Fundos insuficientes!");
                sleep(3000);
                return;
            }
            if ((Jogo.getNaruto()).getEspecial() == null) {
                (Jogo.getNaruto()).setEspecial(especial);
                (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - especial.getPreco());
                System.out.println("                                               " + especial.getNome() + "adicionado com sucesso a slot especial \uD83C\uDF1F ✅");
                sleep(3000);
            } else {
                Especial especial1 = (Jogo.getNaruto()).getEspecial();
                System.out.println("                               " + "Especial Equipado                                        Especial Novo         \n");
                System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + especial1.getNome() + getSpaces(especial1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + especial.getNome());
                System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + especial1.getTipo() + getSpaces(especial1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + especial.getTipo());
                System.out.println("                               ░ Forca do Efeito░ :  " + especial1.getEfeito() + getSpaces(String.valueOf(especial1.getEfeito())) + "░ Forca do Efeito░ :  " + especial.getEfeito());
                System.out.println("\n\n");
                System.out.println("                                                                    Queres trocar? (S/N)");
                char opcao;
                do {
                    System.out.print("");
                    opcao = input.nextLine().charAt(0);
                } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');
                if (opcao == 'n' || opcao == 'N') {
                    System.out.println("                                                        Especial nao equipado !!!  ");
                    sleep(3000);
                } else {
                    (Jogo.getNaruto()).setEspecial(especial);
                    (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - especial.getPreco());
                    System.out.println("                                                         " + especial.getNome() + " equipado com sucesso!");
                    sleep(3000);
                }
            }
        }
    }

    private static Item procurarItemLoja(String itemNome){
        for (Item item : Jogo.getLojaTenTen()){
            if (item.getNome() == itemNome)
                return item;
        }
        return null;
    }

    private static String[][] preencherItens(ArrayList<Item> lojaTenTen) {
        String[][] tabela = new String[lojaTenTen.size()][4];

        for (int i = 0; i < lojaTenTen.size(); i++) {
            Item item = lojaTenTen.get(i);
            tabela[i][0] = item.getNome();

            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                tabela[i][1] = String.valueOf(arma.getAtaqueArma());
                tabela[i][2] = String.valueOf(arma.getPreco());
                tabela[i][3] = String.valueOf(arma.getTipo());
            } else if (item instanceof Consumivel) {
                Consumivel cons = (Consumivel) item;
                tabela[i][1] = String.valueOf(cons.getPercentagemEfeito());
                tabela[i][2] = String.valueOf(cons.getPreco());
                tabela[i][3] = String.valueOf(cons.getTipo());
            } else if (item instanceof Especial) {
                Especial esp = (Especial) item;
                tabela[i][1] = String.valueOf(esp.getEfeito());
                tabela[i][2] = String.valueOf(esp.getPreco());
                tabela[i][3] = String.valueOf(esp.getTipo());
            }
        }

        return tabela;
    }
}

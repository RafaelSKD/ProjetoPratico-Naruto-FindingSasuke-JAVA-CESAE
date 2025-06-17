package Jogo.Menus;

import Itens.Armas.Arma;
import Itens.Consumiveis.Consumivel;
import Itens.Especial.Especial;
import Itens.Item;
import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static Jogo.Menus.Manual.manual;
import static Jogo.Menus.Utils.getSpaces;
import static Jogo.Menus.Utils.headerTenTen;
import static Utils.Cores.ConsoleColors.*;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.colocarEspacos;
import static java.lang.Thread.sleep;

public class Loja {

    /**
     * Método principal que gere o ciclo da loja de armas.
     * Permite ao jogador:
     * - visualizar itens,
     * - comprar,
     * - sair da loja (-1),
     * - ou abrir o manual (0).
     */
    static void lojaArmas() throws InterruptedException, FileNotFoundException {
        int opcao;
        while (true) {
            opcao = lojaMenu(); // apresenta o menu de itens e retorna a escolha do jogador

            if (opcao == -1) {
                // Jogador escolheu sair da loja
                System.out.println("\n\n                                                             ⛔ Sair da loja... ⛔\n");
                sleep(1500);
                break;
            }

            if (opcao == 0) {
                // Jogador escolheu abrir o manual
                System.out.println("\n\n                                                             ⛔ Abrir o manual... ⛔\n");
                sleep(1500);
                manual(); // abre o manual do jogo
            }
        }
    }


    /**
     * Exibe o menu da loja com os itens disponíveis.
     * Retorna a opção escolhida pelo jogador ou redireciona para compra/manual.
     *
     * @return int - número do item comprado, 0 para manual, -1 para sair
     * @throws InterruptedException se a espera (sleep) for interrompida
     */
    public static int lojaMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int opcao;

        // Converte a lista de objetos Item para uma tabela de strings para exibição
        String[][] itensDisponiveis = preencherItens(Jogo.getLojaTenTen());

        while (true) {
            cleanConsole();
            headerTenTen();
            System.out.println("\n                                                               \uD83E\uDE99\uD83E\uDE99\uD83E\uDE99   MOEDAS : " + YELLOW_BOLD+ (Jogo.getNaruto()).getDinheiro() + RESET);
            System.out.println(" ________________________________________________________________________________________________________________________________________________________");
            System.out.println("|    " + YELLOW_BOLD + "ITEM  1" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  2" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  3" + RESET + "                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[0][0] + colocarEspacos(itensDisponiveis[0][0].length(), 40) + "|    Nome:  " + itensDisponiveis[1][0] + colocarEspacos(itensDisponiveis[1][0].length(), 40) + "|    Nome:  " + itensDisponiveis[2][0] + colocarEspacos(itensDisponiveis[2][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[0][1] + colocarEspacos(itensDisponiveis[0][1].length(), 40) + "|    Forca: " + itensDisponiveis[1][1] + colocarEspacos(itensDisponiveis[1][1].length(), 40) + "|    Forca: " + itensDisponiveis[2][1] + colocarEspacos(itensDisponiveis[2][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[0][2] + colocarEspacos(itensDisponiveis[0][2].length(), 40) + "|    Preco: " + itensDisponiveis[1][2] + colocarEspacos(itensDisponiveis[1][2].length(), 40) + "|    Preco: " + itensDisponiveis[2][2] + colocarEspacos(itensDisponiveis[2][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[0][3] + colocarEspacos(itensDisponiveis[0][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[1][3] + colocarEspacos(itensDisponiveis[1][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[2][3] + colocarEspacos(itensDisponiveis[2][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    " + YELLOW_BOLD + "ITEM  4" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  5" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  6" + RESET + "                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[3][0] + colocarEspacos(itensDisponiveis[3][0].length(), 40) + "|    Nome:  " + itensDisponiveis[4][0] + colocarEspacos(itensDisponiveis[4][0].length(), 40) + "|    Nome:  " + itensDisponiveis[5][0] + colocarEspacos(itensDisponiveis[5][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[3][1] + colocarEspacos(itensDisponiveis[3][1].length(), 40) + "|    Forca: " + itensDisponiveis[4][1] + colocarEspacos(itensDisponiveis[4][1].length(), 40) + "|    Forca: " + itensDisponiveis[5][1] + colocarEspacos(itensDisponiveis[5][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[3][2] + colocarEspacos(itensDisponiveis[3][2].length(), 40) + "|    Preco: " + itensDisponiveis[4][2] + colocarEspacos(itensDisponiveis[4][2].length(), 40) + "|    Preco: " + itensDisponiveis[5][2] + colocarEspacos(itensDisponiveis[5][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[3][3] + colocarEspacos(itensDisponiveis[3][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[4][3] + colocarEspacos(itensDisponiveis[4][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[5][3] + colocarEspacos(itensDisponiveis[5][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    " + YELLOW_BOLD + "ITEM  7" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  8" + RESET + "                                        |    " + YELLOW_BOLD + "ITEM  9" + RESET + "                                     |");
            System.out.println("|                                                   |                                                   |                                                |");
            System.out.println("|    Nome:  " + itensDisponiveis[6][0] + colocarEspacos(itensDisponiveis[6][0].length(), 40) + "|    Nome:  " + itensDisponiveis[7][0] + colocarEspacos(itensDisponiveis[7][0].length(), 40) + "|    Nome:  " + itensDisponiveis[8][0] + colocarEspacos(itensDisponiveis[8][0].length(), 37) + "|");
            System.out.println("|    Forca: " + itensDisponiveis[6][1] + colocarEspacos(itensDisponiveis[6][1].length(), 40) + "|    Forca: " + itensDisponiveis[7][1] + colocarEspacos(itensDisponiveis[7][1].length(), 40) + "|    Forca: " + itensDisponiveis[8][1] + colocarEspacos(itensDisponiveis[8][1].length(), 37) + "|");
            System.out.println("|    Preco: " + itensDisponiveis[6][2] + colocarEspacos(itensDisponiveis[6][2].length(), 40) + "|    Preco: " + itensDisponiveis[7][2] + colocarEspacos(itensDisponiveis[7][2].length(), 40) + "|    Preco: " + itensDisponiveis[8][2] + colocarEspacos(itensDisponiveis[8][2].length(), 37) + "|");
            System.out.println("|    Tipo:  " + itensDisponiveis[6][3] + colocarEspacos(itensDisponiveis[6][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[7][3] + colocarEspacos(itensDisponiveis[7][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[8][3] + colocarEspacos(itensDisponiveis[8][3].length(), 37) + "|");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.println("|    " + YELLOW_BOLD + "ITEM  10" + RESET + "                                       |    " + YELLOW_BOLD + "ITEM  11" + RESET + "                                       |    " + YELLOW_BOLD + "Opcoes:" + RESET + "                                     |");
            System.out.println("|                                                   |                                                   |    \uD83D\uDCB4 Para comprar, digite o número do item.   |");
            System.out.println("|    Nome:  " + itensDisponiveis[9][0] + colocarEspacos(itensDisponiveis[9][0].length(), 40) + "|    Nome:  " + itensDisponiveis[10][0] + colocarEspacos(itensDisponiveis[10][0].length(), 40) + "|    \uD83D\uDEAA " + RED_UNDERLINED + "Para sair, digite -1." + RESET + "                    |");
            System.out.println("|    Forca: " + itensDisponiveis[9][1] + colocarEspacos(itensDisponiveis[9][1].length(), 40) + "|    Forca: " + itensDisponiveis[10][1] + colocarEspacos(itensDisponiveis[10][1].length(), 40) + "|    \uD83D\uDCD6 " + CYAN_UNDERLINED + "Para ver o manual, digite 0." + RESET + "             |");
            System.out.println("|    Preco: " + itensDisponiveis[9][2] + colocarEspacos(itensDisponiveis[9][2].length(), 40) + "|    Preco: " + itensDisponiveis[10][2] + colocarEspacos(itensDisponiveis[10][2].length(), 40) + "|                                                |");
            System.out.println("|    Tipo:  " + itensDisponiveis[9][3] + colocarEspacos(itensDisponiveis[9][3].length(), 40) + "|    Tipo:  " + itensDisponiveis[10][3] + colocarEspacos(itensDisponiveis[10][3].length(), 40) + "|                                   ... Escolha  |");
            System.out.println("|___________________________________________________|___________________________________________________|________________________________________________|");
            System.out.print("                                                                                                                            Digite a opção desejada: ");


            // Validação da entrada do jogador
            if (input.hasNextInt()) {
                opcao = input.nextInt();

                if (opcao >= -1 && opcao <= 11) {
                    if (opcao <= 0)
                        return opcao; // -1 para sair ou 0 para manual

                    // Realiza a compra com base no nome do item selecionado
                    compra(itensDisponiveis[opcao - 1][0]);
                    break;
                } else {
                    // Número fora do intervalo permitido
                    System.out.println("\n\n                                                ⛔ Opção inválida! Escolha um número de -1 a 11. ⛔\n");
                }
            } else {
                // Entrada não numérica
                System.out.println("\n\n                                                ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                input.next(); // Evita loop infinito limpando o buffer
            }

            sleep(2500); // Dá tempo para o jogador ler a mensagem antes de limpar
        }

        return opcao;
    }

    /**
     * Realiza a compra de um item da loja com base no nome.
     * A lógica trata de armas, consumíveis e itens especiais, atualizando o inventário de Naruto.
     *
     * @param itemNome Nome do item que o jogador deseja comprar
     * @throws InterruptedException caso o sleep seja interrompido
     */
    private static void compra(String itemNome) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        // Busca o item na loja pelo nome
        Item item = procurarItemLoja(itemNome);

        // Se o item for uma arma
        if (item instanceof Arma) {
            Arma arma = (Arma) item;

            // Verifica se o jogador tem dinheiro suficiente
            if ((Jogo.getNaruto()).getDinheiro() < arma.getPreco()) {
                System.out.println("                                                              Fundos insuficientes!");
                sleep(3000);
                return;
            }

            // Se Naruto ainda não tem uma arma equipada
            if ((Jogo.getNaruto()).getArma() == null) {
                (Jogo.getNaruto()).setArma(arma);
                (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - arma.getPreco());
                System.out.println("                                                                              ⚔️");
                System.out.println("                                                                 " + arma.getNome() + " equipada com sucesso!");
                System.out.println("                                                                        ⚔️⛊STATS  ⚔️⛊");
                System.out.println("                                                                   Arma da mais " + arma.getAtaqueArma() + " de ataque");
                sleep(3000);
                return;
            } else {
                // Compara a arma equipada com a nova
                Arma arma1 = (Jogo.getNaruto()).getArma();
                System.out.println("                               " + "Arma Equipada                                            Arma Nova         \n");
                System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + arma1.getNome() + getSpaces(arma1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + arma.getNome());
                System.out.println("                               ░░ Ataque Extra ░░ :  " + arma1.getAtaqueArma() + getSpaces(String.valueOf(arma1.getAtaqueArma())) + "░░ Ataque Extra ░░ :  " + arma.getAtaqueArma());
                System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + arma1.getTipo() + getSpaces(arma1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + arma.getTipo());
                System.out.println("                               ░ Forca do Efeito░ :  " + arma1.getForcaDoEfeito() + getSpaces(String.valueOf(arma1.getForcaDoEfeito())) + "░ Forca do Efeito░ :  " + arma.getForcaDoEfeito());
                System.out.println("\n\n");
                System.out.println("                                                                    Queres trocar? (S/N)");

                // Confirmação da troca
                char opcao;
                do {
                    System.out.print("");
                    opcao = input.nextLine().charAt(0);
                } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');

                if (opcao == 'n' || opcao == 'N') {
                    System.out.println("                                                               Arma nao equipada !!!  ");
                    sleep(3000);
                    return;
                } else {
                    // Troca a arma e atualiza o dinheiro
                    (Jogo.getNaruto()).setArma(arma);
                    (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - arma.getPreco());

                    System.out.println("                                                         " + arma.getNome() + " equipada com sucesso!");
                    sleep(3000);
                    return;
                }
            }
        }


        // Se o item for um consumível (ex: poções, boosts temporários etc.)
        if (item instanceof Consumivel) {
            Consumivel consumivel = (Consumivel) item;

            // Verifica se Naruto tem dinheiro suficiente para comprar
            if ((Jogo.getNaruto()).getDinheiro() < consumivel.getPreco()){
                System.out.println("                                                             Fundos insuficientes!");
                sleep(3000);
                return;
            }

            // Adiciona o consumível à bolsa de itens do Naruto
            (Jogo.getNaruto()).addConsumivel(consumivel);

            // Desconta o preço do item do saldo do jogador
            (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - consumivel.getPreco());

            // Mensagem de sucesso
            System.out.println("                                               " + consumivel.getNome() + " adicionado com sucesso à bolsa de itens 🎒 ✅");
            sleep(3000);
            return;
        }


        // Se o item for do tipo Especial (buffs passivos enquanto equipados)
        if (item instanceof Especial) {
            Especial especial = (Especial) item;

            // Verifica se o jogador tem moedas suficientes
            if ((Jogo.getNaruto()).getDinheiro() < especial.getPreco()) {
                System.out.println("Fundos insuficientes!");
                sleep(3000);
                return;
            }

            // Caso Naruto ainda não tenha nenhum item especial equipado
            if ((Jogo.getNaruto()).getEspecial() == null) {
                (Jogo.getNaruto()).setEspecial(especial); // equipa direto
                (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - especial.getPreco());
                System.out.println("                                               " + especial.getNome() + " adicionado com sucesso à slot especial 🌟 ✅");
                sleep(3000);
            } else {
                // Se já há um especial equipado, apresenta comparação entre os dois
                Especial especial1 = (Jogo.getNaruto()).getEspecial();
                System.out.println("                               " + "Especial Equipado                                        Especial Novo         \n");
                System.out.println("                               ░░░░░░ Nome ░░░░░░ :  " + especial1.getNome() + getSpaces(especial1.getNome()) + "░░░░░░ Nome ░░░░░░ :  " + especial.getNome());
                System.out.println("                               ░░░░░░ Tipo ░░░░░░ :  " + especial1.getTipo() + getSpaces(especial1.getTipo().name()) + "░░░░░░ Tipo ░░░░░░ :  " + especial.getTipo());
                System.out.println("                               ░ Forca do Efeito░ :  " + especial1.getEfeito() + getSpaces(String.valueOf(especial1.getEfeito())) + "░ Forca do Efeito░ :  " + especial.getEfeito());
                System.out.println("\n\n");

                // Pergunta ao jogador se deseja trocar o item atual pelo novo
                System.out.println("                                                                    Queres trocar? (S/N)");
                char opcao;
                do {
                    System.out.print("");
                    opcao = input.nextLine().charAt(0);
                } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');

                if (opcao == 'n' || opcao == 'N') {
                    System.out.println("                                                             Especial não equipado !!!");
                    sleep(3000);
                } else {
                    // Substitui o item especial e desconta o valor
                    (Jogo.getNaruto()).setEspecial(especial);
                    (Jogo.getNaruto()).setDinheiro(((Jogo.getNaruto()).getDinheiro()) - especial.getPreco());
                    System.out.println("                                                         " + especial.getNome() + " equipado com sucesso!");
                    sleep(3000);
                }
            }
        }

    }

    /**
     * Procura e retorna um item na loja da TenTen com base no nome fornecido.
     *
     * @param itemNome Nome do item a ser procurado na loja.
     * @return O objeto Item correspondente ao nome fornecido, ou null se não for encontrado.
     */
    private static Item procurarItemLoja(String itemNome) {
        // Percorre todos os itens da loja de TenTen
        for (Item item : Jogo.getLojaTenTen()) {
            // Compara o nome do item com o nome fornecido (atenção: == compara referências!)
            if (item.getNome() == itemNome)
                return item; // Retorna o item correspondente
        }
        return null; // Retorna null se nenhum item for encontrado
    }


    /**
     * Preenche uma tabela bidimensional com as informações dos itens da loja TenTen.
     * Cada linha representa um item, com colunas para nome, força/efeito, preço e tipo.
     *
     * @param lojaTenTen Lista de itens disponíveis na loja.
     * @return Uma matriz de Strings com os detalhes dos itens formatados para exibição.
     */
    private static String[][] preencherItens(ArrayList<Item> lojaTenTen) {
        String[][] tabela = new String[lojaTenTen.size()][4]; // Tabela com 4 colunas: Nome, Força, Preço, Tipo

        for (int i = 0; i < lojaTenTen.size(); i++) {
            Item item = lojaTenTen.get(i);
            tabela[i][0] = item.getNome(); // Nome do item

            // Verifica o tipo do item para preencher os dados corretamente
            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                tabela[i][1] = String.valueOf(arma.getAtaqueArma()); // Força de ataque
                tabela[i][2] = String.valueOf(arma.getPreco());      // Preço
                tabela[i][3] = String.valueOf(arma.getTipo());       // Tipo da arma
            } else if (item instanceof Consumivel) {
                Consumivel cons = (Consumivel) item;
                tabela[i][1] = String.valueOf(cons.getEfeito());           // Efeito do consumível
                tabela[i][2] = String.valueOf(cons.getPreco());            // Preço
                tabela[i][3] = String.valueOf(cons.getTipoConsumivel());   // Tipo (VIDA, CHAKRA, ATAQUE)
            } else if (item instanceof Especial) {
                Especial esp = (Especial) item;
                tabela[i][1] = String.valueOf(esp.getEfeito());    // Efeito fixo do item especial
                tabela[i][2] = String.valueOf(esp.getPreco());     // Preço

                // Construção da string de tipos que o item especial afeta
                String tipo = "ESPECIAL:";
                if (esp.isAtaque()) tipo += " ATAQUE";
                if (esp.isChakra()) tipo += " CHAKRA";
                if (esp.isDefesa()) tipo += " DEFESA";
                if (esp.isVida()) tipo += " VIDA";

                // Caso o item afete todos os atributos, simplifica o tipo
                if (esp.isAtaque() && esp.isChakra() && esp.isDefesa() && esp.isVida())
                    tipo = "ESPECIAL: TODOS";

                tabela[i][3] = tipo;
            }
        }

        return tabela;
    }

}

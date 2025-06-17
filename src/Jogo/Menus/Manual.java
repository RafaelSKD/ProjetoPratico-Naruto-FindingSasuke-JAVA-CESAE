package Jogo.Menus;

import Itens.Consumiveis.Consumivel;
import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class Manual {

    /**
     * Exibe o menu do manual do jogo, permitindo visualizar:
     * - Estatísticas do Naruto
     * - Mochila (itens consumíveis)
     * - História
     * - Instruções do jogo
     *
     * Sai do manual ao escolher a opção 0.
     */
    public static void manual() throws InterruptedException, FileNotFoundException {
        while (true) {
            int opcao = manualMenu(); // Mostra o menu principal do manual
            if (opcao == 0) {
                System.out.println("A sair do manual...");
                sleep(2000);
                break; // Sai do loop do manual
            }
            dispacherManual(opcao); // Executa a opção escolhida
        }
    }

    /**
     * Executa a ação correspondente à opção escolhida no manual.
     *
     * @param i opção escolhida
     */
    private static void dispacherManual(int i) throws InterruptedException, FileNotFoundException {
        switch (i) {
            case 1:
                mostrarStats(); // Mostra os stats de Naruto
                break;
            case 2:
                mostrarMochila(); // Lista os itens na mochila
                break;
            case 3:
                mostrarHistoria(); // Exibe a história atual
                break;
            case 4:
                menuExplicacoes(); // Explicações sobre o funcionamento do jogo
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    /**
     * Mostra o menu principal do manual e lê a opção do utilizador.
     *
     * @return a opção escolhida (0 a 4)
     */
    public static int manualMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            cleanConsole();
            System.out.println("\n\n\n\n📊 NARUTO STATS   -  PRIMA 1");
            System.out.println("🎒 MOCHILA        -  PRIMA 2");
            System.out.println("📖 HISTÓRIA       -  PRIMA 3");
            System.out.println("🎮 JOGO           -  PRIMA 4");
            System.out.print("\n\nEscolha uma opcao (0 para sair): ");
            if (input.hasNextLine()) {
                String line = input.nextLine().trim();
                try {
                    int option = Integer.parseInt(line);
                    if (option >= 0 && option <= 4) {
                        return option;
                    } else {
                        System.out.println("\n\n                                                   ⛔ Opção inválida! Escolha um número de 0 a 4 . ⛔\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n\n                                                  ⛔ Entrada inválida! Por favor, insira um número. ⛔\n");
                }
            }
        }
    }

    /**
     * Mostra as estatísticas atuais do Naruto:
     * Vida, Chakra, Ataque, Defesa e Dinheiro.
     */
    private static void mostrarStats() throws InterruptedException {
        cleanConsole();
        System.out.println("📊 STATS DE NARUTO\n");
        System.out.println("Vida: " + Jogo.getNaruto().getVida());
        System.out.println("Chakra: " + Jogo.getNaruto().getChakra());
        System.out.println("Ataque: " + Jogo.getNaruto().getAtaque());
        System.out.println("Defesa: " + Jogo.getNaruto().getDefesa());
        System.out.println("Dinheiro: " + Jogo.getNaruto().getDinheiro());
        System.out.println("\n\n\n\n\n");
        stop(); // Espera até o utilizador carregar numa tecla
    }

    /**
     * Mostra os Itens na mochila do Naruto
     */
private static void mostrarMochila() throws InterruptedException {
        cleanConsole();
        System.out.println("🎒 MOCHILA DE NARUTO\n");

        if (Jogo.getNaruto().getBolsa().isEmpty()) {
            System.out.println("😕 Ups... Naruto não tem nenhum item na mochila no momento.");
            System.out.println("Tenta encontrar aliados ou visitar lojas para conseguir alguns! 🛍️");
            sleep(2500);
            return;
        }

        System.out.println("🧪 Lista de Consumíveis:\n");

        int i = 1;
        for (Consumivel consumivel : Jogo.getNaruto().getBolsa()) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🎁 Item " + i++);
            System.out.println("🔹 Nome : " + consumivel.getNome());
            System.out.println("💥 Efeito: " + consumivel.getEfeito() + "%");
            System.out.println("🧬 Tipo : " + consumivel.getTipoConsumivel());
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        stop();
    }
    /**
     * Mostra aHistoria do jogo
     */
    private static void mostrarHistoria() throws InterruptedException, FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Intro.txt");
        stop();
    }


    /**
     * Menu de explicações do jogo.
     * Este menu permite ao jogador aprender mais sobre os conceitos fundamentais do jogo,
     * como chakra, afinidade, itens especiais, lutas, navegação e Konoha.
     *
     * @throws InterruptedException caso o `sleep` seja interrompido.
     */
    private static void menuExplicacoes() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        while (true) {
            cleanConsole(); // Limpa o console para mostrar o menu de forma limpa
            System.out.println("📊 EXPLICAÇÕES DE JOGO\n\n");
            System.out.println("💠 Chakra - PRIMA 1");
            System.out.println("🌪️ Afinidade Elemental - PRIMA 2");
            System.out.println("🔵 Itens Especiais - PRIMA 3");
            System.out.println("⚔️ Luta - PRIMA 4");
            System.out.println("🗺️ Navegação - PRIMA 5");
            System.out.println("🏯 Konoha - PRIMA 6");
            System.out.println("🔙 Voltar - PRIMA 0");
            System.out.print("\nEscolha uma opção: ");

            String op = input.nextLine().trim(); // Lê a opção escolhida pelo utilizador
            switch (op) {
                case "1": explicacaoChakra(); break;              // Explicação sobre chakra
                case "2": explicacaoAfinidade(); break;           // Explicação sobre afinidade elemental
                case "3": explicacaoItensEspeciais(); break;      // Explicação sobre itens especiais
                case "4": explicacaoLuta(); break;                // Explicação sobre o sistema de luta
                case "5": explicacaoNavegacao(); break;           // Explicação sobre navegação no mapa
                case "6": explicacaoKonoha(); break;              // Explicação sobre a vila de Konoha
                case "0": return;                                 // Retorna ao menu anterior
                default:
                    System.out.println("⛔ Opção inválida!");     // Feedback de erro
                    sleep(1500); // Espera para o jogador ler a mensagem
            }
        }
    }

    /**
     * Mostra a explicação sobre o funcionamento do chakra no jogo.
     * Explica sua importância, consumo, recuperação e fornece dicas estratégicas.
     *
     * @throws InterruptedException caso o método seja interrompido durante o `stop()`.
     */
    private static void explicacaoChakra() throws InterruptedException {
        cleanConsole();
        System.out.println("🔵 CHAKRA: A ENERGIA NINJA\n");
        System.out.println("O chakra é a fonte de energia vital usada para realizar jutsus. 🌀");
        System.out.println("Sem chakra... sem jutsu! 😵\n");
        System.out.println("🧪 COMO FUNCIONA:");
        System.out.println("• Cada jutsu consome uma quantidade específica de chakra.");
        System.out.println("• Quanto mais poderoso o jutsu, mais chakra ele exige.");
        System.out.println("• Se acabar o chakra, só te resta atacar no braço mesmo! 🥴\n");
        System.out.println("🩹 COMO RECUPERAR:");
        System.out.println("• Usando itens como poções de chakra.");
        System.out.println("• Descansando em casa (em Konoha 🏠).");
        System.out.println("💡 Dica ninja:");
        System.out.println("Gerencie seu chakra como ouro! Use jutsus nos momentos certos e nunca vá explorar com chakra vazio. ⚠️");
        stop();
    }

    /**
     * Mostra a explicação sobre o sistema de afinidade elemental.
     * Informa como as vantagens e desvantagens elementares afetam o combate.
     *
     * @throws InterruptedException caso o método seja interrompido durante a execução de `stop()`.
     */
    private static void explicacaoAfinidade() throws InterruptedException {
        cleanConsole();
        System.out.println("🌪️ AFINIDADE ELEMENTAL\n");
        System.out.println("Cada ninja tem uma afinidade com um dos 5 elementos da natureza.");
        System.out.println("Essa afinidade pode trazer vantagem ou desvantagem em combate.\n");
        System.out.println("✅ Ter vantagem elemental → +20% de dano.");
        System.out.println("⚠️ Ter desvantagem elemental → você leva 20% a mais de dano.\n");
        System.out.println("🔁 CÍRCULO ELEMENTAL:");
        System.out.println("🔥 Fogo     >   🌪️ Vento");
        System.out.println("🌪️ Vento    >   ⚡ Raio");
        System.out.println("⚡ Raio     >   ⛰️ Terra");
        System.out.println("⛰️ Terra    >   💧 Água");
        System.out.println("💧 Água     >   🔥 Fogo\n");
        System.out.println("👊 EXEMPLO NA PRÁTICA:");
        System.out.println("Naruto possui afinidade com 🌪️ VENTO.");
        System.out.println("Sasuke possui afinidade com 🔥 FOGO.");
        System.out.println("➡️ Resultado: Sasuke tem vantagem elemental sobre Naruto!");
        System.out.println("   Os jutsus de Sasuke causarão 20% a mais de dano. ⚠️🔥\n");
        System.out.println("🎯 Dica ninja:");
        System.out.println("Você está em desvantagem, então lute com estratégia!");
        System.out.println("Use armas, itens e buffs para equilibrar o combate! 💡");
        stop();
    }

    /**
     * Explica o funcionamento dos itens especiais no jogo.
     * Detalha os benefícios ao equipar e onde podem ser encontrados.
     *
     * @throws InterruptedException caso ocorra uma interrupção durante o `stop()`.
     */
    private static void explicacaoItensEspeciais() throws InterruptedException {
        cleanConsole();
        System.out.println("💠 ITENS ESPECIAIS: O SEGREDO DOS NINJAS LENDÁRIOS\n");
        System.out.println("Estes não são itens comuns... são relíquias lendárias! ✨");
        System.out.println("Ao equipá-los, Naruto recebe aumentos diretos em atributos como:");
        System.out.println("• Ataque ⚔️");
        System.out.println("• Defesa 🛡️");
        System.out.println("• Vida ❤️");
        System.out.println("• Chakra 🔵\n");
        System.out.println("🛍️ ONDE CONSEGUIR?");
        System.out.println("• Loja (quando disponíveis)");
        System.out.println("• Com um pouco de sorte... 🍀 (só ~10% de chance!)\n");
        System.out.println("• Encontrando aliados durante a exploração");
        System.out.println("🔥 Por que usar?");
        System.out.println("• Eles são permanentes.");
        System.out.println("• Transformam completamente o desempenho em batalha.");
        System.out.println("• E claro... deixam te com muito mais estilo ninja. 😎\n");
        System.out.println("📌 Dica:");
        System.out.println("Não os subestime. Um único item especial pode ser a diferença entre vitória e derrota contra Sasuke!");
        stop();
    }

    /**
     * Mostra a explicação sobre as mecânicas de combate do jogo.
     * Detalha os tipos de ataque, uso de chakra, influência de afinidades e dá dicas estratégicas.
     *
     * @throws InterruptedException caso a execução seja interrompida durante a pausa (stop).
     */
    private static void explicacaoLuta() throws InterruptedException {
        cleanConsole();
        System.out.println("⚔️ LUTA: ONDE NINJAS SE PROVAM\n");
        System.out.println("No campo de batalha, cada decisão conta. Aqui estão suas opções:");
        System.out.println("• Ataque Normal → simples, direto e sem custo.");
        System.out.println("• Armas ⚔️ → aumentam seu dano base.");
        System.out.println("• Jutsus 🔥💨⚡ → poderosos, mas consomem chakra.\n");
        System.out.println("🌪️ ELEMENTOS & ESTRATÉGIA:");
        System.out.println("• A afinidade elemental pode te dar vantagem (+20% de dano).");
        System.out.println("• Observe o inimigo — cada um tem fraquezas e resistências.");
        System.out.println("• O ambiente e o tipo de inimigo podem mudar tudo.\n");
        System.out.println("💡 DICAS NINJA:");
        System.out.println("• Gerencie bem seu chakra — gastar tudo cedo pode te custar caro.");
        System.out.println("• Fugir é uma opção... mas pode ter consequências. ⚠️");
        System.out.println("• - Nao e garantida a fuga e podes apanhar mais sem ter atacado primeiro.");
        System.out.println("• Use itens especiais e consumíveis para virar o jogo.");
        System.out.println("• A estratégia sempre vence a força bruta. 🧠🔥\n");
        System.out.println("🏁 Lembre-se:");
        System.out.println("Cada luta te aproxima do Sasuke. Vença com cabeça fria e espírito quente!");
        stop();
    }

    /**
     * Explica ao jogador como funciona a navegação entre regiões no mundo do jogo.
     * Informa sobre os perigos, aliados e a possibilidade de encontrar Sasuke.
     *
     * @throws InterruptedException caso a execução seja interrompida durante o stop().
     */
    private static void explicacaoNavegacao() throws InterruptedException {
        cleanConsole();
        System.out.println("🗺️ NAVEGAÇÃO PELO MUNDO SHINOBI\n");
        System.out.println("Você agora pode explorar diferentes regiões do mapa ninja, cada uma com seus próprios desafios e segredos!");
        System.out.println("Escolha com sabedoria... pois Sasuke pode estar em qualquer lugar 👀\n");
        System.out.println("🌀 Cada região pode ter:");
        System.out.println("   - ⚔️ Inimigos prontos para a luta");
        System.out.println("   - 🤝 Aliados oferecendo ajuda ou itens");
        System.out.println("   - 🛑 E o próprio Sasuke à sua espera...");
        System.out.println("\n🎯 Dica do ninja: prepare-se antes de sair explorando. Konoha é seu porto seguro!");
        stop();
    }

    /**
     * Explica as funcionalidades disponíveis na vila de Konoha, considerada a base segura do jogador.
     * Informa os serviços disponíveis e sua importância na preparação para a jornada.
     *
     * @throws InterruptedException caso a execução seja interrompida durante a pausa com stop().
     */
    private static void explicacaoKonoha() throws InterruptedException {
        cleanConsole();
        System.out.println("🏯 BEM-VINDO À VILA DA FOLHA – KONOHA 🍃\n");
        System.out.println("Aqui é o seu porto seguro, ninja!");
        System.out.println("Recupere forças, compre equipamentos e prepare-se para encarar o mundo shinobi lá fora.\n");
        System.out.println("O que você pode fazer aqui:\n");
        System.out.println("🏡 1 - Casa do Naruto → Recupera totalmente o chakra.");
        System.out.println("💪 2 - Treinar → Aumenta seus atributos.");
        System.out.println("🍜 3 - Ramen Ichiraku → Recupera vida.");
        System.out.println("🛍️ 4 - Loja → Compra de armas e consumíveis.");
        System.out.println("🏥 5 - Hospital Ninja → Cura rápida.");
        System.out.println("🗺️ 6 - Continuar Jornada → Volta à exploração.\n");
        stop();
    }
}

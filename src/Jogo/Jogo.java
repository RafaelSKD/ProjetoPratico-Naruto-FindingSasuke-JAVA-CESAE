package Jogo;

import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;
import Itens.Especial.Especial;
import Itens.Item;
import Mapa.Vila;
import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;
import Ninjas.Ninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Jogo.InicializarObjetos.Item.InicializarArmaduras.inicializarArmaduras;
import static Jogo.InicializarObjetos.Item.InicializarArmas.inicializarArmas;
import static Jogo.InicializarObjetos.Item.InicializarAtaques.inicializarAtaquesChakra;
import static Jogo.InicializarObjetos.Item.InicializarConsumiveis.inicializarConsumiveis;
import static Jogo.InicializarObjetos.Item.InicializarEspeciais.inicializarEspeciais;
import static Jogo.InicializarObjetos.Mapa.InicializarMapa.inicializarMapa;
import static Jogo.InicializarObjetos.Ninjas.InicializarNaruto.inicializarNaruto;
import static Jogo.InicializarObjetos.Ninjas.InicializarNinjas.*;
import static Jogo.InicializarObjetos.Ninjas.InicializarSasuke.inicializarSasuke;
import static Ninjas.Enum.Localizacao.*;
import static Utils.Utils.random;
import static java.util.Collections.addAll;

/**
 * Classe principal que centraliza os dados e estado do jogo.
 */
public class Jogo {
    private String nome = "Naruto - Finding Sasuke";

    // Objetos principais do jogo
    private static Naruto naruto;
    private static Sasuke sasuke;

    // Dados globais do jogo
    private static ArrayList<Vila> listaVilas;
    private static ArrayList<Inimigo> listaInimigos;
    private static ArrayList<Amigo> listaAmigos;
    private static ArrayList<Item> listaItens;
    private ArrayList<AtaqueChakra> listaAtaqueChakra;

    // Itens disponíveis na loja da TenTen
    private static ArrayList<Item> LojaTenTen;

    // Getter para os itens da loja
    public static ArrayList<Item> getLojaTenTen() {
        return LojaTenTen;
    }

    /**
     * Gera dinamicamente os itens que vão estar disponíveis na loja da TenTen.
     * A seleção respeita a probabilidade de spawn definida para cada item.
     */
    public static void addLojaTenTen() {
        LojaTenTen = new ArrayList<>();

        while (LojaTenTen.size() < 11) {
            int index = random(listaItens.size());
            Item item = listaItens.get(index);

            if (LojaTenTen.contains(item)) {
                continue;
            }

            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                if (random(100) < arma.getSpawn()) {
                    LojaTenTen.add(arma);
                }
            } else if (item instanceof Consumivel) {
                Consumivel consumivel = (Consumivel) item;
                if (random(100) < consumivel.getSpawn()) {
                    LojaTenTen.add(consumivel);
                }
            } else if (item instanceof Especial) {
                Especial especial = (Especial) item;
                if (random(100) < especial.getSpawn()) {
                    LojaTenTen.add(especial);
                }
            }
        }
    }

    // Getters e Setters do nome do jogo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters e Setters para Naruto e Sasuke
    public static Naruto getNaruto() {
        return naruto;
    }

    public void setNaruto(Naruto naruto) {
        this.naruto = naruto;
    }

    public static Sasuke getSasuke() {
        return sasuke;
    }

    public void setSasuke(Sasuke sasuke) {
        this.sasuke = sasuke;
    }

    // Getter para lista de vilas
    public static ArrayList<Vila> getListaVilas() {
        return listaVilas;
    }

    /**
     * Método principal chamado para iniciar o jogo.
     * Inicializa todos os objetos e estruturas necessárias.
     */
    public static void jogo(){
        inicializar();
    }

    /**
     * Inicializa todos os componentes essenciais do jogo:
     * vilas, personagens, itens, e distribuições aleatórias.
     */
    public static void inicializar() {
        // Cria e armazena todas as vilas do mapa
        Jogo.listaVilas = inicializarMapa();

        // Inicializa Naruto e Sasuke como personagens principais
        Jogo.naruto = inicializarNaruto();
        Jogo.sasuke = inicializarSasuke();

        // Inicializa as listas de amigos e inimigos NPC
        Jogo.listaAmigos = (ArrayList<Amigo>) inicializarAmigos();
        Jogo.listaInimigos = (ArrayList<Inimigo>) inicializarInimigos();

        // Cria e preenche a lista global de itens disponíveis no jogo
        Jogo.listaItens = new ArrayList<>();
        Jogo.listaItens.addAll(inicializarArmaduras());
        Jogo.listaItens.addAll(inicializarArmas());
        Jogo.listaItens.addAll(inicializarConsumiveis());
        Jogo.listaItens.addAll(inicializarEspeciais());
        Jogo.listaItens.addAll(inicializarAtaquesChakra());

        // Gera itens disponíveis na loja da TenTen com base em probabilidade de spawn
        addLojaTenTen();

        // Distribui armas e equipa Sasuke com armaduras
        distribuirArmas();

        // Associa itens a amigos que podem ajudar Naruto durante o jogo
        distribuirItens();

        // Atribui ataques de chakra aos ninjas
        atribuirAtaques();

        // Coloca cada ninja numa vila, garantindo aleatoriedade e diversidade por vila
        organizar();

        // Esconde Sasuke numa vila aleatória do mapa
        esconderSasuke();
    }


    /**
     * Escolhe aleatoriamente uma vila (exceto Konoha) e esconde nela o Sasuke.
     */
    public static void esconderSasuke() {
        // Cria uma lista de vilas possíveis onde o Sasuke pode ser escondido (exclui Konoha)
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();

        for (Vila vila : Jogo.listaVilas) {
            // Konoha (a vila segura) é excluída da seleção
            if (!vila.getNome().equals("Konohagakure (Vila da Folha)")) {
                vilasPossiveis.add(vila);
            }
        }

        // Escolhe uma vila aleatória da lista válida
        int indiceAleatorio = random(vilasPossiveis.size());

        // Adiciona o Sasuke à vila escolhida
        vilasPossiveis.get(indiceAleatorio).addSasuke(Jogo.sasuke);
    }

    /**
     * Distribui itens permitidos (armas, especiais, armaduras e todos os consumíveis) aleatoriamente pelos amigos do jogo.
     */
    private static void distribuirItens() {
        ArrayList<Item> todosItens = new ArrayList<>();

        // Lista de nomes de itens permitidos para distribuir (exclui os mais fortes ou raros não mencionados)
        String[] nomesPermitidos = {
                "Kusarigama de Chakra", "Bastão do Sábio dos Seis Caminhos", "Shuriken Elementais Gigantes",
                "Cajado Tessen", "Flechas de Chakra", "Samehada", "Kunai Especial do Minato", "Shuriken",
                "Selo Amaldiçoado de Orochimaru", "Orbe de Chakra das Bestas com Cauda",
                "Olho do Mangekyou Sharingan", "Marca do Sábio", "Coroa da Sálvia de Myōboku",
                "Casaco do Sábio", "Manto Reforçado de Konoha", "Jaqueta de Treinamento Chunin",
                "Calças do Sábio dos Seis Caminhos", "Calças da Anbu", "Calças de Campo Ninja"
        };

        // Filtra os itens válidos para distribuição
        for (Item item : Jogo.listaItens) {
            if (item instanceof Consumivel) {
                // Todos os consumíveis são automaticamente válidos
                todosItens.add(item);
            } else {
                // Verifica se o nome do item está na lista de permitidos
                for (String nome : nomesPermitidos) {
                    if (nome.equals(item.getNome())) {
                        todosItens.add(item);
                        break;
                    }
                }
            }
        }

        // Atribui um item aleatório da lista filtrada a cada amigo
        int quantidadeItens = todosItens.size();
        for (Amigo amigo : Jogo.listaAmigos) {
            int indexAleatorio = random(quantidadeItens);
            amigo.setItem(todosItens.get(indexAleatorio));
        }
    }

    /**
     * Distribui armas e armaduras específicas para personagens do jogo.
     * - Sasuke recebe sua armadura e arma icônica.
     * - Cada inimigo recebe uma arma específica com base no seu nome.
     * - A associação é feita com base em verificações de nomes.
     */
    private static void distribuirArmas() {
        for (Item arma : Jogo.listaItens) {

            // ---------------------
            // Armaduras para Sasuke
            // ---------------------
            if (arma instanceof Armadura) {
                Armadura armadura = (Armadura) arma;

                if (arma.getNome().equalsIgnoreCase("Manto Uchiha Superior")) {
                    Jogo.sasuke.setCima(armadura); // parte superior da armadura
                }

                if (arma.getNome().equalsIgnoreCase("Calças Táticas Uchiha")) {
                    Jogo.sasuke.setBaixo(armadura); // parte inferior da armadura
                }
            }

            // --------------------------------------
            // Armas para Sasuke e inimigos específicos
            // --------------------------------------
            if (arma instanceof Arma) {
                Arma armaConvertida = (Arma) arma;

                // Arma exclusiva de Sasuke
                if (arma.getNome().equalsIgnoreCase("Kusanagi")) {
                    Jogo.sasuke.setArma(armaConvertida);
                }

                // Armas específicas para inimigos, associadas pelo nome do ninja
                if (arma.getNome().equalsIgnoreCase("Cabaça de Areia")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Gaara")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Marionete Karasu")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Kankuro")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Marionetes Humanas")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Sasori")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Lâminas Médicas")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Kabuto")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Sensor Ninja")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Karin")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo de Poeira")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Ohnoki")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Liberação de Lava")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Kurotsuchi") || inimigo.getNome().equalsIgnoreCase("Roshi")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Argila Explosiva")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Deidara")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo Vapor")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Han")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo de Terra")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Kitsuchi")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Punhos Elétricos")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("A")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Espada com Liberação de Relâmpago")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Darui")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Espadas Acrobáticas")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Killer Bee")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo Gato Demoníaco")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Yugito Nii")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Chakra Controlado")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Nii")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Liberação de Estrela")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Suiko")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Kubikiribōchō")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Zabuza Momochi")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Senbons")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Haku")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Hiramekarei")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Chojuro")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Espada Explosiva")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Mangetsu Hozuki")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Espadas Trovão")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Raiga Kurosuki")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo Neve")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Fubuki")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Seis Caminhos de Pain")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Pain")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Jutsus de Papel")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Konan")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Kusarigama")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Hanzo")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Estilo de Água")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Suien")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Armadilhas")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Kagari")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }

                if (arma.getNome().equalsIgnoreCase("Samehada")) {
                    for (Inimigo inimigo : listaInimigos) {
                        if (inimigo.getNome().equalsIgnoreCase("Fuguki Suikazan")) {
                            inimigo.setArma(armaConvertida);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Organiza os ninjas (amigos e inimigos) nas vilas da mesma região.
     * Garante que os ninjas sejam distribuídos aleatoriamente,
     * mas apenas dentro da sua localização geográfica correspondente.
     */
    public static void organizar() {
        // Listas para armazenar vilas por localização
        ArrayList<Vila> centralOrienteVilas = new ArrayList<>();
        ArrayList<Vila> nordesteVilas = new ArrayList<>();
        ArrayList<Vila> noroesteVilas = new ArrayList<>();
        ArrayList<Vila> sudesteVilas = new ArrayList<>();
        ArrayList<Vila> sudoesteVilas = new ArrayList<>();

        // Separar vilas por região
        for (Vila vila : Jogo.listaVilas) {
            switch (vila.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteVilas.add(vila);
                case NORDESTE -> nordesteVilas.add(vila);
                case NOROESTE -> noroesteVilas.add(vila);
                case SUDESTE -> sudesteVilas.add(vila);
                case SUDOESTE -> sudoesteVilas.add(vila);
            }
        }

        // Listas de ninjas (amigos + inimigos) por região
        ArrayList<Ninja> centralOrienteNinjas = new ArrayList<>();
        ArrayList<Ninja> nordesteNinjas = new ArrayList<>();
        ArrayList<Ninja> noroesteNinjas = new ArrayList<>();
        ArrayList<Ninja> sudesteNinjas = new ArrayList<>();
        ArrayList<Ninja> sudoesteNinjas = new ArrayList<>();

        // Distribuir inimigos por localização
        for (Inimigo ninja : Jogo.listaInimigos) {
            switch (ninja.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteNinjas.add(ninja);
                case NORDESTE -> nordesteNinjas.add(ninja);
                case NOROESTE -> noroesteNinjas.add(ninja);
                case SUDESTE -> sudesteNinjas.add(ninja);
                case SUDOESTE -> sudoesteNinjas.add(ninja);
            }
        }

        // Distribuir amigos por localização
        for (Amigo ninja : Jogo.listaAmigos) {
            switch (ninja.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteNinjas.add(ninja);
                case NORDESTE -> nordesteNinjas.add(ninja);
                case NOROESTE -> noroesteNinjas.add(ninja);
                case SUDESTE -> sudesteNinjas.add(ninja);
                case SUDOESTE -> sudoesteNinjas.add(ninja);
            }
        }

        // Embaralhar ninjas antes da distribuição
        Collections.shuffle(centralOrienteNinjas);
        Collections.shuffle(nordesteNinjas);
        Collections.shuffle(noroesteNinjas);
        Collections.shuffle(sudesteNinjas);
        Collections.shuffle(sudoesteNinjas);

        // Distribuir ninjas por vilas conforme sua localização
        distribuirNinjasPorVilas(centralOrienteVilas, centralOrienteNinjas);
        distribuirNinjasPorVilas(nordesteVilas, nordesteNinjas);
        distribuirNinjasPorVilas(noroesteVilas, noroesteNinjas);
        distribuirNinjasPorVilas(sudesteVilas, sudesteNinjas);
        distribuirNinjasPorVilas(sudoesteVilas, sudoesteNinjas);
    }

    /**
     * Distribui uma lista de ninjas pelas vilas de uma determinada região.
     * A distribuição é feita de forma cíclica: cada ninja é colocado numa vila,
     * e quando chega à última vila, recomeça na primeira.
     *
     * @param vilas Lista de vilas de uma mesma região.
     * @param ninjas Lista de ninjas (amigos ou inimigos) a serem distribuídos.
     */
    private static void distribuirNinjasPorVilas(ArrayList<Vila> vilas, ArrayList<Ninja> ninjas) {
        if (vilas.isEmpty() || ninjas.isEmpty()) {
            return; // Evita erro se uma das listas estiver vazia
        }

        int vilaIndex = 0;

        for (Ninja ninja : ninjas) {
            // Adiciona o ninja à vila atual
            vilas.get(vilaIndex).getListaNinjas().add(ninja);

            // Avança para a próxima vila de forma cíclica
            // Exemplo: se há 3 vilas e vilaIndex chega a 3, volta para 0
            vilaIndex = (vilaIndex + 1) % vilas.size();
        }
    }

    /**
     * Atribui ataques especiais de chakra a personagens específicos.
     * Cada ataque é verificado pelo seu nome e associado ao personagem correspondente,
     * como Naruto, Sasuke ou inimigos específicos.
     */
    private static void atribuirAtaques() {
        for (Item ataqueChakra : Jogo.listaItens) {
            if (ataqueChakra instanceof AtaqueChakra) {
                AtaqueChakra ataque = (AtaqueChakra) ataqueChakra;

                // === ATAQUES DE SASUKE ===
                if (ataque.getNome().equalsIgnoreCase("Chidori")) {
                    Jogo.sasuke.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Amaterasu")) {
                    Jogo.sasuke.setAtaqueEspecial2(ataque);
                }

                // === ATAQUES DE NARUTO ===
                if (ataque.getNome().equalsIgnoreCase("Rasengan")) {
                    Jogo.naruto.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Rasen-Shuriken")) {
                    Jogo.naruto.setAtaqueEspecial2(ataque);
                }

                // === ATAQUES DE INIMIGOS ===
                if (ataque.getNome().equalsIgnoreCase("Caixão de Areia")) {
                    Inimigo g = buscarInimigo("Gaara");
                    if (g != null) g.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Areia Imperial: Prisão Funerária")) {
                    Inimigo g = buscarInimigo("Gaara");
                    if (g != null) g.setAtaqueEspecial2(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Controle de Marionetes Humanas")) {
                    Inimigo k = buscarInimigo("Kankuro");
                    if (k != null) k.setAtaqueEspecial1(ataque);
                    Inimigo s = buscarInimigo("Sasori");
                    if (s != null) s.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Estilo das Cobras Ocultas")) {
                    Inimigo o = buscarInimigo("Orochimaru");
                    if (o != null) o.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Respiração Venenosa")) {
                    Inimigo kab = buscarInimigo("Kabuto");
                    if (kab != null) kab.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Pulso Curativo Uzumaki")) {
                    Inimigo karin = buscarInimigo("Karin");
                    if (karin != null) karin.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Liberação de Poeira: Desintegração")) {
                    Inimigo o = buscarInimigo("Ohnoki");
                    if (o != null) o.setAtaqueEspecial1(ataque);
                    Inimigo k = buscarInimigo("Kurotsuchi");
                    if (k != null) k.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Jutsu Supremo: Estilo de Poeira Atômica")) {
                    Inimigo o = buscarInimigo("Ohnoki");
                    if (o != null) o.setAtaqueEspecial2(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Argila Explosiva: C2")) {
                    Inimigo d = buscarInimigo("Deidara");
                    if (d != null) d.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Estilo Oito Espadas")) {
                    Inimigo r = buscarInimigo("Roshi");
                    if (r != null) r.setAtaqueEspecial1(ataque);
                    Inimigo h = buscarInimigo("Han");
                    if (h != null) h.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Lariat Relâmpago")) {
                    Inimigo a = buscarInimigo("A (Raikage)");
                    if (a != null) a.setAtaqueEspecial1(ataque);
                    Inimigo kb = buscarInimigo("Killer Bee");
                    if (kb != null) kb.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Manto Relâmpago Supremo")) {
                    Inimigo a = buscarInimigo("A (Raikage)");
                    if (a != null) a.setAtaqueEspecial2(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Pantera Negra Raiton")) {
                    Inimigo d = buscarInimigo("Darui");
                    if (d != null) d.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Névoa Silenciosa")) {
                    Inimigo z = buscarInimigo("Zabuza Momochi");
                    if (z != null) z.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Execução Oculta na Névoa")) {
                    Inimigo z = buscarInimigo("Zabuza Momochi");
                    if (z != null) z.setAtaqueEspecial2(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Espelhos de Gelo e Senbons")) {
                    Inimigo h = buscarInimigo("Haku");
                    if (h != null) h.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Dança de Papel Cortante")) {
                    Inimigo k = buscarInimigo("Konan");
                    if (k != null) k.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Shinra Tensei")) {
                    Inimigo p = buscarInimigo("Pain (Tendo)");
                    if (p != null) p.setAtaqueEspecial1(ataque);
                }
                if (ataque.getNome().equalsIgnoreCase("Chibaku Tensei")) {
                    Inimigo p = buscarInimigo("Pain (Tendo)");
                    if (p != null) p.setAtaqueEspecial2(ataque);
                }
            }
        }
    }


    /**
     * Procura e retorna um inimigo da lista de inimigos com base no nome fornecido.
     *
     * @param nome o nome do inimigo a procurar
     * @return o objeto Inimigo correspondente, ou null se não for encontrado
     */
    private static Inimigo buscarInimigo(String nome) {
        for (Inimigo inimigo : listaInimigos) {
            // Compara o nome ignorando diferenças entre maiúsculas e minúsculas
            if (inimigo.getNome().equalsIgnoreCase(nome)) {
                return inimigo;
            }
        }
        // Retorna null se o inimigo não for encontrado
        return null;
    }


}

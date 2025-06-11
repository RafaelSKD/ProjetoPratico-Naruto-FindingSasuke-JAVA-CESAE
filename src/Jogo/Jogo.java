package Jogo;

import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;
import Itens.Item;
import Mapa.Vila;
import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.NPC.Maus.Inimigo;
import Ninjas.NarutoSasuke.Naruto;
import Ninjas.NarutoSasuke.Sasuke;
import Ninjas.Ninja;

import java.util.ArrayList;
import java.util.Collections;

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

public class Jogo {
    private String nome = "Naruto - Finding Sasuke";
    private static Naruto naruto;
    private static Sasuke sasuke;
    private static ArrayList<Vila> listaVilas;
    private static ArrayList<Inimigo> listaInimigos;
    private static ArrayList<Amigo> listaAmigos;
    private static ArrayList<Item> listaItens;
    private ArrayList<AtaqueChakra> listaAtaqueChakra;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Naruto getNaruto() {
        return naruto;
    }

    public void setNaruto(Naruto naruto) {
        this.naruto = naruto;
    }

    public Sasuke getSasuke() {
        return sasuke;
    }

    public void setSasuke(Sasuke sasuke) {
        this.sasuke = sasuke;
    }

    public static ArrayList<Vila> getListaVilas() {
        return listaVilas;
    }

    public void setListaVilas(ArrayList<Vila> listaVilas) {
        this.listaVilas = listaVilas;
    }

    public ArrayList<Inimigo> getListaInimigos() {
        return listaInimigos;
    }

    public void setListaInimigos(ArrayList<Inimigo> listaInimigos) {
        this.listaInimigos = listaInimigos;
    }

    public ArrayList<Amigo> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(ArrayList<Amigo> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public ArrayList<AtaqueChakra> getListaAtaqueChakra() {
        return listaAtaqueChakra;
    }

    public void setListaAtaqueChakra(ArrayList<AtaqueChakra> listaAtaqueChakra) {
        this.listaAtaqueChakra = listaAtaqueChakra;
    }

    public static void jogo(){
        inicializar();
    }

    public static void inicializar(){
        Jogo.listaVilas = inicializarMapa();
        Jogo.naruto = inicializarNaruto();
        Jogo.sasuke = inicializarSasuke();
        Jogo.listaAmigos = (ArrayList<Amigo>) inicializarAmigos();
        Jogo.listaInimigos = (ArrayList<Inimigo>) inicializarInimigos();
        Jogo.listaItens = new ArrayList<>();
        Jogo.listaItens.addAll(inicializarArmaduras());
        Jogo.listaItens.addAll(inicializarArmas());
        Jogo.listaItens.addAll(inicializarConsumiveis());
        Jogo.listaItens.addAll(inicializarEspeciais());
        Jogo.listaItens.addAll(inicializarAtaquesChakra());
        distribuirArmas();  //distribui as armas para os caracteres certos e coloca armadura no sasuke
        distribuirItens();  // distribui itens pelos amigos
        atribuirAtaques(); // atribui os ataques de Chakra
        organizar(); // organiza os ninjas por vila de forma a nao se repetirem e serem aleatorios mas fixos de forma a nao ser demasiado dificil encontrar o sasuke
        esconderSasuke(); // esconde o sasuke numa vila aleatoria
    }

    public static void esconderSasuke() {
        // Cria uma lista de vilas válidas, exceto "Konohagakure"
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();

        for (Vila vila : Jogo.listaVilas) {
            if (!vila.getNome().equals("Konohagakure (Vila da Folha)")) {
                vilasPossiveis.add(vila);
            }
        }
        // Escolhe uma vila aleatória entre as possíveis
        int indiceAleatorio = random(vilasPossiveis.size());
        vilasPossiveis.get(indiceAleatorio).addSasuke(Jogo.sasuke);
    }

    private static void distribuirItens() {
        ArrayList<Consumivel> consumivel = new ArrayList<>();
         for (Item item : Jogo.listaItens){
             if (item instanceof Consumivel) {
                 consumivel.add((Consumivel) item);
             }
         }
         int quantidadeConsumiveis = consumivel.size();
         for (Amigo amigo : Jogo.listaAmigos)
             amigo.setItem(consumivel.get(random(quantidadeConsumiveis)));
    } // distribui itens pelos amigos

    private static void distribuirArmas(){
        for (Item arma : Jogo.listaItens) {
            if (arma instanceof Armadura) {
                Armadura armadura = (Armadura) arma;

                if (arma.getNome().equalsIgnoreCase("Manto Uchiha Superior")) {
                    Jogo.sasuke.setCima(armadura);
                }

                if (arma.getNome().equalsIgnoreCase("Calças Táticas Uchiha")) {
                    Jogo.sasuke.setBaixo(armadura);
                }
            }

            if (arma instanceof Arma) {
                Arma armaConvertida = (Arma) arma;

                if (arma.getNome().equalsIgnoreCase("Kusanagi")) {
                    Jogo.sasuke.setArma(armaConvertida);
                }

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
    }//distribui as armas para os caracteres certos e coloca armadura no sasuke

    public static void organizar() {
        // Listas para armazenar as vilas separadas por região
        ArrayList<Vila> centralOrienteVilas = new ArrayList<>();
        ArrayList<Vila> nordesteVilas = new ArrayList<>();
        ArrayList<Vila> noroesteVilas = new ArrayList<>();
        ArrayList<Vila> sudesteVilas = new ArrayList<>();
        ArrayList<Vila> sudoesteVilas = new ArrayList<>();

        // Distribui cada vila na sua respectiva lista regional
        for (Vila vila : Jogo.listaVilas) {
            switch (vila.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteVilas.add(vila);
                case NORDESTE -> nordesteVilas.add(vila);
                case NOROESTE -> noroesteVilas.add(vila);
                case SUDESTE -> sudesteVilas.add(vila);
                case SUDOESTE -> sudoesteVilas.add(vila);
            }
        }

        // Listas para armazenar todos os ninjas (amigos + inimigos) por região
        ArrayList<Ninja> centralOrienteNinjas = new ArrayList<>();
        ArrayList<Ninja> nordesteNinjas = new ArrayList<>();
        ArrayList<Ninja> noroesteNinjas = new ArrayList<>();
        ArrayList<Ninja> sudesteNinjas = new ArrayList<>();
        ArrayList<Ninja> sudoesteNinjas = new ArrayList<>();

        // Adiciona todos os ninjas (inimigos e amigos) nas listas regionais
        for (Inimigo ninja : Jogo.listaInimigos) {
            switch (ninja.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteNinjas.add(ninja);
                case NORDESTE -> nordesteNinjas.add(ninja);
                case NOROESTE -> noroesteNinjas.add(ninja);
                case SUDESTE -> sudesteNinjas.add(ninja);
                case SUDOESTE -> sudoesteNinjas.add(ninja);
            }
        }
        for (Amigo ninja : Jogo.listaAmigos) {
            switch (ninja.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteNinjas.add(ninja);
                case NORDESTE -> nordesteNinjas.add(ninja);
                case NOROESTE -> noroesteNinjas.add(ninja);
                case SUDESTE -> sudesteNinjas.add(ninja);
                case SUDOESTE -> sudoesteNinjas.add(ninja);
            }
        }

        // Embaralha os ninjas de cada região para distribuição aleatória
        Collections.shuffle(centralOrienteNinjas);
        Collections.shuffle(nordesteNinjas);
        Collections.shuffle(noroesteNinjas);
        Collections.shuffle(sudesteNinjas);
        Collections.shuffle(sudoesteNinjas);

        // Distribui os ninjas aleatoriamente pelas vilas da mesma região
        distribuirNinjasPorVilas(centralOrienteVilas, centralOrienteNinjas);
        distribuirNinjasPorVilas(nordesteVilas, nordesteNinjas);
        distribuirNinjasPorVilas(noroesteVilas, noroesteNinjas);
        distribuirNinjasPorVilas(sudesteVilas, sudesteNinjas);
        distribuirNinjasPorVilas(sudoesteVilas, sudoesteNinjas);
    }

    private static void distribuirNinjasPorVilas(ArrayList<Vila> vilas, ArrayList<Ninja> ninjas) {
        if (vilas.isEmpty() || ninjas.isEmpty()) {
            return; // Não há vilas ou ninjas para distribuir
        }

        int vilaIndex = 0;
        for (Ninja ninja : ninjas) {
            // Adiciona o ninja à vila atual
            vilas.get(vilaIndex).getListaNinjas().add(ninja);

            // Avança para a próxima vila (cíclico)
            vilaIndex = (vilaIndex + 1) % vilas.size(); // Quando chega ao tamanho de vilas por ex. 3, 3%3 = 0 volta a primeira vila, por exemplo na 2, 2%3 = 2. entao fica na 2, so quando e igual volta a 0
        }
    }

    private static void atribuirAtaques() {
        for (Item ataqueChakra : Jogo.listaItens) {
            if (ataqueChakra instanceof AtaqueChakra) {
                AtaqueChakra ataque = (AtaqueChakra) ataqueChakra;

                // Sasuke
                if (ataqueChakra.getNome().equalsIgnoreCase("Chidori")) {
                    Jogo.sasuke.setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Amaterasu")) {
                    Jogo.sasuke.setAtaqueEspecial2(ataque);
                }
                // Naruto
                if (ataqueChakra.getNome().equalsIgnoreCase("Rasengan")) {
                    Jogo.naruto.setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Rasen-Shuriken")) {
                    Jogo.naruto.setAtaqueEspecial2(ataque);
                }

                // Inimigos
                if (ataqueChakra.getNome().equalsIgnoreCase("Caixão de Areia")) {
                    buscarInimigo("Gaara").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Areia Imperial: Prisão Funerária")) {
                    buscarInimigo("Gaara").setAtaqueEspecial2(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Controle de Marionetes Humanas")) {
                    buscarInimigo("Kankuro").setAtaqueEspecial1(ataque);
                    buscarInimigo("Sasori").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Estilo das Cobras Ocultas")) {
                    buscarInimigo("Orochimaru").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Respiração Venenosa")) {
                    buscarInimigo("Kabuto").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Pulso Curativo Uzumaki")) {
                    buscarInimigo("Karin").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Liberação de Poeira: Desintegração")) {
                    buscarInimigo("Ohnoki").setAtaqueEspecial1(ataque);
                    buscarInimigo("Kurotsuchi").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Jutsu Supremo: Estilo de Poeira Atômica")) {
                    buscarInimigo("Ohnoki").setAtaqueEspecial2(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Argila Explosiva: C2")) {
                    buscarInimigo("Deidara").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Estilo Oito Espadas")) {
                    buscarInimigo("Roshi").setAtaqueEspecial1(ataque);
                    buscarInimigo("Han").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Lariat Relâmpago")) {
                    buscarInimigo("A (Raikage)").setAtaqueEspecial1(ataque);
                    buscarInimigo("Killer Bee").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Manto Relâmpago Supremo")) {
                    buscarInimigo("A (Raikage)").setAtaqueEspecial2(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Pantera Negra Raiton")) {
                    buscarInimigo("Darui").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Névoa Silenciosa")) {
                    buscarInimigo("Zabuza Momochi").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Execução Oculta na Névoa")) {
                    buscarInimigo("Zabuza Momochi").setAtaqueEspecial2(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Espelhos de Gelo e Senbons")) {
                    buscarInimigo("Haku").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Dança de Papel Cortante")) {
                    buscarInimigo("Konan").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Shinra Tensei")) {
                    buscarInimigo("Pain (Tendo)").setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Chibaku Tensei")) {
                    buscarInimigo("Pain (Tendo)").setAtaqueEspecial2(ataque);
                }
            }
        }
    }

    private static Inimigo buscarInimigo(String nome) {
        for (Inimigo inimigo : listaInimigos) {
            if (inimigo.getNome().equalsIgnoreCase(nome)) {
                return inimigo;
            }
        }
        return null;
    }


}
























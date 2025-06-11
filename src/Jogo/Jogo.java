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
    private Naruto naruto;
    private Sasuke sasuke;
    private ArrayList<Vila> listaVilas;
    private ArrayList<Inimigo> listaInimigos;
    private ArrayList<Amigo> listaAmigos;
    private ArrayList<Item> listaItens;
    private ArrayList<AtaqueChakra> listaAtaqueChakra;

    public void jogo(){
        inicializar();
    }

    public void inicializar(){
        this.listaVilas = inicializarMapa();
        this.naruto = inicializarNaruto();
        this.sasuke = inicializarSasuke();
        this.listaAmigos = (ArrayList<Amigo>) inicializarAmigos();
        this.listaInimigos = (ArrayList<Inimigo>) inicializarInimigos();
        this.listaItens = new ArrayList<>();
        this.listaItens.addAll(inicializarArmaduras());
        this.listaItens.addAll(inicializarArmas());
        this.listaItens.addAll(inicializarConsumiveis());
        this.listaItens.addAll(inicializarEspeciais());
        this.listaItens.addAll(inicializarAtaquesChakra());
        distribuirArmas();  //distribui as armas para os caracteres certos e coloca armadura no sasuke
        distribuirItens();  // distribui itens pelos amigos
        atribuirAtaques(); // atribui os ataques de Chakra
        organizar(); // organiza os ninjas por vila de forma a nao se repetirem e serem aleatorios mas fixos de forma a nao ser demasiado dificil encontrar o sasuke
        esconderSasuke(); // esconde o sasuke numa vila aleatoria
    }

    public void esconderSasuke() {
        // Cria uma lista de vilas válidas, exceto "Konohagakure"
        ArrayList<Vila> vilasPossiveis = new ArrayList<>();

        for (Vila vila : this.listaVilas) {
            if (!vila.getNome().equals("Konohagakure (Vila da Folha)")) {
                vilasPossiveis.add(vila);
            }
        }
        // Escolhe uma vila aleatória entre as possíveis
        int indiceAleatorio = random(vilasPossiveis.size());
        vilasPossiveis.get(indiceAleatorio).addSasuke(this.sasuke);
    }

    private void distribuirItens() {
        ArrayList<Consumivel> consumivel = null;
         for (Item item : this.listaItens){
             if (item instanceof Consumivel) {
                 consumivel.add((Consumivel) item);
             }
         }
         int quantidadeConsumiveis = consumivel.size();
         for (Amigo amigo : this.listaAmigos)
             amigo.setItem(consumivel.get(random(quantidadeConsumiveis)));
    } // distribui itens pelos amigos

    private void distribuirArmas(){
        for (Item arma : this.listaItens) {
            if (arma instanceof Armadura) {
                Armadura armadura = (Armadura) arma;

                if (arma.getNome().equalsIgnoreCase("Manto Uchiha Superior")) {
                    this.sasuke.setCima(armadura);
                }

                if (arma.getNome().equalsIgnoreCase("Calças Táticas Uchiha")) {
                    this.sasuke.setBaixo(armadura);
                }
            }

            if (arma instanceof Arma) {
                Arma armaConvertida = (Arma) arma;

                if (arma.getNome().equalsIgnoreCase("Kusanagi")) {
                    this.sasuke.setArma(armaConvertida);
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

    public void organizar() {
        // Listas para armazenar as vilas separadas por região
        ArrayList<Vila> centralOrienteVilas = new ArrayList<>();
        ArrayList<Vila> nordesteVilas = new ArrayList<>();
        ArrayList<Vila> noroesteVilas = new ArrayList<>();
        ArrayList<Vila> sudesteVilas = new ArrayList<>();
        ArrayList<Vila> sudoesteVilas = new ArrayList<>();

        // Distribui cada vila na sua respectiva lista regional
        for (Vila vila : this.listaVilas) {
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
        for (Inimigo ninja : this.listaInimigos) {
            switch (ninja.getLocalizacao()) {
                case CENTRALORIENTE -> centralOrienteNinjas.add(ninja);
                case NORDESTE -> nordesteNinjas.add(ninja);
                case NOROESTE -> noroesteNinjas.add(ninja);
                case SUDESTE -> sudesteNinjas.add(ninja);
                case SUDOESTE -> sudoesteNinjas.add(ninja);
            }
        }
        for (Amigo ninja : this.listaAmigos) {
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

    private void distribuirNinjasPorVilas(ArrayList<Vila> vilas, ArrayList<Ninja> ninjas) {
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

    private void atribuirAtaques() {
        for (Item ataqueChakra : this.listaItens) {
            if (ataqueChakra instanceof AtaqueChakra) {
                AtaqueChakra ataque = (AtaqueChakra) ataqueChakra;

                // Sasuke
                if (ataqueChakra.getNome().equalsIgnoreCase("Chidori")) {
                    this.sasuke.setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Amaterasu")) {
                    this.sasuke.setAtaqueEspecial2(ataque);
                }
                // Naruto
                if (ataqueChakra.getNome().equalsIgnoreCase("Rasengan")) {
                    this.naruto.setAtaqueEspecial1(ataque);
                }
                if (ataqueChakra.getNome().equalsIgnoreCase("Rasen-Shuriken")) {
                    this.naruto.setAtaqueEspecial2(ataque);
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

    private Inimigo buscarInimigo(String nome) {
        for (Inimigo inimigo : listaInimigos) {
            if (inimigo.getNome().equalsIgnoreCase(nome)) {
                return inimigo;
            }
        }
        return null;
    }
}
























package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.NPC.Maus.Inimigo;

import java.util.ArrayList;
import java.util.List;

public class InicializarNinjas {

    public static List<Inimigo> inicializarInimigos() {
        List<Inimigo> inimigos = new ArrayList<>();

        inimigos.add(new Inimigo("Gaara", Afinidade.TERRA, 500, 400, 350, 1000, 869.57, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Kankuro", Afinidade.VENTO, 300, 250, 200, 600, 217.39, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Sasori", Afinidade.FOGO, 450, 300, 400, 750, 739.13, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Kabuto", Afinidade.AGUA, 380, 320, 300, 700, 543.48, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Orochimaru", Afinidade.TERRA, 500, 350, 450, 900, 934.78, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Karin", Afinidade.AGUA, 280, 230, 150, 500, 100.00, Localizacao.SUDOESTE));
        inimigos.add(new Inimigo("Ohnoki", Afinidade.TERRA, 400, 350, 300, 800, 608.70, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("Kurotsuchi", Afinidade.TERRA, 320, 280, 250, 600, 347.83, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("Deidara", Afinidade.FOGO, 450, 300, 400, 700, 739.13, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("Roshi", Afinidade.FOGO, 370, 300, 320, 700, 530.43, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("Han", Afinidade.AGUA, 390, 340, 330, 750, 621.74, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("Kitsuchi", Afinidade.TERRA, 360, 320, 280, 680, 491.30, Localizacao.NOROESTE));
        inimigos.add(new Inimigo("A (Raikage)", Afinidade.RELAMPAGO, 500, 400, 450, 900, 1000.00, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Darui", Afinidade.RELAMPAGO, 380, 320, 300, 700, 543.48, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Killer Bee", Afinidade.RELAMPAGO, 480, 350, 500, 850, 973.91, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Yugito Nii", Afinidade.FOGO, 370, 300, 320, 700, 530.43, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Nii", Afinidade.VENTO, 300, 270, 220, 580, 269.57, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Suiko", Afinidade.AGUA, 320, 280, 250, 600, 347.83, Localizacao.NORDESTE));
        inimigos.add(new Inimigo("Zabuza Momochi", Afinidade.AGUA, 450, 350, 400, 800, 804.35, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Haku", Afinidade.AGUA, 400, 300, 350, 700, 608.70, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Chojuro", Afinidade.AGUA, 370, 320, 310, 650, 543.48, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Mangetsu Hozuki", Afinidade.AGUA, 380, 340, 320, 670, 595.65, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Raiga Kurosuki", Afinidade.RELAMPAGO, 360, 300, 330, 640, 530.43, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Fubuki", Afinidade.AGUA, 300, 260, 220, 550, 256.52, Localizacao.SUDESTE));
        inimigos.add(new Inimigo("Pain (Tendo)", Afinidade.FOGO, 500, 400, 450, 950, 1000.00, Localizacao.CENTRALORIENTE));
        inimigos.add(new Inimigo("Konan", Afinidade.AGUA, 420, 300, 350, 750, 634.78, Localizacao.CENTRALORIENTE));
        inimigos.add(new Inimigo("Hanzo", Afinidade.VENTO, 450, 350, 400, 850, 804.35, Localizacao.CENTRALORIENTE));
        inimigos.add(new Inimigo("Suien", Afinidade.AGUA, 300, 250, 220, 500, 243.48, Localizacao.CENTRALORIENTE));
        inimigos.add(new Inimigo("Kagari", Afinidade.FOGO, 320, 270, 240, 550, 321.74, Localizacao.CENTRALORIENTE));
        inimigos.add(new Inimigo("Fuguki Suikazan", Afinidade.AGUA, 370, 320, 310, 680, 543.48, Localizacao.CENTRALORIENTE));



        return inimigos;
    }

    public static List<Amigo> inicializarAmigos() {
        List<Amigo> amigos = new ArrayList<>();

        amigos.add(new Amigo("Karin", Afinidade.AGUA, 450, 430, 150, 700, Localizacao.SUDOESTE));
        amigos.add(new Amigo("Nonō Yakushi", Afinidade.FOGO, 420, 410, 190, 690, Localizacao.SUDOESTE));
        amigos.add(new Amigo("Kurotsuchi", Afinidade.TERRA, 420, 410, 200, 680, Localizacao.NOROESTE));
        amigos.add(new Amigo("Shizuru", Afinidade.AGUA, 370, 380, 160, 600, Localizacao.NOROESTE));
        amigos.add(new Amigo("Mabui", Afinidade.RELAMPAGO, 430, 420, 200, 700, Localizacao.NORDESTE));
        amigos.add(new Amigo("Shion", Afinidade.AGUA, 450, 450, 160, 710, Localizacao.NORDESTE));
        amigos.add(new Amigo("Isaribi", Afinidade.AGUA, 390, 400, 170, 640, Localizacao.SUDESTE));
        amigos.add(new Amigo("Haku", Afinidade.AGUA, 420, 430, 180, 690, Localizacao.SUDESTE));
        amigos.add(new Amigo("Kusuna", Afinidade.TERRA, 350, 400, 150, 600, Localizacao.CENTRALORIENTE));
        amigos.add(new Amigo("Konan (versão suporte)", Afinidade.AGUA, 400, 410, 180, 680, Localizacao.CENTRALORIENTE));

        return amigos;
    }
}

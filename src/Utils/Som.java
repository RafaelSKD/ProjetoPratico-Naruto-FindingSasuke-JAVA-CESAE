package Utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para reprodução e controle de sons no jogo.
 */
public class Som {
    private static Clip clipIntro;
    private static Clip clipCredits;
    private static Clip clipDattebayo;
    private static Clip clipFightingEffects;
    private static Clip clipKonoha;
    private static Clip clipLose;
    private static Clip clipNarutoFighting;
    private static Clip clipNarutoVictory;
    private static Clip clipNavegacao;
    private static Clip clipSasukeFight;

    // Lista que guarda todos os clips para facilitar parada em lote
    private static final List<Clip> allClips = new ArrayList<>();

    /** Reproduz o som de introdução. */
    public static void playIntro() { clipIntro = play("src/Sons/Intro.wav", false); }

    /** Para o som de introdução. */
    public static void stopIntro() { stop(clipIntro); }

    /** Reproduz os créditos. */
    public static void playCredits() { clipCredits = play("src/Sons/credits.wav", false); }

    /** Para os créditos. */
    public static void stopCredits() { stop(clipCredits); }

    /** Reproduz o grito "Dattebayo". */
    public static void playDattebayo() { clipDattebayo = play("src/Sons/dattebayo.wav", false); }

    /** Para o som "Dattebayo". */
    public static void stopDattebayo() { stop(clipDattebayo); }

    /** Reproduz efeitos de combate. */
    public static void playHit() { clipFightingEffects = play("src/Sons/Fighting-sound-effects.wav", false); }

    /** Para os efeitos de combate. */
    public static void stopHit() { stop(clipFightingEffects); }

    /** Reproduz o som ambiente da Vila da Folha. */
    public static void playKonoha() { clipKonoha = play("src/Sons/Konoha.wav", true); }

    /** Para o som da Vila da Folha. */
    public static void stopKonoha() { stop(clipKonoha); }

    /** Reproduz som de derrota. */
    public static void playLose() { clipLose = play("src/Sons/lose.wav", false); }

    /** Para o som de derrota. */
    public static void stopLose() { stop(clipLose); }

    /** Reproduz som de combate do Naruto. */
    public static void playFight() { clipNarutoFighting = play("src/Sons/NarutoFighting.wav", true); }

    /** Para o som de combate do Naruto. */
    public static void stopFight() { stop(clipNarutoFighting); }

    /** Reproduz som de vitória do Naruto. */
    public static void playWin() { clipNarutoVictory = play("src/Sons/Naruto-Victory.wav", false); }

    /** Para o som de vitória do Naruto. */
    public static void stopWin() { stop(clipNarutoVictory); }

    /** Reproduz som de navegação. */
    public static void playNav() { clipNavegacao = play("src/Sons/Navegacao.wav", true); }

    /** Para o som de navegação. */
    public static void stopNav() { stop(clipNavegacao); }

    /** Reproduz som da luta contra Sasuke. */
    public static void playSasuke() { clipSasukeFight = play("src/Sons/SasukeFight.wav", true); }

    /** Para o som da luta contra Sasuke. */
    public static void stopSasuke() { stop(clipSasukeFight); }

    /**
     * Reproduz um som a partir de um caminho e indica se é para tocar em loop.
     *
     * @param src  caminho para o ficheiro de áudio
     * @param loop se deve repetir continuamente
     * @return o Clip criado e iniciado
     */
    private static Clip play(String src, boolean loop) {
        try {
            File arquivo = new File(src);
            AudioInputStream stream = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
            allClips.add(clip); // adiciona à lista de controle
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Erro ao tocar som: " + e.getMessage());
            return null;
        }
    }

    /**
     * Para e fecha um som.
     *
     * @param clip o Clip a ser parado
     */
    private static void stop(Clip clip) {
        if (clip != null) {
            if (clip.isRunning()) clip.stop();
            clip.close();
        }
    }

    /** Para todos os sons em execução. */
    public static void stopAll() {
        for (Clip clip : allClips) {
            stop(clip);
        }
        allClips.clear(); // limpa a lista após parar todos
    }
}

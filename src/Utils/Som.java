package Utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

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

    // Intro.wav
    public static void playIntro() { clipIntro = play("src/Sons/Intro.wav", false); }
    public static void stopIntro() { stop(clipIntro); }

    // credits.wav
    public static void playCredits() { clipCredits = play("src/Sons/credits.wav", false); }
    public static void stopCredits() { stop(clipCredits); }

    // dattebayo.wav
    public static void playDattebayo() { clipDattebayo = play("src/Sons/dattebayo.wav", false); }
    public static void stopDattebayo() { stop(clipDattebayo); }

    // Fighting-sound-effects.wav
    public static void playHit() { clipFightingEffects = play("src/Sons/Fighting-sound-effects.wav", false); }
    public static void stopHit() { stop(clipFightingEffects); }

    // Konoha.wav
    public static void playKonoha() { clipKonoha = play("src/Sons/Konoha.wav", true); }
    public static void stopKonoha() { stop(clipKonoha); }

    // lose.wav
    public static void playLose() { clipLose = play("src/Sons/lose.wav", false); }
    public static void stopLose() { stop(clipLose); }

    // NarutoFighting.wav
    public static void playFight() { clipNarutoFighting = play("src/Sons/NarutoFighting.wav", true); }
    public static void stopFight() { stop(clipNarutoFighting); }

    // Naruto-Victory.wav
    public static void playWin() { clipNarutoVictory = play("src/Sons/Naruto-Victory.wav", false); }
    public static void stopWin() { stop(clipNarutoVictory); }

    // Navegacao.wav
    public static void playNav() { clipNavegacao = play("src/Sons/Navegacao.wav", true); }
    public static void stopNav() { stop(clipNavegacao); }

    // SasukeFight.wav
    public static void playSasuke() { clipSasukeFight = play("src/Sons/SasukeFight.wav", true); }
    public static void stopSasuke() { stop(clipSasukeFight); }

    // tocar som
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
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Erro ao tocar som: " + e.getMessage());
            return null;
        }
    }

    // parar som
    private static void stop(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

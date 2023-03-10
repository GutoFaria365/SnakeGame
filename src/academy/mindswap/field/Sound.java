package academy.mindswap.field;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    Clip soundLoop;
    public void getSoundClip(String soundPath) {
        final Clip soundClip;
        try {
            File soundFile = new File(soundPath);
            AudioInputStream soundToPlay = AudioSystem.getAudioInputStream(soundFile);
            soundClip = AudioSystem.getClip();
            soundClip.open(soundToPlay);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        if (soundClip.isRunning()) soundClip.stop();   // Stop the player if it is still running
        soundClip.setFramePosition(0); // rewind to the beginning
        soundClip.start();     // Start playing
    }
    public void getSoundLoop() {
        String soundPath = "resources/soundEffects/8bit-music-for-game-68698.wav";
        try {
            File soundFile = new File(soundPath);
            AudioInputStream soundToPlay = AudioSystem.getAudioInputStream(soundFile);
            soundLoop = AudioSystem.getClip();
            soundLoop.open(soundToPlay);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
            soundLoop.setFramePosition(0);
            soundLoop.start();

    }

    public Clip getSoundLoopVar() {
        return soundLoop;
    }
}


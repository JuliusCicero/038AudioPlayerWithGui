package com.juliuscicero.util;

import com.juliuscicero.gui.Frame;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class PlayAudioFile {

    public static boolean isPlayed = true;
    public static Clip clip;
    public static AudioInputStream audioInputStream;
    public static File audioFile;
    public PlayAudioFile() {

    }

    public void init() {
        try {
            File audioRootDirectory = new File("src/data/audio");
            audioFile = Arrays.stream((audioRootDirectory.listFiles())).findFirst().get();
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        Frame frame = new Frame("AudioPlayer");
        frame.init();
    }

    public static void toggleMusic() {
        clip.stop();
        clip.close();
    }

    public static void changeClipStatus() {
        if (isPlayed) {
            clip.stop();
        } else {
            clip.start();
        }
        isPlayed = !isPlayed;
    }

    public static void exit() {
        File norpFile = new File("src" + File.separator + "data" + File.separator + "figures" + File.separator + "numberOfRunningPrograms.data");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(norpFile));
            int formerNORP = Integer.parseInt(reader.readLine());
            reader.close();
            int futureNORP = formerNORP - 1;
            BufferedWriter writer = new BufferedWriter(new FileWriter(norpFile));
            writer.write(futureNORP + "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(2);
    }
}

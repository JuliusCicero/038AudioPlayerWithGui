package com.juliuscicero.main;

import com.juliuscicero.util.PlayAudioFile;

import java.io.*;

public class Start {

    public static void main(String[] args){
        checkForRunningPrograms();
        PlayAudioFile playAudioFile = new PlayAudioFile();
        playAudioFile.init();
    }

    private static void checkForRunningPrograms() {
        int norp, fnorp;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/figures/NumberOfRunningPrograms.data"));
            norp = Integer.parseInt(reader.readLine());
            fnorp = norp + 1;
            reader.close();
            if (norp != 0) {
                System.exit(3);
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/figures/NumberOfRunningPrograms.data"));
                writer.write(fnorp + "");
                writer.close();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

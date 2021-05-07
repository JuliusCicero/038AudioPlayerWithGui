package com.juliuscicero.gui;

import com.juliuscicero.gui.buttons.ExitButton;
import com.juliuscicero.gui.buttons.MinButton;
import com.juliuscicero.gui.buttons.PlayPauseButton;
import com.juliuscicero.util.PlayAudioFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame {

    private PlayPauseButton playPauseButton;
    private MinButton minButton;
    private ExitButton exitButton;

    private boolean isThisPlayed = true;

    public Frame (String s) {
        super(s);

    }

    public void init() {
        setUndecorated(true);
        setSize(96, 32);
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1,3));

        playPauseButton = new PlayPauseButton("Pause / Play");
        playPauseButton.addActionListener(l -> {
            playPauseButton.toggle();
            PlayAudioFile.changeClipStatus();
        });
        playPauseButton.setFocusable(false);
        playPauseButton.setBorderPainted(false);

        minButton = new MinButton("Minimize");
        minButton.addActionListener(l -> {
            minButton.toggle();
            if (this.isAlwaysOnTop()) {
                this.setState(JFrame.ICONIFIED);
            } else {
                this.setState(JFrame.NORMAL);
            }
            setAlwaysOnTop(!this.isAlwaysOnTop());

        });
        minButton.setFocusable(false);
        minButton.setBorderPainted(false);

        exitButton = new ExitButton("Exit");
        exitButton.addActionListener(l -> {
            exitButton.toggle();
            PlayAudioFile.toggleMusic();
            try {
                PlayAudioFile.audioInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PlayAudioFile.exit();
            System.exit(2);
        });
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);


        add(playPauseButton);
        add(minButton);
        add(exitButton);
        playPauseButton.setVisible(true);
        minButton.setVisible(true);
        exitButton.setVisible(true);
        setVisible(true);
        setVisible(true);
    }
}

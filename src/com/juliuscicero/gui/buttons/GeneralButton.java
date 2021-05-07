package com.juliuscicero.gui.buttons;

import javax.swing.*;
import java.awt.*;

public class GeneralButton extends JButton {

    public GeneralButton(String s) {
        super(s);
    }

    public static final Color colorUnaccessed = new Color(51, 51, 51);
    public static final Color colorAccessed = new Color(119, 119, 119);
    public boolean accessed = false;

    public void toggle() {
        accessed = !accessed;
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}

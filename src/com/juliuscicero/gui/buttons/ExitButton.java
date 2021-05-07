package com.juliuscicero.gui.buttons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExitButton extends GeneralButton {

    public ExitButton(String s) {
        super(s);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (this.accessed) {
            g.setColor(colorUnaccessed);
        } else {
            g.setColor(colorAccessed);
        }
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Image img = null;
        try {
            img = ImageIO.read(new File("src" + File.separator + "data" + File.separator + "images" + File.separator + "Exit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, null);
    }
}

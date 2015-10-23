package com.notepad.view;

import javax.swing.*;

/**
 * Created by KartoshkaD on 23.10.2015.
 *
 */
public class NPFontFrame extends JFrame {

    public NPFontFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(300, 300);
        this.setTitle("Font settings");

        JPanel pnl = new JPanel();

        this.add(pnl);
    }

}

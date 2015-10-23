package com.notepad.controller;

import com.notepad.view.NPFontFrame;
import com.notepad.view.NPMainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by KartoshkaD on 23.10.2015.
 *
 */
public class NPFontController{

    NPMainFrame mainFrame;
    NPFontFrame fontFrame;

    public NPFontController(NPMainFrame frameM, NPFontFrame frameF) {
        this.mainFrame = frameM;
        this.fontFrame = frameF;
    }



    public void setFont(Font font) {
        this.mainFrame.setFont(font);
    }
    public void setVisible(boolean bool) {
        this.fontFrame.setVisible(bool);
    }
}

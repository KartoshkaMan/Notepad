package com.notepad.controller;

import com.notepad.model.interfaces.Command;
import com.notepad.view.NPFontFrame;
import com.notepad.view.NPMainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KartoshkaD on 23.10.2015.
 *
 */
public class NPFontController {

    NPMainController mainController;
    NPFontFrame fontFrame;

    // Constructor //
    public NPFontController(NPMainController mainC, NPFontFrame frameF) {
        this.mainController = mainC;
        this.fontFrame = frameF;

        frameF.addBtnListener(new NPFontListener(this.mainController));
    }

    // Listeners //
    private class NPFontListener implements ActionListener {

        private NPMainController mainController;

        public NPFontListener(NPMainController cntrlr) {
            this.mainController = cntrlr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ((Command)e.getSource()).execute(this.mainController);
        }
    }
}

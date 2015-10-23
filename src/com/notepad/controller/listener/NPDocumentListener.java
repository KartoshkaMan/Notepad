package com.notepad.controller.listener;

import com.notepad.controller.NPMainController;
import com.notepad.model.functional.NPDocumentModel;
import com.notepad.view.NPMainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by KartoshkaD on 20.10.2015.
 *
 *
 */
public class NPDocumentListener implements KeyListener{

    private NPMainController controller;

    public NPDocumentListener(NPMainController cntrlr) {
        this.controller = cntrlr;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.controller.updateDoc();
    }
}

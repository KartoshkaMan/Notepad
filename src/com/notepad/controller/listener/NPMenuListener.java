package com.notepad.controller.listener;

import com.notepad.model.interfaces.Command;
import com.notepad.controller.NPMainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KartoshkaD on 20.10.2015.
 *
 */
public class NPMenuListener implements ActionListener{

    NPMainController npMainController;

    public NPMenuListener (NPMainController cntrlr) {
        this.npMainController = cntrlr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((Command) e.getSource()).execute(this.npMainController);
    }
}

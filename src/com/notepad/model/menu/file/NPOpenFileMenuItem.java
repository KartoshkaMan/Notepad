package com.notepad.model.menu.file;

import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;

import javax.swing.JMenuItem;

/**
 * Created by KartoshkaD on 21.10.2015.
 *
 */
public class NPOpenFileMenuItem extends JMenuItem implements Command {

    public NPOpenFileMenuItem() {
        super("Open file...");
    }

    @Override
    public void execute(NPMainController cntrlr) {
        cntrlr.openFile();
    }
}

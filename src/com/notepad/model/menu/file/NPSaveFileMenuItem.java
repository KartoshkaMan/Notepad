package com.notepad.model.menu.file;

import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;

import javax.swing.JMenuItem;

/**
 * Created by KartoshkaD on 22.10.2015.
 *
 */
public class NPSaveFileMenuItem extends JMenuItem implements Command {

    public NPSaveFileMenuItem() {
        super("Save file");
        this.setEnabled(false);
    }

    @Override
    public void execute(NPMainController cntrlr) {
        cntrlr.saveFile();
    }
}

package com.notepad.model.menu.file;

import com.notepad.model.interfaces.Command;
import com.notepad.controller.NPMainController;
import com.notepad.model.functional.NPDocumentModel;

import javax.swing.*;

/**
 * Created by KartoshkaD on 21.10.2015.
 *
 */
public class NPNewFileMenuItem extends JMenuItem implements Command {

    public NPNewFileMenuItem() {
        super("New file...");
    }

    @Override
    public void execute(NPMainController cntrlr) {
        cntrlr.newFile();
    }
}

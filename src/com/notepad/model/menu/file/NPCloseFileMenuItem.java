package com.notepad.model.menu.file;

import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;

import javax.swing.*;

/**
 * Created by KartoshkaD on 22.10.2015.
 *
 */
public class NPCloseFileMenuItem extends JMenuItem implements Command {

    public NPCloseFileMenuItem() {
        super("Close");
    }

    @Override
    public void execute(NPMainController cntrlr) {
        cntrlr.closeFile();
    }
}

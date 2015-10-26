package com.notepad.model.menu.format;

import com.notepad.controller.NPFontController;
import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;
import com.notepad.view.NPFontFrame;
import com.notepad.view.NPMainFrame;

import javax.swing.*;

/**
 * Created by KartoshkaD on 22.10.2015.
 *
 */
public class NPFontFormatMenuItem extends JMenuItem implements Command {
    public NPFontFormatMenuItem () {
        super("Set font...");
    }

    @Override
    public void execute(NPMainController cntrlr) {
        new NPFontController(cntrlr, new NPFontFrame(cntrlr.getFont()));
    }
}

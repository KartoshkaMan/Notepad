package com.notepad.model.menu.format;

import com.notepad.controller.NPFontController;
import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;
import com.notepad.model.interfaces.Controller;

import javax.swing.*;
import java.awt.Font;

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
        //cntrlr.setFont();
    }
}

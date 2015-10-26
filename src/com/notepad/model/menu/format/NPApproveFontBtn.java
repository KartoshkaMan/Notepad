package com.notepad.model.menu.format;

import com.notepad.controller.NPMainController;
import com.notepad.model.interfaces.Command;
import com.notepad.view.NPFontFrame;

import javax.swing.*;

/**
 * Created by KartoshkaD on 26.10.2015.
 *
 */

public class NPApproveFontBtn extends JButton implements Command {

    NPFontFrame npFontFrame;

    public NPApproveFontBtn(NPFontFrame frame) {
        super("Ok");

        this.npFontFrame = frame;
    }

    @Override
    public void execute(NPMainController cntrlr) {
        cntrlr.setFont(this.npFontFrame.getFont());
        this.npFontFrame.dispose();
    }
}

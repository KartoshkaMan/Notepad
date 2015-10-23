package com.notepad.model.interfaces;

import com.notepad.controller.NPMainController;

/**
 * Created by KartoshkaD on 21.10.2015.
 *
 */
public interface Command {
    void execute(NPMainController cntrlr);
}

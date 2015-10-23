package com.notepad.controller;

import com.notepad.controller.listener.NPDocumentListener;
import com.notepad.controller.listener.NPMenuListener;
import com.notepad.model.functional.NPDocumentModel;
import com.notepad.view.NPMainFrame;

import javax.swing.*;

import java.io.File;

/**
 * Created by KartoshkaD on 21.10.2015.
 *
 */
public class NPMainController {

    private NPMainFrame npMainFrame;
    private NPDocumentModel npDocumentModel;

    public NPMainController(NPMainFrame frame, NPDocumentModel doc) {
        this.npDocumentModel = doc;
        this.npMainFrame = frame;

        npMainFrame.setTitle(npDocumentModel.getTitle() + " - Notepad");
        npMainFrame.setContent(npDocumentModel.getContent());

        npMainFrame.addContentListener(new NPDocumentListener(this));
        npMainFrame.addFileMenuListener(new NPMenuListener(this));
    }

    public void newFile() {
        this.sf();
        this.npDocumentModel = new NPDocumentModel();
        this.npMainFrame.setTitle(npDocumentModel.getTitle() + " - Notepad");
        this.npMainFrame.setContent("");
    }
    public void openFile() {
        this.sf();
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("C:\\Users\\%username%\\Documents"));
        jfc.setDialogTitle("Open file...");
        jfc.setApproveButtonText("Open");
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.npDocumentModel = new NPDocumentModel(jfc.getSelectedFile());
            this.npMainFrame.setTitle(this.npDocumentModel.getTitle() + " - Notepad");
            this.npMainFrame.setContent(this.npDocumentModel.getContent());
        }
    }
    public void saveFile() {
        System.err.println("Old:\n" + this.npDocumentModel.getContent() + "\n");
        this.npDocumentModel.save();
        System.err.println("New:\n" + this.npDocumentModel.getContent() + "\n");
        this.npMainFrame.setSaveMenuItemEnabled(false);
    }
    public void saveAsFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Save as...");
        jfc.setApproveButtonText("Save");
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            System.err.println("Old:\n" + this.npDocumentModel.getContent() + "\nChnaged: " + this.npDocumentModel.isChanged() + "\nExists: " + this.npDocumentModel.isExist());
            this.npDocumentModel.saveAs(file);
            System.err.println("New:\n" + this.npDocumentModel.getContent() + "\nChnaged: " + this.npDocumentModel.isChanged() + "\nExists: " + this.npDocumentModel.isExist());
        }
        this.npMainFrame.setTitle(npDocumentModel.getTitle() + " - Notepad");
        this.npMainFrame.setSaveMenuItemEnabled(false);
    }
    public void closeFile() {
        this.sf();
        this.npMainFrame.dispose();
    }

    public void updateDoc() {
        System.err.println("Old: Document: \"" + this.npDocumentModel.getContent() + "\"Frame: \"" + this.npMainFrame.getTextContent() + "\"");
        this.npDocumentModel.setChanged(true);
        this.npDocumentModel.setContent(this.npMainFrame.getTextContent());
        if (this.npDocumentModel.isExist())
            this.npMainFrame.setSaveMenuItemEnabled(true);
        System.err.println("New: Document: \"" + this.npDocumentModel.getContent() + "\"Frame: \"" + this.npMainFrame.getTextContent() + "\"");
        System.err.println("Changed: " + npDocumentModel.isChanged() + " Existed: " + npDocumentModel.isExist() + "\n");
    }

    private void sf(){
        if (this.npDocumentModel.isChanged()) {
            if (this.npDocumentModel.isExist()) {
                Object[] options = {"Save", "Don't save", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "File changed. Do you want to save it?",
                        "Oooops", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (option == 0) {
                    this.npDocumentModel.save();
                }
            }
            else {
                Object[] options = {"Save as...", "Don't save", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "File changed. Do you want to save it?",
                        "Oooops", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (option == 0) {
                    JFileChooser jfc = new JFileChooser();
                    jfc.setDialogTitle("Save file...");
                    jfc.setApproveButtonText("Save");
                    if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        File file = jfc.getSelectedFile();
                        this.npDocumentModel.saveAs(file);
                    }
                }
            }
        }
    }
}

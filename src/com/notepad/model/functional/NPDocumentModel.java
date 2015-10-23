package com.notepad.model.functional;

import javax.swing.*;
import java.io.*;

/**
 * Created by KartoshkaD on 20.10.2015.
 *
 */
public class NPDocumentModel {
    private boolean isChanged = false;
    private boolean isExist = false;

    private String content = "";
    private String title = "Untitled";
    private String path = null;

    public NPDocumentModel(){
        this.isChanged = false;
        this.isExist = false;

        this.content = "";
        this.title = "Untitled";
        this.path = null;
    }
    public NPDocumentModel(File file) {
        this.isChanged = false;
        this.isExist = true;

        this.title = file.getName();
        this.path = file.getAbsolutePath();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String tmpString = br.readLine();

            while (true) {
                sb.append(tmpString);
                tmpString = br.readLine();
                if (tmpString != null)
                    sb.append(System.lineSeparator());
                else
                    break;
            }

            this.content = sb.toString();
        }
        catch (IOException ioe) {
            //JOptionPane.showMessageDialog(null, "Error Occurred");
            ioe.printStackTrace();
        }
    }
    public NPDocumentModel(File file, String string) {
        this.isChanged = false;
        this.isExist = true;

        this.content = string;
        this.title = file.getName();
        this.path = file.getAbsolutePath();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.content);
            bw.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void setChanged(boolean bool) {
        this.isChanged = bool;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setExist(boolean bool){
        this.isExist = bool;
    }

    public void printInfo() {
        System.err.println("Content: " + this.content);
        System.err.println("Path: " + this.path);
        System.err.println("isChanged: " + this.isChanged);
        System.err.println("isExist: " + this.isExist);
    }
    public void save() {
        try {
            File file = new File(this.path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.content);
            bw.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void saveAs(File file) {
        try {
            this.path = file.getAbsolutePath();
            this.title = file.getName();
            this.isExist = true;
            this.isChanged = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.content);
            bw.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean isChanged() {
        return this.isChanged;
    }
    public boolean isExist() {
        return this.isExist;
    }

    public String getContent() {
        return this.content;
    }
    public String getTitle() {
        return this.title;
    }
    public String getPath() {
        return this.path;
    }
}

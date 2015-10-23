package com.notepad.view;

import com.notepad.model.menu.file.*;
import com.notepad.model.menu.format.NPFontFormatMenuItem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by KartoshkaD on 20.10.2015.
 *
 */
public class NPMainFrame extends JFrame {

    private JScrollPane scroller;
    private JTextArea content;

    private JMenuBar bar;

    private JMenu fileMenu;
    private JMenu formatMenu;

    private NPNewFileMenuItem newFile;
    private NPOpenFileMenuItem openFile;
    private NPSaveFileMenuItem saveFile;
    private NPSaveAsFileMenuItem saveAsFile;
    private NPCloseFileMenuItem closeFile;

    private NPFontFormatMenuItem formatFont;

    public NPMainFrame() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JPanel pnl = new JPanel(new BorderLayout());

        // frame set up //
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(d.width / 2, d.height / 2);
        this.setIconImage(new ImageIcon(".\\src\\com\\notepad\\image\\notepad-icon.png").getImage());

        // Menu bar //
        this.bar = new JMenuBar();

        // Menu parts //
        this.fileMenu = new JMenu("File");
        this.formatMenu = new JMenu("Format");

        // File menu items //
        this.newFile = new NPNewFileMenuItem();
        this.openFile = new NPOpenFileMenuItem();
        this.saveFile = new NPSaveFileMenuItem();
        this.saveAsFile = new NPSaveAsFileMenuItem();
        this.closeFile = new NPCloseFileMenuItem();

        // File menu constructor //
        this.fileMenu.add(this.newFile);
        this.fileMenu.add(this.openFile);
        this.fileMenu.add(this.saveFile);
        this.fileMenu.add(this.saveAsFile);
        this.fileMenu.add(this.closeFile);

        // Format menu items //
        this.formatFont = new NPFontFormatMenuItem();

        // Format menu constructor //
        this.formatMenu.add(this.formatFont);

        // Menu bar constructor //
        this.bar.add(this.fileMenu);
        this.bar.add(this.formatMenu);
        this.bar.setBackground(Color.white);

        // Text area //
        this.content = new JTextArea();
        this.scroller = new JScrollPane(this.content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Panel construction //
        pnl.add(this.bar, BorderLayout.NORTH);
        pnl.add(this.scroller, BorderLayout.CENTER);

        // //
        this.add(pnl);
        this.setVisible(true);
    }

    public void addContentListener(KeyListener listener) {
        this.content.addKeyListener(listener);
    }
    public void addFileMenuListener(ActionListener listener){
        this.newFile.addActionListener(listener);
        this.openFile.addActionListener(listener);
        this.saveFile.addActionListener(listener);
        this.saveAsFile.addActionListener(listener);
        this.closeFile.addActionListener(listener);

        this.formatFont.addActionListener(listener);
    }

    public void setContent(String str) {
        this.content.setText(str);
    }
    public void setFont(Font font) {
        this.content.setFont(font);
    }
    public void setSaveMenuItemEnabled(boolean bool) {
        this.saveFile.setEnabled(bool);
    }

    public String getTextContent() {
        return this.content.getText();
    }

}

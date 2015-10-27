package com.notepad.view;

import com.notepad.model.menu.format.NPApproveFontBtn;
import com.notepad.model.menu.format.NPRejectFontBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KartoshkaD on 23.10.2015.
 *
 */
public class NPFontFrame extends JDialog {

    NPApproveFontBtn approveFontBtn;
    NPRejectFontBtn rejectFontBtn;

    JComboBox fonts;
    JComboBox styles;
    JLabel exampleShower;
    JScrollPane fontScroller;
    JTextField fontSize;

    public NPFontFrame(Font font) {
        // Setup frame //
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500, 500);
        this.setTitle("Font settings");

        // Font list //
        int index = 0;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontArray = ge.getAvailableFontFamilyNames();

        for (int i = 0; i < fontArray.length; i++) {
            if (fontArray[i].equals(font.getName())) {
                index = i;
                break;
            }
        }

        this.fonts = new JComboBox(fontArray);
        this.fonts.setSelectedIndex(index);
        this.fontScroller = new JScrollPane(this.fonts, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Font styles //
        String[] styleArray = {"Plain", "Bold", "Italic"};
        this.styles = new JComboBox(styleArray);
        this.styles.setSelectedIndex(font.getStyle());


        // text field //
        this.fontSize = new JTextField();
        this.fontSize.setHorizontalAlignment(JTextField.CENTER);
        this.fontSize.setText("" + font.getSize());

        // Example label //
        this.exampleShower = new JLabel("\"AaBbCcDd\"");
        this.exampleShower.setFont(font);
        this.exampleShower.setHorizontalAlignment(JLabel.CENTER);

        // Buttons //
        approveFontBtn = new NPApproveFontBtn(this);
        rejectFontBtn = new NPRejectFontBtn(this);

        // Listener setup //
        FontChangeListener fcl = new FontChangeListener();
        this.fonts.addActionListener(fcl);
        this.styles.addActionListener(fcl);
        this.fontSize.addActionListener(fcl);

        // Labels //
        JLabel exampleLabel = new JLabel("Example: ");
        JLabel fontLabel = new JLabel("Font: ");
        JLabel styleLabel = new JLabel("Style: ");
        JLabel sizeLabel = new JLabel("Size: ");

        // Panel construction //
        JPanel pnl = new JPanel();
        GroupLayout gl = new GroupLayout(pnl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        pnl.setLayout(gl);

        // Horizontal group //
        gl.setHorizontalGroup(gl.createParallelGroup()
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(fontLabel)
                                .addComponent(fontScroller))
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(styleLabel)
                                .addComponent(styles))
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(sizeLabel)
                                .addComponent(fontSize))
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(approveFontBtn)
                                .addComponent(rejectFontBtn))
        );

        // Vertical group //
        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                                .addComponent(fontLabel)
                                .addComponent(fontScroller))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(styleLabel)
                                .addComponent(styles))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(sizeLabel)
                                .addComponent(fontSize))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(approveFontBtn)
                                .addComponent(rejectFontBtn))
        );

        this.add(pnl);
        this.pack();
        this.setVisible(true);
    }

    //  //
    public void addBtnListener(ActionListener listener) {
        this.approveFontBtn.addActionListener(listener);
        this.rejectFontBtn.addActionListener(listener);
    }

    // Getters //
    public Font getFont() {
        return new Font(this.fonts.getSelectedItem().toString(), this.styles.getSelectedIndex(), Integer.parseInt(this.fontSize.getText()));
    }

    // Listener //
    private class FontChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Font curentFont = exampleShower.getFont();

            if (e.getSource() == fontSize) {
                exampleShower.setFont(new Font(curentFont.getName(), curentFont.getStyle(), Integer.parseInt(fontSize.getText())));
            }
            else if (e.getSource() == fonts) {
                exampleShower.setFont(new Font(fonts.getSelectedItem().toString(), curentFont.getStyle(), curentFont.getSize()));
            }
            else if (e.getSource() == styles) {
                exampleShower.setFont(new Font(curentFont.getName(), styles.getSelectedIndex(), curentFont.getSize()));
            }
        }
    }
}
package com.notepad.view;

import com.notepad.model.menu.format.NPApproveFontBtn;
import com.notepad.model.menu.format.NPRejectFontBtn;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    JLabel exampleLabel;
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
        this.exampleLabel = new JLabel("\"AaBbCcDd\"");
        this.exampleLabel.setFont(font);
        this.exampleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Buttons //
        approveFontBtn = new NPApproveFontBtn(this);
        rejectFontBtn = new NPRejectFontBtn(this);

        // Listener setup //
        FontChangeListener fcl = new FontChangeListener();
        this.fonts.addActionListener(fcl);
        this.styles.addActionListener(fcl);
        this.fontSize.addActionListener(fcl);

        // Panel construction //
        JPanel pnl = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        pnl.add(new JLabel("Example: "), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        pnl.add(exampleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnl.add(new JLabel("Font: "), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        pnl.add(this.fontScroller, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pnl.add(new JLabel("Style: "), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        pnl.add(this.styles, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        pnl.add(new JLabel("Size: "), gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 6;
        pnl.add(this.fontSize, gbc);

        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        pnl.add(this.approveFontBtn, gbc);

        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        pnl.add(this.rejectFontBtn, gbc);

        // //
        this.add(pnl);
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
            Font curentFont = exampleLabel.getFont();

            if (e.getSource() == fontSize) {
                exampleLabel.setFont(new Font(curentFont.getName(), curentFont.getStyle(), Integer.parseInt(fontSize.getText())));
            }
            else if (e.getSource() == fonts) {
                exampleLabel.setFont(new Font(fonts.getSelectedItem().toString(), curentFont.getStyle(), curentFont.getSize()));
            }
            else if (e.getSource() == styles) {
                exampleLabel.setFont(new Font(curentFont.getName(), styles.getSelectedIndex(), curentFont.getSize()));
            }
        }
    }
}

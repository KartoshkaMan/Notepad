package com.notepad.view;

import com.notepad.model.menu.format.NPApproveFontBtn;
import com.notepad.model.menu.format.NPRejectFontBtn;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.xml.bind.annotation.XmlElementDecl;
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
    JComboBox sizes;
    JComboBox styles;
    JLabel exampleShower;
    JScrollPane fontScroller;
    JScrollPane sizeScroller;
    JScrollPane styleScroller;

    public NPFontFrame(Font font) {
        // Setup frame //
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setTitle("Font settings");

        // Fonts list //
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
        this.fontScroller = new JScrollPane(
                this.fonts,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        // Styles list //
        String[] styleArray = {"Plain", "Bold", "Italic"};
        this.styles = new JComboBox(styleArray);
        this.styles.setSelectedIndex(font.getStyle());
        this.styleScroller = new JScrollPane(
                this.styles,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );


        // Sizes list //
        String[] sizeArray = {
                "8", "9", "10", "11", "12", "14", "16", "18",
                "20", "22", "24", "26", "28", "36", "48", "72"
        };
        this.sizes = new JComboBox(sizeArray);
        this.sizeScroller = new JScrollPane(
                this.sizes,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );


        // Example label //
        Border exampleBorder = new LineBorder(Color.black, 1);
        this.exampleShower = new JLabel("AaBbCcDd");
        this.exampleShower.setBorder(exampleBorder);
        this.exampleShower.setFont(font);
        this.exampleShower.setHorizontalAlignment(JLabel.CENTER);
        this.exampleShower.setPreferredSize(new Dimension(250, 60));

        // Buttons //
        approveFontBtn = new NPApproveFontBtn(this);
        rejectFontBtn = new NPRejectFontBtn(this);

        // Listener setup //
        FontChangeListener fcl = new FontChangeListener();
        this.fonts.addActionListener(fcl);
        this.styles.addActionListener(fcl);
        this.sizes.addActionListener(fcl);

        // Labels //
        JLabel exampleLabel = new JLabel("Example:");
        JLabel fontLabel = new JLabel("Font:");
        JLabel styleLabel = new JLabel("Style:");
        JLabel sizeLabel = new JLabel("Size:");
        JLabel emptyLabel = new JLabel("");

        // Panel construction //
        JPanel pnl = new JPanel();
        GroupLayout gl = new GroupLayout(pnl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        pnl.setBackground(Color.white);
        pnl.setLayout(gl);

        // Horizontal group //
        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(exampleLabel)
                                .addComponent(fontLabel)
                                .addComponent(styleLabel)
                                .addComponent(sizeLabel)
                                .addComponent(emptyLabel))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(exampleShower,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE
                                        )
                                .addComponent(fontScroller)
                                .addComponent(styleScroller)
                                .addComponent(sizeScroller)
                                .addGroup(gl.createSequentialGroup()
                                        .addComponent(approveFontBtn)
                                        .addComponent(rejectFontBtn)))
        );


        // Vertical group //
        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(exampleLabel)
                                .addComponent(exampleShower,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(fontLabel)
                                .addComponent(fontScroller))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(styleLabel)
                                .addComponent(styleScroller))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(sizeLabel)
                                .addComponent(sizeScroller))
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(emptyLabel)
                                .addGroup(gl.createParallelGroup()
                                        .addComponent(approveFontBtn)
                                        .addComponent(rejectFontBtn)))
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
        return new Font(
                this.fonts.getSelectedItem().toString(),
                this.styles.getSelectedIndex(),
                Integer.parseInt(this.sizes.getSelectedItem().toString())
        );
    }

    // Listener //
    private class FontChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Font curentFont = exampleShower.getFont();

            if (e.getSource() == sizes) {
                exampleShower.setFont(new Font(
                        curentFont.getName(),
                        curentFont.getStyle(),
                        Integer.parseInt(sizes.getSelectedItem().toString()))
                );
            }
            else if (e.getSource() == fonts) {
                exampleShower.setFont(new Font(
                        fonts.getSelectedItem().toString(),
                        curentFont.getStyle(),
                        curentFont.getSize()));
            }
            else if (e.getSource() == styles) {
                exampleShower.setFont(new Font(
                        curentFont.getName(),
                        styles.getSelectedIndex(),
                        curentFont.getSize()));
            }
        }
    }
}
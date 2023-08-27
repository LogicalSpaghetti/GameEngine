package main.me.spaghetti.main.constructors.thingsInBlocks.presetIcons.text;

import main.me.spaghetti.main.constructors.MyFrame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.me.spaghetti.main.Main.creativelyNamedGameEngineFrame;

public class MyTextField extends JTextField implements KeyListener {
    public MyTextField(String text) {
        super(text);
        setupAutoResize();
    }

    private void setupAutoResize() {
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTextFieldSize();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTextFieldSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTextFieldSize();
            }

            private void updateTextFieldSize() {
                int preferredWidth = getPreferredSize().width;
                int actualWidth = getWidth();
                String text = getText();

                if (preferredWidth > actualWidth) {
                    setColumns(text.length() + 1);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Auto Resizing Text Field Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MyTextField textField = new MyTextField("This is a long text that will resize to fit");
            textField.setColumns(10);
            textField.setHorizontalAlignment(JTextField.LEFT);

            frame.add(textField);

            frame.setSize(300, 150);
            frame.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        setText(getText() + e.getKeyChar());
        MyFrame.refreshDisplay(creativelyNamedGameEngineFrame);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
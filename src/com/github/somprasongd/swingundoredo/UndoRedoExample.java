/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.github.somprasongd.swingundoredo;

import java.awt.BorderLayout;
import javax.swing.*;

public class UndoRedoExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Undo/Redo Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // JTextArea
            JTextArea textArea1 = new JTextArea(10, 30);
            JScrollPane scrollPane1 = new JScrollPane(textArea1);
            UndoRedoUtil.setupUndoRedo(textArea1);
            frame.add(scrollPane1, BorderLayout.NORTH);

            // Create JEditorPane
            JEditorPane editorPane = new JEditorPane();
            JScrollPane scrollPane2 = new JScrollPane(editorPane);
            UndoRedoUtil.setupUndoRedo(editorPane);
            frame.add(scrollPane2, BorderLayout.CENTER);

            // Create a JTextField
            JTextField textField = new JTextField(30);
            UndoRedoUtil.setupUndoRedo(textField);
            frame.add(textField, BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

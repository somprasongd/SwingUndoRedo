/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.somprasongd.swingundoredo;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author somprasongd
 */
public class UndoRedoUtil {

    public static UndoManager setupUndoRedo(JTextComponent textComponent) {
        UndoManager undoManager = new UndoManager();
        Document doc = textComponent.getDocument();

        doc.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        // Define the Undo action
        Action undoAction = new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                } catch (CannotUndoException ex) {
                    ex.printStackTrace();
                }
            }
        };

        // Define the Redo action
        Action redoAction = new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canRedo()) {
                        undoManager.redo();
                    }
                } catch (CannotRedoException ex) {
                    ex.printStackTrace();
                }
            }
        };

        // Bind the Undo action to Ctrl+Z
        textComponent.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("control Z"), "Undo");
        textComponent.getActionMap().put("Undo", undoAction);

        // Bind the Redo action to Ctrl+Y
        textComponent.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("control Y"), "Redo");
        textComponent.getActionMap().put("Redo", redoAction);

        return undoManager;
    }
}

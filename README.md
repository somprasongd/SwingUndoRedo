
# Undo/Redo Utility for Swing Text Components

## Overview
This utility provides an easy way to add Undo (`Ctrl+Z`) and Redo (`Ctrl+Y`) functionality to any Swing `JTextComponent`, including:
- `JTextField`
- `JTextArea`
- `JEditorPane`
- `JTextPane`

## Features
- Supports all Swing text components.
- Creates an `UndoManager` for each text component.
- Listens for text changes and tracks undoable edits.
- Binds `Ctrl+Z` for Undo and `Ctrl+Y` for Redo.

## Usage
### 1. Import the Utility
Ensure you have the `UndoRedoUtil` class in your project.

### 2. Apply Undo/Redo to a Text Component
```java
JTextField textField = new JTextField(30);
UndoManager undoManagerField = UndoRedoUtil.setupUndoRedo(textField);

JTextArea textArea = new JTextArea(5, 30);
UndoManager undoManagerArea = UndoRedoUtil.setupUndoRedo(textArea);
```

### 3. Manually Perform Undo/Redo
If needed, you can manually trigger undo/redo actions:
```java
if (undoManagerField.canUndo()) {
    undoManagerField.undo();
}
if (undoManagerField.canRedo()) {
    undoManagerField.redo();
}
```

## Implementation Details
The `setupUndoRedo` function:
- Creates an `UndoManager`.
- Attaches an `UndoableEditListener` to the component's document.
- Defines `Undo` and `Redo` actions.
- Binds these actions to keyboard shortcuts (`Ctrl+Z` and `Ctrl+Y`).
- Returns the `UndoManager` for external access.

## License
This utility is open-source and free to use in any Java Swing project.


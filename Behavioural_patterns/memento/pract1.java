package Behavioural_patterns.memento;

import java.util.Stack;

public class pract1 {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // User types text
        editor.setText("Hello, World!");
        history.saveState(editor);  // Save state

        System.out.println("Current Text: " + editor.getText());

        // User modifies text
        editor.setText("Hello, Design Patterns!");
        history.saveState(editor);  // Save state

        System.out.println("Updated Text: " + editor.getText());

        // Undo the last change
        history.undo(editor);
        System.out.println("After Undo: " + editor.getText());

        // Undo again
        history.undo(editor);
        System.out.println("After Second Undo: " + editor.getText());
    }
}


class Memento{
    private final String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Editor{
    private String text;

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public Memento save(){
        return new Memento(text);
    }

    public void restore(Memento memento){
        text = memento.getState();
    }
}

class History{
    private Stack<Memento> history = new Stack<>();

    public void saveState(Editor editor){
        history.push(editor.save());
    }

    public void undo(Editor editor){
        if(!history.isEmpty()){
            editor.restore(history.pop());
        }
        else{
            System.out.println("No more states to undo");
        }
    }
}
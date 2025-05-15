package Structural_patterns;

import java.util.HashMap;
import java.util.Map;


interface Character {
    void display(String fontSize);
}

class ConcreteCharacter implements Character {
    private final char symbol; // intrinsic state

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    public void display(String fontSize) { // extrinsic state
        System.out.println("Character: " + symbol + ", Font size: " + fontSize);
    }
}


class CharacterFactory {
    private final Map<Character, ConcreteCharacter> charPool = new HashMap<>();

    public Character getCharacter(char c) {
        charPool.putIfAbsent(c, new ConcreteCharacter(c));
        return charPool.get(c);
    }
}

public class FlyweightPattern {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        String text = "hello";
        String[] fontSizes = {"12pt", "14pt", "12pt", "14pt", "12pt"};

        for (int i = 0; i < text.length(); i++) {
            Character ch = factory.getCharacter(text.charAt(i));
            ch.display(fontSizes[i]); // external data passed in
        }
    }

}

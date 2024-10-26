import java.util.HashMap;
import java.util.Map;

public class FlyWeightPattern {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();

        // Request characters with specific styles
        Character a1 = characterFactory.getCharacter('a', "Arial", 12);
        Character a2 = characterFactory.getCharacter('a', "Arial", 12);
        Character b = characterFactory.getCharacter('b', "Arial", 12);

        // Display characters with specific positions (extrinsic state)
        a1.display(10, 20);
        a2.display(30, 40);  // Reuses the same "a" character with "Arial", 12 style
        b.display(50, 60);

        // Check if the same objects are reused
        System.out.println("a1 and a2 are the same object: " + (a1 == a2));  // true
    }
}

interface Character{
    void display(int x, int y);
}

class StyledCharacter implements Character{
    private char symbol;
    private String font;
    private int fontSize;

    public StyledCharacter(char symbol, String font, int fontSize){
        this.symbol = symbol;
        this.font = font;
        this.fontSize = fontSize;
    }

    public void display(int x, int y){
        System.out.println("Displaying character '" + symbol + "' at (" + x + ", " + y + ")"
                + " with font: " + font + " and font size: " + fontSize);
    }
}

class CharacterFactory{
    private Map<String, Character> characterPool = new HashMap<>();

    public Character getCharacter(char symbol, String font, int fontSize){
        String key = symbol + "-" + font + "-" + fontSize;
        if(!characterPool.containsKey(key)){
            characterPool.put(key, new StyledCharacter(symbol, font, fontSize));
        }
        return characterPool.get(key);
    }
}
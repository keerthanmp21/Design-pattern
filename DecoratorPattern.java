public class DecoratorPattern {
    public static void main(String[] args) {
        Text plainText = new PlainText("kmp");

        Text boldText = new BoldText(plainText);
        System.out.println(boldText.format());

        Text italicText = new ItalicText(plainText);
        System.out.println(italicText.format());

        Text boldItalicText = new BoldText(new ItalicText(plainText));
        System.out.println(boldItalicText.format());
    }
}

interface Text{
    String format();
}

class PlainText implements Text{
    private String text;

    public PlainText(String text){
        this.text = text;
    }

    @Override
    public String format(){
        return text;
    }
}

abstract class TextDecorator implements Text{
    protected Text decoratedText;

    public TextDecorator(Text decoratedText){
        this.decoratedText = decoratedText;
    }

    public String format(){
        return decoratedText.format();
    }
}

class BoldText extends TextDecorator{
    public BoldText(Text decoratedText){
        super(decoratedText);
    }

    @Override
    public String format(){
        return "<b>" + decoratedText.format() + "</b>";
    }
}

class ItalicText extends TextDecorator{
    public ItalicText(Text decoratedText){
        super(decoratedText);
    }

    @Override
    public String format(){
        return "<i>" + decoratedText.format() + "</i>";
    }
}
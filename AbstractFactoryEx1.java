public class AbstractFactoryEx1 {
    private Button button;
    private CheckBox checkBox;

    public AbstractFactoryEx1(GUIFactory factory){
        // The client is unaware of the concrete factory it’s dealing with
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }

    public static void main(String[] args) {
        // The GUIFactory can be chosen based on the runtime environment

        // For Windows
        GUIFactory windowsFactory = new WindowsFactory();
        AbstractFactoryEx1 f1 = new AbstractFactoryEx1(windowsFactory);
        f1.paint();

        // For MacOS
        GUIFactory macOSFactory = new MacOSFactory();
        AbstractFactoryEx1 f2 = new AbstractFactoryEx1(macOSFactory);
        f2.paint();
    }
}

interface Button{
    void paint();
}

interface CheckBox{
    void paint();
}

class WindowsButton implements Button{
    @Override
    public void paint(){
        System.out.println("Rendering a button in windows style.");
    }
}

class MacOSButton implements Button{
    @Override
    public void paint(){
        System.out.println("Rendering a button in mac on style.");
    }
}

class WindowsCheckBox implements CheckBox{
    @Override
    public void paint(){
        System.out.println("Rendering a checkbox in windows style.");
    }
}

class MacOSCheckBox implements CheckBox{
    @Override
    public void paint(){
        System.out.println("Rendering a checkbox in mac on style.");
    }
}

// Abstract Factory Interface
interface GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}

class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox(){
        return new WindowsCheckBox();
    }
}

class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox(){
        return new MacOSCheckBox();
    }
}
public class AbstractFactoryEx1 {
    
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
    CheckBox creatCheckBox();
}


package Creational_patterns;

interface Button{
    void render();
}

class WindowsButton implements Button{
    @Override
    public void render(){
        System.out.println("Windows Button");
    }
}

class MacOSButton implements Button{
    @Override
    public void render(){
        System.out.println("MacOS Button");
    }
}

abstract class Dialog{
    public void renderButton(){
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }
}

class MacOSDialog extends Dialog{
    @Override
    public Button createButton(){
        return new MacOSButton();
    }
}

public class FactoryPattern1{
    public static void main(String[] args) {
        Dialog dialog;
        String os = "Windows";

        if(os.equals("Windows")){
            dialog = new WindowsDialog();
        }
        else{
            dialog = new MacOSDialog();
        }

        dialog.renderButton();
    }
}
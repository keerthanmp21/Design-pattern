package Behavioural_patterns.command;

public class pract1 {
    public static void main(String[] args) {
        Light light = new Light();

        Command turnOnLightCommand = new TurnOnLightCommand(light);
        Command turnOffLightCommand = new TurnOffLightCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(turnOnLightCommand);
        remoteControl.pressButton();

        remoteControl.pressUndo();

        remoteControl.setCommand(turnOffLightCommand);
        remoteControl.pressButton();

        remoteControl.pressUndo();
    }
}

interface Command{
    void execute();
    void undo();
}

class Light{
    public void on(){
        System.out.println("Light is on");
    }

    public void off(){
        System.out.println("Light is off");
    }
}

class TurnOnLightCommand implements Command{
    private Light light;

    public TurnOnLightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.on();
    }

    @Override
    public void undo(){
        light.off();
    }
}

class TurnOffLightCommand implements Command{
    private Light light;

    public TurnOffLightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.off();
    }

    @Override
    public void undo(){
        light.on();
    }
}

class RemoteControl{
    private Command currentCommand;
    private Command previousCommand;

    public void setCommand(Command command){
        this.currentCommand = command;
    }

    public void pressButton(){
        if(currentCommand != null){
            currentCommand.execute();
            previousCommand = currentCommand;
        }
    }

    public void pressUndo(){
        if(previousCommand != null){
            previousCommand.undo();
        }
    }
}

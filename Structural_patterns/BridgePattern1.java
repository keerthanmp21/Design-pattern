package Structural_patterns;

interface Device {
    void enable();
    void disable();
    boolean isEnabled();
}

class TV implements Device {
    private boolean on = false;

    @Override
    public void enable() {
        on = true;
        System.out.println("TV turned ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV turned OFF");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Radio implements Device {
    private boolean on = false;

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio turned ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio turned OFF");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
}

class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Device muted");
    }
}


public class BridgePattern1 {
    public static void main(String[] args) {
        Device tv = new TV();
        Remote remote = new AdvancedRemote(tv);

        remote.togglePower();  // TV turned ON
        remote.togglePower();  // TV turned OFF
    }

}

package Behavioural_patterns.chain_of_responsibility;

public class pract1 {
    public static void main(String[] args) {
        ApprovalHandler manager = new Manager();
        ApprovalHandler director = new Director();
        ApprovalHandler vp = new VP();

        manager.setNextHandler(director);
        director.setNextHandler(vp);

        System.out.println("Requesting approval for 800:");
        manager.handleRequest(800);

        System.out.println("Requesting approval for 3000:");
        manager.handleRequest(3000);

        System.out.println("Requesting approval for 8000:");
        manager.handleRequest(8000);

        System.out.println("Requesting approval for 12000:");
        manager.handleRequest(12000);
    }
}

abstract class ApprovalHandler{
    protected ApprovalHandler nextHandler;

    public void setNextHandler(ApprovalHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int amount);
}

class Manager extends ApprovalHandler{
    @Override
    public void handleRequest(int amount){
        if(amount <= 1000){
            System.out.println("Manager approved the request");
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(amount);
        }
    }
}

class Director extends ApprovalHandler{
    @Override
    public void handleRequest(int amount){
        if(amount <= 5000){
            System.out.println("Director approved the request");
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(amount);
        }
    }
}

class VP extends ApprovalHandler{
    @Override
    public void handleRequest(int amount){
        if(amount <= 10000){
            System.out.println("VP approved the request");
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(amount);
        }
    }
}

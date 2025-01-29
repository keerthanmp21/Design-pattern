package Behavioural_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class pract1 {
    public static void main(String[] args) {
        // create mediator
        ChatMediator chatRoom = new ChatRoom();

        // Create users
        User user1 = new ChatUser(chatRoom, "kmp1");
        User user2 = new ChatUser(chatRoom, "kmp2");
        User user3 = new ChatUser(chatRoom, "kmp3"); 

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hi All");
        user2.send("Hi All");

    }
}

interface ChatMediator{
    void sendMessage(String msg, User user);
    void addUser(User user); 
}

class ChatRoom implements ChatMediator{
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user){
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender){
        for(User user: users){
            if(user != sender){
                user.receive(msg);
            }
        }
    }
}

abstract class User{
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class ChatUser extends User{
    public ChatUser(ChatMediator mediator, String name){
        super(mediator, name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name + " : Sending Message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg){
        System.out.println(this.name + " : Received Message = " + msg);
    }
}
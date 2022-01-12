package com.brandon.designPattern._19_mediator;


import java.util.Date;

public class MediatorDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hi John!");
        john.sendMessage("Hello Robert!");
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        ChatRoom.ShowMessage(this, message);
    }
}

class ChatRoom {
    public static void ShowMessage(User user, String message) {
        System.out.println(String.format("%s [%s] : %s", new Date().toString(), user.getName(), message));
    }
}

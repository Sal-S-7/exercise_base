package org.example.exerciseDesignPattern.exercise03;

public class MyObserver implements Observer{

    private String name;

    public MyObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String notification) {
        System.out.println(name +" à reçu une notification : "+notification);
    }

    public void userAdded(String notification) {
        System.out.println(name +" à été accepté dans le club : "+clubName);
    }

}

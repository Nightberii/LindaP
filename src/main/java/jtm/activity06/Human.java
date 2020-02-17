package jtm.activity06;

import java.util.ArrayList;
import java.util.List;

public class Human implements Humanoid{
    private int weight;
    //private List<String> backpack;
    private String backpack;
    private boolean alive;

    public Human() {
        this.weight = 42;
        this.alive = true;
       // backpack = new ArrayList<>();
    }

    public Human(int weight) {
        this.weight = weight;
        this.alive = true;
        //backpack = new ArrayList<>();
    }

    @Override
    public int getWeight() {

        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String killHimself() {
        String text = "";
        if(alive){
            alive = false;
            text = "Dead";
        }
        return text;
    }

    @Override
    public int getArmCount() {
        return ARM_COUNT;
    }

    @Override
    public String getBackpack() {

        return backpack;
    }

    @Override
    public void setBackpack(String item) {
        backpack = item;
    }

    @Override
    public String isAlive() {
        if(alive) {
            return "Alive";
        } else {
            return "Dead";
        }
    }
    @Override
    public String toString() {
        return "ClassName: " + weight + " [" + backpack + "]";
    }

}

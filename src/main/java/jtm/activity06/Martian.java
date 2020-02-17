package jtm.activity06;


public class Martian implements Humanoid, Alien, Cloneable{
    private int weight;
    private Object backpack;

    public Martian(int weight) {
        this.weight = weight;
    }

    @Override
    public void eatHuman(Humanoid humanoid) {
        if(humanoid.isAlive().equals("Alive")){
            weight += humanoid.getWeight();
            humanoid.killHimself();
        }
    }

    @Override
    public int getLegCount() {
        return LEG_COUNT;
    }

    @Override
    public void setBackpack(Object item) {

        if(( item instanceof Human || item instanceof Martian || item instanceof String) &&item !=this){
            backpack = item;
        }
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
        return "I AM IMMORTAL!";
    }

    @Override
    public int getArmCount() {
        return ARM_COUNT;
    }

    @Override
    public Object getBackpack()  {

        if ( backpack == null){
            return null;
        }

        try {
            return ((Martian) this.clone()).backpack;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setBackpack(String item) {
            backpack = item;
    }

    @Override
    public String isAlive() {
        return "Alive";
    }
    @Override
    public String toString() {
        return "ClassName: " + weight + " [" + backpack + "]";
    }
    @Override
    public Object clone()throws java.lang.CloneNotSupportedException{
        return clone(this);
    }

    private Martian clone(Martian it)  {

        Martian newMartian = new Martian(it.getWeight());

        if(backpack instanceof String){
            newMartian.setBackpack(new String((String) backpack));
        } else if ( backpack instanceof Human){
            newMartian.setBackpack(new Human(((Human) backpack).getWeight()));
        } else if (( backpack instanceof Martian)){
            newMartian.setBackpack(new Martian(((Martian) backpack).getWeight()));
        }

        return newMartian;

    }
}

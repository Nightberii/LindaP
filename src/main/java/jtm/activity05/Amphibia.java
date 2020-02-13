package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Vehicle {
    private byte sails;


    public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
        super(id, consumption, tankSize, wheels);
        this.sails = sails;
    }

    @Override
    public String move(Road road) {

            String status = "";
        if(road instanceof WaterRoad){
            WaterRoad waterRoad = (WaterRoad)road;
            return super.getType() + " is sailing on "
                    + waterRoad + " with " + sails + " sails";

        }
        if (road instanceof Road) {
            Road groundRoad = road;
            return super.move(groundRoad);
        }
        return status;
    }
}

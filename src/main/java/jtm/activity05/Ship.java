package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
    protected byte numberOfSails;

    public Ship(String id, byte sails) {
        super(id, 0, 0);
        this.numberOfSails = sails;
    }

    @Override
    public String move(Road road) {
        String status = "";
        if(road instanceof WaterRoad){
            WaterRoad waterRoad = (WaterRoad) road;
            return super.getType() + " is sailing on "
                    + waterRoad.toString() + " with " + numberOfSails + " sails";

        } if (road instanceof Road){
            Road groundRoad = road;
            return  "Cannot sail on " + groundRoad.toString();
        }
        return status;
    }
}

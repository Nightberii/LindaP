package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
    protected int numberOfWheels;


    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        this.numberOfWheels = wheels;
    }

    @Override
    public String move(Road road) {
        String status = "";
        if(road instanceof WaterRoad){
            WaterRoad waterRoad = (WaterRoad) road;
            return  "Cannot drive on " + waterRoad.toString();
        }
        if (road instanceof Road) {
            Road groundRoad = road;
            return super.move(groundRoad).replaceAll("moving", "driving")  +  " with "+ numberOfWheels + " wheels";
        }
        return status;
    }
}

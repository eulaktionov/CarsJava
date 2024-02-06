package Me;

import java.io.Serializable;

public class Truck extends Vechile implements Serializable
{
    //private double maxLoad;
    double maxLoad;

    public  Truck(int id, String model, int year,
                String color, double price, double fuel100price,
                double maxLoad)
    {
        super(id, model, year, color, price, fuel100price);
        this.maxLoad = maxLoad;
    }
    public String toString()
    {
        return super.toString() + " maxLoad: " + maxLoad;
    }
}


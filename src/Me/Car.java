package Me;

import java.io.*;

public class Car extends Vechile implements Serializable
{
    private final String bodyModel;

    public  Car(int id, String model, int year,
        String color, double price, double fuel100price,
        String bodyModel)
    {
        super(id, model, year, color, price, fuel100price);
        this.bodyModel = bodyModel;
    }
    public String toString()
    {
        return super.toString() + " bodyModel: " + bodyModel;
    }
}


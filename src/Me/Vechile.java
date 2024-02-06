package Me;

import java.io.*;
import java.util.*;

public class Vechile implements Serializable
{
    /*
    private int id;
    private String model;
    private int year;
    private String color;
    private double price;
    private double fuel100price;
    */
    int id;
    String model;
    int year;
    String color;
    double price;
    double fuel100price;

    public Vechile(int id, String model, int year,
       String color, double price, double fuel100price)
    {
        this.id = id;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.fuel100price = fuel100price;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + " model: " + model + " year: " + year +
                " color: " + color + " price: " + price + "fuel100price: " + fuel100price;

    }
}

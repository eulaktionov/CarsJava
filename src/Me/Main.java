package Me;
import java.util.*;
import java.io.*;

public class Main {

    static final int ShowAll = 1;
    static final int FindByName = 2;
    static final int FindByYear = 3;
    static final int FindByPrice = 4;
    static final int AddCar = 5;
    static final int AddTruck = 6;
    static final int Remove = 7;
    static final int Exit = 0;

    static final Menu.Command[] commands = new Menu.Command[]
            {
                    new Menu.Command("Show all     ", ShowAll),
                    new Menu.Command("Find By Name ", FindByName),
                    new Menu.Command("Find By Year ", FindByYear),
                    new Menu.Command("Find By Price", FindByPrice),
                    new Menu.Command("Add car      ", AddCar),
                    new Menu.Command("Add truck    ", AddTruck),
                    new Menu.Command("Remove       ", Remove),
                    new Menu.Command("Exit         ", Exit)
            };

    static Menu menu;
    static final  String objectFile = "vechiles.dat";
    static List<Vechile> vechiles;

    public static void main(String[] args) {
    vechiles = open(objectFile);
    /*
	vechiles = new ArrayList<Vechile>();
    vechiles.add(new Car(1,"Bently", 2010,
            "green", 100000, 500,
            "sedan"));
    vechiles.add(new Car(2,"Ford", 2015,
            "red", 30000, 300,
            "cupe"));
    vechiles.add(new Truck(1,"Ford", 2012,
            "grey", 10000, 1000,
            8.5));
*/
    printAll();

        List<Vechile> found;
        Vechile vechile;

        menu = new Menu(commands);
        int command = menu.enterCommand();
        while (command != Exit) {
            switch (command) {
                case ShowAll:
                    printAll();
                    break;
                case FindByName:
                    String namePart = Menu.enterString("Enter name part: ");
                    found = FindByName(namePart);
                    print(found);
                    break;
                case FindByYear:
                    int yearStart = Menu.enterInt("Enter first year: ");
                    int yearEnd = Menu.enterInt("Enter last year: ");
                    found = FindByYear(yearStart, yearEnd);
                    print(found);
                    break;
                case FindByPrice:
                    double priceStart = Menu.enterDouble("Enter low price: ");
                    double priceEnd = Menu.enterDouble("Enter top price: ");
                    found = FindByPrice(priceStart, priceEnd);
                    print(found);
                    break;
                case AddCar:
                    vechiles.add(EnterCar());
                    printAll();
                    break;
                case AddTruck:
                    vechiles.add(EnterTruck());
                    printAll();
                    break;
                case Remove:
                    int id = Menu.enterInt("Enter id:");
                    vechile = FindById(id);
                    if (vechile == null)
                    {
                        System.out.println("No such id!");
                        break;
                    }

                    vechiles.remove(vechile);
                    printAll();
                    break;
            }
            command = menu.enterCommand();
        }
        save(vechiles, objectFile);
        System.out.println("The program has ended.");

    }

    static Vechile EnterCar()
    {
        int id = Menu.enterInt("Enter id: ");
        String model=Menu.enterString("Enter model: ");
        int year = Menu.enterInt("Enter year: ");
        String color =Menu.enterString("Enter color: ") ;
        double price = Menu.enterDouble("Enter price: ");
        double fuel100price = Menu.enterDouble("Enter fuel price: ");
        String bodyModel = Menu.enterString("Enter body model: ");
        return new Car(id,model,year,color,price,fuel100price,bodyModel);
    }

    static Vechile EnterTruck()
    {
        int id = Menu.enterInt("Enter id: ");
        String model=Menu.enterString("Enter model: ");
        int year = Menu.enterInt("Enter year: ");
        String color =Menu.enterString("Enter color: ") ;
        double price = Menu.enterDouble("Enter price: ");
        double fuel100price = Menu.enterDouble("Enter fuel price: ");
        double maxLoad = Menu.enterDouble ("Enter max load: ");
        return new Truck(id,model,year,color,price,fuel100price,maxLoad);
    }

    static void print(List<Vechile> vechiles)
    {
        for(Vechile it: vechiles)
        {
            System.out.println(it);
        }
    }

    static void printAll()
    {
        for(Vechile it: vechiles)
        {
            System.out.println(it);
        }
    }

    static  Vechile FindById(int id)
    {
        for(Vechile it: vechiles)
        {
            if (it.id == id)
            {
                return it;
            }
        }
        return null;
    }

    static  List<Vechile> FindByName(String name)
    {
        List<Vechile> found = new ArrayList();
        for(Vechile it: vechiles)
        {
            int index = it.model.indexOf(name);
            if (index != -1)
            {
                found.add(it);
            }
        }
        return found;
    }

    static  List<Vechile> FindByYear(int minYear, int maxYear)
    {
        List<Vechile> found = new ArrayList();
        for(Vechile it: vechiles)
        {
            if (it.year >= minYear && it.year <= maxYear)
            {
                found.add(it);
            }
        }
        return found;
    }

    static  List<Vechile> FindByPrice(double minPrice, double maxPrice)
    {
        List<Vechile> found = new ArrayList();
        for(Vechile it: vechiles)
        {
            if (it.price >= minPrice && it.price <= maxPrice)
            {
                found.add(it);
            }
        }
        return found;
    }

    static void save(List<Vechile> vechiles, String filename)
    {
        try(ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            file.writeObject(vechiles);
            System.out.println("File has been saved");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    static ArrayList<Vechile> open(String filename)
    {
        try(ObjectInputStream file = new ObjectInputStream(new FileInputStream(filename)))
        {
            return (ArrayList<Vechile>)file.readObject();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }


}

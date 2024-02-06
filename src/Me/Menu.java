package Me;
import java.util.Scanner;

public class Menu {
    static Scanner reader = new Scanner(System.in);

    final String call = "--> ";
    final String commandError = "No such command!";

    public static class Command {
        String text;
        int value;
        public Command(String text, int value){
            this.text = text;
            this.value = value;
        }
        @Override
        public String toString(){
            return text + " - " + value;
        }
    }

    Command[] commands;

    public  Menu(Command[] commands)
    {
        this.commands = commands;
    }

    int enterCommand(){
        System.out.println();
        for(var command : commands){
            System.out.println(command);
        }
        int value = enterInt(call);
        while (!isValid(value)){
            System.out.println(commandError);
            value = enterInt(call);
        }
        return value;
    }

    boolean isValid(int value){
        for(var command : commands) {
            if (command.value == value) {
                return true;
            }
        }
        return  false;
    }

    public static int enterInt(String call){
        System.out.print(call);
        int value = tryEnterInt();
        while (value == Integer.MAX_VALUE){
            System.out.println("Not number!");
            System.out.print(call);
            value = tryEnterInt();
        }
        return value;
    }

    public static int tryEnterInt(){
        try{
            return Integer.parseInt(reader.nextLine());
        }
        catch (NumberFormatException e){
            return Integer.MAX_VALUE;
        }
    }

    public static double enterDouble(String call){
        System.out.print(call);
        double value = tryEnterDouble();
        while (Double.isNaN(value)){
            System.out.println("Not number!");
            System.out.print(call);
            value = tryEnterDouble();
        }
        return value;
    }

    public static double tryEnterDouble(){
        try{
            return Double.parseDouble(reader.nextLine());
        }
        catch (NumberFormatException e){
            return Double.NaN;
        }
    }

    public static String enterString(String call){
        System.out.print(call);
        return reader.nextLine();
    }

    public static String editString(String call, String value){
        String prompt = String.format("/%s/%s (Enter - left prev): ",
                value, call);
        System.out.print(prompt);
        String newValue = reader.nextLine();
        return newValue.length() == 0 ? value : newValue;
    }

    public static int editInt(String call, int value){
        String prompt = String.format("/%d/%s (Enter - left prev): ",
                value, call);
        System.out.print(prompt);
        int newValue = tryEnterInt();
        return newValue == Integer.MAX_VALUE ? value : newValue;
    }
}

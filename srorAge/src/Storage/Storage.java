package Storage;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Storage {
    protected Scanner scan = new Scanner(System.in);
    public static ArrayList<String> wareHouseArrayList = new ArrayList<>();
    public static ArrayList<String> pointOfSaleArrayList = new ArrayList<>();

    public abstract void isTransfer();

    public abstract void deleteStorage();

    public abstract void printInfoItems();
}
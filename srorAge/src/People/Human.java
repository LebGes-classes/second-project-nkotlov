package People;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Human {
    protected String nameHuman;
    protected String birthdayHuman;
    protected int idHuman;
    protected Scanner scan = new Scanner(System.in);
    public abstract void setNameHuman();
    public abstract String getNameHuman();
    public abstract void setBirthdayHuman();
    public abstract String getBirthdayHuman();
    public abstract void setIdHuman();
    public abstract int getIdHuman();
    public static ArrayList<Assistant> assistantArrayList = new ArrayList<>();
    public static ArrayList<Buyer> buyerArrayList = new ArrayList<>();
}
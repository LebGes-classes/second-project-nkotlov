package People;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Human {
    protected String nameHuman;//имя человека
    protected String birthdayHuman;//др человека
    protected Scanner scan=new Scanner(System.in);//сканнер
    public abstract void setHumanName();//сеттер имени человека
    public abstract String getHumanName();//геттер имени человека

    public abstract void setHumanBirthday();//сеттер др человека
    public abstract String getHumanBirthday();//геттер др человека

    public abstract void setHumanId();//сеттер id человека
    public abstract int getHumanId();//геттер id человека

    public static ArrayList<Assistant> arrayListAssistants = new ArrayList<>();//массив arrayListAssistant
    public static ArrayList<Buyer> arrayListBuyer = new ArrayList<>();//массив arrayListBuyer


}

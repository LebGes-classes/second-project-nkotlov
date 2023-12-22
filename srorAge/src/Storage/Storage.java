package Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Storage {//Хранилище
    public abstract void transfer();//передать
    public abstract void deleteStorage() throws IOException;//удалить хранилище
//    public void printInfoItems();

    protected  Scanner scan=new Scanner(System.in);//сканнер
    public static ArrayList<String> arrayListWareHouse=new ArrayList<>();//массив arraysListWareHouse
    public static ArrayList<String> arrayListPointsOfSale=new ArrayList<>();//массив arraysListPointsOfSale
    public abstract void readToFileAndPrint() throws FileNotFoundException;

}


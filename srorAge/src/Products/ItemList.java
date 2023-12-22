package Products;

import java.util.Scanner;

public class ItemList {
    protected int idItemList; // id списка товара
    protected String nameIdList; // название списка товара
    protected double sizeItemList; // размер списка товара
    protected String descriptionItemList; // описание списка товара
    Scanner scanner = new Scanner(System.in);

    // Конструктор
    public ItemList(int idItemList, String nameIdList, double sizeItemList, String descriptionItemList) {
        this.idItemList = idItemList;
        this.nameIdList = nameIdList;
        this.sizeItemList = sizeItemList;
        this.descriptionItemList = descriptionItemList;
    }

    public void printItemListInfo() {
        System.out.println("Информация о товаре:");
        System.out.println("ID: " + idItemList);
        System.out.println("Название: " + nameIdList);
        System.out.println("Размер: " + sizeItemList);
        System.out.println("Описание: " + descriptionItemList);
    }
}

package Products;

import java.util.Scanner;



public class Product extends ItemList {
    private int salePriceProduct; // цена продажи
    private String condition; // состояние

    // Конструктор
    private String name;

    public Product(int idItemList, String nameIdList, double sizeItemList, String descriptionItemList, int salePriceProduct, String condition) {
        super(idItemList, nameIdList, sizeItemList, descriptionItemList);
        this.salePriceProduct = salePriceProduct;
        this.condition = condition;
    }

    // Дополнительные методы и set/get методы
    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите id товара:");
            int id = scanner.nextInt();
            scanner.nextLine(); // считываем символ новой строки

            System.out.println("Введите название товара:");
            String name = scanner.nextLine();

            System.out.println("Введите размер товара:");
            double size = scanner.nextDouble();
            scanner.nextLine(); // считываем символ новой строки

            System.out.println("Введите описание товара:");
            String description = scanner.nextLine();

            System.out.println("Введите цену продажи товара:");
            int salePrice = scanner.nextInt();
            scanner.nextLine(); // считываем символ новой строки

            System.out.println("Введите состояние товара:");
            String condition = scanner.nextLine();

            return new Product(id, name, size, description, salePrice, condition);

        } catch (Exception e) {
            System.out.println("Ошибка при вводе данных. Попробуйте снова.");
            return null;
        }
    }

    public void printProductInfo() {
        super.printItemListInfo();
        System.out.println("Цена продажи: " + salePriceProduct);
        System.out.println("Состояние товара: " + condition);
    }

    public void sellProduct() {
        System.out.println("Товар " + nameIdList + " продан по цене " + salePriceProduct);
        // Дополнительная логика продажи товара, например, списание со склада и т.д.
    }

    public String getNameIdList() {
        return nameIdList;
    }
}

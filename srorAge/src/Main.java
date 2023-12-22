import People.*;
import Products.*;
import Storage.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Создаем объекты для работы
        WareHouse wareHouse = new WareHouse();
        PointsOfSale pointsOfSale = new PointsOfSale();
        Assistant assistant = new Assistant();
        Buyer buyer = new Buyer();

        int choice;
        do {//Главное меню
            System.out.println("\n=== Меню ===");
            System.out.println("1. Склад");
            System.out.println("2. Пункт продаж");
            System.out.println("3. Продукты");
            System.out.println("4. Ассистенты");
            System.out.println("5. Покупатели");
            System.out.println("0. Выйти");

            System.out.print("Выберите раздел (введите число): ");
            while (!scanner.hasNext()) {
                System.out.println("Неправильно введите ещё раз:");

            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWarehouseMenu(wareHouse, scanner);
                    break;
                case 2:
                    handlePointOfSaleMenu(pointsOfSale, scanner);
                    break;
                case 3:
                    handleProductMenu(scanner,wareHouse,pointsOfSale);
                    break;
                case 4:
                    handleAssistantMenu(scanner);
                    break;
                case 5:
                    handleBuyerMenu(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

        } while (choice != 0);
    }


    private static void handleWarehouseMenu(WareHouse wareHouse, Scanner scanner) throws IOException {
        int warehouseChoice;
        do {
            System.out.println("\n=== Меню Склада ===");
            System.out.println("1. Закупить товар на склад");
            System.out.println("2. Вывести информацию о товарах на складе");
            System.out.println("3. Передать товар на пункт продаж");
            System.out.println("4. Удалить все товары со склада");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            warehouseChoice = scanner.nextInt();

            switch (warehouseChoice) {
                case 1:
                    wareHouse.purchase();
                    wareHouse.writeToFile();
                    break;
                case 2:
                    wareHouse.readToFileAndPrint();
                    break;
                case 3:
                    wareHouse.transfer();
                    break;
                case 4:
                    wareHouse.deleteStorage();
                    break;
                case 0:
                    System.out.println("Возвращаемся в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

        } while (warehouseChoice != 0);
    }


    private static void handlePointOfSaleMenu(PointsOfSale pointsOfSale, Scanner scanner) throws IOException {
        int pointOfSaleChoice;
        do {
            System.out.println("\n=== Меню Пункта продаж ===");
            System.out.println("1. Передать товар на склад");
            System.out.println("2. Вывести информацию о пункте продаж");
            System.out.println("3. Удалить содержимое пункта продаж");
            System.out.println("4. Продать товар");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            pointOfSaleChoice = scanner.nextInt();

            switch (pointOfSaleChoice) {
                case 1:
                    pointsOfSale.transfer();
                    break;
                case 2:
                    pointsOfSale.readToFileAndPrint();
                    break;
                case 3:
                    pointsOfSale.deleteStorage();
                    break;
                case 4:
                    pointsOfSale.toSell();
                    break;
                case 0:
                    System.out.println("Возвращаемся в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");

            }
        } while (pointOfSaleChoice != 0);
    }


    private static void handleProductMenu(Scanner scanner, WareHouse wareHouse, PointsOfSale pointsOfSale) {
        ArrayListProduct productList = new ArrayListProduct(); // Создайте экземпляр ArrayListProduct для хранения продуктов
        int productChoice;

        do {
            System.out.println("\n=== Меню Продуктов ===");
            System.out.println("1. Создать новый продукт");
            System.out.println("2. Вывести информацию о продукте");
            System.out.println("3. Продать продукт");
            System.out.println("4. Передать продукт на склад");
            System.out.println("5. Передать продукт на пункт продаж");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            productChoice = scanner.nextInt();

            switch (productChoice) {
                case 1:
                    Product newProduct = Product.createProduct();
                    if (newProduct != null) {
                        productList.addProduct(newProduct); // Добавьте новый продукт в список
                        System.out.println("Продукт успешно добавлен.");
                    }
                    break;
                case 2:
                    if (productList.getSize() > 0) {
                        System.out.print("Введите индекс продукта: ");
                        int index = scanner.nextInt();
                        if (index > 0 && index <= productList.getSize()) {
                            productList.getProduct(index-1).printProductInfo();
                        } else {
                            System.out.println("Некорректный индекс продукта.");
                        }
                    } else {
                        System.out.println("Список продуктов пуст.");
                    }
                    break;
                case 3:
                    if (productList.getSize() > 0) {
                        System.out.print("Введите индекс продукта для продажи: ");
                        int index = scanner.nextInt();
                        if (index > 0 && index <= productList.getSize()) {
                            productList.getProduct(index-1).sellProduct();
                            productList.removeProduct(index-1); // Удалите проданный продукт из списка
                            System.out.println("Продукт успешно продан.");
                        } else {
                            System.out.println("Некорректный индекс продукта.");
                        }
                    } else {
                        System.out.println("Список продуктов пуст.");
                    }
                    break;
                case 4:
                    if (productList.getSize() > 0) {
                        System.out.print("Введите индекс продукта для передачи на склад: ");
                        int index = scanner.nextInt();
                        if (index > 0 && index <= productList.getSize()) {
                            wareHouse.purchaseProduct(productList.getProduct(index - 1));
                            productList.removeProduct(index - 1); // Удалите продукт из списка после передачи на склад
                            System.out.println("Продукт успешно передан на склад.");
                        } else {
                            System.out.println("Некорректный индекс продукта.");
                        }
                    } else {
                        System.out.println("Список продуктов пуст.");
                    }
                    break;
                case 5:
                    if (productList.getSize() > 0) {
                        System.out.print("Введите индекс продукта для передачи на пункт продаж: ");
                        int index = scanner.nextInt();
                        if (index > 0 && index <= productList.getSize()) {
                            pointsOfSale.transferProduct(productList.getProduct(index - 1));
                            productList.removeProduct(index - 1); // Удалите продукт из списка после передачи на пункт продаж
                            System.out.println("Продукт успешно передан на пункт продаж.");
                        } else {
                            System.out.println("Некорректный индекс продукта.");
                        }
                    } else {
                        System.out.println("Список продуктов пуст.");
                    }
                    break;
                case 0:
                    System.out.println("Возвращаемся в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (productChoice != 0);
    }


    private static void handleAssistantMenu(Scanner scanner) {
        int assistantChoice;
        do {
            System.out.println("\n=== Меню Ассистентов ===");
            System.out.println("1. Добавить нового ассистента");
            System.out.println("2. Вывести информацию об ассистентах");
            System.out.println("3. Удалить ассистента");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            assistantChoice = scanner.nextInt();

            switch (assistantChoice) {
                case 1:
                    Assistant newAssistant = new Assistant();
                    newAssistant.setInfoAssistant();
                    break;
                case 2:
                    Assistant.printInfoAssistant();
                    break;
                case 3:
                    Assistant.removeAssistant();
                    break;
                case 0:
                    System.out.println("Возвращаемся в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

        } while (assistantChoice != 0);
    }


    private static void handleBuyerMenu(Scanner scanner) {
        int buyerChoice;
        do {
            System.out.println("\n=== Меню Покупателей ===");
            System.out.println("1. Добавить нового покупателя");
            System.out.println("2. Вывести информацию о покупателях");
            System.out.println("3. Удалить покупателя");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            buyerChoice = scanner.nextInt();

            switch (buyerChoice) {
                case 1:
                    Buyer newBuyer=new Buyer();
                    newBuyer.setInfoBuyer();
                    break;
                case 2:
                    Buyer.printInfoBuyer();
                    break;
                case 3:
                    Buyer.removeBuyer();
                    break;
                case 0:
                    System.out.println("Возвращаемся в предыдущее меню.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

        } while (buyerChoice != 0);
    }
}
import People.*;
import Product.*;
import Storage.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointsOfSale pointsOfSale = new PointsOfSale();
        WareHouse wareHouse = new WareHouse();
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
//                case 3:
//                    handleProductMenu(scanner,wareHouse,pointsOfSale);
//                    break;
                case 4:
                    handleAssistantMenu(scanner);
                    break;
                case 5:
                    handleBuyerMenu(scanner);
                    break;
                case 0:
                    System.out.println("Вы вышли из программы");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова");
            }

        } while (choice != 0);
    }

    private static void handleAssistantMenu(Scanner scanner) {
        int assistantChoice;
        do {
            System.out.println("\n=== Меню Ассистентов ===");
            System.out.println("1. Добавить нового ассистента");
            System.out.println("2. Вывести информацию об ассистентах");
            System.out.println("3. Удалить конкретного ассистента");
            System.out.println("4. Удалить всех ассистентов");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            assistantChoice = scanner.nextInt();

            switch (assistantChoice) {
                case 1:
                    Assistant newAssistant = new Assistant();
                    newAssistant.setAssistantInfo();
                    break;
                case 2:
                    Assistant.printAssistantInfo();
                    break;
                case 3:
                    Assistant.removeAssistant();
                    break;
                case 4:
                    Assistant.removeAssistantAll();
                    break;
                case 0:
                    System.out.println("Вы вернулись в предыдущее меню");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова");
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
            System.out.println("4. Удалить всех покупателей");
            System.out.println("0. Вернуться в предыдущее меню");

            System.out.print("Выберите действие (введите число): ");
            buyerChoice = scanner.nextInt();


            switch (buyerChoice) {
                case 1:
                    Buyer newBuyer = new Buyer();
                    newBuyer.setBuyerInfo();
                    break;
                case 2:
                    Buyer.printBuyerInfo();
                    break;
                case 3:
                    Buyer.removeBuyer();
                    break;
                case 4:
                    Buyer.removeBuyerAll();
                    break;
                case 0:
                    System.out.println("Вы вернулись в предыдущее меню");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова");
            }

        } while (buyerChoice != 0);
    }

    private static void handleWarehouseMenu(WareHouse wareHouse, Scanner scanner){
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
                    wareHouse.buyItems();
                    break;
                case 2:
                    wareHouse.printInfoItems();
                    break;
                case 3:
                    wareHouse.isTransfer();
                    break;
                case 4:
                    wareHouse.deleteStorage();
                    break;
                case 0:
                    System.out.println("Вы вернулись в предыдущее меню");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова");
            }

        } while (warehouseChoice != 0);
    }


    private static void handlePointOfSaleMenu(PointsOfSale pointsOfSale, Scanner scanner){
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
                    pointsOfSale.isTransfer();
                    break;
                case 2:
                    pointsOfSale.printInfoItems();
                    break;
                case 3:
                    pointsOfSale.deleteStorage();
                    break;
                case 4:
                    pointsOfSale.sellItem();
                    break;
                case 0:
                    System.out.println("Вы вернулись в предыдущее меню");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова");

            }
        } while (pointOfSaleChoice != 0);
    }
}
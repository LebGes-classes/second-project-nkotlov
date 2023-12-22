package Storage;

import Products.Product;

import java.io.*;
import java.util.Scanner;

public class WareHouse extends Storage {//cклад


    @Override
    public void transfer() {//передать
//        System.out.println("Введите номер товара, который хотите передать: ");
//        int productIndex = scan.nextInt();
//        scan.nextLine();// Чтобы поймать символ новой строки после ввода числа
//
//        if ((productIndex > 0) && (productIndex <= arrayListWareHouse.size())) {
//            String transferredProduct = arrayListWareHouse.get(productIndex-1);// Получаем товар из списка на складе
//            arrayListPointsOfSale.add(transferredProduct);// Добавляем товар в список на пункте продаж
//            arrayListWareHouse.remove(productIndex-1);// Удаляем товар из списка на складе по индексу
//            System.out.println("Товар успешно передан на пункт продаж.");
//        } else {
//            System.out.println("Некорректный номер товара.");
//        }
        String sourceFileName = "WareHouseProduct"; // Имя файла-источника
        String destinationFileName = "PointsOfSaleProduct"; // Имя файла-приемника

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName));

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Добавление новой строки (опционально)
            }

            reader.close();
            writer.close();

            clearFile(sourceFileName); // Очистка файла-источника

            System.out.println("Товар отправлен на пункт продаж");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файлов: " + e.getMessage());
        }
    }



    @Override
    public void deleteStorage() throws IOException {//удалить хранилище
//        arrayListWareHouse.clear();
//        System.out.println("Склад очищен");
        String sourceFileName = "WareHouseProduct";
        clearFile(sourceFileName);
        System.out.println("Содержимое склада удалено.");
    }

    public void purchase() throws IOException {
        System.out.println("Введите товар, который хотите закупить:");
        String productWareHouse = scan.nextLine();
        if (!productWareHouse.isEmpty()) {//если не пустая строка
            arrayListWareHouse.add(productWareHouse);
            System.out.println("Товар успешно закуплен.");
        } else {//если пустая
            System.out.println("Некорректное название товара. Закупка не выполнена.");
        }
    }

    public void purchaseProduct(Product product) {
        // Логика закупки продукта на склад
        // Например, добавление продукта в массив arrayListWareHouse

        if (product != null) {
            arrayListWareHouse.add(product.getNameIdList());
        } else {
            System.out.println("Некорректный продукт.");
        }
    }

    public void writeToFile() throws IOException {
        File file = new File("WareHouseProduct");
        // Открываем файл для дополнения (append)
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < arrayListWareHouse.size(); i++) {
            printWriter.println(arrayListWareHouse.get(i));
        }
        printWriter.close();
    }

    @Override
    public void readToFileAndPrint() throws FileNotFoundException {
        File file = new File("WareHouseProduct");

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список продуктов на складе:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет продуктов");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
    public static void clearFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.close(); // Очистка файла путем открытия и закрытия FileWriter}
    }

//    @Override
//    public void printInfoItems() {
//        if (pointOfSaleArrayList.size() > 0) {
//            for (int i = 0; i < pointOfSaleArrayList.size(); i++) {
//                System.out.println((i + 1) + ". " + pointOfSaleArrayList.get(i));
//            }
//        } else {
//            System.out.println("Нет продуктов");
//        }
//    }


}


package Storage;

import Products.Product;

import java.io.*;
import java.util.Scanner;

public class PointsOfSale extends Storage {
    @Override
    public void transfer() {//передать
//        System.out.println("Введите номер товара, который хотите передать: ");
//        int productIndex = scan.nextInt();
//        scan.nextLine();// Чтобы поймать символ новой строки после ввода числа
//
//        if ((productIndex >= 0) && (productIndex < arrayListPointsOfSale.size())) {
//            String transferredProduct = arrayListPointsOfSale.get(productIndex-1);// Получаем товар из списка на складе
//            arrayListWareHouse.add(transferredProduct);// Добавляем товар в список на пункте продаж
//            arrayListPointsOfSale.remove(productIndex-1);// Удаляем товар из списка на складе по индексу
//            System.out.println("Товар успешно передан на склад.");
//        } else {
//            System.out.println("Некорректный номер товара.");
//        } код без файлов
        String sourceFileName = "PointsOfSaleProduct"; // Имя файла-источника
        String destinationFileName = "WareHouseProduct"; // Имя файла-приемника

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
        String sourceFileName = "PointsOfSaleProduct";
        clearFile(sourceFileName);
        System.out.println("Содержимое пункта продаж удалено.");
    }

    public void toSell(){//продать
        System.out.println("Введите номер продукта, который хотите продать: ");
        int productToSell = scan.nextInt();
        if (productToSell > 0 && productToSell <= arrayListPointsOfSale.size()){
            arrayListPointsOfSale.remove(arrayListPointsOfSale.get(productToSell-1));
            System.out.println("Товар успешно продан.");
        } else {//если пустая
            System.out.println("Такого товара нет на пункте продаж.");
        }
    }

    public void transferProduct(Product product) {
        if (product != null) {
            arrayListPointsOfSale.add(product.getNameIdList());
        } else {
            System.out.println("Некорректный продукт.");
        }
    }


    @Override
    public void readToFileAndPrint() throws FileNotFoundException {
        File file = new File("PointsOfSaleProduct");

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


    private static void clearFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.close(); // Очистка файла путем открытия и закрытия FileWriter
    }
}

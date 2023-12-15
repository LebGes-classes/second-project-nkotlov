package Storage;

public class PointsOfSale extends Storage {
    @Override
    public void isTransfer() {
        System.out.println("Введите номер товара, который хотите вернуть: ");
        int number = scan.nextInt();
        if (number > 0 && number <= pointOfSaleArrayList.size()) {
            wareHouseArrayList.add(pointOfSaleArrayList.get(number - 1));
            pointOfSaleArrayList.remove(number - 1);
            System.out.println("Товар был возвращен на склад");
        } else {
            System.out.println("Такого товара не существует!");
        }
    }

    @Override
    public void deleteStorage() {
        pointOfSaleArrayList.clear();
        System.out.println("Склад очищен!");
    }

    @Override
    public void printInfoItems() {
        if (pointOfSaleArrayList.size() > 0) {
            for (int i = 0; i < pointOfSaleArrayList.size(); i++) {
                System.out.println((i + 1) + ". " + pointOfSaleArrayList.get(i));
            }
        } else {
            System.out.println("Нет продуктов");
        }
    }

    public void sellItem() {
        System.out.println("Введите номер продукта, который хотите продать: ");
        int number = scan.nextInt();
        if (number > 0 && number <= pointOfSaleArrayList.size()) {
            pointOfSaleArrayList.remove(number - 1);
            System.out.println("Товар был успешно продан!");
        } else {
            System.out.println("Такого товара не существует");
        }

    }
}
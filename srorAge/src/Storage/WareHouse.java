package Storage;

public class WareHouse extends Storage {

    @Override
    public void isTransfer() {
        System.out.println("Введите номер товара, который хотите передать: ");
        int number = scan.nextInt();
        if (number > 0 && number <= wareHouseArrayList.size()) {
            pointOfSaleArrayList.add(wareHouseArrayList.get(number - 1));
            wareHouseArrayList.remove(number - 1);
            System.out.println("Товар был передан в пункт продаж");
        } else {
            System.out.println("Такого товара не существует");
        }
    }

    @Override
    public void deleteStorage() {
        wareHouseArrayList.clear();
        System.out.println("Склад очищен");
    }

    @Override
    public void printInfoItems() {
        if (wareHouseArrayList.size() > 0) {
            for (int i = 0; i < wareHouseArrayList.size(); i++) {
                System.out.println((i + 1) + ". " + wareHouseArrayList.get(i));
            }
        } else {
            System.out.println("Нет продуктов");
        }
    }

    public void buyItems() {
        System.out.println("Введите название товара, который хотите закупить: ");
        while (true) {
            String nameItem = scan.nextLine().trim();
            if (!nameItem.isEmpty()) {
                wareHouseArrayList.add(nameItem);
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите название товара еще раз: ");
            }
        }
    }
}
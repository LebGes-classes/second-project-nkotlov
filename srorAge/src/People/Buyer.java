package People;

import java.util.Scanner;

public class Buyer extends Human {
    @Override
    public void setNameHuman() {
        System.out.println("Введите ФИО покупателя: ");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String nameBuyer = scan.nextLine().trim();
            if (!nameBuyer.isEmpty()) {
                nameHuman = nameBuyer;
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите ФИО покупателя: ");
            }
        }
    }

    @Override
    public String getNameHuman() {
        return nameHuman;
    }

    @Override
    public void setBirthdayHuman() {
        System.out.println("Введите дату рождения покупателя: ");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String birthdayBuyer = scan.nextLine();
            if (!birthdayBuyer.isEmpty()) {
                birthdayHuman = birthdayBuyer;
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите дату рождения покупателя: ");
            }
        }
    }

    @Override
    public String getBirthdayHuman() {
        return birthdayHuman;
    }

    @Override
    public void setIdHuman() {
        System.out.println("Введите Id покупателя: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Некорректный ввод данных. Введите Id покупателя: ");
            scan.next();
        }
        int idBuyerScanner = scan.nextInt();
        idHuman = idBuyerScanner;
        scan.nextLine();

    }

    @Override
    public int getIdHuman() {
        return idHuman;
    }

    public void setBuyerInfo() {
        setNameHuman();
        setBirthdayHuman();
        setIdHuman();
        addBuyer();
    }

    public static void printBuyerInfo() {
        if (buyerArrayList.size() > 0) {
            for (int i = 0; i < buyerArrayList.size(); i++) {
                Buyer buyer = buyerArrayList.get(i);
                System.out.println();
                System.out.println("Номер покупателя: " + (i + 1));
                System.out.println("ФИО покупателя: " + buyer.getNameHuman());
                System.out.println("Дата рождения покупателя: " + buyer.getBirthdayHuman());
                System.out.println("Id покупателя: " + buyer.getIdHuman());
            }
        } else {
            System.out.println("Нет покупателей");
        }
    }

    public void addBuyer() {
        buyerArrayList.add(this);
    }

    public static void removeBuyerAll() {
        if (buyerArrayList.size() > 0) {
            while (buyerArrayList.size() != 0) {
                for (int i = 0; i < buyerArrayList.size(); i++) {
                    buyerArrayList.remove(buyerArrayList.get(i));
                }
            }
            System.out.println("Все покупатели удалены!");
        } else {
            System.out.println("Нет покупателей");
        }

    }

    public static void removeBuyer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер покупателя, которого хотите удалить: ");
        if (buyerArrayList.size() > 0) {
            int removeScan = scan.nextInt();
            if (removeScan > 0 && removeScan <= buyerArrayList.size()) {
                buyerArrayList.remove(removeScan - 1);
            } else {
                System.out.println("Неверный номер покупателя. Введите номер покупателя, которого хотите удалить: ");
            }
        } else {
            System.out.println("Нет покупателей");
        }


    }
}
package People;


import java.util.Scanner;

public class Buyer extends Human {
    private int idBuyer;//id покупателя

    @Override
    public void setHumanName() {//сеттер имя покупателя
        System.out.println("Введите ФИО покупателя:");
        while (true) {
            String inputName = scan.nextLine().trim();
            if (!inputName.isEmpty()) {
                nameHuman = inputName;
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите ФИО покупателя:");
            }
        }
    }

    @Override
    public String getHumanName() {
        return nameHuman;
    }//геттер имя покупателя


    @Override
    public void setHumanBirthday() {//сеттер др покупателя
        System.out.println("Введите дату рождения покупателя:");
        while (true) {
            String inputDR = scan.nextLine().trim();
            if (!inputDR.isEmpty()) {
                birthdayHuman = inputDR;
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите дату рождения поупателя:");
            }
        }
    }

    @Override
    public String getHumanBirthday() {
        return birthdayHuman;
    }//геттер др покупателя


    @Override
    public void setHumanId() {//сеттер id покупателя
        System.out.println("Введите id покупателя:");
        while (!scan.hasNextInt()){
            System.out.println("Некорректный ввод. Введите id покупателя:");
            scan.next(); // Прочитать некорректный ввод, чтобы избежать зацикливания
        }
        idBuyer = scan.nextInt();
        scan.nextLine();
    }
    @Override
    public int getHumanId() {
        return idBuyer;
    }//геттер id покупателя


    public void setInfoBuyer(){//все сеттеры покупателя
        setHumanName();
        setHumanBirthday();
        setHumanId();
        addBuyer();
    }
    public static void printInfoBuyer() {//вывод инфо про покупателя(все геттеры покупателя)
        if (arrayListBuyer.size()>0){
            for (int i = 0; i < arrayListBuyer.size(); i++) {
                Buyer buyer = arrayListBuyer.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println("ФИО покупателя: " + buyer.getHumanName());
                System.out.println("Дата рождения покупателя: " + buyer.getHumanBirthday());
                System.out.println("Id покупателя: " + buyer.getHumanId());
            }
        }else {
            System.out.println("Нет покупателей.");
        }
    }
    public void addBuyer() {
        arrayListBuyer.add(this);
    }

    // Метод для удаления ассистента из списка
    public static void removeBuyer() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите номер покупателя, которого хотите удалить:");
        int idRemoveBuyer= scan.nextInt();
        if (idRemoveBuyer > 0 && idRemoveBuyer <= arrayListBuyer.size()) {
            arrayListBuyer.remove(idRemoveBuyer - 1);
        } else {
            System.out.println("Некорректный номер покупателя.");
        }
    }
}

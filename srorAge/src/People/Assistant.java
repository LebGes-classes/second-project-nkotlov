
package People;

import java.util.Scanner;

public class Assistant extends Human {
    private String isPost;

    @Override
    public void setNameHuman() {
        System.out.println("Введите ФИО сотрудника: ");
        while (true) {
            String nameAssistant = scan.nextLine().trim();
            if (!nameAssistant.isEmpty()) {
                nameHuman = nameAssistant;
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите ФИО сотрудника: ");
            }
        }
    }

    @Override
    public String getNameHuman() {
        return nameHuman;
    }

    @Override
    public void setBirthdayHuman() {
        System.out.println("Введите дату рождения сотрудника: ");
        while (true) {
            String birthdayAssistant = scan.nextLine();
            if (!birthdayAssistant.isEmpty()) {
                birthdayHuman = birthdayAssistant;
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите дату рождения сотрудника:");
            }
        }

    }

    @Override
    public String getBirthdayHuman() {
        return birthdayHuman;
    }

    @Override
    public void setIdHuman() {
        System.out.println("Введите Id сотрудника: ");
        while (!scan.hasNextInt()) {
            System.out.println("Некорректный ввод данных. Введите Id сотрудника:");
            scan.next();
        }
        int idAssistantScanner = scan.nextInt();
        idHuman = idAssistantScanner;
        scan.nextLine();
    }

    @Override
    public int getIdHuman() {
        return idHuman;
    }

    private void setPost() {
        System.out.println("Введите должность сотрудника: ");
        while (true) {
            String assistantPost = scan.nextLine().trim();
            if (!assistantPost.isEmpty()) {
                isPost = assistantPost;
                break;
            } else {
                System.out.println("Некорректный ввод данных. Введите должность сотрудника: ");
            }
        }
    }

    public String getPost() {
        return isPost;
    }

    public void setAssistantInfo() {
        setNameHuman();
        setBirthdayHuman();
        setIdHuman();
        setPost();
        addAssistant();
    }

    public static void printAssistantInfo() {
        if (assistantArrayList.size() > 0) {
            for (int i = 0; i < assistantArrayList.size(); i++) {
                Assistant assistant = assistantArrayList.get(i);
                System.out.println();
                System.out.println("Номер сотрудника: " + (i + 1));
                System.out.println("ФИО сотрудника: " + assistant.getNameHuman());
                System.out.println("Дата рождения сотрудника: " + assistant.getBirthdayHuman());
                System.out.println("Id сотрудника: " + assistant.getIdHuman());
                System.out.println("Должность сотрудника: " + assistant.getPost());
            }
        } else {
            System.out.println("Нет сотрудников");
        }
    }

    public void addAssistant() {
        assistantArrayList.add(this);
    }

    public static void removeAssistantAll() {
        if (assistantArrayList.size() > 0) {
            while (assistantArrayList.size() != 0) {
                for (int i = 0; i < assistantArrayList.size(); i++) {
                    assistantArrayList.remove(assistantArrayList.get(i));
                }
            }
            System.out.println("Все сотрудники уволены!");
        } else {
            System.out.println("Нет сотрудников");
        }
    }


    public static void removeAssistant() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер сотрудника, которого хотите уволить: ");
        if (assistantArrayList.size() > 0) {
            int removeScan = scan.nextInt();
            if (removeScan > 0 && removeScan <= assistantArrayList.size()) {
                assistantArrayList.remove(removeScan - 1);
            } else {
                System.out.println("Неверный номер сотрудника. Введите номер сотрудника, которого хотите уволить: ");
            }
        } else {
            System.out.println("Нет сотрудников");
        }
    }
}
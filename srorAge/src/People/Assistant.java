package People;


import java.util.Scanner;

public class Assistant extends Human {
    private int idAssistant;//id сотрудника
    private String postAssistant;//должность сотрудника


    @Override
    public void setHumanName() {//сеттер имя сотрудника
        System.out.println("Введите ФИО сотрудника:");
        while (true) {
            String inputName = scan.nextLine().trim();
            if (!inputName.isEmpty()) {
                nameHuman = inputName;
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите ФИО сотрудника:");
            }
        }
    }
    @Override
    public String getHumanName() {
        return nameHuman;
    }//геттер имя сотрудника


    @Override
    public void setHumanBirthday() {//сеттер др сотрудника
        System.out.println("Введите дату рождения сотрудника:");
        while (true) {
            String inputDR = scan.nextLine().trim();
            if (!inputDR.isEmpty()) {
                birthdayHuman = inputDR;
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите дату рождения сотрудника:");
            }
        }
    }
    @Override
    public String getHumanBirthday() {
        return birthdayHuman;
    }//геттер др сотрудника


    @Override
    public void setHumanId() {//сеттер id сотрудника
        System.out.println("Введите id сотрудника:");
        while (!scan.hasNextInt()){
            System.out.println("Некорректный ввод. Введите id сотрудника:");
            scan.next(); // Прочитать некорректный ввод, чтобы избежать зацикливания
        }
        idAssistant = scan.nextInt();
        scan.nextLine();
    }
    @Override
    public int getHumanId() {
        return idAssistant;
    }//геттер id сотрудника


    public void setPost() {//сеттер должность сотрудника
        System.out.println("Введите должность сотрудника:");
        while (true) {
            String inputPost = scan.nextLine().trim();
            if (!inputPost.isEmpty()) {
                postAssistant = inputPost;
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите должность сотрудника:");
            }
        }
    }
    public String getPost(){
        return postAssistant;
    }//геттер должность сотрудника

    public void setInfoAssistant(){//все сеттеры сотрудника
        setHumanName();
        setHumanBirthday();
        setHumanId();
        setPost();
        addAssistant();
    }

    public static void printInfoAssistant(){//вывод инфо про ассистента(все геттеры сотрудника)
        if (arrayListAssistants.size()>0){
            for (int i = 0; i < arrayListAssistants.size(); i++) {
                Assistant assistant = arrayListAssistants.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println("ФИО сотрудника: " + assistant.getHumanName());
                System.out.println("Дата рождения сотрудника: " + assistant.getHumanBirthday());
                System.out.println("Id сотрудника: " + assistant.getHumanId());
                System.out.println("Должность сотрудника: " + assistant.getPost());
            }
        }else {
            System.out.println("Нет сотрудников.");
        }
    }

    // Метод для добавления ассистента в список
    public void addAssistant() {
        arrayListAssistants.add(this);
    }

    // Метод для удаления ассистента из списка
    public static void removeAssistant() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите номер сотрудника, которого хотите уволить:");
        int idRemoveAssistant= scan.nextInt();
        if (idRemoveAssistant > 0 && idRemoveAssistant <= arrayListAssistants.size()) {
            arrayListAssistants.remove(idRemoveAssistant - 1);
        } else {
            System.out.println("Некорректный номер сотрудника.");
        }
    }

}



package task;

import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {

        UserManager userManager = UserManager.getInstance();

        while (true) {
            System.out.print("Введи операцию: ");
            Scanner sc = new Scanner(System.in);
            UserInfoFileManager userInfoFileManager = new UserInfoFileManager();
            String operation = sc.nextLine();


            switch (operation) {
                case "создать":
                    userManager.create();
                    break;
                case "удалить":
                    userManager.delete();
                    break;
                case "обновить":
                    userManager.update();
                    break;
                case "получить":
                    userManager.get();
                    break;
                case "сортировка по имени":
                    userManager.sortName();
                    break;
                case "сортировка по адресу":
                    userManager.sortAddress();
                    break;
                case "записать":
                    userInfoFileManager.write();
                    break;
                case "стоп":
                    return;
                default:
                    System.out.println("Нет нужной операции");
                    break;
            }
        }
    }


// TODO: Требования:
//        1. Создание класса User с полями для хранения информации о пользователе ( id, имя, возраст, email ,adress).
//        2. Создание класса, который управляет данными пользователей (UserManager) и имеет методы для создания, получения,
//        обновления и удаления пользователей.  Так же реализуйте методы сортировки пользователей по адресам , именам.
//        3. Для хранения данных используйте коллекции
//        4. Создание класса , который создает файл с информацией о пользователе(UserInfoFileManager).
//          Класс должен записывать информацию о пользователе в File.txt
//        5. Реализация консольного интерфейса для взаимодействия с методами

//    Пример выполнения задачи:
//            1. Создание класса Main для запуска приложения.
//            2. Создание класса User для представления данных о пользователе.
//            3. Создание класса UserManager для управления данными пользователей, включая методы для создания, чтения, обновления и др методов.
//            4.UserInfoFileManager вызывает метод get получая пользователя и записывает его данные в файл.
//            5. Реализация консольного интерфейса(при помощи new Scanner()) для взаимодействия с пользователем, включая команды для вызова различных функций
//            (например, "create", "get", "update", "delete" и т.д ).К примеру при вызове create я создам нового пользователя ,
//            при вызове list верну всех добавленных пользователей.
}

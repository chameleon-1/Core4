package task;

import java.util.*;
import java.util.stream.Collectors;

public class UserManager {

    private static UserManager instance;                               //реализация сингтона

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private final Map<Integer, User> users = new HashMap<>();          //мапа с юзерами

    @Override
    public String toString() {
        return "UserManager{" +
                "users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserManager that = (UserManager) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public User create() {                  //создание юзера
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Введи id: ");
        Integer id = sc.nextInt();
        System.out.print("Введи имя: ");
        String name = sc2.nextLine();
        System.out.print("Введи возраст: ");
        int age = sc.nextInt();
        System.out.print("Введи адрес: ");
        String address = sc2.nextLine();
        System.out.print("Введи email: ");
        String email = sc3.nextLine();
        User user0 = new User(name, age, address, email);
        if (users.containsKey(id)) {
            System.out.println("Пользователь с таким id уже существует");
        } else {
            users.put(id, user0);
        }
        return user0;
    }

    public void see() {
        System.out.println(users);
    }

    public Map<Integer, User> update() {                          //обновление даннных по ид
        while (true) {
            System.out.print("Введи id: ");
            Scanner sc = new Scanner(System.in);
            int findId = sc.nextInt();
            System.out.print("Что требуется измениить: ");
            Scanner sc2 = new Scanner(System.in);
            String operation = sc2.nextLine();
            switch (operation) {
                case "имя":
                    System.out.print("На какое имя изменить: ");
                    String updateName = sc2.nextLine();
                    users.get(findId).setName(updateName);
                    break;
                case "возраст":
                    System.out.print("На какой возраст изменить: ");
                    int updateAge = sc.nextInt();
                    users.get(findId).setAge(updateAge);
                    break;
                case "адрес":
                    System.out.print("На какой адрес изменить: ");
                    String updateAddress = sc2.nextLine();
                    users.get(findId).setAddress(updateAddress);
                    break;
                case "email":
                    System.out.print("На какой email изменить: ");
                    String updateEmail = sc2.nextLine();
                    users.get(findId).setEmail(updateEmail);
                    break;
                case "стоп":
                    break;
                default:
                    System.out.println("нет подходящего параметра для изменения");
                    break;
            }
            return users;
        }
    }

    public Map<Integer, User> getForWrite() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи id пользователя: ");
        int findId1 = sc.nextInt();
        Map<Integer, User> forWrite = null;
        if (users.containsKey(findId1)) {
            forWrite = new HashMap<>();
            forWrite.put(findId1, users.get(findId1));
            System.out.println("пользователь записан");
        } else {
            System.out.println("Пользователь с id " + findId1 + " не найден");
        }
        return forWrite;
    }


    public Map<Integer, User> get() {                       //поиск пользователя
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите id пользователя: ");
        Integer findId = sc.nextInt();
        if (users.containsKey(findId)) {
            System.out.println(users.get(findId));
        } else {
            System.out.println("Пользователь с id " + findId + " не найден");
        }
        return users;
    }

    public Map<Integer, User> delete() {                       //удаление пользователя
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите id пользователя: ");
        Integer findId = sc.nextInt();
        if (users.containsKey(findId)) {
            users.remove(findId);
        } else {
            System.out.println("Пользователь с id " + findId + " не найден");
        }
        return users;
    }

    public void sortName() {
        List<User> list = new ArrayList<>(users.values());
        System.out.println(list.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList()));
    }

    public void sortAddress() {
        List<User> list2 = new ArrayList<>(users.values());
        System.out.println(list2.stream()
                .sorted(Comparator.comparing(User::getAddress))
                .collect(Collectors.toList()));
    }
}


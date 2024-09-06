package task;

import java.util.*;
import java.util.stream.Collectors;

public class UserManager {

    private static UserManager instance;                               //���������� ��������

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private final Map<Integer, User> users = new HashMap<>();          //���� � �������

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

    public User create() {                  //�������� �����
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.print("����� id: ");
        Integer id = sc.nextInt();
        System.out.print("����� ���: ");
        String name = sc2.nextLine();
        System.out.print("����� �������: ");
        int age = sc.nextInt();
        System.out.print("����� �����: ");
        String address = sc2.nextLine();
        System.out.print("����� email: ");
        String email = sc3.nextLine();
        User user0 = new User(name, age, address, email);
        if (users.containsKey(id)) {
            System.out.println("������������ � ����� id ��� ����������");
        } else {
            users.put(id, user0);
        }
        return user0;
    }

    public void see() {
        System.out.println(users);
    }

    public Map<Integer, User> update() {                          //���������� ������� �� ��
        while (true) {
            System.out.print("����� id: ");
            Scanner sc = new Scanner(System.in);
            int findId = sc.nextInt();
            System.out.print("��� ��������� ���������: ");
            Scanner sc2 = new Scanner(System.in);
            String operation = sc2.nextLine();
            switch (operation) {
                case "���":
                    System.out.print("�� ����� ��� ��������: ");
                    String updateName = sc2.nextLine();
                    users.get(findId).setName(updateName);
                    break;
                case "�������":
                    System.out.print("�� ����� ������� ��������: ");
                    int updateAge = sc.nextInt();
                    users.get(findId).setAge(updateAge);
                    break;
                case "�����":
                    System.out.print("�� ����� ����� ��������: ");
                    String updateAddress = sc2.nextLine();
                    users.get(findId).setAddress(updateAddress);
                    break;
                case "email":
                    System.out.print("�� ����� email ��������: ");
                    String updateEmail = sc2.nextLine();
                    users.get(findId).setEmail(updateEmail);
                    break;
                case "����":
                    break;
                default:
                    System.out.println("��� ����������� ��������� ��� ���������");
                    break;
            }
            return users;
        }
    }

    public Map<Integer, User> getForWrite() {
        Scanner sc = new Scanner(System.in);
        System.out.print("����� id ������������: ");
        int findId1 = sc.nextInt();
        Map<Integer, User> forWrite = null;
        if (users.containsKey(findId1)) {
            forWrite = new HashMap<>();
            forWrite.put(findId1, users.get(findId1));
            System.out.println("������������ �������");
        } else {
            System.out.println("������������ � id " + findId1 + " �� ������");
        }
        return forWrite;
    }


    public Map<Integer, User> get() {                       //����� ������������
        Scanner sc = new Scanner(System.in);
        System.out.print("������� id ������������: ");
        Integer findId = sc.nextInt();
        if (users.containsKey(findId)) {
            System.out.println(users.get(findId));
        } else {
            System.out.println("������������ � id " + findId + " �� ������");
        }
        return users;
    }

    public Map<Integer, User> delete() {                       //�������� ������������
        Scanner sc = new Scanner(System.in);
        System.out.println("������� id ������������: ");
        Integer findId = sc.nextInt();
        if (users.containsKey(findId)) {
            users.remove(findId);
        } else {
            System.out.println("������������ � id " + findId + " �� ������");
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


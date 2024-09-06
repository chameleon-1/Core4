package task;

import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {

        UserManager userManager = UserManager.getInstance();

        while (true) {
            System.out.print("����� ��������: ");
            Scanner sc = new Scanner(System.in);
            UserInfoFileManager userInfoFileManager = new UserInfoFileManager();
            String operation = sc.nextLine();


            switch (operation) {
                case "�������":
                    userManager.create();
                    break;
                case "�������":
                    userManager.delete();
                    break;
                case "��������":
                    userManager.update();
                    break;
                case "��������":
                    userManager.get();
                    break;
                case "���������� �� �����":
                    userManager.sortName();
                    break;
                case "���������� �� ������":
                    userManager.sortAddress();
                    break;
                case "��������":
                    userInfoFileManager.write();
                    break;
                case "����":
                    return;
                default:
                    System.out.println("��� ������ ��������");
                    break;
            }
        }
    }


// TODO: ����������:
//        1. �������� ������ User � ������ ��� �������� ���������� � ������������ ( id, ���, �������, email ,adress).
//        2. �������� ������, ������� ��������� ������� ������������� (UserManager) � ����� ������ ��� ��������, ���������,
//        ���������� � �������� �������������.  ��� �� ���������� ������ ���������� ������������� �� ������� , ������.
//        3. ��� �������� ������ ����������� ���������
//        4. �������� ������ , ������� ������� ���� � ����������� � ������������(UserInfoFileManager).
//          ����� ������ ���������� ���������� � ������������ � File.txt
//        5. ���������� ����������� ���������� ��� �������������� � ��������

//    ������ ���������� ������:
//            1. �������� ������ Main ��� ������� ����������.
//            2. �������� ������ User ��� ������������� ������ � ������������.
//            3. �������� ������ UserManager ��� ���������� ������� �������������, ������� ������ ��� ��������, ������, ���������� � �� �������.
//            4.UserInfoFileManager �������� ����� get ������� ������������ � ���������� ��� ������ � ����.
//            5. ���������� ����������� ����������(��� ������ new Scanner()) ��� �������������� � �������������, ������� ������� ��� ������ ��������� �������
//            (��������, "create", "get", "update", "delete" � �.� ).� ������� ��� ������ create � ������ ������ ������������ ,
//            ��� ������ list ����� ���� ����������� �������������.
}

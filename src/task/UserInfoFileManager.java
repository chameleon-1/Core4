package task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class UserInfoFileManager {
    public void write() {
        try {
            File file = new File("text.txt");
            if (file.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("ошибка при создании файла");
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("text.txt");
            Map<Integer, User> forWrite = UserManager.getInstance().getForWrite();
            writer.write(forWrite.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("ошибка записи файла");
            e.printStackTrace();

        }
    }
}

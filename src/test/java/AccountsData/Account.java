package AccountsData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Account {

    //Generates an UserName
    public static String generateUserName() {
        String userName = "JohnDoe" + randomNumber();
        writeToFile("username.txt", userName);
        return userName;
    }

    //Generates a Password
    public static String generatePassword() {
        String password = "Test" + randomNumber();
        writeToFile("password.txt", password);
        return password;
    }

    //Generates a random number for the UserName and Password
    public static int randomNumber()
    {
        return new Random().nextInt(9000);
    }

    private static void writeToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





package kata5p1;

import java.util.List;

public class Kata5P1Main {
    public static void main(String[] args) {
        List<String> mails = new MailListReader().read("C:\\Users\\Álvaro\\IdeaProjects\\Kata5P1\\email.txt");
        DataBase dt = new DataBase();
        dt.insert(mails);
    }
}

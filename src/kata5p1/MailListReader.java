package kata5p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public List<String> read(String fileName){
        List<String> mailList = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String st;
            while((st = bf.readLine()) != null){
                if(st.indexOf('@')!=-1){
                    mailList.add(st);
                }
            }
            return mailList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mailList;
    }

}

import java.io.FileNotFoundException;
import java.util.Scanner;


public class ApplicationRunner {

    public static void main(String[] args) {


        try {
            ReadDatabase rdb = new ReadDatabase();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }


    }
}

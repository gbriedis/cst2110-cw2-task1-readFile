import java.io.FileNotFoundException;


public class ApplicationRunner {

    public static void main(String[] args) {

        try {
            ReadDatabase rdb = new ReadDatabase();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}

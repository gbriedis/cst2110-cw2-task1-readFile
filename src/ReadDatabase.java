import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDatabase {

    ArrayList<Album> album = new ArrayList<>();

    public void readFile() throws FileNotFoundException {

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";

        try {
            File textFile = new File(dataFile);
            Scanner scan = new Scanner(textFile);

            while(scan.hasNextLine()) {
                scan.useDelimiter(":");

                String temp1 = scan.next();
                String temp2 = scan.next();
                String temp3 = scan.next();
                String temp4 = scan.next();
                String temp5 = scan.nextLine();

                album.add(new Album(temp1, temp2, temp3, temp4, temp5));



            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File has not been found");
        }
    }
}

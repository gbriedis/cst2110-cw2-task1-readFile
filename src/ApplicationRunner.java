import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ApplicationRunner {

    public static void main(String[] args) throws FileNotFoundException {
        Album[] albums = readFile();

        while (true) {
            outputChoices();
            Scanner stream = new Scanner(System.in);
            String userInput = stream.nextLine();

            switch (userInput){
                // output all the albums
                case "1":
                    System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                    String ranking = "Rank", title = "Title", artist = "Artist", year = "Year", sales = "Sales";
                    System.out.format("|%3s\t|%60s\t|%20s\t|%5s\t|%7s|", ranking, title, artist, year, sales);
                    System.out.println("");
                    System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                    outputAlbums(albums);
                    System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
                    break;
                case "2":
                    //output all the tracks in a specified album
                    System.out.print("Enter album rank from list [0-19] :");
                    int choice = stream.nextInt();
                    albums[choice].outputTrack();
                    break;
                case "3":
                    // output all the tracks containing specific word
                    System.out.print("Enter search word or phrase > ");
                    String trackInput = stream.nextLine();
                    for (int i = 0; i < albums.length; i++) {
                        albums[i].findTrack(trackInput);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Enter a valid choice");
            }
        }
    }

    // output choices
    private static void outputChoices() {
        System.out.println("List albums......1");
        System.out.println("Select album.....2");
        System.out.println("Search title.....3");
        System.out.println("List albums......0");
    }

    // output albums
    private static void outputAlbums(Album[] albums) {
        for(Album i: albums) {
            System.out.println(i);
        }
    }

    // read file, store it in an array using Album class
    private static Album[] readFile() throws FileNotFoundException {
        Album[] albums = new Album[20];

        int numAlbums = 0, counter = 0;

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        File text = new File(dataFile);
        Scanner scan = new Scanner(text);

        while (scan.hasNextLine()) {
            String record = scan.nextLine();
            Scanner lineScan = new Scanner(record);
            lineScan.useDelimiter(":");

            String ranking, title, artist, year, sales, songName, songLength;

            ranking = lineScan.next();
            try {
                // if counter == ranking then create a new array of album
                int rankingInt = Integer.parseInt(ranking);
                counter++;
                if(counter == rankingInt) {
                    title = lineScan.next();
                    artist = lineScan.next();
                    year = lineScan.next();
                    sales = lineScan.nextLine();
                    albums[numAlbums]=new Album(ranking, title, artist, year, sales);
                    numAlbums++;
                }
            }
            catch(NumberFormatException exception) {
                // if counter != ranking then save it into ArrayList of tracks
                Scanner songScan = new Scanner(record);
                songScan.useDelimiter("[-\\(|\\)]");
                songName = songScan.next();
                songLength = songScan.nextLine();

                if(songLength.equals("---------------------------------------------------------------------------------")){}
                else {
                    albums[numAlbums-1].addTrack(songName, songLength);
                }
            }
        }
        return albums;
    }
}

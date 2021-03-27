import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDatabase {

    private Album[] albums;
    private int numAlbums;

    private Song[] songs;
    private int numSongs;

    private int rankingInt;
    private int counter;

    public ReadDatabase() throws FileNotFoundException {
        albums = new Album[20];
        numAlbums = 0;
        songs = new Song[400];
        numAlbums = 0;
        counter = 0;
        readFile();
    }

    public void readFile() throws FileNotFoundException {
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
                rankingInt = Integer.parseInt(ranking);
                counter++;
                if(counter == rankingInt) {
                    title = lineScan.next();
                    artist = lineScan.next();
                    year = lineScan.next();
                    sales = lineScan.nextLine();
                    addAlbum(ranking, title, artist, year, sales);
                }
            }
            catch(NumberFormatException exception) {
                Scanner songScan = new Scanner(record);
                songScan.useDelimiter("[-\\(|\\)]");
                songName = songScan.next();
                songLength = songScan.nextLine();

                if(songLength.equals("---------------------------------------------------------------------------------")){

                }
                else {
                    addSong(songName, songLength);

                }
            }
        }
    }

    private void addAlbum(String ranking, String title, String artist, String year, String sales) {
        albums[numAlbums]=new Album(ranking, title, artist, year, sales);
        numAlbums++;
    }

    private void addSong(String name, String length) {
        songs[numSongs]=new Song(name, length);
        numSongs++;
    }
}

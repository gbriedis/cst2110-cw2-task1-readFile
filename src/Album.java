import java.util.ArrayList;

public class Album {
    private String ranking;
    private String title;
    private String artist;
    private String year;
    private String sales;
    private ArrayList<String> tracks;

    public Album(String ranking, String title, String artist, String year, String sales) {
        this.ranking = ranking;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;

        tracks = new ArrayList<String>();
    }

    // getters
    public String getRanking(){
        return this.ranking;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public String getSales() {
        return sales;
    }

    // add track to ArrayList
    public void addTrack(String name, String length) {
        tracks.add(name);
        tracks.add(length);
    }

    // output every track at a specified Album array index (Album[index])
    public void outputTrack() {
        String sTitle = "Title", sTime = "(Mins:Secs)";
        System.out.println("Album title: " + this.title);
        System.out.println("Artist: " + this.artist);
        System.out.println("Year of release: " + this.year);
        System.out.println("Sales to date: " + this.sales);
        System.out.println("");
        System.out.println("Track List:");
        System.out.println("------------------------------");
        System.out.println(sTitle+" | "+sTime);
        System.out.println("------------------------------");

        int count = 0;
        for(int i = 0; i < tracks.size(); i++) {
            if (count < 2) {
                System.out.print(tracks.get(i));
                count++;
            }
            else {
                System.out.println("");
                count = 0;
                i--;
            }
        }
        System.out.println("");
        System.out.println("------------------------------");

    }

    // output all the tracks containing a phrase
    public void findTrack(String phrase) {
        for (int i=0;i<tracks.size();i++){
            if(tracks.get(i).contains(phrase)){
                System.out.println("Artist("+title+") Album ("+artist+")");
                System.out.println("-------");
                System.out.print(tracks.get(i));
                i++;
                System.out.println(tracks.get(i));
                System.out.println("-------");

                System.out.println("");
            }
        }
    }

    // toString to output all of the Albums
    @Override
    public String toString(){
        return String.format("|%3s\t|%60s\t|%20s\t|%5s\t|%7s|", getRanking(), getTitle(), getArtist(), getYear(), getSales());
    }

}
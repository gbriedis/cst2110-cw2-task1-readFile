import java.util.ArrayList;

public class Album {
    private String ranking;
    private String title;
    private String artist;
    private String year;
    private String sales;
    public ArrayList<String> albumArr = new ArrayList<>();

    public Album(String ranking, String title, String artist, String year, String sales) {
        this.ranking = ranking;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;

        addContent(ranking, title, artist, year, sales);
    }


    public void addContent(String ranking, String title, String artist, String year, String sales) {
        albumArr.add(ranking);
        albumArr.add(title);
        albumArr.add(artist);
        albumArr.add(year);
        albumArr.add(sales);
    }


    public String getTitle(){
        return title;
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

}
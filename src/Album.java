public class Album {
    private String ranking;
    private String title;
    private String artist;
    private String year;
    private String sales;

    public Album(String ranking, String title, String artist, String year, String sales) {
        this.ranking = ranking;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;

        output();
    }



    public void output() {
        //System.out.println("---------------------------");
        System.out.print("Ranking: " + ranking + "|");
        System.out.print("Title: " + title + "|");
        System.out.print("Artist: " + artist + "|");
        System.out.print("Year: " + year + "|");
        System.out.println("Sales: " + sales);
        //System.out.println("---------------------------");

    }

}
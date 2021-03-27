public class Song {
    private String name;
    private String length;

    public Song(String name, String length) {
        this.name = name;
        this.length = length;

        output();
    }

    private void output() {
        System.out.print("Song Name: " + name + "|");
        System.out.println("Song Length: " + length);
    }
}

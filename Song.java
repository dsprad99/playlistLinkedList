public class Song {
    private String name;
    private String artist;
    private String album;
    private int length;
    private Song next;
    private Song previous;

    //if the a song node is intialized and the parameters
    //are empty then the strings are initialized and are empty
    //and the length attribute is set to 0
    public Song() {
        this.name = "";
        this.artist = "";
        this.album = "";
        this.length = 0;
    }

    public Song(String name, String artist, String album, int length) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Song getNext() {
        return next;
    }

    public void setNext(Song next) {
        this.next = next;
    }

    public Song getPrevious() {
        return previous;
    }

    public void setPrevious(Song previous) {
        this.previous = previous;
    }

}

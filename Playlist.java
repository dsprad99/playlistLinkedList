import java.util.*;

public class Playlist {
    private Song head;
    private Song tail;
    private int size;

    Scanner scnr = new Scanner(System.in);

    public Playlist() {
        head = new Song();
        tail = new Song();
        size = 0;
        head.setNext(tail);
        tail.setPrevious(head);

    }


    public void addSong(Song s) {
        //set our last song equal to the last node in the playlist
        Song lastSong = tail.getPrevious();
        lastSong.setNext(s);
        s.setPrevious(lastSong);
        s.setNext(tail);
        tail.setPrevious(s);

        //adds 1 to the size of 
        //the amount of songs in our playlist
        incrementSize();
    }

    public void toMyString() {
        System.out.println("Playlist:");
        //set our current song equal to the first song node in the playlist
        Song current_song = head.getNext();
        //while there are still songs while iterating through the playlist and 
        //it does not equal the end of the playlist we will print out 
        //attributes of the songs
        while (current_song != tail) {
            System.out.println("---------------------");
            System.out.println("Song name: " + current_song.getName());
            System.out.println("Artist name: " + current_song.getArtist());
            System.out.println("Album name: " + current_song.getAlbum());
            System.out.println("Length name: " + current_song.getLength() + " seconds");
            System.out.println("---------------------");
            current_song = current_song.getNext();
        }
        System.out.println("Number of total songs on playlist: " + size);
        int totalLength = calculateSongLength();
        int song_seconds = totalLength % 60;
        int song_minutes = totalLength / 60;
        System.out.println("Length of playlist: " + song_minutes + " minutes " + song_seconds + " seconds");
    }

    public int calculateSongLength() {
        int totalSongLength = 0;
        //this will iterate through each song node in our playlist
        //and we will add the length of each song to our totalSongLength
        Song current_song = head.getNext();
        while (current_song != tail) {
            totalSongLength += current_song.getLength();
            current_song = current_song.getNext();
        }
        return totalSongLength;
    }

    public void insertNewSong(Scanner scnr, Song current_song, Song new_song) {

        //if our current song is already at the end of the playlist
        //then we can just add the song to the playlist using the addSong playlist
        if (current_song == tail.getPrevious()) {
            addSong(new_song);
            return;
        }

        //next song after our current song
        Song next_song = current_song.getNext();

        //adds the new song after our current song
        current_song.setNext(new_song);
        //adds the current song behind the new song
        new_song.setPrevious(current_song);

        //adds the new song after our next song
        new_song.setNext(next_song);
        //adds the new song behind our next song node 
        next_song.setPrevious(new_song);

        incrementSize();
    }
    
    public void removeCurrentSong(Song current_song) {
        //if there is no current song we will return a message
        //saying that there is nothing playing in the playlist
        if (current_song == null) {
            System.out.println("No song is currently playing!");
            return;
        }

        //gets the song node after the current song
        Song nextSong = current_song.getNext();
        //gets the song node before the current song
        Song prevSong = current_song.getPrevious();
 
        prevSong.setNext(nextSong);
        nextSong.setPrevious(prevSong);

        System.out.println("Removed the current song: " + current_song.getName());

        //current song is the next song after the song node being removed
        current_song = nextSong;
        decrementSize();
        
    }

    public Song getHead() {
        return head;
    }

    public Song getTail() {
        return tail;
    }


    public void decrementSize() {
        size = size - 1;
    }

    public void incrementSize() {
        size = size + 1;
    }
}

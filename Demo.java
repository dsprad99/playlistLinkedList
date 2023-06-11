import java.util.Scanner;

/*
 * Name: Davis Spradling
 * Date: 6/10/2023
 * The purpose of this program is using a doubly linked list we can store songs 
 * in a playlist inorder to navigate through the playlist.
 */

public class Demo {

    public static void main(String[] args) {

        Playlist p1 = new Playlist();

        int scan = 0;

        Song current_song = null;

        while (p1.calculateSongLength() >= 0) {
            System.out.println(" 1. Add a Song to the Playlist");
            System.out.println(" 2. Insert a new Song after the Song that is currently playing");
            System.out.println(" 3. Print the contents of the Playlist");
            System.out.println(" 4. Display the current Song");
            System.out.println(" 5. Remove the current song ");
            System.out.println(" 6. Skip to the next song ");
            System.out.println(" 7. Return to the previous song");
            System.out.println(" 8. Exit");

            Scanner scnr = new Scanner(System.in);
            scan = scnr.nextInt();

            switch (scan) {
                case 1:
                    System.out.println("Song name:");
                    String song_name = scnr.next();
                    System.out.println("Song author:");
                    String author = scnr.next();
                    System.out.println("Song playlist:");
                    String song_playlist = scnr.next();
                    System.out.println("Song length:");
                    int song_length = scnr.nextInt();

                    Song new_song = new Song(song_name, author, song_playlist, song_length);
                    p1.addSong(new_song);

                    if (current_song == null) {
                        current_song = new_song;
                    }
                    break;
                case 2:
                    System.out.print("Song name: ");
                    String name = scnr.next();
                    System.out.print("Artist name: ");
                    String artist = scnr.next();
                    System.out.print("Album name: ");
                    String album = scnr.next();
                    System.out.print("Song length: ");
                    int length = scnr.nextInt();

                    new_song = new Song(name, artist, album, length);
                    p1.insertNewSong(scnr, current_song,new_song);
                    break;
                case 3:
                    p1.toMyString();
                    break;
                case 4:
                    System.out.println("Current Song: " + current_song.getName());
                    break;
                case 5:
                     p1.removeCurrentSong(current_song);
                    break;
                case 6:
                    current_song = skipToNextSong(current_song, p1);
                    break;
                case 7:
                    current_song = skipToPreviousSong(current_song, p1);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }

    }
    
    public static Song skipToNextSong(Song current_song, Playlist p1) {
        //if there is no current song then we will output that 
        //not song is play
        if (current_song == null) {
            System.out.println("No song is playing!");
            return null;
        }

        //this is the next song in the playlist ahead of the current song
        Song next_song = current_song.getNext();
        
        //if the next song is at the tail of the playlist then we will set the 
        //next song to the head since the tail points back to the head
        if (next_song == p1.getTail()) {
            next_song = p1.getHead().getNext();
        }

        //set our current song equal to our first song
        current_song = next_song;
        System.out.println("Skipped to next song: " + current_song.getName());
        return current_song;
    }
    
    public static Song skipToPreviousSong(Song current_song, Playlist p1) {
            //if there is no current song then we will output that there is no 
            //song playing
            if (current_song == null) {
                System.out.println("No song is playing!");
                return null;
            }

            //set our next song equal to the node behind the current song
            Song next_song = current_song.getPrevious();
            //if we are at the head of the linked list we will wrap around to the tail
            if (next_song == p1.getHead()) {
                next_song = p1.getTail().getPrevious(); 
            }
            current_song = next_song;
            System.out.println("Skipped to previous song: " + current_song.getName());
            return current_song;
        }
}



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Album {
    private String name;//principle of encapsulation
    private String artist;
    List<Song> songs;//because we are accessing every detail of songs

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();//allocating the memory
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        //checking in arrayList
        for(Song s: songs){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }
   public void addSongstoAlbum(String title, double duration){
        Song s = new Song(title,duration);//creating a new song
        //checking whether the song already exist
        if(findSong(s.getTitle()) == true){
            System.out.println("Song already present in album");
        }
        else{
            songs.add(s);
            System.out.println("New Song has been added");
        }
        return;
    }

    //polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playList) {
        //still have a doubt
        if(findSong(title) == true){
            for(Song song: songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the album");
        }
        return;
    }
    public void addToPlaylistFromAlbum(int trackNo,LinkedList<Song> playList){
        int index = trackNo - 1;//because we are searching in arraylist
        if(index >= 0 && index < songs.size()){
            playList.add(songs.get(index));//adding according to indexes
            System.out.println("Song has been added to your playlist");
        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }
}

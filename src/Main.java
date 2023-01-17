import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album1 = new Album("Moosa", "Siddhu Moosewala");
        album1.addSongstoAlbum("295", 4.05);
        album1.addSongstoAlbum("LastRide", 5.5);
        album1.addSongstoAlbum("Vaar", 5.5);
        album1.addSongstoAlbum("So High", 3.05);

        Album album2 = new Album("Arijit's Songs", "Arijit Singh");
        album2.addSongstoAlbum("Kesariya", 5);
        album2.addSongstoAlbum("Jeena Jeena", 4.05);
        album2.addSongstoAlbum("Gerua", 6);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Gerua"));

        //creating a playlist
        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("295", myPlayList);
        album2.addToPlaylistFromAlbum(2, myPlayList);
        album1.addToPlaylistFromAlbum("Vaar",myPlayList);
        album2.addToPlaylistFromAlbum("Gerua",myPlayList);

        play(myPlayList);
    }

        public static void play(LinkedList<Song> playList){
            Scanner sc = new Scanner(System.in);
            //making list iterator
            ListIterator<Song> itr = playList.listIterator();

            boolean isForward = false;


            if(playList.size() > 0){
                System.out.println("Currently Playing: ");
                System.out.println(itr.next());
                isForward = true;
            }
            else {
                System.out.println("Playlist is empty");
                return;
            }

            System.out.println("Enter your Choice: ");
            printMenu();

            boolean quit = false;
            while(!quit){
                int choice = sc.nextInt();
                switch (choice){

                    case 1://playing next
                        //because we are coming from previous song,to stop repetition we are doing this
                        //these are just to take one extra step
                        if(isForward == false){
                            itr.next();
                            isForward = true;
                        }
                        //if next song exist
                        if(itr.hasNext()){

                            System.out.println(itr.next());
                        }
                        else{
                            System.out.println("You have reached the end of the playlist");
                            isForward = false;//because we are at the end
                        }
                        break;
                    case 2://playing previous
                        //coming tp previous from forward position
                        if(isForward == true){
                            itr.previous();
                            isForward = false;
                        }
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                        }
                        else {
                            System.out.println("You are at the start of playlist");
                            isForward = true;//we can move forward from here
                        }
                        break;
                    case 3://playing again
                        if(isForward == true){
                            if(itr.hasPrevious()) {
                                System.out.println(itr.previous());
                                isForward = false;
                            }
                        }
                        //isForward = false
                        else{
                            if(itr.hasNext()){
                                System.out.println(itr.next());
                            }
                                isForward = true;
                        }
                        break;
                    case 4://getting all options again
                        printMenu();
                        break;

                    case 5:
                        itr.remove();
                        System.out.println("Song has been deleted");
                        break;

                    case 6://getting all songs
                        if(playList.size() > 0) {
                            printSongs(playList);
                        }
                        else{
                            System.out.println("List is empty");
                        }
                        break;
                    case 7:
                        quit = true;
                        break;

                }
            }
        }

        public static void printSongs(LinkedList<Song> playList){
            for(Song song: playList){
                System.out.println(song);
            }
        }
        public static void printMenu(){
            System.out.println("1 - Play next song");
            System.out.println("2 - Play previous song");
            System.out.println("3 - Repeat the current song");
            System.out.println("4 - Show menu again");
            System.out.println("5 - Delete the current song");
            System.out.println("6 - Print all the songs in playlist");
            System.out.println("7 - Exit");
        }

    }
//}
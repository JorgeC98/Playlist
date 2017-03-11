/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

import java.util.*;

/**
 *
 * @author JorgeRicardo
 */
public class Album {
   
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    
    public Album(String name, String artist){
        this.name=name;
        this.artist=artist;
        this.songs= new ArrayList<Song>();
    }
    
    public boolean addSong(String title, double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }
    
    private Song findSong(String title){
        for(Song checkedSong: this.songs){ //For Each: para cada cancion del arreglo canciones...
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    
    public boolean addToPlayList(int trackNumber, List<Song> playList){
        int index=trackNumber - 1; //nuestras estructuras de datoss nunca empiezan en 1
                                    //por eso le restamos uno al track dado
        if ((index >= 0) && (index < this.songs.size())){  //validamos nuestro indice
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track "+trackNumber);
        return false;
    }
    
    public boolean addToPlayList(String title, List<Song>playList){
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song "+title+ "is not in this album.");
        return false;
    }

}

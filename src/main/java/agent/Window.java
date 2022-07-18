package agent;

import game.Door;

import java.util.ArrayList;

public class Window {
    public final ArrayList<Door> doors;

    public Door getDoor(int doorNo) {
       for(Door door : doors) {
           if(door.number == doorNo) {
               return door;
           }
       }
       throw new Error("door not found");
    }

    public Window(ArrayList<Door> doors) {
        this.doors = doors;
    }
}

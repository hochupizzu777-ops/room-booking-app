package ru.roombooking.room;

public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(String id){
        super("Помещение с ID " + id + " не найдено");
    }
}

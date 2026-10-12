package ru.roombooking.room;

public final class Room {

    private final String id;
    private final String name;
    private final int capacity;
    private final boolean active;

    public Room(
            String id,
            String name,
            int capacity
    ){
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException(
                    "Id не может быть пустым"
            );
        }
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(
                    "Name не может быть пустым"
            );
        }
        if (capacity <= 0){
            throw new IllegalArgumentException(
                    "Вместимость должна быть больше нуля"
            );
        }

        this.id = id;
        this.name = name.trim();
        this.capacity = capacity;
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean getActive(){
        return active;
    }

}

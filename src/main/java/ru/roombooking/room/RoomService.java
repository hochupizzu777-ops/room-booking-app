package ru.roombooking.room;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomService {

    private final Map<String, Room> rooms= new ConcurrentHashMap<>();

    public Room createRoom(String name, int capacity){

        String id = UUID.randomUUID().toString();

        Room room = new Room(id, name, capacity);

        rooms.put(id, room);

        return room;
    }

    public List<Room> getAllRooms(){
        return List.copyOf(rooms.values());
    }

    public Room getRoomById(String id){
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException(
                    "Id помещения не может быть пустым"
            );
        }

        Room room = rooms.get(id);

        if (room == null){
            throw new RoomNotFoundException(id);
        }

        return room;
    }
}

package ru.roombooking.room;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Room createRoom(String name, int capacity) {
        Room room = new Room(name, capacity);

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "ID помещения не должен быть пустым"
            );
        }

        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }
}

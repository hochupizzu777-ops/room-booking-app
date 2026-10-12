package ru.roombooking.room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "active", nullable = false)
    private boolean active;

    protected Room() {
    }

    public Room(String name, int capacity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Название помещения не должно быть пустым"
            );
        }

        String checkedName = name.trim();

        if (checkedName.length() > 255) {
            throw new IllegalArgumentException(
                    "Название помещения не должно превышать 255 символов"
            );
        }

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Вместимость должна быть больше нуля"
            );
        }

        this.name = checkedName;
        this.capacity = capacity;
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getActive() {
        return active;
    }
}

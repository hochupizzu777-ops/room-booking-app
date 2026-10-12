package ru.roombooking.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateRoomRequest(

        @NotBlank(message = "Название помещения не должно быть пустым")
        String name,

        @Positive(message = "Вместимость должна быть больше нуля")
        int capacity

) {
}

package ru.roombooking.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateRoomRequest(

        @NotBlank(message = "Название помещения не должно быть пустым")
        @Size(max = 255, message = "Название не должно превышать 255 символов")
        String name,

        @Positive(message = "Вместимость должна быть больше нуля")
        int capacity

) {
}
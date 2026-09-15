package ru.unlegit.simplerestapi.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Пользователь системы")
public class User {

    @Schema(description = "Уникальный идентификатор", example = "1")
    long id;
    @Schema(description = "Имя пользователя", example = "Ivan")
    String name;
    @Schema(description = "Email пользователя", example = "ivan@example.com")
    String email;
}
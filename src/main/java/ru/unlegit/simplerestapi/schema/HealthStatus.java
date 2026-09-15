package ru.unlegit.simplerestapi.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Статус жизни системы")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HealthStatus {

    @Schema(description = "Статус жизни системы", example = "UP")
    String status;
    @Schema(description = "Время фиксации статуса", example = "2026-09-14T09:32:18.349516Z")
    String timestamp;
    @Schema(description = "Имя сервиса", example = "User Service")
    String service;
}
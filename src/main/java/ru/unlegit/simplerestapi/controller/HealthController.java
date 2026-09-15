package ru.unlegit.simplerestapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unlegit.simplerestapi.schema.HealthStatus;

import java.time.Instant;

@RestController
@RequestMapping("/api/health")
@Tag(name = "Служебное", description = "Проверка состояния сервиса")
public class HealthController {

    @GetMapping
    @Operation(summary = "Health-check")
    @ApiResponse(
            responseCode = "200", description = "Успешно",
            content = @Content(schema = @Schema(implementation = HealthStatus.class))
    )
    public HealthStatus health() {
        return new HealthStatus("UP", Instant.now().toString(), "Simple REST API");
    }
}
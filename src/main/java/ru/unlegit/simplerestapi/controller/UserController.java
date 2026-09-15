package ru.unlegit.simplerestapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.unlegit.simplerestapi.schema.User;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "Операции с пользователями")
public class UserController {

    private static final List<User> USERS = List.of(
            new User(1L, "Ivan", "ivan@example.com"),
            new User(2L, "Petr", "petr@example.com"),
            new User(3L, "Anna", "anna@example.com")
    );

    @GetMapping
    @ApiResponse(
            responseCode = "200", description = "Успешно",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @Operation(summary = "Получить всех пользователей", description = "Возвращает статический список пользователей")
    public List<User> getAll() {
        return USERS;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public User getById(@PathVariable long id) {
        return USERS.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
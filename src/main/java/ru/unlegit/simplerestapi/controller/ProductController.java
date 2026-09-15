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
import ru.unlegit.simplerestapi.schema.Product;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Товары", description = "Операции с товарами")
public class ProductController {

    private static final List<Product> PRODUCTS = List.of(
            new Product(100L, "Ноутбук", new BigDecimal("79999.99")),
            new Product(101L, "Мышь", new BigDecimal("1500.00")),
            new Product(102L, "Клавиатура", new BigDecimal("3500.50"))
    );

    @GetMapping
    @ApiResponse(
            responseCode = "200", description = "Успешно",
            content = @Content(schema = @Schema(implementation = Product.class))
    )
    @Operation(summary = "Список товаров")
    public List<Product> getAll() {
        return PRODUCTS;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Товар по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Товар найден"),
            @ApiResponse(responseCode = "404", description = "Товар не найден")
    })
    public Product getById(@PathVariable Long id) {
        return PRODUCTS.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
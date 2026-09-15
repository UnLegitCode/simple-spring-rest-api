package ru.unlegit.simplerestapi.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Товар")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Schema(description = "Идентификатор товара", example = "100")
    long id;
    @Schema(description = "Название товара", example = "Ноутбук")
    String title;
    @Schema(description = "Цена", example = "79999.99")
    BigDecimal price;
}
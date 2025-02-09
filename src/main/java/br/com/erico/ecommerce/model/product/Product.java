package br.com.erico.ecommerce.model.product;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Price is mandatory")
    @Pattern(regexp = "\\d+,\\d{2}", message = "Prime must respect the pattern \"0,00\"")
    private BigDecimal price;

    @NotNull(message = "Stock is mandatory")
    @Min(value = 0, message = "Stock must be greater than zero")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

}

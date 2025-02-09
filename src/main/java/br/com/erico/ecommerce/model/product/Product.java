package br.com.erico.ecommerce.model.product;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.category.Category;
import br.com.erico.ecommerce.model.order.OrderItem;
import br.com.erico.ecommerce.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
    private BigDecimal price;

    @NotNull(message = "Stock is mandatory")
    @Min(value = 0, message = "Stock must be greater than zero")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}

package br.com.erico.ecommerce.model.order;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.cart.CartItem;
import br.com.erico.ecommerce.model.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal subtotal;

    @OneToMany(mappedBy = "item")
    private List<CartItem> cartItems;

}

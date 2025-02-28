package br.com.erico.ecommerce.model.payment;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod method;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @NotNull
    @Min(0)
    private BigDecimal amount;
}

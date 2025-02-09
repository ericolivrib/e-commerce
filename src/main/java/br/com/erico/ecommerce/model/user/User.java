package br.com.erico.ecommerce.model.user;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.address.Address;
import br.com.erico.ecommerce.model.order.Order;
import br.com.erico.ecommerce.model.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid e-mail")
    @NotEmpty(message = "E-mail is mandatory")
    private String email;

    // TODO: Include a password field

    @NotEmpty(message = "Phone number is mandatory")
    @Pattern(regexp = "(\\d{2}) \\d{5}-\\d{4}", message = "Phone number must respect the pattern \"(00) 00000-0000\"")
    private String phone;

    @NotEmpty(message = "Type is mandatory")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "seller")
    private List<Product> product;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}

package br.com.erico.ecommerce.model.address;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "delivery_addresses")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Street name is mandatory")
    private String street;

    @NotNull(message = "House number is mandatory")
    private Integer number;

    @NotEmpty(message = "City is mandatory")
    private String city;

    @NotEmpty(message = "State is mandatory")
    @Size(min = 2, max = 2, message = "State must have 2 letters")
    private String state;

    @NotEmpty(message = "Zip code is mandatory")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must respect the pattern \"00000-000\"")
    private String zipCode;

    private String complement;

    @OneToMany(mappedBy = "address")
    private List<User> users;

}

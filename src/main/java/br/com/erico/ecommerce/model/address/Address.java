package br.com.erico.ecommerce.model.address;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String street;

    @NotNull
    private Integer number;

    @NotBlank
    private String city;

    @NotBlank
    @Size(min = 2, max = 2, message = "State must have 2 letters")
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String zipCode;

    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

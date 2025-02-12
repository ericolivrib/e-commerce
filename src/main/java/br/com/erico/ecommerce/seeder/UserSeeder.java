package br.com.erico.ecommerce.seeder;

import br.com.erico.ecommerce.model.user.User;
import br.com.erico.ecommerce.model.user.UserRepository;
import br.com.erico.ecommerce.model.user.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
@Configuration
public class UserSeeder implements DataSeeder {

    private final UserRepository userRepository;

    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seed(ContextRefreshedEvent event) {
        userRepository.findByType(UserType.CUSTOMER).ifPresentOrElse(
                (customer) -> log.info("Customer user not required"),
                () -> {
                    userRepository.save(User.builder()
                            .name("Customer User")
                            .email("customer@example.com")
                            .phone("(12) 34567-8901")
                            .type(UserType.CUSTOMER)
                            .build());
                    log.info("Customer user seeded");
                }
        );

        userRepository.findByType(UserType.SELLER).ifPresentOrElse(
                (seller) -> log.info("Seller user not required"),
                () -> {
                    userRepository.save(User.builder()
                            .name("Seller User")
                            .email("seller@example.com")
                            .phone("(98) 76543-2109")
                            .type(UserType.SELLER)
                            .build());
                    log.info("Seller user seeded");
                }
        );
    }

}

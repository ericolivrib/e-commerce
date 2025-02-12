package br.com.erico.ecommerce.model.user;

import br.com.erico.ecommerce.model.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByType(UserType type);
}

package br.com.erico.ecommerce.model.category;

import br.com.erico.ecommerce.model.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends BaseRepository<Category> {

    Optional<Category> findByName(String name);
}

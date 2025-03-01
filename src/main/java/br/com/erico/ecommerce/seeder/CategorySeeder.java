package br.com.erico.ecommerce.seeder;

import br.com.erico.ecommerce.model.BaseRepository;
import br.com.erico.ecommerce.model.category.Category;
import br.com.erico.ecommerce.model.category.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Configuration
public class CategorySeeder implements DataSeeder {

    private final CategoryRepository categoryRepository;

    protected CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seed() {
        var categoryNames = Arrays.asList("Electronics & Gadgets", "Fashion & Apparel", "Home & Furniture",
                "Beauty & Personal Care", "Health & Wellness", "Sports & Outdoors", "Automotive & Accessories",
                "Toys & Baby Products", "Books, Movies & Music", "Groceries & Gourmet");

        var categoryList = new ArrayList<Category>(categoryNames.size());

        for (var name : categoryNames) {
            var category = categoryRepository.findByName(name);

            if (category.isEmpty()) {
                categoryList.add(Category.builder().name(name).build());
            }
        }

        if (!categoryList.isEmpty()) {
            log.info("Categories seeded");
        }

        categoryRepository.saveAll(categoryList);
    }
}

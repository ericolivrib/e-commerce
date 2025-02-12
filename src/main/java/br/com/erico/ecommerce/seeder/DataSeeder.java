package br.com.erico.ecommerce.seeder;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public interface DataSeeder {

    @EventListener(ContextRefreshedEvent.class)
    void seed();
}

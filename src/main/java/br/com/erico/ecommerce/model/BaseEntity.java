package br.com.erico.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
public abstract class BaseEntity {

    protected Long id;

    @CreationTimestamp
    protected Instant createdAt;

    @UpdateTimestamp
    protected Instant updatedAt;

    protected Instant deletedAt;

}

package br.com.erico.ecommerce.service;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.BaseRepository;

public abstract class BaseService<E extends BaseEntity, R extends BaseRepository<E>> {

    private final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public void save(E entity) {
        repository.save(entity);
    }

    public void delete(long id) {
        var entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
    }
}

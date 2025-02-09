package br.com.erico.ecommerce.service;

import br.com.erico.ecommerce.model.BaseEntity;
import br.com.erico.ecommerce.model.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<E extends BaseEntity, R extends BaseRepository<E>> {
}

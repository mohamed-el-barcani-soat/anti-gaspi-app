package com.soat.anti_gaspi.domain;

import java.util.Set;

public interface DomainRepository<Entity extends DomainEntity, DomainId> {
    DomainId save(Entity entity);
    void delete(Entity entity);
    Entity find(DomainId id);
    Set<Entity> findAll();
}

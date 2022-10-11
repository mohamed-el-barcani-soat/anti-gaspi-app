package com.soat.anti_gaspi.domain.usecases;

import com.soat.anti_gaspi.domain.DomainEntity;

public interface Usecase<Input extends DomainEntity, Output> {

    Output handle(final Input entity);
}

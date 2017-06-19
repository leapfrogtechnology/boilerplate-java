package com.lftechnology.boilerplate;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager em;
}

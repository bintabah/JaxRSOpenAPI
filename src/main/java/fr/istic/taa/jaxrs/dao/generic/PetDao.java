package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Pet;

public class PetDao extends AbstractJpaDao<Long, Pet> {
    public PetDao() {
        setClazz(Pet.class);
    }



}

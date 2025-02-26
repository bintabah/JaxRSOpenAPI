package fr.istic.taa.jaxrs;

import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import fr.istic.taa.jaxrs.domain.Tag;

public class ServiceWeb {
    private EntityManager manager;

    public ServiceWeb(EntityManager manager) {
        this.manager = manager;
    }

    private void createPet(){
        int numbreOfPets = manager.createQuery("Select a From Pet a", Pet.class).getResultList().size();
        if (numbreOfPets == 0) {
            Tag tag1 = new Tag("amical");
            Pet pet = new Pet("Cat");
            pet.addTag(tag1);
            manager.persist(pet);
        }
    }

    public static void main(String[] args) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        ServiceWeb service = new ServiceWeb(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        service.createPet();
        tx.commit();
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(".. done");
    }
}

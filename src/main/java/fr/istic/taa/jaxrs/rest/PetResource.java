package fr.istic.taa.jaxrs.rest;
import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.PetDao;
import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("pet")
@Produces({ "application/json", "application/xml" })
public class PetResource {
  PetDao petDao = new PetDao();
  @GET
  @Path("/{petId}")
  public Pet getPetById(@PathParam("petId") Long petId) {
    return petDao.findOne(petId);
  }

  @GET
  @Path("/")
  public List<Pet> gestAllPets() {
    return petDao.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) 
  {
      TagDao tagDao = new TagDao();
      for (Tag tag : pet.getTags()) {
        tagDao.save(tag);
      }
      petDao.save(pet);
    return Response.ok().entity("SUCCESS").build();
  }

  @DELETE
  @Path("/{petId}")
  public Response deletePet(@PathParam("petId") Long petId) {
    petDao.deleteById(petId);
    return Response.ok().entity("SUCCESS").build();
  }

}
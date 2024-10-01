package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {
    @Steps
    PetStoreStep petStoreStep;
    @Given("dado que estoy en la pagina de mascotas")
    public void dadoQueEstoyEnLaPagina() {
    }
    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        petStoreStep.crearOrden(id, petId,quantity);
    }

    @Then("el codigo de estado de la respuesta debe ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStoreStep.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStoreStep.obtenerRespuestaOrder();
        petStoreStep.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());
    }
}

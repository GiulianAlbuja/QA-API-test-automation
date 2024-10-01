package com.everis.base.stepDefinitions;

import com.everis.base.AreasStep;
import com.everis.base.models.Areas;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

public class ConsultaAreasStepDef {
    @Steps
    AreasStep areasStep;

    @Given("dado que estoy en la pagina")
    public void dadoQueEstoyEnLaPagina() {
    }

    @When("consulto el area con ID {int}")
    public void consultoElAreaConID(int id) {
        areasStep.consultarArea(id);
    }

    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int codigo) {
        areasStep.validarCodigoRespuesta(codigo);
    }


    @And("la respuesta debe contener el id (.*), name(.*), parentAreaId(.*)$")
    public void laRespuestaDebeContenerElIdIdNameNameParentAreaIdParentAreaId(String id, String name, String parentAreaId) {
        Areas areas = areasStep.obtenerRespuestaAreas();
        assertEquals(id, areas.getId());
        assertEquals(name, areas.getName());
        assertEquals(parentAreaId, areas.getParentAreaId());
    }
}

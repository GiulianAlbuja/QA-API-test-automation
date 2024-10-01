package com.everis.base;

import com.everis.base.models.Areas;
import com.everis.base.models.ChildAreas;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AreasStep {

    private String URL_BASE = "http://api.football-data.org/v4/";

    public Areas areas;
    public void consultarArea(int id){
        areas = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("areas/" + id).
                as(Areas.class)
                ;

        listarAreas(areas);
    }

    private void listarAreas(Areas areas){
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("OUT: ID" + areas.getId());
        System.out.println("OUT: Name" + areas.getName());
        System.out.println("OUT: Code" + areas.getCode());
        System.out.println("OUT: Flag" + areas.getFlag());
        System.out.println("OUT: Parent Area ID" + areas.getParentAreaId());
        System.out.println("OUT: Parent Area" + areas.getParentArea());
        System.out.println("***************************************");
        System.out.println("OUT: Child Area");
        if(areas.getChildAreas() != null){
            for(ChildAreas childAreas : areas.getChildAreas()){
                System.out.println("OUT: ID" + childAreas.getId());
                System.out.println("OUT: Name" + childAreas.getName());
                System.out.println("OUT: Code" + childAreas.getCountryCode());
                System.out.println("OUT: Flag" + childAreas.getFlag());
                System.out.println("OUT: Parent Area ID" + childAreas.getParentAreaId());
                System.out.println("OUT: Parent Area" + childAreas.getParentArea());
                System.out.println("***************************************");
                System.out.println("***************************************");
            }
        }

    }

    public void validarCodigoRespuesta(int i){
        assertThat(lastResponse().statusCode(), is(i));
    }

    public Areas obtenerRespuestaAreas() {
        return areas;
    }
}

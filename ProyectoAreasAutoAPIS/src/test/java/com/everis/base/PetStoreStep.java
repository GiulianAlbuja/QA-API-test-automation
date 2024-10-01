package com.everis.base;

import com.everis.base.models.Order;

import static io.restassured.RestAssured.given;

public class PetStoreStep {
    private String URL_BASE = "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Order respuestaOrder;

    public void crearOrden(int id, int petId, int quantity){
        Order nuevaOrden = new Order(id, petId, quantity);
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrden)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("store/order/" + id)
                .as(Order.class);
        System.out.println("Id creado: " + respuestaOrder.getId());
        System.out.println("PetId creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity creado: " + respuestaOrder.getQuantity());
    }

    public void validarCodigoRespuesta(int codigoEsperado){
        if(codigoRespuesta != codigoEsperado){
            throw new AssertionError("Codigo esperado: " + codigoEsperado + "Codigo Obtenido" + codigoRespuesta );
        }
    }

    public Order obtenerRespuestaOrder(){
        return respuestaOrder;
    }



}

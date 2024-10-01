package com.everis.base;

import com.everis.base.models.Order;
import static io.restassured.RestAssured.given;

public class PetStoreStep {
    private final String URL_BASE = "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Order respuestaOrder;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public void crearOrden(int id, int petId, int quantity){
        Order nuevaOrden = new Order(id, petId, quantity);
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrden)
                .when()
                .post("/store/order")
                .then()
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("store/order/" + id)
                .as(Order.class);

        logSuccess("Id creado: " + respuestaOrder.getId());
        logSuccess("PetId creado: " + respuestaOrder.getPetId());
        logSuccess("Quantity creado: " + respuestaOrder.getQuantity());
    }

    public void validarCodigoRespuesta(int codigoEsperado){
        if(codigoRespuesta != codigoEsperado){
            logError("Código esperado: " + codigoEsperado + ", Código obtenido: " + codigoRespuesta);
            throw new AssertionError("Código esperado: " + codigoEsperado + ", Código obtenido: " + codigoRespuesta );
        }
        logSuccess("Código de respuesta validado correctamente: " + codigoRespuesta);
    }

    public Order obtenerRespuestaOrder(){
        return respuestaOrder;
    }

    public void consultarRespuesta(int id){
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("store/order/" + id)
                .then()
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("store/order/" + id)
                .as(Order.class);
        logSuccess("Id consultado: " + respuestaOrder.getId());
        logSuccess("PetId consultado: " + respuestaOrder.getPetId());
        logSuccess("Quantity consultado: " + respuestaOrder.getQuantity());
        logSuccess("Código de respuesta: " + codigoRespuesta);
    }

    public void validarServicio(int codigoEsperado) {
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("store/inventory")
                .then()
                .extract()
                .statusCode();
        validarCodigoRespuesta(codigoEsperado);
        logSuccess("¡SERVICIO FUNCIONANDO!");
    }

    private void logSuccess(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    private void logError(String message) {
        System.err.println(ANSI_RED + message + ANSI_RESET);
    }
}

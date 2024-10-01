
# Gestión de Órdenes de la Tienda de Mascotas

Este proyecto se centra en la **Gestión de Órdenes** para una tienda de mascotas. Se implementó una feature que incluye dos escenarios principales: **Crear una nueva orden** y **Consultar una orden**. Estos escenarios están diseñados para asegurarnos que el funcionamiento de la API de la tienda de mascotas es el correcto.
## Features

### 1. Crear una Nueva Orden

Este escenario permite crear una nueva orden en la tienda de mascotas. Se utiliza un conjunto de datos de ejemplo para realizar la creación de órdenes con diferentes atributos como `id`, `petId` y `quantity`. La validación incluye verificar el código de estado de la respuesta y confirmar que los detalles de la orden coincidan con los valores ingresados.

#### Escenario: Crear una nueva orden

- **Given**: Estar en la página de mascotas.
- **When**: Crear una orden con un conjunto específico de datos.
- **Then**: Validar que el código de estado de la respuesta sea 200 y que la respuesta contenga los datos correctos.


Nota: Para **crear una nueva orden**, se realizó un ***scenario outline*** 
### 2. Consultar una Orden

Este escenario permite consultar una orden existente en la tienda de mascotas utilizando su `id`. También se valida el código de estado de la respuesta y se verifica que la respuesta contenga la información correcta de la orden.

#### Escenario: Consultar una orden
- **Given**: Estar en la página de mascotas.
- **When**: Consultar la orden con un `id` específico.
- **Then**: Validar que el código de estado de la respuesta sea 200 y que la respuesta contenga los datos correctos.

Nota: Para **consultar una orden**, se realizó un ***scenario*** y un ***scenario outline*** 

## Cómo Funciona

El proyecto utiliza **Cucumber** para la ejecución de pruebas automatizadas, facilitando la definición de pruebas en un lenguaje natural. La lógica de negocio está encapsulada en clases separadas que interactúan con la API de la tienda de mascotas, utilizando **RestAssured** para realizar las peticiones HTTP.

### Estructura del Proyecto
Capas: Gherkin, Step Definition (SD), Step
Archivo: Runner



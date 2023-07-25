## Tecnologías a usar:
- Java version: 11

- Spring Boot version: 2.7.14



## Estructura:



El siguiente proyecto tiene una arquitectura DAO que permita su fácil entendimiento,

para facilidad de pruebas en el ambiente local utiliza una base de datos H2.



## Endpoints y Requests:



El ejercicio plantea un crud completo por lo tanto

tenemos guardar un ticket, consultar un ticket por ID

Consultar los tickets de un usuario, eliminar un ticket y listar todos los tickets.

El proyecto corre en el puerto 8080 en el path base `/ticket`





- Guardar ticket: es un método HTTP tipo POST en el path base, recibe como body un json con la siguiente estructura:

  ```json

    {


        "id_Usuario":"123123",

        "fecha_Creacion":"2024-05-09",

        "fecha_Actualizacion":"2024-05-20",

        "estatus":true

    }

    ```

- Consultar ticket por ID: es un método HTTP tipo GET en el path `/byid/{idTicket}` ejemplo: `localhost:8080/ticket/byid/2`

- Consultar todos los ticktes: es un método HTTP tipo GET en el path `/page/{numero de pagina}`ejemplo: `localhost:8080/ticket/page/0`,   este servicio consulta todos los tickets y los muestra en una paginación de 10 en 10.

- Eliminar un ticket por ID: es un método HTTP tipo DELETE en el path `/{idTicket}` ejemplo: `localhost:8080/ticket/2`

- Consultar todos los tickets de un usuario: es un método HTTP tipo GET en el path `/user/{idUser}` ejemplo `localhost:8080/ticket/user/123123`

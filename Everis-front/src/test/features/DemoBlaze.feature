# language: es
Característica: Agregar producto al carrito de compras del portal web Demo Blaze

  Como cliente de Demo blaze
  Queremos agregar 2 productos en el carrito de compras en la plataforma web
  Para validar que se hayan agregado satisfactoriamente y que la suma de ambos productos sea la correcta.

  # Escenarios de negocio
  @RealizarPago
  Esquema del escenario: Agregar productos al carrito de compras

    Dado que un cliente ingresa al portal de Demo Blaze
    Y se registra con su usuario <USUARIO> y contraseña <PASSWORD>
    Y el cliente accede al login de acceso

    Cuando el cliente añada dos productos mayor a 300 soles al carrito de compras

    Entonces el cliente validara el precio final como la cantidad de los productos en el carrito de compras

    Ejemplos:
       |  USUARIO       |PASSWORD  |
       |antuanette |lalala|


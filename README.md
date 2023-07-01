# Proyecto Semestral: Programacion II
Integrantes:

-Alex Blanchard Ortiz

Especificaciones del proyecto:

>I)El sistema permite al personal de una empresa de autobuses elegir y reservar
asientos de forma conveniente por su cliente.

>II)Los usuarios pueden visualizar una representación gráfica de los asientos
disponibles en el bus y seleccionar los que deseen ocupar.

>III)El sistema muestra la información detallada sobre cada asiento, como ubicación,
número y categoría.

>IV)Una vez que los susarios seleccionan los asientos deseados, se verifica la 
disponibilidad y permite confirmar la reserva mostrando el precio a pagar.  

>V)El pago no es gestionado por el sistemas

>VI)El sistema gestiona varios tipos de buses.

>VII)El sistema cuenta con un menú que permite seleccionar el autobus en función
de su horario y recorrido.

Patrones de Diseño usados:
>Singleton: En el proyecto las clases MenuCompra y ResumenCompra son singleton, para que puedan ser actualizados
de manera global.

Decisiones:
>Las decisiones mas dificiles de tomar fueron las disposicion de los elementos de la interfaz y los patrones de diseño a utilizar,
el patron singleton si bien es muy util deja de lado un poco el concepto de encapsulamiento haciendo un objeto de alcanze global
lo cual crea sus propios problemas.

Critica:
>La interfaz aunque sea simple y funcional puede ser poco clara e incluso poco atractiva para el usuario,
esto se podria arreglar enfoncando mas tiempo en el desarrollo y estudio de esta.

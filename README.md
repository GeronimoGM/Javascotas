# Javascotas

## Información
* Trabajo práctico integrador (tercer cuatrimestre)
* Materia: Laboratorio III.
* Profesor: Gimenez, Guillermo Fabián.
* Facultad: Universidad Tecnológica Nacional

### Tecnologías aplicadas
* Java
* Swing
* Json

## Integrantes
* Manco, Mateo.
* Yatin, Mateo.
* Gonzalez Martino, Gerónimo.

## Introducción
Elegida la opción número 3 (Tema libre) de la consigna, decidimos hacer una red social sobre mascotas.
En esta podremos registrar un usuario, registrar una mascota, hacer publicaciones, enviar mensajes, comentar, likear y recibir notificaciones mientras se interactúa con otros usuarios.

## UML
Para comenzar a planificar el desarrollo de la aplicación, decidimos realizar un diagrama UML.
Para realizarlo usamos [Figma](https://www.figma.com/). Presione [aquí](https://www.figma.com/board/rrjfndIINQCGBa5jEWRuT9/UML?node-id=25-189&t=35tfsBWJx59svZ5K-1) para ir hacia el diagrama.

## Librerías
### Gson
Para facilitarnos la serialización y deserialización de archivos en el formato JSON, decidimos utilizar la libreria [Gson](https://github.com/google/gson).
### LGoodDatePicker
Ante la necesidad de un selector de fechas en el código nativo de Swing, decidimos utilizar [LGoodDatePicker](https://github.com/LGoodDatePicker/LGoodDatePicker) para facilitarnos el trabajo.

## Backend
Este paquete agrupa todas las clases 
### Gestor
Este paquete agrupa a todas las clases que se relacionan con el Gestor
#### Clases
* Gestor: clase estática encargada de guardar y cargar el archivo JSON, de iniciar sesión y registrar usuarios. 
* MascotaAdapter: ayuda a la serialización y deserialización de la clase abstracta Mascota
* NotificacionDeserializer: ayuda a la deserialización de la clase genérica Notificación.
* NotificacionSerializer: ayuda a la serialización de la clase genérica Notificación.
### Excepciones
* ContrasenaIncorrectaException: excepción usada por el Gestor en caso de que se intente iniciar sesión con una contaseña inválida.
* UsuarioNoExistenteException: excepción usada por el Gestor en caso de que se intente hacer un get de un usuario que no existe.
* UsuarioYaExistenteExepction: excepción usada por el Gestor en caso de que se intente registrar con un username ya existente.
### Mascotas
#### Clases
* Mascota: clase abstracta con características que comparten todas las mascotas.
* Conejo: clase que hereda de Mascota para representar un conejo.
* Gato: clase que hereda de Mascota para representar un gato.
* Perro: clase que hereda de Mascota para representar un perro.
### Social
#### Clases
## Frontend

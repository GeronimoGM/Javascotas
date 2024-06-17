# Índice

## Información General
1. [Datos del Proyecto](#datos-del-proyecto)
2. [Tecnologías Aplicadas](#tecnologías-aplicadas)
3. [Integrantes](#integrantes)

## Introducción
4. [Descripción del Proyecto](#descripción-del-proyecto)

## UML
5. [Diagrama UML](#diagrama-uml)

## Librerías
6. [Gson](#gson)
7. [LGoodDatePicker](#lgooddatepicker)

## Backend
8. [Gestor](#gestor)
   - [Clases](#clases-del-gestor)
   - [Excepciones](#excepciones-del-gestor)
9. [Mascotas](#mascotas)
   - [Clases](#clases-de-mascotas)
10. [Social](#social)
    - [Clases](#clases-social)
    - [Enums](#enums)
    - [Interfaces](#interfaces)

## Frontend
11. [Componentes](#componentes)
12. [Páginas](#páginas)

## Información General

### Datos del Proyecto
* Trabajo práctico integrador (tercer cuatrimestre).
* Materia: Laboratorio III.
* Profesor: Gimenez, Guillermo Fabián.
* Facultad: Universidad Tecnológica Nacional.

### Tecnologías Aplicadas
* Java.
* Swing.
* Json.

### Integrantes
* Manco, Mateo.
* Yatin, Mateo.
* Gonzalez Martino, Gerónimo.

## Introducción

### Descripción del Proyecto
Elegida la opción número 3 (Tema libre) de la consigna, decidimos hacer una red social sobre mascotas.
En esta podremos registrar un usuario, registrar una mascota, hacer publicaciones, enviar mensajes, comentar, likear y recibir notificaciones mientras se interactúa con otros usuarios.

## UML

### Diagrama UML
Para comenzar a planificar el desarrollo de la aplicación, decidimos realizar un diagrama UML.
Para realizarlo usamos [Figma](https://www.figma.com/). Presione [aquí](https://www.figma.com/board/rrjfndIINQCGBa5jEWRuT9/UML?node-id=25-189&t=35tfsBWJx59svZ5K-1) para ir hacia el diagrama.

## Librerías

### Gson
Para facilitarnos la serialización y deserialización de archivos en el formato JSON, decidimos utilizar la libreria [Gson](https://github.com/google/gson).

### LGoodDatePicker
Ante la necesidad de un selector de fechas en el código nativo de Swing, decidimos utilizar [LGoodDatePicker](https://github.com/LGoodDatePicker/LGoodDatePicker) para facilitarnos el trabajo.

## Backend

### Gestor

#### Clases del Gestor
* **Gestor:** clase estática encargada de guardar y cargar el archivo JSON, de iniciar sesión y registrar usuarios.
* **MascotaAdapter:** ayuda a la serialización y deserialización de la clase abstracta Mascota.
* **NotificacionDeserializer:** ayuda a la deserialización de la clase genérica Notificación.
* **NotificacionSerializer:** ayuda a la serialización de la clase genérica Notificación.

#### Excepciones del Gestor
* **ContrasenaIncorrectaException:** excepción usada por el Gestor en caso de que se intente iniciar sesión con una contaseña inválida.
* **UsuarioNoExistenteException:** excepción usada por el Gestor en caso de que se intente hacer un get de un usuario que no existe.
* **UsuarioYaExistenteExepction:** excepción usada por el Gestor en caso de que se intente registrar con un username ya existente.

### Mascotas

#### Clases de Mascotas
* **Mascota:** clase abstracta con características que comparten todas las mascotas.
* **Conejo:** clase que hereda de Mascota para representar un conejo.
* **Gato:** clase que hereda de Mascota para representar un gato.
* **Perro:** clase que hereda de Mascota para representar un perro.

### Social

#### Clases Social
* **Chat:** clase que representa un chat entre dos usuarios y que contiene mensajes.
* **Comentario:** clase que representa un comentario en una publicación. Implementa la interfaz Notificadora y Likeable.
* **Like:** clase que representa un like enviado por un usuario ya sea en una publicación o un comentario. Implementa la interfaz Notificadora.
* **Mensaje:** clase que representa un mensaje de un chat.
* **Notificacion:** clase genérica que representa una notificación enviada por un usuario con cualquiera de las clases que implementan la interfaz Notificadora.
* **Publicacion:** clase que representa una publicación que tiene comentarios y likes y trata sobre una de las mascotas del usuario. Los comentarios son ordenados por cantidad de likes. Implementa la interfaz Likeable.
* **Usuario:** clase que representa un usuario. Este usuario puede publicar, añadir mascotas, abrir un chat y recibir notificaciones.

#### Enums
* **Sexo:** enumeración utilizada para trabajar más fácilmente con el género del usuario y de la mascota.

#### Interfaces
* **Likeable:** interfaz que indica que la clase que la implemente puede recibir likes.
* **Notificadora:** interfaz que indica que la clase que la implementa puede producir notificaciones.

## Frontend

### Componentes
* **JChat:** se encarga de la parte visual de la ventana emergente del chat.
* **JComentario:** se encarga de la parte visual de un comentario.
* **JFormMascota:** se encarga de la parte visual del formulario al añadir una mascota.
* **JMascota:** representa la información de una mascota.
* **JNotificacion:** se encarga de la parte visual de una notificación.
* **JPublicacion:** se encarga de la parte visual de una publicación.
* **JSeccionComentarios:** se encarga de la parte visual de ventana emergente para realizar un comentario.
* **JUsuario:** representa un usuario y permite acceder con un botón al perfil de un usuario desde la página explorar.

### Páginas
* **JPaginaChats:** se encarga de la parte visual de los chats.
* **JPaginaExplorar:** se encarga de la parte visual de la exploración de los usuarios.
* **JPaginaInicioSesion:** se encarga de la parte visual del inicio de sesión para los usuarios.
* **JPaginaRegistro:** se encarga de la parte visual del registro de cada usuario.
* **JPaginaNotificacion:** se encarga de la parte visual del apartado de notificaciones.
* **JPaginaPerfil:** se encarga de la parte visual del perfil de cada usuario.
* **JPaginaPrincipal:** se encarga de la parte visual previa al log in o sign in.
* **JPaginaRedSocial:** se encarga de gestionar la parte visual de la página a la que se entra cuando se inicia sesión.
* **JMainFrame:** ventana para visualizar todo el proyecto.

## Bibliografía
* **[Documentación de Swing](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F/javax/swing/package-summary.html)**
* **[ChatGPT](https://chatgpt.com/)**

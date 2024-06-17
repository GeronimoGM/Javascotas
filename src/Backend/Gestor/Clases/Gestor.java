package Backend.Gestor.Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import Backend.Gestor.Excepciones.ContrasenaIncorrectaException;
import Backend.Gestor.Excepciones.UsuarioNoExistenteException;
import Backend.Gestor.Excepciones.UsuarioYaExistenteException;
import Backend.Mascotas.Clases.Abstracta.Mascota;
import Backend.Social.Clases.Usuario;

public class Gestor {
    public static Usuario sesionIniciada = null;
    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    private final static File jsonFile = new File("files/usuarios.json"); 
    // Constructor
    public Gestor() throws InstantiationException{
        throw new InstantiationException("Esta clase no puede ser instanciada");
    }
    // Getter y setters
    public static Usuario getUsuario(String username) throws UsuarioNoExistenteException {
        if (usuarios.containsKey(username)) {
            return usuarios.get(username);
        }
        else {
            throw new UsuarioNoExistenteException("No existe un usuario con el username: " + username);
        }
    }
    public static Iterator<Usuario> getUsuarios() {
        return usuarios.values().iterator();
    }
    // Métodos
    public static void registrarse(Usuario usuario) throws UsuarioYaExistenteException {
        if (!usuarios.containsKey(usuario.getUsername())) {
            usuarios.put(usuario.getUsername(), usuario);
            sesionIniciada = usuario;
        }
        else {
            throw new UsuarioYaExistenteException("Ya existe un usuario con el username: " + usuario.getUsername());
        }
    }

    public static void iniciarSesion(String username, String contrasena) throws UsuarioNoExistenteException, ContrasenaIncorrectaException {
        if (!usuarios.containsKey(username)) {
            throw new UsuarioNoExistenteException("No existe un usuario con el username: " + username);
        }
        else {
            Usuario porIniciar = usuarios.get(username);
            if (porIniciar.esContrasenaCorrecta(contrasena)) {
                sesionIniciada = porIniciar;
            }
            else {
                throw new ContrasenaIncorrectaException("Contraseña incorrecta");
            }
        }
    }

    public static void cerrarSesion() {
        sesionIniciada = null;
        guardar();
    }

    public static void guardar() {
        BufferedWriter buffer = null;

        try {
            buffer = new BufferedWriter(new FileWriter(jsonFile));

            Gson gson = createGson();

            gson.toJson(usuarios, buffer);
        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public static void cargar() {
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new FileReader(jsonFile));

            Gson gson = createGson();

            usuarios = gson.fromJson(buffer, new TypeToken<HashMap<String, Usuario>>(){}.getType());
        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    private static Gson createGson() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // Serializadores y deserializadores para LocalDate
        JsonSerializer<LocalDate> localDateSerializer = (src, typeOfSrc, context) -> context.serialize(src.format(dateFormatter));
        JsonDeserializer<LocalDate> localDateDeserializer = (json, typeOfT, context) -> LocalDate.parse(json.getAsString(), dateFormatter);

        // Serializadores y deserializadores para LocalDateTime
        JsonSerializer<LocalDateTime> localDateTimeSerializer = (src, typeOfSrc, context) -> context.serialize(src.format(dateTimeFormatter));
        JsonDeserializer<LocalDateTime> localDateTimeDeserializer = (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), dateTimeFormatter);
        
        // Serializadores y deserializadores para File
        JsonSerializer<File> fileSerializer = (src, typeOfSrc, context) -> context.serialize(src.getAbsolutePath());
        JsonDeserializer<File> fileDeserializer = (json, typeOfT, context) -> new File(json.getAsString());
        
        // Construcción de Gson con los adaptadores personalizados
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, localDateSerializer)
                .registerTypeAdapter(LocalDate.class, localDateDeserializer)
                .registerTypeAdapter(LocalDateTime.class, localDateTimeSerializer)
                .registerTypeAdapter(LocalDateTime.class, localDateTimeDeserializer)
                .registerTypeAdapter(File.class, fileSerializer)
                .registerTypeAdapter(File.class, fileDeserializer)
                .registerTypeAdapter(Mascota.class, new MascotaAdapter()) // Registro del adaptador de Mascota
                .create();
    }
}

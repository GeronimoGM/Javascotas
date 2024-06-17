package Backend.Gestor.Clases;

import Backend.Social.Clases.Comentario;
import Backend.Social.Clases.Like;
import Backend.Social.Clases.Mensaje;
import Backend.Social.Clases.Notificacion;
import com.google.gson.*;
import java.lang.reflect.Type;

public class NotificacionDeserializer implements JsonDeserializer<Notificacion<?>> {
    @Override
    public Notificacion<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String type = jsonObject.get("type").getAsString();

        JsonElement notificadoraElement = jsonObject.get("notificacion");

        if ("Like".equals(type)) {
            Like like = context.deserialize(notificadoraElement, Like.class);
            return new Notificacion<>(like);
        } else if ("Mensaje".equals(type)) {
            Mensaje mensaje = context.deserialize(notificadoraElement, Mensaje.class);
            return new Notificacion<>(mensaje);
        } else if ("Comentario".equals(type)) {
            Comentario comentario = context.deserialize(notificadoraElement, Comentario.class);
            return new Notificacion<>(comentario);
        } else {
            throw new JsonParseException("Unknown type: " + type);
        }
    }
}

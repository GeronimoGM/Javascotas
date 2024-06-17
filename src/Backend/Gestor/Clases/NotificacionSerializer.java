package Backend.Gestor.Clases;

import Backend.Social.Clases.Comentario;
import Backend.Social.Clases.Like;
import Backend.Social.Clases.Mensaje;
import Backend.Social.Clases.Notificacion;
import Backend.Social.Interfaces.Notificadora;
import com.google.gson.*;
import java.lang.reflect.Type;

public class NotificacionSerializer implements JsonSerializer<Notificacion<?>> {
    @Override
    public JsonElement serialize(Notificacion<?> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        
        Notificadora<?> notificadora = src.getNotificacion();
        if (notificadora instanceof Like) {
            jsonObject.addProperty("type", "Like");
        } else if (notificadora instanceof Mensaje) {
            jsonObject.addProperty("type", "Mensaje");
        } else if (notificadora instanceof Comentario) {
            jsonObject.addProperty("type", "Comentario");
        } else {
            throw new JsonParseException("Unknown type: " + notificadora.getClass().getName());
        }
        
        jsonObject.add("notificacion", context.serialize(notificadora));
        
        return jsonObject;
    }
}

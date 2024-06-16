package Backend.Gestor.Clases;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import Backend.Mascotas.Clases.Abstracta.Mascota;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

@SuppressWarnings("unused")
public class MascotaAdapter implements JsonSerializer<Mascota>, JsonDeserializer<Mascota> {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";

    @Override
    public JsonElement serialize(Mascota src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, src.getClass().getName());
        jsonObject.add(INSTANCE, context.serialize(src));
        return jsonObject;
    }

    @Override
    public Mascota deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class<?> klass = getObjectClass(className);
        return context.deserialize(jsonObject.get(INSTANCE), klass);
    }

    private Class<?> getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
}

package pub.config.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by alexandru.ionita on 3/4/15.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperProvider implements ContextResolver<ObjectMapper>
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final SimpleModule SIMPLE_MODULE = new SimpleModule();

    private static final Function<? super Object, ? extends Object> VOID_IT =
            new Function<Object, Object>()
            {
                @Override
                public Object apply(Object input)
                {
                    return null;
                }
            };

    static
    {
        SIMPLE_MODULE.addSerializer(Set.class, new SetSerializer());
        OBJECT_MAPPER.registerModule(new GuavaModule());
        OBJECT_MAPPER.registerModule(SIMPLE_MODULE);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public ObjectMapper getContext(Class<?> type)
    {
        return null;
    }

    static ObjectMapper objectMapper()
    {
        return OBJECT_MAPPER;
    }

    private static class SetSerializer extends JsonSerializer<Set>
    {

        @Override
        public void serialize(Set value,
                              JsonGenerator gen,
                              SerializerProvider serializers)
                throws IOException
        {
            final Map map = (value == null) ? null : Maps.asMap(value, VOID_IT);
            OBJECT_MAPPER.writeValue(gen, map);
        }
    }

    private static class SetDeserializer extends JsonDeserializer<Set>
    {
        @Override
        public Set deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException
        {
            final Map map = OBJECT_MAPPER.readValue(p, Map.class);
            return (map == null) ? null : map.keySet();
        }
    }
}

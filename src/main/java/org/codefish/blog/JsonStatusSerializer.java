package org.codefish.blog;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * serializer for json status enum to get the inner value
 * source:http://webcache.googleusercontent.com/search?q=cache:JkaRtKhtZAUJ:www.paulocordeiro.com.br/index.php/2011/04/19/serializador-json-personalizado-para-enum/+serializador-json-personalizado-para-enum&cd=1&hl=en&ct=clnk&gl=uk&source=www.google.co.uk
 * @author matthewreid
 */
public class JsonStatusSerializer extends JsonSerializer<Enum<?>> {
	@Override
	public void serialize(Enum<?> value, JsonGenerator jgen,SerializerProvider arg2) throws IOException,JsonProcessingException {
		jgen.writeString(value.toString());
	}
}

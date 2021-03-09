package nl.vs.fuse.animalorder.convertors;

import java.io.IOException;
import java.util.Map;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * https://stackoverflow.com/questions/43836518/how-to-pass-namedquery-parameters-in-apache-camel-jpa-by-header
 * @author makker
 *
 */
public class StringToMapTypeConverter implements TypeConverters {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static JavaType mapType;

    static {
        mapType = mapper.getTypeFactory().constructMapType(Map.class,
                String.class, Object.class);
    }

    @Converter
    public Map<String, Object> toMap(String map) throws IOException {
    	// parameters string in camel URI should start with #.  
    	if (map.startsWith("#")) {
    		map = map.substring(1);
    	}
        return mapper.readValue(map, mapType);
    }
}
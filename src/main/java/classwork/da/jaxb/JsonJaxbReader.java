package classwork.da.jaxb;

//import classwork.entity.jaxb.Fallback;
import classwork.entity.serialize.Fallback;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonJaxbReader {

    public Fallback read(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final Fallback fallback = mapper.readValue(new File(url), Fallback.class);
        return fallback;
    }

}

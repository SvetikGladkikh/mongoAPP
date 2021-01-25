package classwork.util.jaxb;

import classwork.da.jaxb.JaxbSerializeReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class WriteXml {

    public static final String SOURCE_FILE = "temp.jaxb.out";
    public static final String RESULT_FILE = "result_parameters.jaxb.xml";

    public static void main(String... args) throws Exception {

        System.out.println("Read from: " + SOURCE_FILE + "\nWrite to " + RESULT_FILE+ "\n");
        new XmlMapper().writeValue(
                new File(RESULT_FILE),
                new JaxbSerializeReader().customSerializeReader(SOURCE_FILE)
        );
    }

}

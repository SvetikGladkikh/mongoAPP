package classwork.util.jaxb;

import classwork.da.jaxb.JaxbSerializeWriter;
import classwork.da.jaxb.JsonJaxbReader;
//import classwork.entity.jaxb.Fallback;
import classwork.entity.serialize.Fallback;

import java.io.IOException;

/**
 * Чтение из файла objects_data.json и запись сериализации в файл temp.jaxb.out
 * */
public class ReadJson {

    public static final String SOURCE_FILE = "objects_data.json";
    public static final String RESULT_FILE = "temp.jaxb.out";

    public static void main(String[] args) throws IOException {

        System.out.println("Считываем данные из файла " + SOURCE_FILE + "\n");
        Fallback srcData = new JsonJaxbReader().read(SOURCE_FILE);
        System.out.println(srcData);
        System.out.println();

        System.out.println("Записываем данные в файл " + RESULT_FILE + "\n");
        new JaxbSerializeWriter().customSerializeWriter(srcData, RESULT_FILE);
    }

}

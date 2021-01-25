package homework.v3;


import classwork.entity.serialize.Fallback;
import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.classwork.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * Сделать файл с минимум пятью элементами
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * 9) Составленную в п.1 сущность представить в виде xsd-схемы и
 * выполнить генерацию классов аналогично классам из пакета classwork.entity.jaxb
 * * можно сделать и с json-схемой, пренципиально механизм не поменяется.
 * */

public class HomeWork {
    public static final String SOURCE_FILE = "homework.parameters.json";
    public static final String RESULT_FILE_SER = "homework.parameters.ser";
    public static final String RESULT_FILE_EXTER = "homework.parameters.exter";
    public static final String RESULT_FILE_JSON_SER = "homework.result.ser.parameters.json";
    public static final String RESULT_FILE_JSON_EXTER = "homework.result.exter.parameters.json";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // чтение json-файла в память
        ObjectMapper mapper = new ObjectMapper();
        JsonFileClass jsonFileClass = mapper.readValue(new File(SOURCE_FILE), JsonFileClass.class);

        // сериализация с помощью встроенного механизма сериализации
        try (FileOutputStream fos = new FileOutputStream(RESULT_FILE_SER)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(jsonFileClass);
            }
        }

        // сериализация с помощью интрефейса Externalizable
        try (FileOutputStream fileOutputStream = new FileOutputStream(RESULT_FILE_EXTER)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(jsonFileClass);
            }
        }

        // чтение сериализованных данных
        try (FileInputStream fos1 = new FileInputStream(RESULT_FILE_SER)) {
            try (ObjectInputStream oos1 = new ObjectInputStream(fos1)) {
                JsonFileClass jsonFileClassSer = (JsonFileClass) oos1.readObject();

                // запись в json
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_FILE_JSON_SER), jsonFileClassSer);
            }
        }

        try (FileInputStream fos2 = new FileInputStream(RESULT_FILE_EXTER)) {
            try(ObjectInputStream oos2 = new ObjectInputStream(fos2)) {
                JsonFileClass jsonFileClassExter = (JsonFileClass) oos2.readObject();

                // запись в json
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_FILE_JSON_EXTER), jsonFileClassExter);
            }
        }



    }
}

package classwork.da.jaxb;

//import classwork.entity.jaxb.Fallback;
import classwork.entity.serialize.Fallback;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JaxbSerializeReader {
	
	public Fallback customSerializeReader(String filename) throws IOException, ClassNotFoundException {
		try (FileInputStream fos = new FileInputStream(filename)){
			try (ObjectInputStream oos = new ObjectInputStream(fos)){
				return (Fallback)oos.readObject();
			}
		}
		
	}
	
}

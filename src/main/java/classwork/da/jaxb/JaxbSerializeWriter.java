package classwork.da.jaxb;

//import classwork.entity.jaxb.Fallback;
import classwork.entity.serialize.Fallback;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JaxbSerializeWriter {
	
	public void customSerializeWriter(Fallback parameters, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(parameters);
			}
		}
	}
	
}

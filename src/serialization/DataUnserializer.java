package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DataUnserializer {
    public static HelloData unSerializeData() {
        try {
            FileInputStream fin = new FileInputStream("data/data.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            HelloData data = (HelloData) in.readObject();
            in.close();
            fin.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

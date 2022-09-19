package serialization;

public class Main {
    public static void main(String[] args) {
        HelloData data = new HelloData(1, "Hello", "Transient");
        DataSerializer.serializeData(data);
        HelloData data2 = DataUnserializer.unSerializeData();
        System.out.println(data2.getNumber());
        System.out.println(data2.getMessage());
        System.out.println(data2.getTransientMessage());
    }
}

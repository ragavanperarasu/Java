import java.io.*;

// Serializable class
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString() method to display person details
    public String toString() {
        return "Person [Name: " + name + ", Age: " + age + "]";
    }
}

public class ObjectSerialization {

    // Method to serialize the object
    public static void serializeObject(Person person, String fileName) {
        try {
            // Create a file output stream
            FileOutputStream fos = new FileOutputStream(fileName);

            // Create an object output stream and write the object
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);

            // Close the streams
            oos.close();
            fos.close();

            System.out.println("Object serialized and saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize the object
    public static Person deserializeObject(String fileName) {
        Person person = null;
        try {
            // Create a file input stream
            FileInputStream fis = new FileInputStream(fileName);

            // Create an object input stream and read the object
            ObjectInputStream ois = new ObjectInputStream(fis);
            person = (Person) ois.readObject();

            // Close the streams
            ois.close();
            fis.close();

            System.out.println("Object deserialized from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void main(String[] args) {
        String fileName = "person.ser";

        // Create a Person object
        Person person = new Person("John Doe", 30);

        // Step 1: Serialize the Person object
        serializeObject(person, fileName);

        // Step 2: Deserialize the Person object
        Person deserializedPerson = deserializeObject(fileName);

        // Step 3: Print deserialized object details
        System.out.println("Deserialized Person: " + deserializedPerson);
    }
}

/* 
Algorithm
Object Serialization:
Create a class that implements the Serializable interface.
Create an instance of the class and populate it with data.
Use ObjectOutputStream along with FileOutputStream to write the object to a file.

Object Deserialization:
Use ObjectInputStream along with FileInputStream to read the object from the file.
Cast the read object back to its original type.

Handle Exceptions:
Use try-catch blocks to handle IOException and ClassNotFoundException.
 */


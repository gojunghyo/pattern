package design.sigleton.review;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Item item = Item.getInstance();
        Item item1 = null;



        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("Item.obj"))) {
            out.writeObject(item);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("Item.obj"))) {
           item1 =  (Item) in.readObject();
        }

        System.out.println(item == item1);

    }
}

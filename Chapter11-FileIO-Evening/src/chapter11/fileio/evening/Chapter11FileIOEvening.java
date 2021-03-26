package chapter11.fileio.evening;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Chapter11FileIOEvening {

    public static void main(String[] args) {
        Random random = new Random();
        try {
            PrintWriter printWriter = new PrintWriter("test.txt");
            printWriter.println(42);
            printWriter.println(123123123123.45);
            printWriter.println("Happy Thursday!");
            printWriter.println("Happy Thursday!");
            printWriter.println("Happy Thursday!");
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            File file = new File("test.txt");
            Scanner fileReader = new Scanner(file);
            int someInt = Integer.parseInt(fileReader.nextLine());
            double someDouble = Double.parseDouble(fileReader.nextLine());
            String someString = fileReader.nextLine();

            System.out.println(someInt + " " + someDouble + " " + someString);

            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

//        StringBuffer stringBuffer = new StringBuffer();
//        for( int letter = 0; letter < 65535; letter++)
//        {
//            stringBuffer.append("a");
//        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.dat");

            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeInt(42);
            dataOutputStream.writeDouble(123123123123.45);
            dataOutputStream.writeUTF("Happy Thursday!");
            dataOutputStream.writeUTF("Happy Thursday!");
            dataOutputStream.writeUTF("Happy Thursday!");
            dataOutputStream.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("test.dat");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            int someInt = dataInputStream.readInt();
            double someDouble = dataInputStream.readDouble();
            String someString = dataInputStream.readUTF();

            System.out.println(someInt + " " + someDouble + " " + someString);
            
            dataInputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("test.dat", "rw");
            randomAccessFile.seek(12); // + 4 bytes for int + 8 bytes for double
            String someString = randomAccessFile.readUTF();
            randomAccessFile.seek(4);
            randomAccessFile.writeInt(42);
            randomAccessFile.writeInt(42);
            System.out.println(someString);
            randomAccessFile.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        
        
        try
        {
            // array.asList from https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
            ArrayList<String> toppings = new ArrayList<String>( Arrays.asList( "Chicken", "BBQ Sauce", "Bacon", "Pineapple" ));
            Pizza alohaBBQ = new Pizza("Large", "Round", toppings , 14.99);
            
            FileOutputStream fileOutputStream = new FileOutputStream("pizza.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(alohaBBQ);
            
            objectOutputStream.close();
        }
         catch (IOException ex) {
            System.out.println(ex);
        }
        
        try{
            Pizza filePizza;
            
            FileInputStream fileInputStream = new FileInputStream("pizza.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            filePizza = (Pizza)objectInputStream.readObject();
            System.out.println(filePizza);
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

}

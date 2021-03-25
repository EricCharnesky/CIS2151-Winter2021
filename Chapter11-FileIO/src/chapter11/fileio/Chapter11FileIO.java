package chapter11.fileio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter11FileIO {

    public static void main(String[] args) {
        try {
            PrintWriter fileWriter = new PrintWriter("test.txt");
            fileWriter.println("Some basic text file");
            fileWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            // optional argument for append mode
            FileOutputStream fstream = new FileOutputStream("test.dat");
            DataOutputStream outputFile = new DataOutputStream(fstream);
            outputFile.writeInt(42);
            outputFile.writeDouble(123.45);
            outputFile.writeFloat(65);
            outputFile.writeUTF("some message");
            outputFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("test.dat");
            DataInputStream inputFile = new DataInputStream(fileInputStream);
            int someIntValue = inputFile.readInt();
            double someDoubleValue = inputFile.readDouble();
            float someFloatValue = inputFile.readFloat();
            String someString = inputFile.readUTF();
            System.out.println(someString);

        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("test.dat", "r");
            randomAccessFile.seek(4); // # of bytes from the beginning
            randomAccessFile.seek(12); // 4 bytes for int + 8 bytes for double

            float someValue = randomAccessFile.readFloat();
            System.out.println(someValue);
            randomAccessFile.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            BeanBroth ericsCoffee = new BeanBroth("Black coffee", 250);
            ericsCoffee.fill();
            ericsCoffee.drink(50);
            FileOutputStream fileOutputStream = new FileOutputStream("objects.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(fileOutputStream);
            objectOutputFile.writeObject(ericsCoffee);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            BeanBroth inputBeanBroth;
            
            FileInputStream fileInputStream = new FileInputStream("objects.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(fileInputStream);
            
            inputBeanBroth = (BeanBroth)objectInputFile.readObject();
            
            System.out.println(inputBeanBroth);
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }

    }

}

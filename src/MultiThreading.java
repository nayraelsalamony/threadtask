import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MultiThreading extends Thread  {
    public  void readFile(){
        try {
            File file = new File("file.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String threadName=Thread.currentThread().getName();
                System.out.println(threadName);
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(" error");
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        readFile();
    }
    public static void main(String[] args){
        MultiThreading t1=new MultiThreading();
        MultiThreading t2=new MultiThreading();
        MultiThreading t3=new MultiThreading();
        t1.start();
        t2.start();
        t3.start();
     }
    }


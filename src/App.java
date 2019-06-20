import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Methods methods = new Methods();
        methods.go();
/*
        File file = new File("data.csv");
        Queue<Car> carsInQueue = methods.carsFromFile(file);
        Scanner sc = new Scanner(System.in);
        String name = null;

        do {
            methods.start();
            name = sc.nextLine();
            methods.app(name, carsInQueue);
        } while (!(name.equals("0")));


 */
    }
}

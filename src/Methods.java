import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Methods {


    public void go() throws IOException {
        File file = new File("data.csv");
        Queue<Car> carsInQueue = carsFromFile(file);
        Scanner sc = new Scanner(System.in);
        String name = null;
        do {
            start();
            name = sc.nextLine();
            app(name, carsInQueue);
        } while (!(name.equals("0")));
    }

    private void app(String numb, Queue<Car> carsInQueue) throws IOException {
        switch (numb) {
            case "0":
                System.out.println("Do zobaczenia");
                if (carsInQueue.peek() != null) {
                    carsToFile("data.csv", carsInQueue);
                    System.out.println("Kolejka została zapisana w pliku");
                } else {
                    File file = new File("data.csv");
                    file.delete();
                }
                break;
            case "1":
                carAdd(carsInQueue);
                break;
            case "2":
                carsInQueue.poll();
                break;
            case "3":
                for (Car car : carsInQueue) {
                    System.out.println(car.toString());
                }
                System.out.println("\n");
                break;
            default:
                System.out.println("Podajaj: 0 lub 1, 2 lub 3");
        }
    }

    private void start() throws FileNotFoundException {
        System.out.println("Wybierz odpowiedni kod akcji:");
        System.out.println("\t\t0 - Koniec programu");
        System.out.println("\t\t1 - Dodawanie nowego pojazdu do kolejki");
        System.out.println("\t\t2 - Obsługa następnego pojazdu z kolejki");
        System.out.println("\t\t3 - Wyświetalnie pojazdów w kolejce");
    }

    private void carAdd(Queue<Car> carsInQueue) {  //dodawniawe nowego pojadu do kolejki
        Scanner sc = new Scanner(System.in);
        System.out.println("Musisz podać następujace dane:");
        System.out.println("rodzaj: ");
        String type = sc.nextLine();

        System.out.println("marka: ");
        String makeOfCar = sc.nextLine();

        System.out.println("model: ");
        String model = sc.nextLine();

        System.out.println("rocznik: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("przebieg: ");
        double mileage = sc.nextDouble();
        sc.nextLine();

        System.out.println("numer VIN: ");
        String vin = sc.nextLine();

        Car car = new Car(type, makeOfCar, model, year, mileage, vin);

        carsInQueue.add(car);

    }

    private Queue<Car> carsFromFile(File file) throws FileNotFoundException {
        Queue<Car> carsToday = new LinkedList<>();
        if (file.exists()) fill(file, carsToday);
        return carsToday;
    }

    private void fill(File file, Queue<Car> carsToday) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String tempData = sc.nextLine();
            String[] split = tempData.split(";");
            Car tempCar = new Car(split[0], split[1], split[2], Integer.valueOf(split[3]),
                    Double.valueOf(split[4]), split[5]);
            carsToday.add(tempCar);
        }
    }

    private void carsToFile(String file, Queue<Car> qc) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw);
        int x = qc.size();

        for (int i = 0; i < x; i++) {
            bfw.write((qc.poll()).toCsv());
            bfw.newLine();
        }
        bfw.close();
    }



    /*
    public void app(String numb, Queue<Car> carsInQueue) throws IOException {
        switch (numb) {
            case "0":
                System.out.println("Do zobaczenia");
                if (!(carsInQueue.peek() == null)) {
                    carsToFile("data.csv", carsInQueue);
                    System.out.println("Kolejka została zapisana w pliku");
                }
                break;
            case "1":
                carAdd(carsInQueue);
                break;
            case "2":
                carsInQueue.poll();
                break;
            case "3":
                for (Car car : carsInQueue) {
                    System.out.println(car.toString());
                }
                break;
            default:
                System.out.println("Podajaj: 0 lub 1, 2 lub 3");
        }
    }

    public void start() throws FileNotFoundException {
        // System.out.println("Witaj. Co chcesz zrobić?");
        System.out.println("Wybierz odpowiedni kod akcji:");
        System.out.println("\t\t0 - Koniec programu");
        System.out.println("\t\t1 - Dodawanie nowego pojazdu do kolejki");
        System.out.println("\t\t2 - Obsługa następnego pojazdu z kolejki");
        System.out.println("\t\t3 - Wyświetalnie pojazdów w kolejce");
    }

    public void carAdd(Queue<Car> carsInQueue) {  //dodawniawe nowego pojadu do kolejki
        Scanner sc = new Scanner(System.in);
        System.out.println("Musisz podać następujace dane:");
        System.out.println("rodzaj: ");
        String type = sc.nextLine();

        System.out.println("marka: ");
        String makeOfCar = sc.nextLine();

        System.out.println("model: ");
        String model = sc.nextLine();

        System.out.println("rocznik: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("przebieg: ");
        double mileage = sc.nextDouble();
        sc.nextLine();

        System.out.println("numer VIN: ");
        String vin = sc.nextLine();

        Car car = new Car(type, makeOfCar, model, year, mileage, vin);

        carsInQueue.add(car);

    }

    public Queue<Car> carsFromFile(String file) throws FileNotFoundException {
        Queue<Car> carsToday = new LinkedList<>();
        File file1 = new File(file);
        if (file1.exists()) {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                String tempData = sc.nextLine();
                String[] split = tempData.split(";");
                Car tempCar = new Car(split[0], split[1], split[2], Integer.valueOf(split[3]),
                        Double.valueOf(split[4]), split[5]);
                carsToday.add(tempCar);
            }
        }
        file1.delete();
        return carsToday;
    }

    public void carsToFile(String file, Queue<Car> qc) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw);
        int x = qc.size();

        for (int i = 0; i < x; i++) {
            bfw.write((qc.poll()).toCsv());
            bfw.newLine();
        }
        bfw.close();
    }
*/
}

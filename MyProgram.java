import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class MyProgram
{
   public static void main(String[] args) {
        String options = "Choose a series to sum:\n1) Arithmetic\n2) Geometric\n3) Fibonacci\n4) Square Series\n5) Exit\nEnter option: ";
        Scanner input = new Scanner(System.in);

        Series series = new Series(SeriesCategory.NONE);

    

        int opt = 0;
        boolean endProgram = false;
        do {
            opt = getIntInput(options, input);

            switch (opt) {
                case 1: // Arithmetic
                    clearScreen();
                    series.setSeriesCategory(SeriesCategory.ARITHMETIC);
                    series.calculateSeriesSum(input);
                    System.out.println("The sum is: " + series.getSum() + "\n");
                    break;

                case 2: // Geometric
                    clearScreen();
                    series.setSeriesCategory(SeriesCategory.GEOMETRIC);
                    series.calculateSeriesSum(input);
                    System.out.println("The sum is: " + series.getSum() + "\n");
                    break;

                case 3: // Fibonacci
                    clearScreen();
                    series.setSeriesCategory(SeriesCategory.FIBONACCI);
                    series.calculateSeriesSum(input);
                    System.out.println("The sum is: " + series.getSum() + "\n");
                    break;

                case 4:
                    clearScreen();
                    series.setSeriesCategory(SeriesCategory.SQUARE);
                    series.calculateSeriesSum(input);
                    System.out.println("The sum is: " + series.getSum() + "\n");
                    break;
                case 5:
                    endProgram = true;
                    break;
                default:
                    clearScreen();
                    System.out.println("Please enter a valid option from the list");
                    input.nextLine();
                    break;
            }
        } while (!endProgram);

        input.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getIntInput(String msg, Scanner input) {
        int num = 0;

        while (true) {
            try {
                System.out.printf(msg);
                num = input.nextInt();

                if (num < 0) {
                    System.out.println("You number cannot be less then 0!");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a whole number\n");
                input.nextLine(); // clear buffer
            }
        }

        return num;
    }

    public static void saveSum(String save) {

        File file = new File("output.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("output.txt", true);

            writer.write(save);
            writer.write("\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}

import java.util.Scanner;

public class Series {
    private SeriesCategory seriesType;
    private double sum;

    public Series(SeriesCategory seriesType) {
        this.seriesType = seriesType;
        this.sum = 0;
    }

    public SeriesCategory getSeriesCategory() {
        return this.seriesType;
    }

    public void setSeriesCategory(SeriesCategory newSeriesType) {
        this.seriesType = newSeriesType;
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum(double newSum) {
        this.sum = newSum;
    }

    public void calculateSeriesSum(Scanner input) {
        int term;

        switch (this.seriesType) {
            
            case SeriesCategory.ARITHMETIC:
                term = MyProgram.getIntInput("Enter the max term: ", input);
                int a = MyProgram.getIntInput("Enter the a: ", input);
                int d = MyProgram.getIntInput("Enter the d: ", input);

                sum = arithmeticSeries(a, d, term);

                MyProgram.saveSum(String.format("%s Paramters: a: %d d: %d term: %d", this.toString(), a, d, term));
                break;

            case SeriesCategory.GEOMETRIC:
                term = MyProgram.getIntInput("Enter the max term: ", input);

                sum =  geometricSeries(term);

                MyProgram.saveSum(String.format("%s Paramters: term: %d", this.toString(), term));
                break;

            case SeriesCategory.FIBONACCI:
                term = MyProgram.getIntInput("Enter the max term: ", input);

                sum = fibonaciiSum(term);   

                MyProgram.saveSum(String.format("%s Paramters: term: %d", this.toString(), term));
                break;
            case SeriesCategory.SQUARE:
                term = MyProgram.getIntInput("Enter the max term: ", input);

                sum = sqrNumberSeries(term);

                MyProgram.saveSum(String.format("%s Paramters: term: %d", this.toString(), term));
                break;
            case SeriesCategory.NONE:
                break;
        }
    }

    private int arithmeticSeries(int a, int d, int term) {
        if(term <= 0) {
            return 0;
        }

        return (a + (term - 1) * d) + arithmeticSeries(a, d, term - 1);
    }

    private double geometricSeries(int n) {
        if(n == 0) {
            return 1;
        }

        return (double)Math.pow(3, n) + geometricSeries(n - 1);
    }

    /**
     * Will calculate Fibonacci sequence of nth term
     * 
     * @param n The max term of the Fibonacci sequence
     */
    private int fibonaciSeries(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonaciSeries(n - 1) + fibonaciSeries(n - 2);
    }

    private int fibonaciiSum(int n) {
        if(n <= 0) {
            return n;
        }

        return fibonaciSeries(n) + fibonaciiSum(n -1);
    }

    public static int sqrNumberSeries(int n) {
        if(n == 1) {
            return 1;
        }

        return (n * n) + sqrNumberSeries(n - 1); 
    }

    public String toString() {

        String cat = "";
        switch (seriesType) {
            case SeriesCategory.NONE:
            cat = "None";
            break;

            case SeriesCategory.ARITHMETIC: 
            cat = "Arithmetic";
            break;

            case SeriesCategory.GEOMETRIC:
            cat = "Geometric";
            break;

            case SeriesCategory.FIBONACCI: 
            cat = "Fibonacci";

            break;

            case SeriesCategory.SQUARE:
            cat = "Square";
            break; 
        }

        return String.format("Category: %s Sum: %.2f ", cat, this.sum);
    }
}

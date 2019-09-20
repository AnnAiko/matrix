package matrix;

public class Matrix {

    public static void main(String[] args) {
        System.out.println("Исходная матрица:");
        readFile read = new readFile();
        read.readFile();
        System.out.println("Транспонированная матрица:");
        read.printMatrix();
    }
}

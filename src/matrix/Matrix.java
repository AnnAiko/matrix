package matrix;

public class Matrix {

    public static void main(String[] args) {
        System.out.println("�������� �������:");
        readFile read = new readFile();
        read.readFile();
        System.out.println("����������������� �������:");
        read.printMatrix();
    }
}

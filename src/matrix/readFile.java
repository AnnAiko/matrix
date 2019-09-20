package matrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class readFile {
    private String filePath = "matrix.txt";
    private String sText = "";
    //Размер матрицы
    private int iSizeMatrix = 0;
    //Матрица
    private int[][] matrix = null;

    //Читать файл
    public void readFile() {
        String sText = "";
        Scanner scan = null;
        try {
            FileReader fr = new FileReader(filePath);
            scan = new Scanner(fr); // чтение из файла 
            scan.useDelimiter("\\n");
            while (scan.hasNext()) {
                sText += scan.next();
                iSizeMatrix++;
            }
            scan.close();
            matrix = new int[iSizeMatrix][iSizeMatrix];
            //Разбить матрицу на элементы
            String[] sElement = sText.split("\\s+");
            int iCountElement = 0;
            for (int i = 0; i < iSizeMatrix; i++) {
                for (int j = 0; j < iSizeMatrix; j++) {
                    matrix[i][j] = Integer.parseInt(sElement[iCountElement]);
                    iCountElement++;
                }
            }
            printMatrix();
            //Транспонировать
            transpose();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

//Вывести 
    public void printMatrix() {
        for (int i = 0; i < iSizeMatrix; i++) {
            for (int j = 0; j < iSizeMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Транспонировать
    public void transpose() {
        for (int i = 0; i < iSizeMatrix; i++) {
            for (int j = i + 1; j < iSizeMatrix; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

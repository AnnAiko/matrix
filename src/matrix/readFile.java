package matrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class readFile {
    private String filePath = "matrix.txt";
    private String sText = "";
    //������ �������
    private int iSizeMatrix = 0;
    //�������
    private int[][] matrix = null;

    //������ ����
    public void readFile() {
        String sText = "";
        Scanner scan = null;
        try {
            FileReader fr = new FileReader(filePath);
            scan = new Scanner(fr); // ������ �� ����� 
            scan.useDelimiter("\\n");
            while (scan.hasNext()) {
                sText += scan.next();
                iSizeMatrix++;
            }
            scan.close();
            matrix = new int[iSizeMatrix][iSizeMatrix];
            //������� ������� �� ��������
            String[] sElement = sText.split("\\s+");
            int iCountElement = 0;
            for (int i = 0; i < iSizeMatrix; i++) {
                for (int j = 0; j < iSizeMatrix; j++) {
                    matrix[i][j] = Integer.parseInt(sElement[iCountElement]);
                    iCountElement++;
                }
            }
            printMatrix();
            //���������������
            transpose();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

//������� 
    public void printMatrix() {
        for (int i = 0; i < iSizeMatrix; i++) {
            for (int j = 0; j < iSizeMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //���������������
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

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/4/20 - 1:18
 */
public class Sparsearray {
    public static void main(String[] args) {
        int chessArrs[][] = new int[11][11];
        chessArrs[1][2]=1;
        chessArrs[2][3]=2;
        for(int[] arr : chessArrs){
            for(int data :arr){
                System.out.print(" "+data+" ");

            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
        int rows = chessArrs.length;
        int valueNum = 0;
        int[] valueArr = new int[4];
        for(int[] arr : chessArrs){
            for(int data :arr){
                if(data !=0){
                    valueNum++;
                    valueArr[valueNum] = data;
                }
            }
        }

        System.out.println(rows);
        System.out.println(valueNum);
        System.out.println(Arrays.toString(valueArr));
        System.out.println("-------------------------------------");
        int sparsearray[][] = new int[valueNum+1][3];
        sparsearray[0][0] = 11;
        sparsearray[0][1] = 11;
        sparsearray[0][2] = valueNum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArrs[i][j] != 0){
                    count++;
                    sparsearray[count][0] = i;
                    sparsearray[count][1] = j;
                    sparsearray[count][2] = chessArrs[i][j];
                }
            }
        }
        for (int i = 0; i < sparsearray.length; i++) {
            for (int j = 0; j < sparsearray[0].length; j++) {
                System.out.print(" \t"+sparsearray[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        int chessArr2[][] = new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i = 0; i < sparsearray[0][2]; i++) {
            chessArr2[sparsearray[i+1][0]][sparsearray[i+1][1]] = sparsearray[i+1][2];
        }
        for (int i = 0; i < chessArr2.length; i++) {
            for (int i1 = 0; i1 < chessArr2[0].length; i1++) {
                System.out.print(" "+chessArr2[i][i1]+" ");
            }
            System.out.println();
        }


    }
}

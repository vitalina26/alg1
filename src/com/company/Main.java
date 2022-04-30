package com.company;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import java. util. Arrays;
import java.util.Scanner;
public class Main {
    public static Integer[] MinMaxMatrix(Integer[][] matrix, int n)
    {
        Integer[] MinMax = new Integer[2];
        MinMax[0] = matrix[0][0];
        MinMax[1] = MinMax[0];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++ ) {
                if (matrix[i][j] < MinMax[0])
                    MinMax[0] = matrix[i][j];
                if (matrix[i][j] > MinMax[1])
                    MinMax[1] = matrix[i][j];
            }
        }

        return MinMax;
    }
    public static void MatrixOut(Integer[][] matrix,int n)
    {
        System.out.print("\n");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++ ) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }
    public static Integer[] Swap (int i, Integer[] array)
    {
        int tmp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = tmp;
        return array;
    }

    static Integer[][] Swap(int i, int j, Integer[][] matrix)
    {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i + 1][j];
        matrix[i + 1][j] = tmp;
        return matrix;
    }

    public static Integer[] ByAscending(Integer[] array)
    {
        for (int j = 0; j < array.length - 1; j++)
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] > array[i + 1])
                    array = Swap(i, array);

        return array;
    }
    public static Integer[] ByDescending(Integer[] array)
    {
        for (int j = 0; j < array.length - 1; j++)
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] < array[i + 1])
                    array = Swap(i, array);

        return array;
    }



    public static Integer[][] Sorting_1(Integer[][] matrix)
    {
        int n = matrix.length;

        for (int row = 0; row < n; row++)
            for (int j = 0; j < n; j++)
                for (int i = 0; i < n - 1; i++)
                    if (matrix[row][i] > matrix[row][i + 1])
                        matrix[row] = Swap(i, matrix[row]);

        return matrix;
    }
    public static Integer[][] Sorting_2(Integer[][] matrix)
    {
        int n = matrix.length;

        for (int row = 0; row < n; row++)
            for (int j = 0; j < n; j++)
                for (int i = 0; i < n - 1; i++)
                {
                    if (row % 2 == 0)
                    {
                        if (matrix[row][i] > matrix[row][i + 1])
                            matrix[row] = Swap(i, matrix[row]);
                    }
                    else
                    {
                        if (matrix[row][i] < matrix[row][i + 1])
                            matrix[row] = Swap(i, matrix[row]);
                    }
                }

        return matrix;
    }

    public static Integer[][] Sorting_3(Integer[][] matrix)
    {
        int n = matrix.length;

        for (int col = 0; col < n; col++)
            for (int j = 0; j < n; j++)
                for (int i = 0; i < n - 1; i++)
                    if (matrix[i][col] > matrix[i + 1][col])
                        matrix = Swap(i, col, matrix);

        return matrix;
    }

    public static Integer[] ToArray(Integer[][] matrix)
    {
        int n = matrix.length;
        Integer[] result = new Integer[n * n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i * n + j] = matrix[i][j];
        return result;
    }


    public static Integer[] ToArraySortAscending (Integer[] array)
    {
        int n = array.length;
        for (int j = 0; j < n; j++)
            for (int i = 0; i < n - 1; i++)
                if (array[i] > array[i + 1])
                    array = Swap(i, array);
        return array;
    }


    public static Integer[][] Sorting_4(Integer[][] matrix)
    {
        int N = matrix.length;
        Integer[] array = ToArray(matrix);
        array = ToArraySortAscending(array);
        int j = 0;
        Integer[][] result = new Integer[N][];
        for (int i = 0; i < N; i++)
            result[i] = new Integer[N];
        for (int n = 0; n < N;)
        {
            for (int i = n; i < N; i++)
                result[n][i] = array[j++];
            for (int i = n + 1; i < N; i++)
                result[i][N - 1] = array[j++];
            for (int i = N - 2; i >= n; i--)
                result[N - 1][i] = array[j++];
            for (int i = N - 2; i > n; i--)
                result[i][n] = array[j++];
            n++;
            N--;
        }
        return result;
    }

    public static Integer[] ToArraySortDescending(Integer[] array)
    {
        int n = array.length;
        for (int j = 0; j < n; j++)
            for (int i = 0; i < n - 1; i++)
                if (array[i] < array[i + 1])
                    array = Swap(i, array);

        return array;
    }



    public static Integer[][] Sorting_5(Integer[][] matrix)
    {
        int N = matrix.length;
        Integer[] array = ToArray(matrix);
        array = ToArraySortDescending(array);
        int j = 0;
        Integer[][] result = new Integer[N][];

        for (int i = 0; i < N; i++)
            result[i] = new Integer[N];

        for (int n = 0; n < N;)
        {

            for (int i = N - 1; i >= n; i--)
                result[n][i] = array[j++];

            for (int i = n + 1; i < N; i++)
                result[i][n] = array[j++];

            for (int i = n + 1; i < N; i++)
                result[N - 1][i] = array[j++];

            for (int i = N - 2; i > n; i--)
                result[i][N - 1] = array[j++];

            n++;
            N--;
        }

        return result;
    }




    public static void main(String[] args) {

        System.out.println("Enter n > 10");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Integer[][] matrix = new Integer[n][];
        for (int i = 0; i < n; i++)
        {
            matrix[i] = new Integer[n];
            for(int j = 0; j < n; j++)
            {
                Random r = new Random();
                matrix[i][j] = r.nextInt(200);
            }
        }
        MatrixOut(matrix,n);
        System.out.print("\n");
        Integer[] min_max = MinMaxMatrix(matrix, n);
        System.out.println("MIN : " + min_max[0] + "  MAX : " + min_max[1]);
         Integer[][] s1 =Sorting_1(matrix);
         MatrixOut(s1,n);
        Integer[][] s2 =Sorting_2(matrix);
        MatrixOut(s2,n);
        Integer[][] s3 =Sorting_3(matrix);
        MatrixOut(s3,n);
        Integer[][] s4 =Sorting_4(matrix);
        MatrixOut(s4,n);
        Integer[][] s5 =Sorting_5(matrix);
        MatrixOut(s5,n);


    }
}

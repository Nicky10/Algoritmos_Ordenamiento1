/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.lang.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Ordenamiento {

    public static int[] toIntArray(String[] strings) {
        int[] numbers;
        numbers = new int[strings.length];

        for (int c = 0; c < strings.length; c++) {
            numbers[c] = Integer.parseInt(strings[c]);
        }
        return numbers;
    }

    public static void BubbleSort(int[] a) 
    {
        for (int i = 0; i < a.length - 1; i++) 
        {
            for (int j = 0; j < a.length - 1; j++) 
            {
                if (a[j] > a[j + 1]) 
                {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void InsertionSort(int[] A) 
    {
        int j;
        int aux;
        for (int p = 1; p < A.length; p++) 
        {
            aux = A[p];
            j = p - 1;
            while ((j >= 0) && (aux < A[j])) 
            {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = aux;
        }
    }

    public static int LinealSearch(int[] A, int data) 
    {
        int dato = 0;
        for (int i = 0; i < A.length; i++) 
        {
            int j = A[i];
            if (j == data) 
            {
                dato = A[i] + 1;
                break;
            }
        }
        return dato;
    }
    
    public void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");            
        }
        System.out.println("");
    }
    
    public int[] bigArray(int length)
    {
        Random rd = new Random();
        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=rd.nextInt(100);
            
        }
        
        return temp;
        
    }
    
    public int[] mergeSort(int[] unsorted) {
        int size;
        if (unsorted.length > 1) {
            size = unsorted.length / 2;
            int[] left_array = new int[size];
            int[] right_array = new int[unsorted.length - size];
            
            for (int i = 0; i < size; i++)
                left_array[i] = unsorted[i];
            
            for (int i = size; i < unsorted.length; i++)
                right_array[i - size] = unsorted[i];
            
            return merge(mergeSort(left_array), mergeSort(right_array));
        }
        
        return unsorted;
    }
    
    public int[] merge(int[] a, int[] b) {
        int lenght = a.length + b.length;
        int[] c = new int[lenght];
        int index_a = 0, index_b = 0, index_c = 0;
        
        while (index_a < a.length && index_b < b.length) {
            if (a[index_a] < b[index_b]) {
                c[index_c] = a[index_a];
                index_a++;
            } else {
                c[index_c] = b[index_b];
                index_b++;
            }
            index_c++;
        }
        
        while (index_a < a.length) {
            c[index_c] = a[index_a];
            index_a++;
            index_c++;
        }
        
        while (index_b < b.length) {
            c[index_c] = b[index_b];
            index_b++;
            index_c++;
        }
        
        return c;
    }

    
    public void countingSort(int[] unsorted)
    {
        int c = Integer.MIN_VALUE;
        int index = 0;
        int[] aux;
        for (int i = 0; i < unsorted.length; i++) 
        {
            if(unsorted[i] > c)
            {
                c = unsorted[i];
            }
        }        
        aux = new int[c + 1];
        
        for (int i = 0; i < unsorted.length; i++) 
            aux[unsorted[i]] += 1;  
        
        for (int i = 0; i < aux.length; i++) 
        {
            for (int j = 0; j < aux[i]; j++) 
            {
                unsorted[index] = i;
                index +=1;                
            }
        }
        
    }
    
    public int BinarySearch(int[] arreglo, int x)
    {
        int lowerBound = 0;
        int upperBound = arreglo.length - 1;
        int index = -1;
        while (lowerBound < upperBound)
        {
            int middlePoint = (lowerBound + upperBound) / 2;
            if (x==arreglo[middlePoint])
            {
                index=middlePoint;
                break;
            }
            else if(x<arreglo[middlePoint])
            {
                upperBound = middlePoint -1;
            }
            else
            {
                lowerBound = middlePoint +1;
            }
        }
        if (lowerBound==upperBound && arreglo[lowerBound]==x)
        {
            index=lowerBound;            
        }
        return index;        
    }
    
    public int BinarySearch_Recursive(int[] arreglo, int x, int lB, int uB)
    {
        int middlePoint = (uB+lB)/2;
        if (uB==lB)
        {
            if (x==arreglo[middlePoint])
            {
                return middlePoint;                
            }
            else return-1;                        
        }
        else 
        {
            if(x == arreglo[middlePoint])
            {
                return middlePoint;                
            }
            else if(x < arreglo[middlePoint])
            {
                return BinarySearch_Recursive(arreglo, x, lB, middlePoint);
            }
            else
            {
              return BinarySearch_Recursive(arreglo, x, middlePoint, uB);
            }
        }
    }
    

    public static void main(String[] args) 
    {
//        System.out.println("Ingrese una serie de numeros separados por comas");
//        Scanner sc = new java.util.Scanner(System.in);
//        String a = sc.next();
//        String[] b = a.split(",");
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        Ordenamiento array = new Ordenamiento();
        int[] arreglo = array.bigArray(10000);
        System.out.println(Arrays.toString(arreglo));
        arreglo = array.mergeSort(arreglo);
//      InsertionSort(arreglo);
        System.out.println(Arrays.toString(arreglo));
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        
    }

}

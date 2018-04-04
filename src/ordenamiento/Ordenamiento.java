/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Ordenamiento {
    
    public static int[] toIntArray(String[] strings)
    {
        int[] numbers;
        numbers = new int[strings.length];

        for(int c=0;c<strings.length;c++)
        {
        numbers[c]=Integer.parseInt(strings[c]);
        }
        return numbers;
    }

    public static void BubbleSort(int[] a)
    {
        for (int i = 0; i < a.length -1; i++) 
        {
            for (int j = 0; j < a.length -1; j++)
            {
            if(a[j]>a[j+1])
            {
                int tmp = a[j+1];
                a[j+1] = a[j];
                a[j] = tmp;
            }
            }
        }
    }
    
    public static void InsertionSort(int[] A)
    {
        int j;
        int aux;
        for (int p = 1; p < A.length; p++){ 
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
            if(j == data)
            {
                dato = A[i] + 1;
                break;
            }
        }
        return dato;
    }
    
    
    public static void main(String[] args) 
    {
        System.out.println("Ingrese una serie de numeros separados por comas");
        Scanner sc = new java.util.Scanner(System.in);
        String a = sc.next();
        String[] b = a.split(",");
        int[] arreglo;
        arreglo = toIntArray(b);
        InsertionSort(arreglo);
        System.out.println(Arrays.toString(arreglo));
    }
    
}

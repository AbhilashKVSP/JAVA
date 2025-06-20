package com.myjava;

import java.rmi.dgc.VMID;

class Sorting {
    // Bubble Sort = O(n^2)
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Selection Sort = O(n^2)
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    // Insertion Sort = O(n^2)
    public void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                //Keep swapping
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    // Merge Sort

    public void mergedSort(int[] arr) {
        divide(arr,0,arr.length-1);
    }
    public void divide(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mi = si+(ei-si)/2; // if si and ei is large it might go out of int range so use this
        divide(arr,si,mi);
        divide(arr,mi+1,ei);
        conquer(arr,si,mi,ei);
    }

    private void conquer(int arr[], int si, int mi, int ei) {
        int[] merged =new int[ei-si+1];
        int index1=si;
        int index2 = mi+1;
        int idx = 0;
        while(index1 <= mi && index2 <= ei){
            if(arr[index1] <= arr[index2]){
                merged[idx++] = arr[index1++];
            }else{
                merged[idx++]= arr[index2++];
            }
        }
        while(index1 <= mi){
            merged[idx++] = arr[index1++];
        }
        while(index2 <= ei){
            merged[idx++]= arr[index2++];
        }
        for(int i=0,j=si; i<merged.length;i++,j++){
            arr[j] = merged[i];
        }
    }

    // Quick Sort

    public void QuickSort(int[] arr) {
        int n = arr.length;
        QShelper(arr,0,n-1);
    }

    private void QShelper(int[] arr, int low, int high) {
        if(low<high){
            int pidx = partition(arr,low,high);
            QShelper(arr,low,pidx-1);
            QShelper(arr,pidx+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i= low; // To track how many lower values than pivot
        for(int j= low; j< high; j++){
            if(arr[j] < pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}

public class Main {

    public static void main(String[] args) {
        Sorting sort = new Sorting();
        int arr[] = {5, 6, 7, 8, 0};
        System.out.println("Input Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Bubble Sorted Array: ");
        sort.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("================================");

        int arr2[] = {7,8,3,1,2};
        System.out.println("Input Array: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("selection Sorted Array: ");
        sort.selectionSort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("================================");

        int arr3[] = {7,8,5,1,2};
        System.out.println("Input Array: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        System.out.println("Insertion Sorted Array: ");
        sort.InsertionSort(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        System.out.println("================================");
        int arr4[] = {7,2,5};
        System.out.println("Input Array: ");
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        System.out.println("Merged Sorted Array: ");
        sort.mergedSort(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        System.out.println("================================");
        int arr5[] = {1,7,6,3,5};
        System.out.println("Input Array: ");
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
        System.out.println("Quick Sorted Array: ");
        sort.QuickSort(arr5);
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + " ");
    }
}
}

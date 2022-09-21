package util;

import java.awt.desktop.UserSessionEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class QuickSort {

    public static <Type> void quickSort(Type[] toSort, Comparator<Type> comp){
        sort(toSort, 0, toSort.length - 1, comp);
    }

    public static <Type> void sort(Type[] toSort, int l, int h, Comparator<Type> comp){
        int p;

        if(l < h){
            p = partition(toSort, l, h, comp);
            sort(toSort, l, p-1, comp);
            sort(toSort, p+1, h, comp);
        }
    }

    private static <Type> int partition(Type[] toSort, int l, int h, Comparator<Type> comp){
        int i;
        int p;
        int firstHigh;

        p = h;
        firstHigh = l -1;
        for (i = l; i<h; i++){
            if (comp.compare(toSort[i], toSort[p]) <= 0){
                firstHigh++;
                Type temp = toSort[firstHigh];
                toSort[firstHigh] = toSort[i];
                toSort[i] = temp;
            }
        }
        Type temp = toSort[firstHigh + 1];
        toSort[firstHigh + 1] = toSort[h];
        toSort[h] = temp;
        return (firstHigh + 1);
    }

    public static void main(String[] args) {
        String[] data = {"This", "is", "an", "Example", "of", "sorting", "Strings"};
        Double[] datuh = {5.0,2.0,6.0,1.0,7.0,8.0};

        quickSort(data, Comparator.naturalOrder());
        System.out.println(Arrays.toString(data));
        quickSort(datuh, Comparator.naturalOrder());
        System.out.println(Arrays.toString(datuh));
    }
}

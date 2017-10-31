package com.cszjo.offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * Created by hansiming on 2017/10/31.
 */
public class Demo34 {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        for(int i = 0;i < array.length; i++)
            copy[i] = array[i];
        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        int i = mid;
        int j = high;
        int copyIndex = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += (j - mid);
                copy[copyIndex--] = array[i--];
                if (count >= 1000000007)
                    count %= 1000000007;
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        for (;i >= low; i--)
            copy[copyIndex--] = array[i];
        for (;j > mid; j--)
            copy[copyIndex--] = array[j];
        for (int m = low; m <= high; m++)
            array[m] = copy[m];
        return (leftCount + rightCount + count) % 1000000007;
    }

//    private int InversePairsCore(int[] array,int[] copy,int low,int high)
//    {
//        if(low==high) {
//                return 0;
//        }
//        int mid = (low+high)>>1;
//        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
//        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
//        int count = 0;
//        int i=mid;
//        int j=high;
//        int locCopy = high;
//        while(i>=low&&j>mid)
//        {
//                if(array[i]>array[j])
//                {
//                        count += j-mid;
//                        copy[locCopy--] = array[i--];
//                        if(count>=1000000007)//数值过大求余
//                        {
//                                count%=1000000007;
//                            }
//                    }
//                else
//                {
//                        copy[locCopy--] = array[j--];
//                    }
//            }
//        for(;i>=low;i--)
//        {
//                copy[locCopy--]=array[i];
//            }
//        for(;j>mid;j--)
//        {
//                copy[locCopy--]=array[j];
//            }
//        for(int s=low;s<=high;s++)
//        {
//                array[s] = copy[s];
//            }
//        return (leftCount+rightCount+count)%1000000007;
//    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 3};
        System.out.println(new Demo34().InversePairs(arr));
    }
}

package com.cszjo.leetcode.array;

public class Solution4 {

/*    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }*/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if ((len1 + len2) % 2 == 0) {
            double k1 = findKth(nums1, nums2, 0, 0, (len1 + len2 - 1) / 2);
            double k2 = findKth(nums1, nums2, 0, 0, (len1 + len2) / 2);
            return (k1 + k2) / 2;
        } else {
            return findKth(nums1, nums2, 0, 0, (len1 + len2) / 2);
        }
    }

    private double findKth(int[] nums1, int[] nums2, int start1,
                           int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 > len2) {
            return findKth(nums2, nums1, start2, start1, k);
        }

        if (k == 0) {
            if (start1 < nums1.length) {
                return Math.min(nums1[start1], nums2[start2]);
            } else {
                return nums2[start2];
            }
        }

        if (start1 >= nums1.length) {
            return nums2[start2 + k];
        }

        int mid = (k - 1) / 2;

        if (start1 + mid >= nums1.length) {
            return findKth(nums1, nums2, start1, start2 + mid + 1, k - mid - 1);
        }

        if (nums1[start1 + mid] > nums2[start2 + mid]) {
            return findKth(nums1, nums2, start1, start2 + mid + 1, k - mid - 1);
        } else {
            return findKth(nums1, nums2, start1 + mid + 1, start2, k - mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1,2,3,5,6};
        double medianSortedArrays =
                new Solution4().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}

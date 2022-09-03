package leecode200;

/**
 * @author sven
 * @date 2022/09/03
 * @desprication 4. Median of Two Sorted Arrays
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        if (m == 0) {
            if (n%2 == 0) {
                return (nums2[n/2 - 1] + nums2[n/2])/2.0;
            } else {
                return nums2[n/2];
            }
        }

        if (n == 0) {
            if (m%2 == 0) {
                return (nums1[m/2 - 1] + nums1[m/2])/2.0;
            } else {
                return nums1[m/2];
            }
        }

        int count =0;
        int i =0, j =0;
        while (count != (m+n)) {
            // 边界条件，1、如果num1数组已经遍历完，接着遍历nums2数组
            if (i==m) {
                while(j !=n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            // 边界条件，1、如果num2数组已经遍历完，接着遍历nums1数组
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}

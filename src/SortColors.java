import java.util.Arrays;
import java.util.Random;

/**
 * Given an array with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent.
 * We use the integers 0, 1, and 2 to represent the color
 * red, white, and blue, respectively.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int read  = 0;               // index to read the array
        int left  = 0;               // when arr[read] == 0, we swap read with left
        int right = nums.length - 1; // when arr[read] == 2, we swap read with right

        while (read <= right) {
            if (nums[read] == 0)
            {
                // found 0 on read, but we only swap with left when arr[left] is not 0,
                // so increment left until we find non-0
                while (left <= read && nums[left] == 0)
                {
                    left++;
                }
                if (left < read)
                    swap(nums, read, left++);
            }
            else if (nums[read] == 2)
            {
                // found 2 on read, only swap with right if arr[right] is not 2,
                // so increment left until we find non-2
                while (right >= read && nums[right] == 2)
                {
                    right--;
                }
                if (right > read)
                {
                    swap(nums, read, right--);
                    // we may have swapped 2 at arr[read] with 0 at arr[right]
                    // if we did, decrement read index so it will be caught on the next iteration
                    if (nums[read] == 0)
                        read--;
                }
            }
            read++;
        }
    }

    /**
     * Swap two values in an array
     */
    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        SortColors sort = new SortColors();
/*        Random rand = new Random();
        int size = 3;
        int[] colors = new int[size];
        int count = 0;
        while (count < 20) {
            for (int i = 0; i < size; i++) {
                colors[i] = rand.nextInt(3);
            }
            System.out.println("=================================");
            System.out.println(Arrays.toString(colors));
            sort.sortColors(colors);
            System.out.println(Arrays.toString(colors));
            count++;
        }*/

//        Some test cases:
//        int[] colors = {2,0,2,1,1,0};
//        int[] colors = {2,0,1};
//        int[] colors = {1,1,1,1,0,0,0,0};
//        int[] colors = {2,2,2,2,1,1,1,1};
//        int[] colors = {0,1,1,2,0};

//        int[] colors = {1, 2, 1, 0, 2};
//        int[] colors = {1, 2, 2, 2, 0, 0, 2, 2, 0};
//        int[] colors = {1, 1, 2, 2, 1, 1, 2, 2, 1};
//        int[] colors = {2, 2, 2, 0, 1, 0, 1, 2, 2};
//        int[] colors = {2, 0, 1, 1, 2, 1, 1, 2, 2};
//        int[] colors = {0,1,2,0,1,0,2,0,1};
    }
}

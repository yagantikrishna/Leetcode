//find all possible permutations of a given array
//Time complexity O(n!*n)
//Space complexity O(n)
import java.util.*;
import java.util.Arrays;

public class permutation2 {
    //base case is iteration reaches array length
    public void findpermute2(int[] nums, int ind, ArrayList<ArrayList<Integer>> ans) {
        if (ind == nums.length) {
            ArrayList<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        //iterate from 0 to array_length and swap index with pointer
        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);//swap index with pointer
            findpermute2(nums, ind + 1, ans);
            swap(i,ind,nums);// swap again to backtrace the elements to same position
        }
    }

    //method to swap elements of a array
    private void swap(int i,int j,int[] nums) {
    int temp=nums[i];
    nums[j]=nums[i];
    nums[i]=temp;
    }

    //function which takes array as input and return permutations as ans
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findpermute2(nums,0,ans);
        return ans;
    }

    //Driver code
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] nums = new int[10];
        ArrayList<Integer> ds = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1000);
        }
        long startTime = System.nanoTime();
        permutation2 p2=new permutation2();
        System.out.println(p2.permute(nums));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println(duration);
    }
}
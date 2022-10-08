
//Program to find all the permutations possible for a given array/string
import java.util.*;

public class permutation {

    // basecase: when list becomes equal to arraylength stop the recursion and add
    // it to the list
    public static void findpermute(boolean[] marked, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans,
            int[] arr) {
        int limit = arr.length;
        if (ds.size() == limit) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // iterate from index to arraylength, if index is not marked add it to the list
        // and mark it, once base case is reached, remove the last elementand unmark it for other recursions
        for (int index = 0; index < limit; index++) {
            if (!marked[index]) {
                ds.add(arr[index]);
                marked[index] = true;
                findpermute(marked, ds, ans, arr);
                ds.remove(ds.size() - 1);
                marked[index] = false;
            }
        }
    }

    // Method to take array as input and find the permutations
    public static ArrayList<ArrayList<Integer>> permute(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean marked[] = new boolean[arr.length];
        findpermute(marked, ds, ans, arr);
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("Enter the length of the array");
        Scanner sc = new Scanner(System.in);
        int arraylength = sc.nextInt();
        int[] array = new int[arraylength];
        System.out.println("Enter the elements of the array");
        Scanner s = new Scanner(System.in);
        for (int index = 0; index < arraylength; index++) {
            array[index] = s.nextInt();
        }
        System.out.println(permute(array));
        ;
    }
}

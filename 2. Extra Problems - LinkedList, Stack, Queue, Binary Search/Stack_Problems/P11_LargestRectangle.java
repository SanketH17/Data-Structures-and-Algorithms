package Stack_Problems;

import java.util.*;
import java.util.Stack;

public class P11_LargestRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] rb = new int[n]; // rb - right boundary -> next smaller element to the right
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            // pop ans push
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            // ans
            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }

            // push
            st.push(i);
        }

        int[] lb = new int[n]; // lb - left boundary -> next smaller element to the left

        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            // ans
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }

            // push
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);

        sc.close();

    }
}

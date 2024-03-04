package com.pro.Alg;

import java.util.Stack;

public class Algorithms {
	
	public static void moveZerosToEnd(int ar[]) {
		
		int j=0;
		for(int i=0;i<ar.length;i++) {
			
			if(ar[i]!=0 && ar[j]==0) {	
				ar[j]=ar[i];
				ar[i]=0;
			}
			if(ar[j]!=0)j++;	
		}	
	}
	
	public static void nextGreaterElement(int ar[]) {
		
//		for(int i=0;i<ar.length;i++) {
//			int j=i;
//			for(;j<ar.length;j++) {
//				if(ar[j]>ar[i]) {
//					ar[i]=ar[j];
//					break;
//				}
//			}
//			if(j==ar.length)ar[i]=-1;		
//		}
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=ar.length-1;i>=0;i--) {
			while(!stack.isEmpty() && stack.peek()<=ar[i]) stack.pop();
			if(stack.isEmpty())ar[i]=-1;
			else ar[i]=stack.peek();
			stack.push(ar[i]);
		}
	}
	
	
	public static void main(String[] args) {
		
		int ar[]=new int[]{1,0,0,5,0,7,9};
//		moveZerosToEnd(ar);
		nextGreaterElement(ar);
		for(int i:ar)System.out.print(i+" ");
//		for(int i:TwoPointers.twoSum(new int[] {2, 7,9,11},9)) System.out.print(i+" ");
//		System.out.println(TwoPointers.ContainerWithMostWater(new int[] {1,8,6,2,5,4,8,3,7}));
//		int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
//		for(int i=0;i<TwoPointers.removeDuplicates(nums);i++)System.out.print(nums[i]+" ");
		
	}

}

class TwoPointers{
	
	public static int[] twoSum(int[] numbers, int target) {
        
        int i=0,j=numbers.length-1;
        while(i<j){
           
            int sum=numbers[i]+numbers[j];
            if(sum==target) return new int[]{i+1,j+1};
            else if(sum>target)j--;
            else i++;
        }
        return new int[]{-1,-1};
    }
	
	public static int ContainerWithMostWater(int arr[]) {
		
		    int i=0;
	        int max=0;
	        int j=arr.length-1;
	        while(i<j){
	               int  level=Integer.min(arr[i],arr[j])*(j-i);
	               if(level>max)max=level;
	               if(arr[i]<arr[j])i++;
	               else  j--;
	          }
	        return max;
	}
	public static int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
	public static void nextPermutation(int[] arr) {

        int n = arr.length, i, j;

    for (i = n - 2; i >= 0; i--) {
      if (arr[i] < arr[i + 1]) {
        break;
      }
    }

    if (i < 0) {
      reverse(arr, 0, arr.length - 1);
    }
 
    else {
 
      for (j = n - 1; j > i; j--) {
        if (arr[j] > arr[i]) {
          break;
        }
      }
      swap(arr, i, j);
      reverse(arr, i + 1, arr.length - 1);
    }
  }
 
  private static void reverse(int[] arr, int start, int end)
  {
    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }
 
 private static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
 public static int trapRainWater(int[] ar) {
     if(ar.length<3)return 0;
     int level=0,curr=0;
     int l=0,h=ar.length-1;
     while(l<h){
         if(ar[l]<=ar[h]){
             curr=ar[l];
             while(ar[++l]<curr){
                 level+=curr-ar[l];
             }
         }
         else{
             curr=ar[h];
             while(ar[--h]<curr ){
                 level+=curr-ar[h];
             }
         }
     }    
    return level;
}
  
  
  
}










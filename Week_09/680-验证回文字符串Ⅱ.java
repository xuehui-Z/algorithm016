class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else {
                if (arr[left+1] == arr[right] && validPalindrome(arr,left+1,right))  return true;
                if (arr[left] == arr[right-1] &&validPalindrome(arr,left,right-1)) return true;
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
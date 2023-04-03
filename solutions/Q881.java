import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int sum = 0;
        while(left < right){
            if (people[left]+people[right]<=limit){
                sum++;
                left++;
                right--;
            } else {
                sum++;
                right--;
            }
        }
        if (left == right){
            sum++;
        }
        return sum;
    }
}
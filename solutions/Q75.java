class Q75 {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length-1;
        while (white<=blue){
            // put all red on left
            if (nums[white] == 0){
                nums[white] = 1;
                nums[red] = 0;
                red++;
                white++;
            } else if (nums[white] == 1){
                white++;
            } else if (nums[white] == 2){
                nums[white] = nums[blue];
                nums[blue] = 2;
                blue--;
            }
        }
    }
}
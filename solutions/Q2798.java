class Q2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int num = 0;
        for (int h : hours) {
            if (h >= target) {
                num++;
            }
        }
        return num;
    }
}
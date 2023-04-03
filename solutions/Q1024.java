import java.util.Arrays;

class Q1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b)->{
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });

        int curEnd = 0;
        int nextEnd = 0;
        int i = 0;
        int n = clips.length;
        int count = 0;
        
        while (i < n && clips[i][0] <= curEnd) {

            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            count++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return count;
            }
        }
        
        return -1;
    }
}
public class Q2645 {
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int last = 2;
        int ans = 0;
        for(char c : s) {
            int value = c - 'a';

            while((last + 1) % 3 != value) {
                last++;
                ans++;
            }
            last = value;
        }

        while(last != 2) {
            last++;
            ans++;
        }
        return ans;


        // int ans = 0;
        // Character prev1 = null, prev2 = null;

        // for (int i=0; i<word.length(); i++){
        //     if (word.charAt(i) == 'a'){
        //         if (prev1 == null){
        //             prev1 = 'a';
        //         } else if (prev1 == 'a'){
        //             ans += 2;
        //         } else if (prev1 == 'b'){
        //             if (prev2 == null){
        //                 ans += 2;
        //                 prev1 = 'a';
        //             } else if (prev2 == 'a'){
        //                 ans += 1;
        //                 prev1 = 'a';
        //                 prev2 = null;
        //             }
        //         }
        //     } else if (word.charAt(i) == 'b'){
        //         if (prev1 == null){
        //             prev1 = 'b';
        //         } else if (prev1 == 'a'){
        //             prev2 = 'a';
        //             prev1 = 'b';
        //         } else if (prev1 == 'b'){
        //             if (prev2 == null){
        //                 ans += 2;
        //             } else if (prev2 == 'a'){
        //                 ans += 1;
        //                 prev1 = 'b';
        //                 prev2 = null;
        //             }
        //         }
        //     } else {
        //         if (prev1 == null){
        //             ans += 2;
        //         } else if (prev1 == 'a'){
        //             ans += 1;
        //             prev1 = null;
        //         } else if (prev1 == 'b'){
        //             if (prev2 == null){
        //                 ans += 1;
        //                 prev1 = null;
        //             } else if (prev2 == 'a'){
        //                 prev1 = null;
        //                 prev2 = null;
        //             }
        //         }
        //     }
        // }

        // if (prev1 != null && prev2 != null){
        //     ans +=1;
        // } else if (prev1 != null){
        //     ans += 2;
        // }

        // return ans;
    }
}

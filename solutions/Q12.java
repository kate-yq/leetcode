public class Q12 {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i<num/1000; i++){
            ans.append("M");
        }
        num = num%1000;
        if (num>=900){
            ans.append("CM");
            num -=900;
        } else if (num>=500){
            ans.append("D");
            num -=500;
        } else if (num>=400){
            ans.append("CD");
            num -=400;
        }
        for (int i=0; i<num/100; i++){
            ans.append("C");
        }
        num = num%100;
        if (num>=90){
            ans.append("XC");
            num -=90;
        } else if (num>=50){
            ans.append("L");
            num -=50;
        } else if (num>=40){
            ans.append("XL");
            num -=40;
        }
        for (int i=0; i<num/10; i++){
            ans.append("X");
        }
        num = num%10;
        if (num==9){
            ans.append("IX");
            return ans.toString();
        } else if (num>=5){
            ans.append("V");
            num -=5;
        } else if (num==4){
            ans.append("IV");
            return ans.toString();
        }
        for (int i=0; i<num; i++){
            ans.append("I");
        }
        return ans.toString();
    }
}

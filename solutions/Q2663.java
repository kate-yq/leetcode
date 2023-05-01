public class Q2663 {
    public String smallestBeautifulString(String s, int k) {
        char[] str = s.toCharArray();
        int i = str.length - 1;
        str[i]++;
        while (i >= 0 && i < str.length) {
            if (str[i] >= 'a' + k) {
                str[i] = 'a';
                i--;
                if (i >= 0) {
                    str[i]++;
                } else {
                    break;
                }
            } else if ((i - 1 >= 0 && str[i] == str[i - 1]) || (i - 2 >= 0 && str[i] == str[i - 2])) {
                str[i]++;
            } else {
                i++;
            }
        }
        return (i == -1) ? "" : new String(str);
    }
}

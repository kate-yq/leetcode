import java.util.HashMap;

public class Q2002 {
    public int maxProduct(String s) {
        HashMap<Integer,Integer> map=new HashMap<>(); // KEY=bit mask , VALUE= length of the string generated from that mask
        int n=s.length();
        for(int mask=0;mask<(1<<n);mask++){// generate bitmask from 1 to 2^n 
            String temp="";
            for(int i=0;i<n;i++){ 
                if((mask & (1<<i)) !=0) // generate the string from the mask 
                    temp+=s.charAt(i);
            }
            
            if(isPali(temp)){ // check if its a palindrome
                map.put(mask,temp.length()); 
            }
        }
        
        int res=0;
        for(int i: map.keySet()){
            for(int j :map.keySet()){
                if((i&j)==0){ // if AND of two bitmask is zero means they are disjoint
                    res=Math.max(res, map.get(i)*map.get(j));
                }
            }
        }
        
        return res;
        
        
        
        
    }
    
    private boolean isPali(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

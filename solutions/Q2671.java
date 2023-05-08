import java.util.HashMap;

public class Q2671 {
    HashMap<Integer, Integer> numToFreq;
    HashMap<Integer, Integer> freqToNum;
    
    public Q2671() {
        this.numToFreq = new HashMap<>();
        this.freqToNum = new HashMap<>();
    }
    
    public void add(int number) {
        int freq = numToFreq.getOrDefault(number, 0);
        numToFreq.put(number, freq+1);
        if (freq == 0){
            freqToNum.put(1, freqToNum.getOrDefault(1, 0)+1);
        } else {
            freqToNum.put(freq, freqToNum.get(freq)-1);
            freqToNum.put(freq+1, freqToNum.getOrDefault(freq+1, 0)+1);
            if (freqToNum.get(freq) == 0){
                freqToNum.remove(freq);
            }
        }
    }
    
    public void deleteOne(int number) {
        if (!numToFreq.containsKey(number)){
            return;
        }
        int freq = numToFreq.get(number);

        if (freq == 1){
            numToFreq.remove(number);
            freqToNum.put(freq, freqToNum.get(freq)-1);
        } else {
            numToFreq.put(number, freq-1);
            freqToNum.put(freq, freqToNum.get(freq)-1);
            freqToNum.put(freq-1, freqToNum.getOrDefault(freq-1, 0)+1);
        }
        
        if (freqToNum.get(freq) == 0){
            freqToNum.remove(freq);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return freqToNum.containsKey(frequency);
    }
}

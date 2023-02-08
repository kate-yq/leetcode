class Q408{
    public boolean validWordAbbreviation(String word, String abbr) {
        int idxAbbr = 0;
        int n = abbr.length();
        StringBuilder etd = new StringBuilder();
        while (idxAbbr<n){
            if (!Character.isDigit(abbr.charAt(idxAbbr))){
                etd.append(abbr.charAt(idxAbbr));
            } else if (abbr.charAt(idxAbbr)=='0'){
                return false;
            } else {
                int amt = abbr.charAt(idxAbbr)-'0';
                while (idxAbbr<n-1 && Character.isDigit(abbr.charAt(idxAbbr+1))){
                    idxAbbr++;
                    amt = amt*10 + abbr.charAt(idxAbbr)-'0';
                }
                if (amt > word.length()){
                    return false;
                }
                for (int i=0; i<amt; i++){
                    etd.append(".");
                }
            }
            idxAbbr++;
        }
        if (etd.length()!=word.length()){
            return false;
        }
        for (int i=0; i<word.length(); i++){
            if (word.charAt(i)!=etd.charAt(i) && etd.charAt(i)!='.'){
                return false;
            }
        }
        return true;
    }
}
public class Q990 {
    int[] parents;

    public boolean equationsPossible(String[] equations) {
        this.parents = new int[26];

        for (int i=0; i<26; i++){
            parents[i] = i;
        }

        for (String e : equations){
            if (e.charAt(1) == '='){
                int a = e.charAt(0)-'a';
                int b = e.charAt(3)-'a';
                parents[find(a)] = find(b);
            }
        }

        for (String e : equations){
            if (e.charAt(1) == '!'){
                int a = e.charAt(0)-'a';
                int b = e.charAt(3)-'a';
                if (find(a) == find(b)){
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int cur){
        if (parents[cur] != cur){
            parents[cur] = find(parents[cur]);
            cur = parents[cur];
        }

        return parents[cur];
    }
}

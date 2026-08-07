class Solution {
    int ans;
    HashSet<Integer> visit;
    HashMap<Integer, List<Integer>> list;
    public int countComponents(int n, int[][] edges) {
        ans = 0;
        visit = new HashSet<>();
        list = new HashMap<>();
        for(int i = 0; i < n; i++){
            list.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int par = edges[i][0];
            int child = edges[i][1];
            list.get(par).add(child);
            list.get(child).add(par);
        }
        for(int i = 0; i < n; i++){
            if(!visit.contains(i)){
                ans++;
                dfs(i);
            }
        }
        return ans;
    }
    public void dfs(int node){
        if(visit.contains(node)) return;
        visit.add(node);
        for(int nb : list.get(node)){
            dfs(nb);
        }
    }
}

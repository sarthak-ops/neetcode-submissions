class Solution {
    HashMap<Integer, List<Integer>> ans;
    HashSet<Integer> visit;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        ans = new HashMap<>();
        visit = new HashSet<>();
        for(int i = 0; i < n; i++){
            ans.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int par = edges[i][0];
            int child = edges[i][1];
            ans.get(par).add(child);
            ans.get(child).add(par);
        }
        if(dfs(0, -1) == false) return false;
        return visit.size() == n;
    }
    public boolean dfs(int node, int parent){
        if(visit.contains(node)) return false;
        visit.add(node);
        for(int nb : ans.get(node)){
            if(nb == parent) continue;
            if(dfs(nb, node) == false) return false;
        }
        return true;
    }
}

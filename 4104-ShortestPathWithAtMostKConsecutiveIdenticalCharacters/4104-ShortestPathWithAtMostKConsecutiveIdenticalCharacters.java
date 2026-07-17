// Last updated: 7/17/2026, 3:01:48 PM
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
        }
        int INF=Integer.MAX_VALUE/2;
        int[][] dist=new int[n][k+1];
        for(int[] row:dist){
            Arrays.fill(row,INF);
        }
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[0][1]=0;
        pq.add(new int[]{0,0,1});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int cost=cur[0];
            int node =cur[1];
            int cnt=cur[2];

            if(node==n-1){
                return cost;
            }
            if(cost>dist[node][cnt])continue;

            for(int[]next:graph[node]){
                int v = next[0];
                int w=next[1];

                int newCnt;
                if(labels.charAt(v)==labels.charAt(node)){
                    newCnt=cnt+1;
                }else{
                    newCnt=1;
                }
                if(newCnt>k)continue;
                int newCost=cost+w;

                if(newCost<dist[v][newCnt]){
                    dist[v][newCnt]=newCost;
                    pq.add(new int[]{newCost,v,newCnt});
                }
            }
        }
        return-1;
    }
}
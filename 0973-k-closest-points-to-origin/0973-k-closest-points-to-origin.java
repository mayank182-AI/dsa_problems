class Solution {

    class Triplet {
        int x;
        int y;
        int dist;

        Triplet(int x,int y,int dist) {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.dist,a.dist));
        int ans[][]=new int[k][2];

        int n=points.length;

        for(int i=0;i<n;i++) {
            int nx=points[i][0];
            int ny=points[i][1];

            int dist = nx*nx+ny*ny;
            pq.add(new Triplet(nx,ny,dist));

            while(pq.size() > k)
            pq.poll();
        }

        int i=0;

        while(!pq.isEmpty()) {

            Triplet t = pq.poll();
            ans[i][0]=t.x;
            ans[i][1]=t.y;
            i++;
        }     

        return ans;

        
    }
}
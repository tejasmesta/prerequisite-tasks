class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int P = prerequisites.length;
        
        for(int i=0;i<P;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int indegree[] = new int[N];
        
        for(int i=0;i<adj.size();i++)
        {
            for(Integer j:adj.get(i))
            {
                indegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<N;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        int ans = 0; 
        
        while(!q.isEmpty())
        {
            int r =q.remove();
            
            ans++;
            
            for(Integer j:adj.get(r))
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    q.add(j);
                }
            }
        }
        
        if(ans==N)
        {
            return true;
        }
        
        return false;
        
    }
    
}

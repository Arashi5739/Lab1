package Lab1;

import java.util.*;

public class DijkstraSP 
{  
	DijkstraSP p;
    class QueueItem {  
        int node;  
        double distance;  
          
        public QueueItem(int node, double distance) {  
            this.node = node;  
            this.distance = distance;  
        }  
          
        public int compareTo(QueueItem t) {  
            if (node > t.node) return 1;  
            if (node < t.node) return -1;  
            return 0;  
        }  
    }  
      
    Comparator<QueueItem> itemComparator = new Comparator<QueueItem>() {  
        public int compare(QueueItem t1, QueueItem t2) {  
            return t1.compareTo(t2);  
        }  
    };  
      
    private Queue<QueueItem> pq; // 获取当前distance中最小值  
    private double[] disTo; // 到起点的距离  
    private DirectedEdge[] edgeTo; // 路径  
      
    public DijkstraSP(EdgeWeightDiGraph g,String vertex) {  
    	int begin = Main.aq.indexOf(vertex);
        pq = new PriorityQueue<>(itemComparator);  
        disTo = new double[g.V()];  
        edgeTo = new DirectedEdge[g.V()];  
        for (int i = 0; i < g.V(); i++) {  
            disTo[i] = Double.POSITIVE_INFINITY;  
        }     
        pq.add(new QueueItem(begin, 0.0));  
        disTo[begin] = 0;  
        while (!pq.isEmpty()) { // 获取Queue顶元素，松弛对应的顶点的边  
            QueueItem t = pq.poll();  
            relax(g, t.node);  
        }  
    }  
      
    private void relax(EdgeWeightDiGraph g, int v) {  
        for (DirectedEdge e : EdgeWeightDiGraph.adj(v)) {  
            int to = Main.aq.indexOf(e.getTarget());  
            if (disTo[to] > disTo[v] + e.weight()) {  
                disTo[to] = disTo[v] + e.weight();  
                edgeTo[to] = e;  
                pq.offer(new QueueItem(to, disTo[to]));  
            }  
        }  
    }  
      
    public double disTo(int v) {  
        return disTo[v];  
    }  
      
    public boolean hasPath(int v) {  
        return disTo[v] < Double.POSITIVE_INFINITY;  
    }  
      
    public Iterable<DirectedEdge> pathTo(String vertex) {  
    	if(Main.aq.contains(vertex))
    	{
    		int v = Main.aq.indexOf(vertex);
            if (!hasPath(v)) return null;  
            List<DirectedEdge> path = new ArrayList<>();  
            for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[Main.aq.indexOf(e.getSource())]) {  
                path.add(0, e);  
                }
            //DirectedEdge e = path.get(path.size()-1);
            return path; 
    	}
    	return null; 
    }  
    
    public static String calcShortestPath(String word1, String word2)
    {
        String s = "";
        if(Main.aq.contains(word1) && Main.aq.contains(word2))
        {
            DijkstraSP p = new DijkstraSP(Main.g,word1);
            String ad = "";
            double sum = 0;
            ArrayList<String> ad2 = new ArrayList<String>();
            for(DirectedEdge e : p.pathTo(word2))
            {
                ad=ad + e.getSource()+"->";
                ad2.add(e.getTarget());
                sum+=e.weight();
            }
            ad += ad2.get(ad2.size()-1);
            s = ad+"\t"+sum;
        }
        else if(!Main.aq.contains(word1) && Main.aq.contains(word2))
        {
            s = "No “" + word1 + "” in the graph!";
        }
        else if(Main.aq.contains(word1))
        {
            s = "No “" + word2 + "” in the graph!";
        }
        else
        {
            s = "No “" + word1 + "” and “" + word2 + "” in the graph!";
        }
        
        return s;
    }
}  

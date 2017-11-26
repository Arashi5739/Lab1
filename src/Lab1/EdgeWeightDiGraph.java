package Lab1;

import java.util.*;

public class EdgeWeightDiGraph
{
	public static List<DirectedEdge>[] adj; // 邻接表矩阵  
    public static int V; // 点的数目  
    public static int E; // 边的数目

    public static DirectedEdge ContainEdge(DirectedEdge e)   //存在边
    {
    	String source = e.getSource();
    	String target = e.getTarget();
    	int i = Main.aq.indexOf(source);
    	List<DirectedEdge> edges=adj[i];
		for(int j=0;j<edges.size();j++)
		{
			if(edges.get(j).getTarget().equals(target))
			{
				return edges.get(j);
			}
		}
		return null;
    }
    
    
    @SuppressWarnings("unchecked")
    public EdgeWeightDiGraph(int V) 
    {  
        this.V = V;  
        E = 0;  
        adj = (List<DirectedEdge>[]) new List[V];  
        for (int i = 0; i < V; i++)
        {  
            adj[i] = new ArrayList<>();  
        }  
    }  
	      
    public static void addEdge(DirectedEdge e) {  
    	int i = Main.aq.indexOf(e.getSource());
        adj[i].add(e);  
        E++;  
    }  
      
    public static int V() {  
        return V;  
    }  
      
    public int E() {  
        return E;  
    }  
      
    public static Iterable<DirectedEdge> adj(int v) {  
        return adj[v];  
    }  
    
    public String showDirectedGraph() {  
        String s = V + " 个顶点, " + E + " 条边\n";  
        for (int i = 0; i < Main.aq.size(); i++) {  
            s += Main.aq.get(i) + ": ";  
            for (DirectedEdge e : EdgeWeightDiGraph.adj(i))
            {  
                s += e.getTarget() + " [" + e.weight() + "], ";  
            }  
            s += "\n";  
        }  
        return s;  
    }

}

package Lab1;

import java.util.*;

public class EdgeWeightDiGraph
{
	public static List<DirectedEdge>[] adj; // �ڽӱ����  
    public static int V; // �����Ŀ  
    public static int E; // �ߵ���Ŀ

    public static DirectedEdge ContainEdge(DirectedEdge e)   //���ڱ�
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
        String s = V + " ������, " + E + " ����\n";  
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

package Lab1;

import java.util.*;

public class BridgeWords 
{
	public static ArrayList<String> bridge = new ArrayList<String>();
	Main main = new Main();
	public ArrayList<String> BridgeWord(String a,String b)
    {
    	int pa=main.aq.indexOf(a);
    	int pb=main.aq.indexOf(b);
    	ArrayList<String> bridge = new ArrayList<String>();
    	if(pa!=-1 && pb!=-1)
    	{
    		List<DirectedEdge> egdes=main.g.adj[pa];
    		int s = egdes.size();
    		for(int i=0;i<s;i++)
    		{
    			DirectedEdge e = egdes.get(i);
    			String c = e.getTarget();		
    			int pc=main.aq.indexOf(c);
    			List<DirectedEdge> edges2=main.g.adj[pc];
    			int s2 = edges2.size();
    			for(int j=0;j<s2;j++)
    			{
    				DirectedEdge e2 = edges2.get(j);
    				if(b.equals(e2.getTarget()))
    				{
    					bridge.add(c);
    				}
    			}
    		}
    	}
    	return bridge;
    }
	
	public String queryBridgeWords(String word1, String word2)
	{
    	int pa=main.aq.indexOf(word1);
    	int pb=main.aq.indexOf(word2);
    	String s = "";
    	ArrayList<String> bridge = BridgeWord(word1,word2);
		if(pa!=-1 && pb!=-1)
		{
			if(bridge.size()==1)
			{
				s ="The bridge words from ¡°" + word1 + "¡± to ¡°" + word2 + "¡± is:" + bridge;
			}
			else if(bridge.size()>1)
			{
				s ="The bridge words from ¡°" + word1 + "¡± to ¡°" + word2 + "¡± are:" + bridge;
			}
			else
			{
				s ="No bridge words from ¡°" + word1 + "¡± to ¡°" + word2 + "¡±!";
			}
		}
		else if(pa==-1 && pb!=-1)
		{
			s ="No ¡°" + word1 + "¡± in the graph!";
		}
		else if(pa!=-1 && pb==-1)
		{
			s = "No ¡°" + word2 + "¡± in the graph!";
		}
		else
		{
			s = "No ¡°" + word1 + "¡± and ¡°" + word2 + "¡± in the graph!";
		}
			return s;
	}
}

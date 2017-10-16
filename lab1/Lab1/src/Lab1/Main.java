package Lab1;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Main
{
	public static ArrayList<String> al;
	public static ArrayList<String> aq;
	public static EdgeWeightDiGraph g;
	public static ArrayList<String> bridge;
	
    public static void main(String[] args)throws Exception 
    {
        File f=new File("C:\\Users\\zipeng\\workspace\\Lab1\\src\\text.txt");
        FileInputStream fis=new FileInputStream(f);
        byte[] b=new byte[(int)f.length()];			
        fis.read(b);
        int len=(int)f.length();
        fis.close();
        al=new ArrayList<String>();
    	arr(b,len,al);
    	aq= new ArrayList<String>();       		
		Set<String> as=new HashSet<String>();
		as.addAll(al);
		Iterator<String> it = as.iterator();
		while(it.hasNext())
		{
			String a=it.next();
			aq.add(a);
		}	

		int s=aq.size(); 
		g = new EdgeWeightDiGraph(s);
		g.CreateGraph(al,aq);

    	ButtonTest BT = new ButtonTest();
    	BT.GUI();
    }
    
    public static void arr(byte[] b, int len, ArrayList<String> al)
    {
    	char c;
    	int c1;
    	String s="";
    	for(int i=0;i<len;i++)
    	{
    		c= (char)b[i];
    		c1 = (int)c;
    		if((c1 <= 90 && c1 >= 65) || (c1 <= 122 && c1 >= 97) || (c1 <= 57 && c1 >= 48))
    		{
    			if(c1 <= 122 && c1 >= 97)
    			{
    				s += c;
    			}
    			if(c1 <= 90 && c1 >= 65)
    			{
    				c1 += 32;
    				s += (char)c1;
    			}
    		}
    		else
    		{
    			if(s.equals("")){}
    			else
    			{
    				al.add(s);
    				s = "";
    			}
    		}
    	}
    	if(!s.equals(""))
    	{
    		al.add(s);
    	}
    }
    
    public static String calcShortestPath(String word1, String word2)
    {
    	String s = "";
    	if(aq.contains(word1) && aq.contains(word2))
    	{
    		DijkstraSP p = new DijkstraSP(g,word1);
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
    	else if(!aq.contains(word1) && aq.contains(word2))
    	{
    		s = "No ¡°" + word1 + "¡± in the graph!";
    	}
    	else if(aq.contains(word1) && !aq.contains(word2))
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

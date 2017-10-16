package t1;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.jgrapht.graph.DefaultEdge;
public class EdgeWeightDiGraph {
	
	public List<DirectedEdge>[] adj; // 邻接表矩阵  
    private int V; // 点的数目  
    private int E; // 边的数目  
	public static ArrayList<String> al;
	public static ArrayList<String> aq;
	public static EdgeWeightDiGraph g;
    public static void main(String[] args)throws Exception 
    {
    	int choose=0;
    	String word1, word2;
    	Scanner in=new Scanner(System.in);
        File f=new File("C:\\Users\\1\\workspace\\t1\\src\\text.txt");
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
		System.out.println(aq);
		int s=aq.size(); 
		g = new EdgeWeightDiGraph(s);
		g.CreateGraph(al,aq);
		ButtonTest bt = new ButtonTest();
		bt.GUI();
		//System.out.println(g.toString());
		//g.word("have","pen");
		//g.file();
		
		/*DijkstraSP p = new DijkstraSP(g,"i");
		String ad = "";
		double sum = 0;
		ArrayList<String> ad2 = new ArrayList<String>();
		for(DirectedEdge e : p.pathTo("apple"))
		{
			ad=ad + e.getSource()+"->";
			ad2.add(e.getTarget());
			sum+=e.weight();
		}
		ad += ad2.get(ad2.size()-1);
		System.out.println(ad+"\t"+sum);
		*/
		//ran a = new ran();
		//a.random();
		//show sg = new show();
		//sg.showG();
		//showtest st = new showtest();
		//st.showG();
		
		
    }
    
    
    public DirectedEdge containE(DirectedEdge e)
    {
    	String source = e.getSource();
    	String target = e.getTarget();
    	int i = aq.indexOf(source);
    	List<DirectedEdge> es=adj[i];
		int s3 = es.size();
		for(int j=0;j<s3;j++)
		{
			if(es.get(j).getTarget().equals(target))
			{
				return es.get(j);
			}
		}
		return null;
    }
    
    public void CreateGraph(ArrayList<String> al,ArrayList<String> aq)
    {   	
    	int s=aq.size(); 
    	int s2=al.size();
    	for(int i=0;i<s2-1;i++)
        	{
        		DirectedEdge e = new DirectedEdge(al.get(i),al.get(i+1),1);
        		if(containE(e)!=null)
            	{
   		
            		double w=containE(e).weight();
            		w+=1;      		     		
            		containE(e).setWeight(w);
            	}
            	else
            	{
            		if(!al.get(i).equals(al.get(i+1)))
            		{
            			addEdge(e);
            		}
            	}		
        	}
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

    public ArrayList<String> word(String a,String b)
    {
    	int pa=aq.indexOf(a);
    	int pb=aq.indexOf(b);
    	ArrayList<String> bridge = new ArrayList<String>();
    	//String bri = "";
    	if(pa!=-1 && pb!=-1)
    	{
    		List<DirectedEdge> es=adj[pa];
    		int s = es.size();
    		for(int i=0;i<s;i++)
    		{
    			DirectedEdge e = es.get(i);
    			String c = e.getTarget();		
    			int pc=aq.indexOf(c);
    			List<DirectedEdge> es2=adj[pc];
    			int s2 = es2.size();
    			for(int j=0;j<s2;j++)
    			{
    				DirectedEdge e2 = es2.get(j);
    				if(b.equals(e2.getTarget()))
    				{
    					bridge.add(c);
    				}
    			}
    		}
    	}
    	else if(pa==-1 && pb!=-1)
    	{
    		
    	}
    	else if(pa!=-1 && pb==-1)
    	{
    		
    	}
    	else
    	{
    		
    	}
    	//System.out.println(bridge);
    	//for(int i = 0;i<bridge.size();i++)
    	//{
    		//bri=bri + bridge.get(i) + ' ';
    	//}
    	return bridge;
    }
    
    public static ArrayList<String> StoA(String s)
    {
    	ArrayList<String> af=new ArrayList<String>();
    	String w="";
    	if(s.equals(""))
    	{
    		return af;
    	}
    	for(int i=0;i<s.length()-1;i++)
    	{
    		if(s.charAt(i)!=' ')
    		{
    			w+=s.charAt(i);
    		}
    		else
    		{
    			System.out.println(w);
    			af.add(w);
    			w="";
    		}	
    	}
    	af.add(w);
    	return af;
    }
    
    public void file()throws Exception 
    {
    	String FA="";
    	File f=new File("C:\\Users\\1\\workspace\\t1\\src\\text1.txt");
        FileInputStream fis=new FileInputStream(f);
        byte[] b=new byte[(int)f.length()];			
        fis.read(b);
        int len=(int)f.length();
        fis.close();
        ArrayList<String> af=new ArrayList<String>();
    	arr(b,len,af);
    	int s = af.size();
    	{
    		for(int i=0;i<s-1;i++)
    		{
    			ArrayList<String> bridge = word(af.get(i),af.get(i+1));
    			//ArrayList<String> bridge=new ArrayList<String>();
    			FA+=af.get(i)+" ";
    			if(!bridge.isEmpty())
    			{
    				FA+=bridge.get(0)+" ";
    			}
    		}
    		FA+=af.get(s-1);
    	}
    	System.out.println(af);
    	System.out.println(FA);
    }
    
    public String file2(String fff)
    {
    	String FA="";
    	
        ArrayList<String> af=new ArrayList<String>();
        int len=(int)fff.getBytes().length;
    	arr(fff.getBytes(),len,af);
    	int s = af.size();
    	{
    		for(int i=0;i<s-1;i++)
    		{
    			ArrayList<String> bridge = word(af.get(i),af.get(i+1));
    			//ArrayList<String> bridge=new ArrayList<String>();
    			FA+=af.get(i)+" ";
    			if(!bridge.isEmpty())
    			{
    				FA+=bridge.get(0)+" ";
    			}
    		}
    		FA+=af.get(s-1);
    	}
    	//System.out.println(af);
    	//System.out.println(FA);
    	return FA;
    }
    
	    public EdgeWeightDiGraph(int V) {  
	        this.V = V;  
	        E = 0;  
	        adj = (List<DirectedEdge>[]) new List[V];  
	        for (int i = 0; i < V; i++) {  
	            adj[i] = new ArrayList<>();  
	        }  
	    }  
	      
	    public void addEdge(DirectedEdge e) {  
	    	int i = aq.indexOf(e.getSource());
	        adj[i].add(e);  
	        E++;  
	    }  
	      
	    public int V() {  
	        return V;  
	    }  
	      
	    public int E() {  
	        return E;  
	    }  
	      
	    public Iterable<DirectedEdge> adj(int v) {  
	        return adj[v];  
	    }  
	      
	    public Iterable<DirectedEdge> edges() {  
	        List<DirectedEdge> edges = new ArrayList<>();  
	        for (int i = 0; i < V; i++) {  
	            for (DirectedEdge e : adj[i]) {  
	                edges.add(e);  
	            }  
	        }  
	        return edges;  
	    }  
	      
	    public String toString() {  
	        String s = V + " 个顶点, " + E + " 条边\n";  
	        for (int i = 0; i < V; i++) {  
	            s += aq.get(i) + ": ";  
	            for (DirectedEdge e : adj(i)) {  
	                s += e.getTarget() + " [" + e.weight() + "], ";  
	            }  
	            s += "\n";  
	        }  
	        return s;  
	    }  
	  
}

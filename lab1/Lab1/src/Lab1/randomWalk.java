package Lab1;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;

public class randomWalk  
{  
	List<DirectedEdge>[] adj; 
	Main main = new Main();
	List<DirectedEdge> path = new ArrayList<>();  
	String vertex = "";

	public String randomWalk()
	{
		int v = new Random().nextInt(main.aq.size());
		r(v);
		DirectedEdge e = path.get(path.size()-1);
		vertex += e.getTarget();
		System.out.println(vertex);
		return vertex;
	}
	public void write()throws Exception
	{
		File f = new File("C:\\Users\\zipeng\\workspace\\Lab1\\src\\textnew.txt");
    	FileOutputStream fos=new FileOutputStream(f);
    	fos.write(vertex.getBytes());
    	fos.close();
    	System.out.println("文本写入成功");
	}
	
	public void r(int v) 
	{  
		List<DirectedEdge> edges= new ArrayList<>(); 
		edges = main.g.adj[v];
		if(!edges.isEmpty())
		{
			int n = new Random().nextInt(edges.size());
			DirectedEdge e = edges.get(n);
			vertex = vertex + main.aq.get(v) + " ";
			int t = main.aq.indexOf(e.getTarget());
			
			if(!path.contains(e))
			{
				path.add(e);
				r(t);
			}
			else
			{
				path.add(e);
			}
		}
    }  
}

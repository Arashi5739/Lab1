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
	 public static void main(String[] args) throws Exception
	 {
	     Main m = new Main();
	     m.testmain();

	     ButtonTest BT = new ButtonTest();
	     BT.GUI();
	 }
	 
    public void testmain() throws Exception 
    {
        File f=new File("C:\\Users\\zipeng\\mygit\\Lab1\\src\\text.txt");
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
		Creategraph.CreateGraph(al,aq);

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
    

    

}

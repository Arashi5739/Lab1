package Lab1;

import java.io.IOException;

import java.io.File;
import java.io.FileOutputStream;

public class Graph 
{
	EdgeWeightDiGraph g;
	Main main = new Main();
	public  void showG() 
	{
		g = main.g;					
		GraphViz gViz=new GraphViz("C:\\Users\\zipeng\\Desktop\\pic", "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe");
	        gViz.start_graph();
	        for (int i = 0; i < g.V(); i++) 
	    	{  
	    	    for (DirectedEdge e : g.adj(i)) 
	    	    {  
	    	    	
	    	    	gViz.addln(e.getSource()+"->"+e.getTarget()+";");
	    	    }  
	    	}  
	        gViz.end_graph();
	        try {
	            gViz.run();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
		
	class  GraphViz{
	    private String runPath = "";
	    private String dotPath = ""; 
	    private String runOrder="";
	    private String dotCodeFile="dotcode.txt";
	    private String resultGif="dotGif";
	    private StringBuilder graph = new StringBuilder();
	
	    Runtime runtime=Runtime.getRuntime();
	
	    public void run() {
	        File file=new File(runPath);
	        file.mkdirs();
	        writeGraphToFile(graph.toString(), runPath);
	        creatOrder();
	        try {
	            runtime.exec(runOrder);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public void creatOrder(){
	        runOrder+=dotPath+" ";
	        runOrder+=runPath;
	        runOrder+="\\"+dotCodeFile+" ";
	        runOrder+="-T gif ";
	        runOrder+="-o ";
	        runOrder+=runPath;
	        runOrder+="\\"+resultGif+".gif";
	        System.out.println(runOrder);
	    }
	
	    public void writeGraphToFile(String dotcode, String filename) {
	        try {
	            File file = new File(filename+"\\"+dotCodeFile);
	            if(!file.exists()){
	                file.createNewFile();
	            }
	            FileOutputStream fos = new FileOutputStream(file);
	            fos.write(dotcode.getBytes());
	            fos.close();
	        } catch (java.io 
	
	.IOException ioe) { 
	            ioe.printStackTrace();
	        }
	     }  
	
	    public GraphViz(String runPath,String dotPath) {
	        this.runPath=runPath;
	        this.dotPath=dotPath;
	    }
	
	    public void add(String line) {
	        graph.append("\t"+line);
	    }
	
	    public void addln(String line) {
	        graph.append("\t"+line + "\n");
	    }
	
	    public void addln() {
	        graph.append('\n');
	    }
	
	    public void start_graph() {
	        graph.append("digraph G {\n") ;
	    }
	
	    public void end_graph() {
	        graph.append("}") ;
	    }   
} 

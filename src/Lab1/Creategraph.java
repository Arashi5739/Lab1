package Lab1;

import java.util.ArrayList;

public class Creategraph {
    public static void CreateGraph(ArrayList<String> al,ArrayList<String> aq)    //生成加权有向图
    {       
        for(int i=0;i<al.size()-1;i++)
            {
                DirectedEdge e = new DirectedEdge(al.get(i),al.get(i+1),1);
                if(EdgeWeightDiGraph.ContainEdge(e)!=null)
                {
                    double w = EdgeWeightDiGraph.ContainEdge(e).weight();
                    w += 1;                         
                    EdgeWeightDiGraph.ContainEdge(e).setWeight(w);
                }
                else
                {
                    if(!al.get(i).equals(al.get(i+1)))
                    {
                        EdgeWeightDiGraph.addEdge(e);
                    }
                }
            }
    } 


}

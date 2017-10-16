package Lab1;

public class DirectedEdge {  
    
    private double weight;  
    private String Source;  
    private String Target;  
      
    public DirectedEdge(String Source, String Target, double weight) {  
        this.Source = Source;  
        this.Target = Target;  
        this.weight = weight;  
    }  
      
    public String getSource() {  
        return Source;  
    }  
      
    public String getTarget() {  
        return Target;  
    }  
      
    public double weight() {  
        return weight;  
    }  
    
    public void setWeight(double weight) {  
        this.weight = weight;  
    }  
      
    public int compareTo(DirectedEdge e) {  
        if (weight > e.weight()) return 1;  
        if (weight < e.weight()) return -1;  
        return 0;  
    }  
      
    public String toString() {  
        String s = Source + " -> " + Target + ", weight: " + weight;  
        return s;  
    }  
  
}  

package Lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BridgeWordsTest {
    Main m;

    @Before
    public void setUp() throws Exception {
        m = new Main(); 
    }
    
    @Test
    public void testShortPath1() throws Exception {
        m.testmain();
        String s = DijkstraSP.calcShortestPath("big","time");
        String s2 = "big->data->time\t2.0";
        
        Assert.assertEquals("最短路径错误",s, s2);
    }
    
    @Test
    public void testShortPath2() throws Exception {
        m.testmain();
        String s = DijkstraSP.calcShortestPath("1","time");
        String s2 = "No “1” in the graph!";
        
        Assert.assertEquals("word1不存在",s, s2);
    }
    
    @Test
    public void testShortPath3() throws Exception {
        m.testmain();
        String s = DijkstraSP.calcShortestPath("data","bbb");
        String s2 = "No “bbb” in the graph!";
        
        Assert.assertEquals("word2不存在",s, s2);
    }
    
    @Test
    public void testShortPath4() throws Exception {
        m.testmain();
        String s = DijkstraSP.calcShortestPath("aaa","");
        String s2 = "No “aaa” and “” in the graph!";
        
        Assert.assertEquals("word1，2不存在",s, s2);
    }
    

    @Test
    public void testBridgeWord1() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("big","time");
        String s2 = "The bridge words from “big” to “time” is:[data]";
        
        Assert.assertEquals("存在桥接词",s, s2);
    }

    @Test
    public void testBridgeWord2() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("big","data");
        String s2 = "No bridge words from “big” to “data”!";
        
        Assert.assertEquals("桥接词不存在",s, s2);
    }
    
    @Test
    public void testBridgeWord3() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("is","data");
        String s2 = "No “is” in the graph!";
        
        Assert.assertEquals("word1不存在",s, s2);
    }
    
    @Test
    public void testBridgeWord4() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("big","aaaa");
        String s2 = "No “aaaa” in the graph!";
        
        Assert.assertEquals("word2不存在",s, s2);
    }
    
    @Test
    public void testBridgeWord5() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("bbbb","aaaa");
        String s2 = "No “bbbb” and “aaaa” in the graph!";
        
        Assert.assertEquals("word1，2不存在",s, s2);
    }
    
    @Test
    public void testBridgeWord6() throws Exception {
        m.testmain();
        BridgeWords b = new BridgeWords();
        String s = b.queryBridgeWords("of","in");
        String s2 = "The bridge words from “of” to “in” are:[the, services]";
        
        Assert.assertEquals("存在多个桥接词",s, s2);
    }
    
   
}


package Lab1;

import java.util.ArrayList;

public class NewText {

	public String generateNewText(String inputText)
    {
		BridgeWords BW = new BridgeWords();
		Main main = new Main();
		String FA="";
		int len=(int)inputText.getBytes().length;
        ArrayList<String> af=new ArrayList<String>();
    	main.arr(inputText.getBytes(),len,af);
    	int s = af.size();
		for(int i=0;i<s-1;i++)
		{
			ArrayList<String> bridge = BW.BridgeWord(af.get(i),af.get(i+1));
			FA += af.get(i)+" ";
			if(!bridge.isEmpty())
			{
				FA += bridge.get(0)+" ";
			}
		}
		FA += af.get(s-1);
    	return FA;
    }
}

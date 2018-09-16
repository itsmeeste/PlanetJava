
public class main 
{
	public static void main(String [] args)
	{
		table t = new table();
		//t.findElement("Sveggjerium","Ee",false);
		//t.findElement("Zockurijirium","Zr",false);
		//t.findElement("Jeffkanium","Kn",false);
		//t.findElement("Jefftzlon","Zt",false);
		//t.findElement("Jeffntzum","Nn",false);
		//t.findElement("Tuffjeffium","Ty",false);
		
		//System.out.println("ALPHABETICAL ORDER");
		//t.findElement(" Gozerium","ie",true);
		
		//t.FindElementOrder("iron");
		t.ReadFile("test.txt");
		t.PrintHashMap();
		
		
		
		
	}

}

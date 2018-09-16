import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class table 
{
	HashMap<String,String> elements = new HashMap<String,String>();
	public boolean findElement(String name,String con,boolean alpha)
	{
		name = name.toLowerCase();
		con = con.toLowerCase();
		if(alpha)
		{
			con = alphabeticalOrder(con);
		}
		// checks for the input 
		if(con.length() > name.length() || con.length() < 2)
		{
			System.out.println("Name: " + name + ", Con: " + con + ", Found: False");
			return false;
			
		}
		int first = name.indexOf(con.charAt(0));
		int second = name.lastIndexOf(con.charAt(1));
		
		
		if(first != -1 && second != -1)
		{
			if(second > first)
			{
				System.out.println("Name: " + name + ", Con: " + con + ", Found: True");
				return true;
			}
		}
		
		
		System.out.println("Name: " + name + ", Con: " + con + ", Found: False");
		return false;
	}
	
	public String alphabeticalOrder(String input)
	{
		if(input.length() < 2)
			return input;
		int c1 = input.charAt(0);
		int c2 = input.charAt(1);
		
		if(c2 < c1)
		{
			
			return input.substring(1) + input.substring(0,1);
		}
		return input;
	}
	
	public void FindElementOrder(String name)
	{
		for(int i =0; i < name.length()-1; i++)
		{
			for(int j = 1; j < name.length(); j++)
			{
				if(i == j || j < i)
					continue;
				if(CheckHashMap(name.substring(i,i+1) + name.substring(j,j+1),name))
					return;
				//System.out.println(name.substring(i,i+1) + name.substring(j,j+1));
			}
		}
		return;
	}
	
	public boolean CheckHashMap(String input,String name)
	{
		if(elements.get(input) == null)
		{
			System.out.println("ADDED " + input + ", " + name);
			elements.put(input, name);
			return true;
		}
		return false;
	}
	
	public void ReadFile(String filename)
	{
		try
		{
			File f2 = new File(filename);
			FileReader fr = new FileReader(f2);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null)
			{
				FindElementOrder(line);
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void PrintHashMap()
	{
		File file = new File("output.txt");
		  
		try
		{
			//Create the file
			if (file.createNewFile())
			{
			    System.out.println("File is created!");
			} else {
			    System.out.println("File already exists.");
			}
			 
			//Write Content
			FileWriter writer = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(writer);
			elements.forEach((key, value) -> {
				try {
					br.write(key + ":" + value + "\n");
					br.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			br.close();
			writer.close();
		
		}
		catch(Exception e)
		{
			
		}
	}

}

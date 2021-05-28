package medifilehandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVFILE {
	public CSVFILE()
	{
		
	}
	public void writecsv(String values,String path)
	{
		try(PrintWriter w = new PrintWriter(new FileWriter(path,true))){
			StringBuilder sd =new StringBuilder();
			sd.append(values);
			sd.append('\n');
			w.write(sd.toString());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	public ArrayList<String[]> readcsv(String path)
	{
		String line="";
		String splitby=",";
		
		ArrayList<String[]> arraylist= new ArrayList<>();
		try(BufferedReader br =new BufferedReader(new FileReader(path)) )
		{
			ArrayList<String> head= new ArrayList<>();
			int count=0;
			while((line=br.readLine())!=null)
			{
				count++;
				String[] linearray =line.split(splitby);
				if(count==1)
				{
					for(int i=0;i<linearray.length;i++)
					{
						head.add(linearray[i]);
					}
				}
				else
				{
					arraylist.add(linearray);
				}
				
			}
		}
		catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		return arraylist;
	}
	

	public void createFirestcsv(String path,String values)
	{
		File f=new File(path);
		File parent=f.getParentFile();
		if(!parent.exists()&&!parent.mkdir())
		{
			throw new IllegalStateException("couldnt ceate dir"+parent);
			
		}
		if(!f.exists())
		{
			try(PrintWriter w=new PrintWriter(new FileWriter(path,true)))
			{
				StringBuilder sb=new StringBuilder();
				sb.append(values);
				sb.append('\n');
				w.write(sb.toString());
				
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}

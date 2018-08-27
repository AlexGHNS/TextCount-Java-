package NA.TextCount;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) 
    {
    	String path="C:\\Users\\PSIH\\eclipse-workspace\\TextCount\\src\\main\\resources\\InputText";
        String[] subStr;
        ArrayList<String> words = new ArrayList<String>();
    	try 
       		{
    	   	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
	       	subStr=AddStringArr(reader);
    	   	words=ArrayWords(subStr);
    	   	WordsCount(words);
		    reader.close();
      		}
    	catch (Exception e) 
       		{
			System.out.println( "File not found!/Файл не найден!" );
       		}
    }
    
    //Считывает текст построчно и записывает слова в массив subStr типа String
    public static String[] AddStringArr(BufferedReader reader) throws IOException
    {
    	String line;
    	String text="";
    	String[] subStr;
        while ((line = reader.readLine()) != null) 
    	{
    		text+=line+" ";
    	}
   	subStr = text.split(" ");
    return subStr;	
    }
    
    //Добавляет в коллекцию words типа ArrayList<String> все элементы из массива subStr
    public static ArrayList<String> ArrayWords(String[] subStr)
    {
    	ArrayList<String> words = new ArrayList<String>();
    	for(int i = 0; i < subStr.length; i++) 
    	{ 
        	words.add(subStr[i]);
    	}
   		return words;
    }
    
    //Записывает в ассоциативный массив couterMap типа Map<String, Long> значения из коллекции words и производит их группировку.
    public static void WordsCount(ArrayList<String> words)
    {
    	Map<String, Long> couterMap = words.stream().collect(Collectors.groupingBy(e -> e.toString(),Collectors.counting()));
	    System.out.println(couterMap);
    }
}

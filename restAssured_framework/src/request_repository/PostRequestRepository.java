package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import common_method.Get_Data;

public class PostRequestRepository
{
	
	public static String baseuri()
	{
		String baseuri = "https://reqres.in/";
		return baseuri;
	}
	public static String resource ()
	{
		String resource = "api/users";
		return resource;
	}
    public static String postRequestTC1 () throws IOException
    {
    	ArrayList<String> data = Get_Data.getdataexcel("Post_data", "tc1");
    	System.out.println(data);
    	String Name = data.get(2);
    	String Job = data.get(3);
    	String requestBody = "{\r\n"
    			+ "    \"name\": \""+Name+"\",\r\n"
    			+ "    \"job\": \""+Job+"\"\r\n"
    			+ "}";
    	return requestBody;
    	
    }
    
}



package test_class;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodPut;
import common_method.CommonMethodUtilities;
import io.restassured.path.json.JsonPath;
import request_repository.PutRequestRepository;

public class PutTc1 {
	
	@Test
	public static void orchestrator() throws IOException
	{    
		String responseBody = "" ;
		int responseStatuscode = 0;
		String baseUri = PutRequestRepository.baseuri();
		String resource = PutRequestRepository.resource();
		String requestBody = PutRequestRepository.putRequestTC1();
		for(int i=0 ; i<5 ; i++) 
        {
		 responseStatuscode = CommonMethodPut.responseStatuscode_Extractor(baseUri, resource, requestBody);
          if (responseStatuscode == 200)
		  {
        	  responseBody = CommonMethodPut.responseBodyExtractor(baseUri, resource, requestBody);
			responseBodyValidator(responseBody);
			
			break;
	      }
          else
          {
        	  System.out.println("correct status code is not found in the iteration " + i);
          }
        } 
		CommonMethodUtilities.evidenceFilecreator("Put Tc1", requestBody, responseBody);
		AssertJUnit.assertEquals(responseStatuscode, 200);
		
     }

    public static void responseBodyValidator(String responseBody)
	{
		// create jsonPath object to extract responseBody parameters
		JsonPath jsp = new JsonPath(responseBody);

		// extract responseBody parameters
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_updatedAt = jsp.getString("updatedAt");

		//System.out.println("name : " + res_name + "\njob : " + res_job  + "\nupdatedAt : " + res_updatedAt);

		// validate responsBody parameter
		AssertJUnit.assertEquals(res_name, "morpheus");
		AssertJUnit.assertEquals(res_job, "zion resident");
		

		// extract date from createdAt parameter
		String actual_date = res_updatedAt.substring(0, 10);
		String current_date = LocalDate.now().toString(); 
		AssertJUnit.assertEquals(actual_date, current_date);
		//System.out.println("Actual DATE : " + actual_date + "\nCURRENT DATE : " + current_date);

	}

}

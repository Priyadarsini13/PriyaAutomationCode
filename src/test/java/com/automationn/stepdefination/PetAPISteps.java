package com.automationn.stepdefination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import com.automation.pojo.pet.Category;
import com.automation.pojo.pet.PetAPIResponse;
import com.automation.pojo.pet.PetInfo;
import com.automation.pojo.pet.Tag;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetAPISteps {

	public PetInfo createPetClass(Map<String, String> petData) {
		
		 
		List<Category> cate = new ArrayList<>();
		Category category = new Category(Integer.parseInt(petData.get("categoryId")),petData.get("categoryName"));
		cate.add(category);
		List<String> photoUrls = new ArrayList<>();
		photoUrls.add(petData.get("photoUrls"));
		List<Tag> tags = new ArrayList<>();
		Tag tagData = new Tag(Integer.parseInt(petData.get("tagsId")),petData.get("tagsName"));
		tags.add(tagData);
		PetInfo petInfo = new PetInfo(Integer.parseInt(petData.get("petId")),category,petData.get("petName"),photoUrls,tags,petData.get("status"));
		List<PetInfo> pet = new ArrayList<>();
		pet.add(petInfo);
		return petInfo;
	}

	public Response createPetRequest(String url, PetInfo petInfo) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(url, "application/json", petInfo);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().post();
		return res;
		
	}
	
	public PetInfo validatePetInfoIsAdded(Response res) {
		PetInfo petInfo = petResponseDeSerialization(res);
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
		return petInfo;
	}

	private PetInfo petResponseDeSerialization(Response res) {
		return res.as(PetInfo.class);
	}
	
	public PetInfo fetchPetInfoById(String url,String petId) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(url + "/" + petId, "application/json", null);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().get();
		PetInfo expectedResponse = res.as(PetInfo.class);
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
		return expectedResponse;
		
	}

	public PetAPIResponse uploadImageOfPetById(String image, String petUrl, String petId) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(petUrl + "/" + petId+"/uploadImage",image);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().post();
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());	
		return res.as(PetAPIResponse.class);
	}

	public PetAPIResponse deletePetInfoById(String petUrl, String petId) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(petUrl + "/" + petId, "application/json", null);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().delete();
		PetAPIResponse expectedResponse = res.as(PetAPIResponse.class);
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
		res = requestSpec.when().get();
		Assert.assertEquals("Verify pet record is deleted!", 404, res.getStatusCode());
		return expectedResponse;
	}

	public PetInfo updatePetRequest(String petUrl, PetInfo toBeUpdated) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(petUrl,"application/json",toBeUpdated);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().put();
		PetInfo expectedResponse = res.as(PetInfo.class);
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
		return expectedResponse;
	}

	public PetInfo[] findPetInfoByStatus(String petUrl) {
		APIRequestBuilder apiRequestBuilder = new APIRequestBuilder(petUrl,"application/json",null);
		RequestSpecification requestSpec = apiRequestBuilder.getRequestSpecification();
		requestSpec = RestAssured.given().spec(requestSpec);
		Response res = requestSpec.when().get();
		PetInfo[] expectedResponse = res.as(PetInfo[].class);
		Assert.assertEquals("Status Check Passed!", 200, res.getStatusCode());
		return expectedResponse;
	}
	
	
}

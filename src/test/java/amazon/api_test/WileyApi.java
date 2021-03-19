package amazon.api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WileyApi {
    RequestSpecification httpRequest;
    Response response;

    @Test
    public void getJavaSearchResults() {
        RestAssured.baseURI = "https://www.wiley.com/en-us/search/autocomplete/";
        httpRequest= RestAssured.given();

        response = httpRequest.queryParam("term","Java").request(Method.GET, "/comp_00001H9J");
        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        Assert.assertEquals(bodyAsString.contains("term") , true , "Suggestions is:<span class=\"search-highlight\">java</span>");
        Assert.assertEquals(bodyAsString.contains("Wiley") , true , "Response body contains Wiley");

       // JsonPath jsonPath=response.jsonPath();
       // Assert.assertEquals(jsonPath.get("title"),"Wiley");

        /*String record=jsonPath.getString("title");
        Assert.assertEquals(record,"Wiley");*/

        /*String responseBody=response.getBody().asString();
        Assert.assertEquals(responseBody.contains("Wiley"),true);
        Assert.assertEquals(responseBody.contains("term"),true);*/


    }

    @Test
    public void postDynamicDelay() {
        RestAssured.baseURI = "https://httpbin.org/delay";
        httpRequest= RestAssured.given();

        response = httpRequest.request(Method.POST, "/5");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getImageWithTypePng() {
        RestAssured.baseURI = "https://httpbin.org/image/png";
        httpRequest= RestAssured.given();

        response = httpRequest.request(Method.GET);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

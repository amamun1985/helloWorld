package amazon.api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WileyApiTC3 {
    private static final Logger LOGGER= LogManager.getLogger(WileyApiTC3.class);
    @Test
    public void getImage(){
        RestAssured.baseURI="https://httpbin.org/#/Images/get_image_png";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().prettyPrint());
        LOGGER.debug("Actual status code : "+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),200);

 /*       JsonPath jsonPath=response.jsonPath();
        String record=jsonPath.getString("suggestions[5]");
        Assert.assertNotNull(record,"user record is null");*/
    }
}

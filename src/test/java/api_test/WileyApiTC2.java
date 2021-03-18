package amazon.api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WileyApiTC2 {
    private static final Logger LOGGER= LogManager.getLogger(WileyApiTC2.class);
    @Test(priority = 1)
    public void postCall(){

        RestAssured.baseURI="https://httpbin.org/#/Dynamic_data/post_delay__delay_ ";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject rowJsonBodyObject=new JSONObject();//we need to create obj for json row body
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(rowJsonBodyObject.toJSONString());
        LOGGER.debug("Request body : "+rowJsonBodyObject);
        Response response=httpRequest.request(Method.POST);
        LOGGER.debug(response.getBody().asString());//or down line
        //LOGGER.debug(response.getBody().prettyPrint());
        //this is the status of body response of status
        LOGGER.debug("Actual status code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),201);


        /*//now validate the jsonPath from response
        JsonPath jsonPath=response.jsonPath();
        //validate the user record is not null
        String record=jsonPath.getString("name");
        Assert.assertEquals(record,userName);*/
    }
}

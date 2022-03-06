import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class restApi {
    Response response;
    @Test
    public void getMapLocation() {
        response = given().log().all().get("http://api.positionstack.com/v1/forward?access_key=e31effaa611e43656fed10673266a5dc&query=1600%20Pennsylvania%20Ave%20NW,%20Washington%20DC");
        response.then().assertThat().statusCode(200);
        System.out.println(response.getBody().prettyPrint());
    }

}




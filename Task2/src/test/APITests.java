package Task2;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITests {

	@Test(dataProvider = "BooksData", priority = 1)
	public void validateBookingIsCreatedSuccessfully(String checkin, String checkout) throws IOException {
		String jsonString = "{\"bookingdates\": " + "{ " + "\"checkin\":" + '"' + checkin + "\"," + "\"checkout\":"
				+ '"' + checkout + "\"" + "}," + " \"bookingid\": 11, \"depositpaid\": true,"
				+ " \"email\": \"mohamed_sabry007@yahoo.com\", " + "\"firstname\": \"mohamed\","
				+ " \"lastname\": \"mahran\", " + "\"phone\": \"+201284774770\", " + "\"roomid\": 12}";
		// Test that bookings can be created as same as below
		RestAssured.given().baseUri("https://automationintesting.online/booking/")
				.header("Content-Type", "application/json").body(jsonString)
				// WHEN
				.when().post()
				// THEN
				.then().assertThat().statusCode(201);

	}

	@Test(priority = 2)
	public void validateBookingDetailsIsDisplayedSuccessfully() {

		Response res = given().baseUri("https://automationintesting.online/booking/").when().get("/?roomid=12").

				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();

		String responseString = res.asString();
		System.out.println(responseString);
		JsonPath js = rawToJson(responseString);

		int count = js.get("bookings.size()");
		int roomID = 0;
		String firstname = "";
		String lastname = "";

		for (int i = 0; i < count; i++) {
			//
			roomID = js.get("bookings[" + i + "].roomid");
			firstname = js.get("bookings[" + i + "].firstname");
			lastname = js.get("bookings[" + i + "].lastname");
		}
		// Test that at least 2 existing bookings are returned in the response.
		System.out.println(count);
		assertEquals(count, 2);

		// Test that the data returned for an existing booking matches
		assertEquals(roomID, 12);
		assertEquals(firstname, "mohamed");
		assertEquals(lastname, "mahran");
	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object[][] { { "2019-02-25", "2019-02-26" }, { "2020-03-26", "2020-03-27" } };
	}
	public static JsonPath rawToJson(String responseString)
	{
		
		String respons=responseString.toString();
		
		JsonPath x = new JsonPath(respons);
		
		return x; 
    }
}

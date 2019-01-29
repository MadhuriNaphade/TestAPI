package WeatherDetails;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class getRequestData {
	//String URL = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	//Response res;
	Response res=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	@BeforeTest
	@Given("User is on Home Page")
	public void getresponse()
	{
	System.out.println(res);
	}
	@When("the status code is 200")
	@Test(priority=0)
	public void getresponsecode()
	{
		int code = res.getStatusCode();
		System.out.println("Status code is " +" "+ code );
		Assert.assertEquals(code,200);
	}
	@Test(priority=1)
	@Then("Get the Weather Details")
	public void getWeatherData()
	{
		String data = res.asString();
		System.out.println("Data is" + data);
		
	}
}

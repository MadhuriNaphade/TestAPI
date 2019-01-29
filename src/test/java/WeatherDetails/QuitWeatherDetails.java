package WeatherDetails;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.response.Response;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class QuitWeatherDetails {
	Response res=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	@Test(priority=2)
	@When("Got the weather details")
	public void DoneWeather()
	{
	//retrieved data
		String weatherdetails = res.jsonPath().getString("weather");
		System.out.println("Weather Details = >" + weatherdetails);
	}
	@AfterTest
	@Then("quit successfully")
	public void CloseConnection()
	{
		ConnectionConfig connectionConfig = new ConnectionConfig();
		connectionConfig.closeIdleConnectionsAfterEachResponseAfter(10, TimeUnit.MILLISECONDS);
		System.out.println("Connection closed");
	}
}

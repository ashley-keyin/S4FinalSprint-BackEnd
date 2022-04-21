package com.S4FinalSprint.CustomerAPI;

import com.S4FinalSprint.CustomerAPI.domain.Customer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

@SpringBootTest
class CustomerApiApplicationTests {
	@Test
	void contextLoads() {
	}
	private static final String API_ROOT = "http://localhost:8080/customer";
	private Customer createRandomCustomer(){
		Customer customer = new Customer();
		customer.setId(5);
		customer.setFirstName("Dryden");
		customer.setLastName("Bussey");
		customer.setAddress("createCustomerAsUri");
		customer.setEmail("d@b.com");
		customer.setPhoneNumber("700-300-4000");
		customer.setCity("St.John's");
		customer.setCountry("Canada");
		customer.setAccountBalance("1000.00");
		return customer;
	}
	private String createCustomerAsUri(Customer customer) {
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(customer)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("Id");
	}
	@Test
	public void whenGetAllCustomers_thenOK() {
		Response response = RestAssured.get(API_ROOT);
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByFirstName_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByFirstName?firstName=Hale");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByLastName_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByLastName?lastName=Borrington");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByEmail_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByEmail?email=hborrington0@usda.gov");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByPhoneNumber_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByPhoneNumber?phoneNumber=261-757-2241");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByAddress_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByAddress?address=810 Lien Point");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByCity_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByCity?city=Canga’an");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByCountry_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByCountry?country=Indonesia");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetCustomerByAccountBalance_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/search/findByAccountBalance?accountBalance=$1178.79");
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}




	@Test
	public void whenMemberIdDoesNotExist_thenNotFound(){
		Response response = RestAssured.get(API_ROOT + Math.floor(Math.random()*(5000-4000+1)+4000));
		Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}
}

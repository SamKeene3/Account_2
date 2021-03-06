package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository acc;

	private static final String MOCK_OBJECT1 = "{\"id\":1,\"account_number\":\"12\",\"first_name\":\"brian\",\"last_name\":\"k\"}";
	private static final String MOCK_OBJECT2 = "{\"id\":2,\"account_number\":\"12\",\"first_name\":\"Molly\",\"last_name\":\"k\"}";
	private static final String MOCK_OBJECT3 = "{\"id\":3,\"account_number\":\"12\",\"first_name\":\"Mike\",\"last_name\":\"k\"}";
	private static final String MOCK_OBJECT4 = "{\"id\":4,\"account_number\":\"12\",\"first_name\":\"Sam\",\"last_name\":\"k\"}";

	@Before
	public void setup() {
		acc = new AccountMapRepository();

	}

	@Test 
	public void addAccountTest() {
		String reply = acc.createAccount(MOCK_OBJECT1);
		Assert.assertEquals(reply, "Account Created");
	}

	@Test
	@Ignore 
	public void add2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void removeAccountTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountsTest() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");
	}

	@Test
	@Ignore
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	@Ignore
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		Assert.assertEquals(0, acc.checkName("James"));

	}

	@Test

	public void getCountForFirstNamesInAccountWhenOne() {

		String input1 = acc.createAccount(MOCK_OBJECT1); 
		String input2 = acc.createAccount(MOCK_OBJECT2);
		Assert.assertEquals(1, acc.checkName("John"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		String input3 = acc.createAccount(MOCK_OBJECT3);
		String input4 = acc.createAccount(MOCK_OBJECT4);
		Assert.assertEquals(2, acc.checkName("John"));
	}

	@Test
	public void getOneAccountMap() {
		Long id = (long) 1;
		String input1 = acc.createAccount(MOCK_OBJECT1);
		String input2 = acc.createAccount(MOCK_OBJECT2);
		String input3 = acc.createAccount(MOCK_OBJECT3);
		String input4 = acc.createAccount(MOCK_OBJECT4);
		Assert.assertEquals("{\"id\":1,\"account_number\":\"12\",\"first_name\":\"Jamie\",\"last_name\":\"d\"}",
				acc.getOneAccount(id));

	}
}
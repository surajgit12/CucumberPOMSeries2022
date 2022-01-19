package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String username =credList.get(0).get("username");
		String password =credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage =loginpage.doLogin(username, password);
	
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title =accountPage.getaccountPageTitle();
		System.out.println("Account Page tile is "+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable SectionList) {
		
		List<String>ExpectedAccountList =SectionList.asList();
		System.out.println("Expected Account List Section" +ExpectedAccountList);
		
		List<String> actualAccountSectionList = accountPage.getAccountsSectionList();
		System.out.println("Expected Account List Section" +actualAccountSectionList);
		
		Assert.assertTrue(ExpectedAccountList.containsAll(actualAccountSectionList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedSectionCount) {

		Assert.assertTrue(accountPage.getAccountsSectionCount()==ExpectedSectionCount );
	}

}

package stepDefinitions;

        import com.codoid.products.exception.FilloException;
        import io.cucumber.java.After;
        import io.cucumber.java.Before;
        import io.cucumber.java.Scenario;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.chrome.ChromeDriver;
        import pageObjects.EMemo;
        import pageObjects.bankislamiClass;
        import pageObjects.baseClass;
        import java.io.IOException;

public class steps extends baseClass {
    protected Scenario scenario;
    bankislamiClass bank = new bankislamiClass();
    EMemo memo = new EMemo();

    @Before
    public void Setup(Scenario s){
        this.scenario=s;
        System.out.println("Scenario Start Running");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver/chromedriver.exe");
        System.out.println("Scenario got 001");

        driver=new ChromeDriver();
        System.out.println("Scenario got 002");

        driver.manage().deleteAllCookies();
        System.out.println("Scenario got 003");

        driver.manage().window().maximize();
        System.out.println("Scenario got 004");

    }

    @After
    public void addScreenshot(Scenario scenario){
        //validate if scenario has failed
        if(scenario.isFailed()) {
            System.out.println("Scenario got failed");
            TakesScreenshot tss = (TakesScreenshot) driver;
            final byte[] screenshot =tss.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getClass().getSimpleName());
        }
//        driver.quit();
    }

    //////////////////////// Open bank islami website ////////////////////////

    @When("open url {string}")
    public void open_url(String url) {
        System.out.println("Scenario got 005");
        System.out.println(url);
        System.out.println("Scenario got 006");
        System.out.println(driver);
        System.out.println("Scenario got 007");
        driver.get(url);
        System.out.println("Scenario got 008");
    }
    @When("enter keyword in search textbox and click on enter")
    public void enter_keyword_in_search_textbox_and_click_on_enter() {
        bank.Search_Box(); System.out.println("Scenario got 009");
    }

    @Then("search page title should be {string}")
    public void search_page_title_should_be(String string) {
        System.out.println("Scenario got 010");
        driver.getTitle();
        System.out.println("Scenario got 0011");
        System.out.println("Title is :: "+driver.getTitle());
        System.out.println("Scenario got 012");
    }
    @Then("click on link")
    public void click_on_link() {
        bank.Search_Result();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        driver.getTitle();
        System.out.println("Title is :: "+driver.getTitle());
    }

    //////////////////////// Login to EMemo website ////////////////////////

    @When("click on dropdown and select form")
    public void click_on_dropdown_and_select_form() throws InterruptedException {
        memo.Select_Form();
//        Thread.sleep(2000);
    }

    @Then("enter login details")
    public void enter_login_details() throws IOException {
        memo.GetLogin();
    }

    @Then("click on sign in button")
    public void click_on_sign_in_button() {
        memo.Signin_Btn();
    }

    @Then("open New EMeme and fill the form and click on submit button")
    public void open_new_e_meme_and_fill_the_form_and_click_on_submit_button() throws IOException {
        memo.ProcessMultipleRecords();
    }

    @Then("click on My EMemo")
    public void click_on_my_e_memo() {
        memo.My_EMemo();
    }
}

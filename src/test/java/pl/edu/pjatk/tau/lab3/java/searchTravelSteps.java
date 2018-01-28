/* package pl.edu.pjatk.tau.lab3.java;

import pl.edu.pjatk.tau.lab1.domain.Travel;
import pl.edu.pjatk.tau.lab1.service.TravelManagerImpl;
import pl.edu.pjatk.tau.lab2.service.TravelCheck;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class searchTravelSteps {

    private TravelManagerImpl travelManagerImpl = new TravelManagerImpl();
    private TravelCheck travelCheck = new TravelCheck();
    private List<Travel> searchForRecords;



    @Given("a data source")
    public void dataSource(){
        travelCheck.setData(travelManagerImpl);
    }

    @Given("^I have data and 3 records on the list$")
    public void threeTravels(){
        travelManagerImpl.create (new Travel(5, "Paris", "Gdansk", 405));
        travelManagerImpl.create (new Travel(6, "Gdansk", "Porto", 118));
        travelManagerImpl.create (new Travel(7, "Split", "New York", 1999));

    }

    @When("^I want find one of them.$xyz")
    public void lookingForRecord (String xyz) throws NoSuchFieldException{
        xyz = "New York";
        searchForRecords = travelCheck.findRecordsByRegex(xyz);

    }

    @Then("^I should find one of them.$")
    public void recordShouldBeFound(int num){
        Assert.assertTrue(searchForRecords.size() >= 1);
    }
}

*/
/* package pl.edu.pjatk.tau.lab3.java;

import pl.edu.pjatk.tau.lab1.domain.Travel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.ArrayList;

public class deleteTravelSteps {

    List<Travel> travelList = new ArrayList<Travel>();


    @Given("I have data and 3 records on the list")
    public void threeTravels(){
        Travel t5 = new Travel(5, "Paris", "Gdansk", 405);
        Travel t6 = new Travel(6, "Gdansk", "Porto", 118);
        Travel t7 = new Travel(7, "Split", "New York", 1999);
        travelList.add(t5);
        travelList.add(t6);
        travelList.add(t7);

    }

    @When("I gonna delete one of them")
    public void deletingRecord() throws NoSuchFieldException {
        travelList.remove(2);
    }

    @Then("^As a result theres should be 2 records$")
    public void checkRecords() {
        Assert.assertTrue(travelList.size()==2);
    }
}

*/
package pl.edu.pjatk.tau.lab3.java;

import pl.edu.pjatk.tau.lab1.domain.Travel;
import pl.edu.pjatk.tau.lab1.service.TravelManager;
import pl.edu.pjatk.tau.lab1.service.TravelManagerImpl;
import pl.edu.pjatk.tau.lab2.service.TravelCheck;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.ArrayList;

public class Test {

    private TravelManagerImpl travelManagerImpl = new TravelManagerImpl();
    private TravelCheck travelCheck = new TravelCheck();
    private List<Travel> searchForRecords;

    @Given("a data source")
    public void dataSource(){
        travelCheck.setData(travelManagerImpl);
    }

    @Given("I have data and 3 records on the list")
    public void fewAlbums(){
        travelManagerImpl.create(new Travel(3, "Gdansk", "London", 89));
        travelManagerImpl.create(new Travel(3, "Gdansk", "London", 89));
        travelManagerImpl.create(new Travel(3, "Gdansk", "London", 89));
    }


    @When("I want find one of them.")
    public void lookingForRecord() throws NoSuchFieldException{
        searchForRecords = travelCheck.findRecordsByRegex("Gdansk");
    }

    @Then("I should find one of them.")
    public void recordShouldBeFound(){
        Assert.assertTrue(searchForRecords.size() >= 1);
    }


}


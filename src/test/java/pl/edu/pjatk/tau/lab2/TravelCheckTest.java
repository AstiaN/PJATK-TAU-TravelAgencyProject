package pl.edu.pjatk.tau.lab2;

import pl.edu.pjatk.tau.lab1.service.TravelManager;
import pl.edu.pjatk.tau.lab1.domain.Travel;
import pl.edu.pjatk.tau.lab2.service.TravelCheck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.BDDMockito;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TravelCheckTest {
    private TravelCheck travelCheck = new TravelCheck();

    @Mock
    private TravelManager mockManager;

    @Before
    public void setup(){
        assertNotNull(mockManager);
        travelCheck.setDataSource(mockManager);
    }
    @Test
    public void testFindRecordsByRegex() throws NoSuchFieldException {
        // mock creation
        Travel t1= new Travel(1, "Paris", "Gdansk", 405);
        Travel t2 = new Travel(2, "Gdansk", "Porto", 118);

        List<Travel> travelList = asList(t1, t2);

        // using mock object - it does not throw any "unexpected interaction" exception
        when(mockManager.readAll()).thenReturn(travelList);
        List<Travel> foundRecords = travelCheck.findRecordsByRegex("Porto");

        // selective, explicit, highly readable verification
        verify(mockManager).readAll();
        Assert.assertTrue(foundRecords.size() == 1);
    }

    @Test
    public void testDeleteRecords(){
        // mock creation
        Travel t3 = new Travel(3, "Paris", "Gdansk", 405);
        Travel t4 = new Travel(4, "Gdansk", "Porto", 118);

        List<Travel> listOfTravels = asList(t3, t4);

        // using mock object - it does not throw any "unexpected interaction" exception
        travelCheck.deleteRecords(listOfTravels);

        // selective, explicit, highly readable verification
        verify(mockManager).delete(t3);
        verify(mockManager).delete(t4);
    }

    @Test
    public void testFindRecordsByRegexWithMistakenRegex(){

        Travel t5 = new Travel(5, "Paris", "Gdansk", 405);
        Travel t6 = new Travel(6, "Gdansk", "Porto", 118);
        Travel t7 = new Travel(7, "Split", "New York", 1999);

        List<Travel> bladesTestList = new ArrayList<Travel>(Arrays.asList(t5, t6, t7));

        BDDMockito.given(mockManager.readAll()).willReturn(bladesTestList);
        String regexString = "new york";

        List<Travel> TravelRegex = travelCheck.findRecordsByRegex(regexString);

        Assert.assertEquals(0, TravelRegex.size());

    }
}

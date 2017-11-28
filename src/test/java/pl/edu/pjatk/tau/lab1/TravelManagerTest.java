package pl.edu.pjatk.tau.lab1;


import org.junit.Test;
import junit.framework.TestCase;

import pl.edu.pjatk.tau.lab1.domain.Travel;
import pl.edu.pjatk.tau.lab1.service.TravelManagerImpl;



/**
 * Unit test for simple App.
 */

public class TravelManagerTest
    extends TestCase {
    @Test
    public void testCreate() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t1 = new Travel(1, "Gdansk", "London", 89);
        travelManager.create(t1);
        assertEquals(1, travelManager.read(1));
    }

    @Test
    public void testRead() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t2 = new Travel(2, "Gdansk", "London", 89);
        travelManager.create(t2);
        assertEquals(2, travelManager.read(2).getId());
        assertEquals("Gdansk", travelManager.read(2).getFrom());
        assertEquals("London", travelManager.read(2).getDirection());
        assertEquals(89, travelManager.read(2).getPrice());
    }

    @Test
    public void testReadAll() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t21 = new Travel(3, "Gdansk", "London", 89);
        Travel t22 = new Travel(4, "Krakow", "Milano", 119);
        travelManager.create(t21);
        travelManager.create(t22);
        assertEquals(t21, travelManager.read(3));
        assertEquals(t22, travelManager.read(4));
    }

    @Test
    public void testUpdate() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t3 = new Travel(3, "Gdansk", "London", 89);
        Travel t4 = new Travel(4, "Krakow", "Milano", 119);
        travelManager.create(t3);
        travelManager.update(t4, 4);

        assertEquals(t4.getId(), travelManager.read(4).getId());
        assertEquals(t4.getFrom(), travelManager.read(4).getFrom());
        assertEquals(t4.getDirection(), travelManager.read(4).getDirection());
        assertEquals(t4.getPrice(), travelManager.read(4).getPrice());
    }

    @Test
    public void testDelete() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t5 = new Travel(5, "Gdansk", "London", 89);
        Travel t6 = new Travel(6, "Krakow", "Milano", 119);
        travelManager.create(t5);
        travelManager.create(t6);

        assertEquals(t5, travelManager.read(5));
        assertEquals(t6, travelManager.read(6));

        travelManager.delete(t6, 6);

        assertEquals(t5, travelManager.read(5));
        assertEquals(null, travelManager.read(6));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUpdateException() throws Exception {
        TravelManagerImpl travelManager = new TravelManagerImpl();
        Travel t7 = new Travel(7, "Gdansk", "London", 89);
        travelManager.create(t7);

        travelManager.update(travelManager.read(0), 8);

    }
}
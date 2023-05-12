package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollisionDetectorTest {

    public CollisionDetectorTest(){
    }

    @BeforeAll
    public static void setUpClass(){}

    @AfterAll
    public static void tearDownClass(){}

    @BeforeEach
    public void setUp(){}

    @AfterEach
    public void tearDown(){}

    @Test
    public void testCollision(){
        System.out.println("Collision");
        Entity entity = null;
        Entity entity2 = null;
        CollisionDetector instance = new CollisionDetector();
        Boolean expected = null;
        Boolean result = instance.collides(entity,entity2);
        assertEquals(expected, result);

        fail("Test case");
    }

}

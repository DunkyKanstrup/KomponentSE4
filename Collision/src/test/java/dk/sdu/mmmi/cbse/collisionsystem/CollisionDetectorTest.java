package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollisionDetectorTest {

    private CollisionDetector collisionDetector;
    private GameData gameData;
    private World world;

    private Entity createEntity(int life, String id, float x, float y, float radius){
        Entity entity = mock(Entity.class);
        LifePart lifePart = mock(LifePart.class);
        PositionPart positionPart = mock(PositionPart.class);
        when(entity.getPart(PositionPart.class)).thenReturn(positionPart);
        when(positionPart.getX()).thenReturn(x);
        when(positionPart.getY()).thenReturn(y);
        when(positionPart.getRadians()).thenReturn(radius);
        when(entity.getID()).thenReturn(id);
        when(entity.getPart(LifePart.class)).thenReturn(lifePart);
        when(lifePart.getLife()).thenReturn(life);
        return entity;
    }

    @BeforeEach
    public void setUp(){
        collisionDetector = new CollisionDetector();
        gameData = mock(GameData.class);
        world = mock(World.class);
    }

    @AfterEach
    public void tearDown(){
        if(world.getEntities().size() > 0){
            for (Entity ent: world.getEntities()) {
                world.removeEntity(ent);
            }
        }
    }

    @Test
    public void EntitiesWithLifeStays(){
        Entity entity1 = createEntity(1,"1", 1,1,1);
        Entity entity2 = createEntity(1,"2", 2,2,1);

        when(world.getEntities()).thenReturn(List.of(new Entity[]{entity1, entity2}));
        collisionDetector.process(gameData,world);

        assertTrue(world.getEntities().contains(entity1));
        assertTrue(world.getEntities().contains(entity2));
    }

    @Test
    public void TestEntityWithMostHealthStays(){
        Entity entity1 = createEntity(1,"1", 1,1,1);
        Entity entity2 = createEntity(0,"2", 1,1,1);

        when(world.getEntities()).thenReturn(List.of(new Entity[]{entity1, entity2}));
        collisionDetector.process(gameData,world);
        LifePart lifePart = entity2.getPart(LifePart.class);
        System.out.println(lifePart.getLife());
        assertTrue(world.getEntities().contains(entity1));
        assertTrue(world.getEntities().contains(entity2));
    }


    @Test
    public void TestCollisionOnDifferentPosition(){
        Entity entity1 = createEntity(2,"1", 1,1,1);
        Entity entity2 = createEntity(1,"2", 2,2,1);

        assertFalse(collisionDetector.collides(entity1,entity2));
    }

}

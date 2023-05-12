module Core {
    //Asteroids internal modules
    requires Common;
    requires CommonEnemy;
    requires CommonBullet;
    requires CommonAsteroids;

    //Spring & LibGDX
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    exports dk.sdu.mmmi.cbse.main;
    opens dk.sdu.mmmi.cbse.main to spring.core;

    //Asteroids SPIs
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
}



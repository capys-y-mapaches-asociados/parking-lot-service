package co.edu.icesi.papupros.lot;

import co.edu.icesi.papupros.lot.ParkingLotApp;
import co.edu.icesi.papupros.lot.config.AsyncSyncConfiguration;
import co.edu.icesi.papupros.lot.config.EmbeddedSQL;
import co.edu.icesi.papupros.lot.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { ParkingLotApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}

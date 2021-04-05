package co.edu.usco.ecommerce.config.dbmigrations;

import co.edu.usco.ecommerce.domain.AudProducto;
import co.edu.usco.ecommerce.domain.Authority;
import co.edu.usco.ecommerce.domain.Factura;
import co.edu.usco.ecommerce.domain.Pedido;
import co.edu.usco.ecommerce.domain.Producto;
import co.edu.usco.ecommerce.domain.User;
import co.edu.usco.ecommerce.security.AuthoritiesConstants;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);

        User systemUser = new User();
        systemUser.setId("user-0");
        systemUser.setLogin("system");
        systemUser.setPassword("$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
        systemUser.setFirstName("");
        systemUser.setLastName("System");
        systemUser.setEmail("system@localhost");
        systemUser.setActivated(true);
        systemUser.setLangKey("es");
        systemUser.setCreatedBy(systemUser.getLogin());
        systemUser.setCreatedDate(Instant.now());
        systemUser.getAuthorities().add(adminAuthority);
        systemUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(systemUser);

        User anonymousUser = new User();
        anonymousUser.setId("user-1");
        anonymousUser.setLogin("anonymoususer");
        anonymousUser.setPassword("$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("User");
        anonymousUser.setEmail("anonymous@localhost");
        anonymousUser.setActivated(true);
        anonymousUser.setLangKey("es");
        anonymousUser.setCreatedBy(systemUser.getLogin());
        anonymousUser.setCreatedDate(Instant.now());
        mongoTemplate.save(anonymousUser);

        User adminUser = new User();
        adminUser.setId("user-2");
        adminUser.setLogin("admin");
        adminUser.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        adminUser.setFirstName("admin");
        adminUser.setLastName("Administrator");
        adminUser.setEmail("admin@localhost");
        adminUser.setActivated(true);
        adminUser.setLangKey("es");
        adminUser.setCreatedBy(systemUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);

        User userUser = new User();
        userUser.setId("user-3");
        userUser.setLogin("user");
        userUser.setPassword("$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
        userUser.setFirstName("");
        userUser.setLastName("User");
        userUser.setEmail("user@localhost");
        userUser.setActivated(true);
        userUser.setLangKey("es");
        userUser.setCreatedBy(systemUser.getLogin());
        userUser.setCreatedDate(Instant.now());
        userUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(userUser);
    }

    @ChangeSet(order = "03", author = "initiator", id = "03-addProducto")
    public void addProducto(MongoTemplate mongoTemplate) {
        Producto producto = new Producto("Coca Cola", new BigDecimal(2000), 19.0, 100L, 0L);
        mongoTemplate.save(producto);
    }

    @ChangeSet(order = "04", author = "initiator", id = "04-addAudProducto")
    public void addAudProducto(MongoTemplate mongoTemplate) {
        Producto producto = new Producto("Coca Cola", new BigDecimal(2000), 19.0, 100L, 2L);
        producto.setId("ObjectId(\"6069e33f4d7cc854044f8d2b\")");
        AudProducto AudProducto = new AudProducto("INSERT", Instant.now(), producto);
        mongoTemplate.save(AudProducto);
    }

    /*
     * @ChangeSet(order = "05", author = "initiator", id = "05-addPedido") public
     * void addPedido(MongoTemplate mongoTemplate) { Pedido pedido = new
     * Pedido("ObjectId(\"6069e33f4d7cc854044f8d2b\")", 2L);
     * mongoTemplate.save(pedido); }
     */

    /*
     * @ChangeSet(order = "06", author = "initiator", id = "06-addFactura") public
     * void addFactura(MongoTemplate mongoTemplate) { Factura factura = new
     * Factura(Instant.now(), new BigDecimal(4000), 1L, Set.of( new
     * Pedido("ObjectId(\"6069efcf4d7cc854044f8d41\")",
     * "ObjectId(\"6069e33f4d7cc854044f8d2b\")", 2L))); mongoTemplate.save(factura);
     * }
     */
}

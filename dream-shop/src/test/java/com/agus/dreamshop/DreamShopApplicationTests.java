package com.agus.dreamshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "auth.token.JwtSecret=testSecretKeyForTestingPurposesOnly123456789012345678901234567890",
    "auth.token.expirationInMils=3600000"
})
class DreamShopApplicationTests {

    @Test
    void contextLoads() {
        // Test para verificar que el contexto de Spring se carga correctamente
    }

}
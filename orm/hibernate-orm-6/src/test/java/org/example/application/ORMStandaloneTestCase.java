package org.example.application;

import jakarta.persistence.EntityManagerFactory;
import org.example.some_shared_library.CompanyId;
import org.example.user_management_app.UserModel;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.hibernate.testing.orm.jpa.PersistenceUnitInfoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * This template demonstrates how to develop a standalone test case for Hibernate ORM.  Although this is perfectly
 * acceptable as a reproducer, usage of ORMUnitTestCase is preferred!
 */
class ORMStandaloneTestCase {

    @Test
    void HHH_19020_Test() throws Exception {

        List<String> managedClassNames = List.of(
            UserModel.class.getName(),

            // having CompanyId on the managed classes causes the NPE, because the AbstractId is missing
            // in getMetadataCollector().getMappedSuperclass() of addPropertyToMappedSuperclass().
            // however the AbstractId does not cause an issue when it is only used via the UserModel class above
            CompanyId.class.getName()
        );


        // This is how Spring Boot initializes this project (built using the debugger...):
        var persistenceUnitInfo = new PersistenceUnitInfoImpl("sample");
        PersistenceUnitInfoDescriptor persistenceUnitInfoDescriptor = new PersistenceUnitInfoDescriptor(persistenceUnitInfo) {
            @Override
            public List<String> getManagedClassNames() {
                return managedClassNames;
            }
        };
        EntityManagerFactoryBuilderImpl entityManagerFactoryBuilder = new EntityManagerFactoryBuilderImpl(persistenceUnitInfoDescriptor, Map.of());
        try (EntityManagerFactory entityManagerFactory = entityManagerFactoryBuilder.build()) {
            entityManagerFactory.createEntityManager();
        }
    }
}

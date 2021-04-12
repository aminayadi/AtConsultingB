package tn.atconsulting.at.apioffice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tn.atconsulting.at.apioffice");

        noClasses()
            .that()
                .resideInAnyPackage("tn.atconsulting.at.apioffice.service..")
            .or()
                .resideInAnyPackage("tn.atconsulting.at.apioffice.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..tn.atconsulting.at.apioffice.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}

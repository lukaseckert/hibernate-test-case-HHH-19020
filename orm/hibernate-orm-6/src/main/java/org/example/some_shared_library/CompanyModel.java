package org.example.some_shared_library;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class CompanyModel {

    @Id
    private String id;

    @AttributeOverride(name = "id", column = @Column(name = "ownerCompanyId"))
    private CompanyId ownerCompanyId;

}

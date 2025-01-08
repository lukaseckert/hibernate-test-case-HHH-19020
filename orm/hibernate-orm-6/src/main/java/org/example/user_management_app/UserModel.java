package org.example.user_management_app;

import org.example.some_shared_library.UserId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    private String id;

    @AttributeOverride(name = "id", column = @Column(name = "brotherId"))
    private UserId brotherId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserId getBrotherId() {
        return brotherId;
    }

    public void setBrotherId(UserId brotherId) {
        this.brotherId = brotherId;
    }
}

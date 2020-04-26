package sample.model.hibernate;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Data
public class UserDBO {
    @Column
    private String login;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

}

package SdaFinalProject.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "lecturers")
public class Lecturer implements Serializable {

    @Id
    @GeneratedValue(generator="SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="SEQUENCE_GENERATOR", sequenceName = "SEQ_LECTURERS", allocationSize = 1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "description")
    private String description;
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

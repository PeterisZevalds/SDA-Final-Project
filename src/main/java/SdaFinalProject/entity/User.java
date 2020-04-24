package SdaFinalProject.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Column(name = "surname")
    @Size(min = 1, max = 50)
    private String surname;

    @NotBlank
    @Column(unique = true, name = "email")
    @Size(min = 1, max = 100)
    private String email;

    @NotBlank
    @Column(unique = true, name = "phone_number")
    @Size(min = 1, max = 20)
    private String phoneNumber;

    @NotBlank
    @Column(unique = true, name = "username")
    @Size(min = 1, max = 50)
    private String username;

    @NotBlank
    @Column(name = "password")
    @Size(min = 1, max = 50)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package faleite.xyz.back_form.security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    private String password;

    private String carRegister;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String login, String password, String carRegister) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.carRegister = carRegister;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarRegister() {
        return carRegister;
    }

    public void setCarRegister(String carRegister) {
        this.carRegister = carRegister;
    }
}

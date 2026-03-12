package faleite.xyz.back_form.domain.model;

import jakarta.persistence.*;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private Boolean active;

    public Collaborator() {
        active = true;
    }

    public Collaborator(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.active = true;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

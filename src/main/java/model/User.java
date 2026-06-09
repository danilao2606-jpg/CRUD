package model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Имя пожалуйста)")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Ты вводишь свой ник? А нужно имя)")
    @Size(min = 2, max = 30, message = "Странное имя, нужно от 2 до 30 букв в имени")
    @Column (name = "name")
    private String name;

    @NotEmpty(message = "Почту пожалуйста =)")
    @Email(message = "Email не подходит как бы...")
    @Column (name = "email")
    private String email;

    @Max(value = 100, message = "Ты выглядишь моложе")
    @Min(value = 0, message = "А это точно твой возраст?")
    @Column(name = "age")
    private int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User() { }

    public long getId() { return id;}

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

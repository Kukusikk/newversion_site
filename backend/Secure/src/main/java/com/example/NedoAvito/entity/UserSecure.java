package com.example.NedoAvito.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

//класс для авторизации и регистрации клиента
@Entity
@Table(name = "UsersSecure")
public class UserSecure {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idusersecure;
    @Column(unique=true)
    private String login;
    @NotNull
    private String password;
    //токен, который используется при сессии но имеет срок жизни
    private UUID usedtoken;
    public UserSecure(){}
    public UserSecure(String login, @NotNull String password) {
        this.login = login;
        this.password = password;
        }

    public UUID getIdusersecure() {
        return idusersecure;
    }

    public void setIdusersecure(UUID idusersecure) {
        this.idusersecure = idusersecure;
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

    public UUID getUsedtoken() {
        return usedtoken;
    }

    public void setUsedtoken(UUID usedtoken) {
        this.usedtoken = usedtoken;
    }


}

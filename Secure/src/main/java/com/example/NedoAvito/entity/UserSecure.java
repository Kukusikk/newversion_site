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
    private String usedtoken;
    //время жизни используемового токена
    private int ttltoken;
    //токен используется когда срок жизни используемого токена подошел к концу, чтобы повторно не вводить логин/пароль
    private String renewaltoken;
    public UserSecure(){}
    public UserSecure(String login, @NotNull String password) {
        this.login = login;
        this.password = password;
        this.usedtoken = "";
        this.ttltoken = 0;
        this.renewaltoken = "";
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

    public String getUsedtoken() {
        return usedtoken;
    }

    public void setUsedtoken(String usedtoken) {
        this.usedtoken = usedtoken;
    }

    public int getTtltoken() {
        return ttltoken;
    }

    public void setTtltoken(int ttltoken) {
        this.ttltoken = ttltoken;
    }

    public String getRenewaltoken() {
        return renewaltoken;
    }

    public void setRenewaltoken(String renewaltoken) {
        this.renewaltoken = renewaltoken;
    }
}

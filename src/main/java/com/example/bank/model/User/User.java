package com.example.bank.model.User;

import com.example.bank.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name="User")
public  class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "contactNumber", nullable = false)
    private String contactNumber;

 public  User(@JsonProperty("firstName") String firstName,@JsonProperty("lastname") String lastname, String email, String password, String contactNumber) {
     this.name = firstName+" "+lastname;
     this.email = email;
     this.password = password;
     this.contactNumber = contactNumber;


 }

public String getName() {
     return name;
}
protected void setName(String firstName,String lastname) {
     this.name = firstName+" "+lastname;
}


public String getEmail() {
     return email;
}
protected void setEmail(String email) {
     this.email = email;
}
public String getPassword() {
     return password;
}
protected void setPassword(String password) {
     this.password = password;
}

public String getContactNumber() {
     return contactNumber;
}
protected void setContactNumber(String contactNumber) {
     this.contactNumber = contactNumber;
}

protected User(){
     super();
}
    // Getters and Setters
}
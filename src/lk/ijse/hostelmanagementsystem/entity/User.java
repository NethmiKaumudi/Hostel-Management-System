package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Column(name = "user_name", columnDefinition = "VARCHAR(64)")
    private String UserName;
    private String PassWord;

    public User() {
    }

    public User(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }

    public UserDTO toDto() {
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName(this.UserName);
        userDTO.setPassWord(this.PassWord);
        return userDTO;
    }
}

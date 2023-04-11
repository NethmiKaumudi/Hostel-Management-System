package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.User;

public class UserDTO {
    private String UserName;
    private String PassWord;

    public UserDTO() {
    }

    public UserDTO(String userName, String passWord) {
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

    public  User toEntity() {

        User user = new User();
        user.setUserName(this.UserName);
        user.setPassWord(this.PassWord);
        return user;
    }

}

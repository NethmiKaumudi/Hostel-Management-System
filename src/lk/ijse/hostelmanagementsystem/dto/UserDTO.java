package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data

public class UserDTO {
    private String UserName;
    private String PassWord;


    public  User toEntity() {

        User user = new User();
        user.setUserName(this.UserName);
        user.setPassWord(this.PassWord);
        return user;
    }

}

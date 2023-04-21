package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class User {
    @Id
    @Column(name = "user_name", columnDefinition = "VARCHAR(64)")
    private String UserName;
    private String PassWord;

    public UserDTO toDto() {
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName(this.UserName);
        userDTO.setPassWord(this.PassWord);
        return userDTO;
    }
}

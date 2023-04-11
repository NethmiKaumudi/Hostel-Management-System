package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.entity.User;

public interface UserService {
    public String save(UserDTO userDTO);
    public UserDTO get(String userName);
    public boolean update(UserDTO userDTO) ;
    }

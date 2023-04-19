package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.entity.User;

public interface UserService extends SuperService {
     String save(UserDTO userDTO);
     UserDTO get(String userName);
     boolean update(UserDTO userDTO) ;
    }

package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.projection.CustomDTO;

import java.util.ArrayList;
import java.util.List;

public interface QueryService extends SuperService {
     List<StudentDTO> getAllPendingPaymentStudent();
}

package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.CustomDTO;
import lk.ijse.hostelmanagementsystem.projection.Custom;

import java.util.ArrayList;

public interface QueryService extends SuperService {
     ArrayList<CustomDTO> getAllPendingPaymentStudent();
}

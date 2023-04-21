package lk.ijse.hostelmanagementsystem.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "reservation")
public class Reservation {
    @Id
    @Column( columnDefinition = "VARCHAR(64)")
    private String reservationId;
    private LocalDate date;
    private String status;

    @ManyToOne
    private Student students;

    @ManyToOne
    private Room rooms;



}

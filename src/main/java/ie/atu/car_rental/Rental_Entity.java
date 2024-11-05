package ie.atu.car_rental;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental_Entity {

    @Pattern(regexp = "RENT-")
    private String rentalCode;

    @Size(max = 50 ,message = "carModel cant greater than 50 characters")
    private String carModel;

    @Size(max = 100,message = "renterName cant greater than 100 characters")
    private String renterName;

    @Email(message = "Invalid Email")
    private String renterEmail;

    @FutureOrPresent(message = "Must be today or in the future")
    private Date rentalStartDate;

    @Past(message = "Must be after rental Start Date")
    private Date rentalEndDate;

    @PositiveOrZero(message = "DailyRate is Wrong")
    private DecimalFormat dailyRate;

}

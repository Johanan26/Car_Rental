package ie.atu.car_rental;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/CarRental")
public class CarController {
    private ProductServices myService;

    public CarController(ProductServices myService){
        this.myService = myService;
    }
    private List<Rental_Entity> list = new ArrayList<>();

    @PostMapping("MakeBooking")
    public List<Rental_Entity> newProduct(@Valid @RequestBody Product product){
        list = myService.addProduct(product);
        return list;
    }
    @GetMapping("RentalBooking/{rentalCode}")
    public List<Rental_Entity> getProduct(@Valid @RequestBody Product product){
        return list;
    }

    @PutMapping("updateBooking/{rentalCode}")
    public List<Rental_Entity> updateProduct(@Valid @PathVariable String rentalCode ,@RequestBody Product product){
        list = myService.updateProduct(rentalCode,product);
        return list;
    }

    @DeleteMapping("DeleteBooking/{rentalCode}")
    public List<Rental_Entity> deleteProduct(@Valid @PathVariable String rentalCode){
        list = myService.updateProduct(rentalCode);
        return list;
    }
}

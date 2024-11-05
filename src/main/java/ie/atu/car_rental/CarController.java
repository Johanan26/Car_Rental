package ie.atu.car_rental;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CarRental")
public class CarController(ProductServices myServices) {
    private List<Product> list = new ArrayList<>();

    @GetMapping("RentalBooking")
    {
        list = myService.listProduct(product);
        return list;
    }

    @PostMapping("MakeBooking/{rentalCode}")
    public List<Product>newProduct(@Valid @RequestBody Product product){
        list = myService.addProduct(product);
        return list;
    }

    @PutMapping("updateBooking/{rentalCode}")
    public List<Product>updateProduct(@Valid @PathVariable String rentalCode  @RequestBody Product product){
        list = myService.updateProduct(rentalCode,product);
        return list;
    }

    @DeleteMapping("DeleteBooking/{rentalCode}")
    public List<Product>deleteProduct(@Valid @PathVariable String rentalCode){
        list = myService.updateProduct(rentalCode);
        return list;
    }
}

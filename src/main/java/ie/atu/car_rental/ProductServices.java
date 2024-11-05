package ie.atu.car_rental;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    private List<Rental_Entity> myList = new ArrayList<>();

    public List<Rental_Entity> addProduct(Product product)
    {
        myList.add(product);
        return myList;
    }

    public List<Rental_Entity> updateProduct(String rentalCode,Product product)
    {
        for (product p : myList){
            if(p.getrentalCode() == rentalCode)
            {
                myList.remove(p);
            }
        }
        myList.add(Product);
        return myList;
    }

    public List<Rental_Entity> deleteProduct(String rentalCode, Product product)
    {
        for (product p : myList){
            if(p.getrentalCode() == rentalCode)
            {
                myList.remove(p);
            }
        }
        return myList;
    }
}

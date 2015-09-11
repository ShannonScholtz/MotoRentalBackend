package za.ac.cput.MotoRental.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.MotoRental.Services.MotorCycleService;
import za.ac.cput.MotoRental.config.factory.EngineTypeEmbeddableFactory;
import za.ac.cput.MotoRental.config.factory.MotorBikeCondtionFactory;
import za.ac.cput.MotoRental.domain.MotorCycle;
import za.ac.cput.MotoRental.domain.PaymentMethod;
import za.ac.cput.MotoRental.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/20.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private MotorCycleService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/motorcyle",method = RequestMethod.GET)
    public MotorCycle getMotorCycle(){

        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);
        Rental rental = new Rental.Builder("22-07-2015").returnDate("28-07-2015").paymentMethod(paymentMethods).build();
        rentals.add(rental);
        MotorCycle couse = new MotorCycle
                .Builder("kawa2345")
                .Make("Kawasaki")
                .Model("Ninja")
                .year("2009")
                .motorBikeCondition(MotorBikeCondtionFactory.createAddress("20000", "Full", "Mint"))
                .engineTypeEmbeddable(EngineTypeEmbeddableFactory.createEngineTypeEmbeddable("600ccxerghc", "600cc", "Petrol"))
                .rentals(rentals)
                .build();

        return couse;
    }

    @RequestMapping(value = "motorcycles", method = RequestMethod.GET)
    public List<MotorCycle> getMotorCycles(){
        return service.getMotorCycles();
    }




}

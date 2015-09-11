package za.ac.cput.MotoRental.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by student on 2015/08/20.
 */@RunWith(Suite.class)
   @Suite.SuiteClasses({
           CustomerTest.class,
           MotorCycleTest.class,
           PaymentMethodTest.class,
           RentalTest.class,
           SalesPersonTest.class
   })
   public class TestSuite {

}


package za.ac.cput.MotoRental.config.factory;

import za.ac.cput.MotoRental.domain.LoginEmbeddable;

/**
 * Created by student on 2015/08/12.
 */
public class LoginEmbeddableFactory {
    public static LoginEmbeddable createLogin(String username, String password)
    {
        LoginEmbeddable loginEmbeddable = new LoginEmbeddable
                .Builder(username)
                .password(password)
                .build();
        return loginEmbeddable;
    }
}

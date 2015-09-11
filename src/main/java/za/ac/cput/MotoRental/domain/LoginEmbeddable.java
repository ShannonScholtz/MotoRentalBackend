package za.ac.cput.MotoRental.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/12.
 */
@Embeddable
public class LoginEmbeddable implements Serializable {
    //@Column(unique = true)
    private String username;
    private String password;

    //constructors
    private LoginEmbeddable()
    {

    }

    public LoginEmbeddable(Builder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
    }

    //getters
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public static class Builder
    {
        private String username;
        private String password;

        public Builder(String username)
        {
            this.username = username;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder copy(LoginEmbeddable loginEmbedable)
        {
            this.username = loginEmbedable.username;
            this.password = loginEmbedable.password;
            return this;
        }

        public LoginEmbeddable build()
        {
            return new LoginEmbeddable(this);
        }
    }
}

package edu.bu.cs673.stockportfolio.domain.user;

import com.sun.istack.NotNull;
import edu.bu.cs673.stockportfolio.domain.portfolio.Portfolio;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

/**********************************************************************************************************************
 * Data object representing a user of our software product. Each user can have a portfolio that gets analyzed by the
 * system.
 *
 *********************************************************************************************************************/
@Entity
@Check(constraints = "LENGTH(TRIM(username)) > 0 &&"
        + " LENGTH(TRIM(username)) > 0 &&"
        + " LENGTH(TRIM(email)) > 0 &&"
        + " LENGTH(TRIM(password)) > 10")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nationalized
    @NotNull
    private String username;

    @Nationalized
    @NotNull
    private String password;

    private String salt;

    @Nationalized
    @NotNull
    private String email;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user" ,cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public User() {
    }

    public User(String username, String password, String salt, String email, Portfolio portfolio) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.portfolio = portfolio;
    }

    public User(Long id, String username, String password, String salt, String email, Portfolio portfolio) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}

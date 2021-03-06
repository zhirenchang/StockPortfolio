package edu.bu.cs673.stockportfolio.domain.account;

import edu.bu.cs673.stockportfolio.domain.portfolio.Portfolio;
import edu.bu.cs673.stockportfolio.domain.investment.quote.Quote;

import javax.persistence.*;
import java.util.List;

/**********************************************************************************************************************
 * Data object representing a users Account. An account holds investment products such as stocks.
 *
 *********************************************************************************************************************/
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "account_line",
//            joinColumns = {@JoinColumn(name = "account_id")},
//            inverseJoinColumns = {@JoinColumn(name = "security_id")}
//    )
//    private List<Security> securities;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "account_line",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "quote_id")}
    )
    private List<Quote> quotes;

    private String accountType;

    private String platform;

    public Account() {
    }

    public Account(Portfolio portfolio, List<Quote> quotes, String accountType, String platform) {
        this.portfolio = portfolio;
        this.quotes = quotes;
        this.accountType = accountType;
        this.platform = platform;
    }

    public Account(Long id, Portfolio portfolio, List<Quote> quotes, String accountType, String platform) {
        this.id = id;
        this.portfolio = portfolio;
        this.quotes = quotes;
        this.accountType = accountType;
        this.platform = platform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}

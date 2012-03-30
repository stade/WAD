/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author stade
 */
@Entity
public class AnnualBudget implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "Budget year must be defined.")
    @Size(min = 4, max = 4, message = "Budget year length must be 4")
    @Pattern(regexp = "[0-9]+", message = "Budget year must contain digits")
    private String budgetYear;
    @NotNull(message = "Amount must be defined.")
    @Size(min = 1, max = 50, message = "Budget year length must be between 1 and 50")
    @Pattern(regexp = "[0-9]+", message = "Amount must contain only digits")
    private String amount;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Team team;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
    
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }
    
    
}

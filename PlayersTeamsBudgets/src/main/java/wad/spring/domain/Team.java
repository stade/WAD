/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name must be defined.")
    @Size(min = 1, max = 40, message = "Name length must be between 1 and 40.")
    @Pattern(regexp = "(\\w+.\\s.)+\\w+", message = "Name must contain only words.")
    private String name;
    @OneToMany(mappedBy = "team", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Player> players;
    
    @OneToMany(mappedBy = "team", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<AnnualBudget> budgets;

    
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addPlayer(Player player) {
        if(!players.contains(player)) {
            players.add(player);
        }
        
        player.setTeam(this);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addBudget(AnnualBudget budget) {
           if(!budgets.contains(budget)) {
            budgets.add(budget);
        }
        
        budget.setTeam(this);
    }

    public List<AnnualBudget> getBudgets() {
        return this.budgets;
    }

    public void setBudgets(List<AnnualBudget> budgets) {
        this.budgets = budgets;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.AnnualBudget;

/**
 *
 * @author stade
 */
public interface AnnualBudgetService {
    public void saveOrUpdate(AnnualBudget budget, Long teamId);
    public List<AnnualBudget> listAll();
}

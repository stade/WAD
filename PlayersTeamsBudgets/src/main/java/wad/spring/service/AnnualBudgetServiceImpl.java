/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.AnnualBudget;
import wad.spring.domain.Team;
import wad.spring.repository.AnnualBudgetRepository;
import wad.spring.repository.TeamRepository;


/**
 *
 * @author stade
 */
@Service
public class AnnualBudgetServiceImpl implements AnnualBudgetService {
       
    @Autowired
    AnnualBudgetRepository budgetRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AnnualBudget> listAll() {
        return budgetRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(AnnualBudget budget, Long teamId) {
        Team t = teamRepository.findOne(teamId);
        t.addBudget(budget);
        teamRepository.save(t);
    }
}


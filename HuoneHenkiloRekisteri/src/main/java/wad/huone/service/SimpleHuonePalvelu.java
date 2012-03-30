package wad.huone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.huone.database.HuoneDao;


import wad.huone.domain.Huone;

@Service
public class SimpleHuonePalvelu implements HuonePalvelu {

    @Autowired
    private HuoneDao huoneDao;

    @Override
    @Transactional
    public void lisaa(Huone huone) {
        huoneDao.create(huone);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Huone> listaa() {
        return huoneDao.list();
    }

    @Override
    @Transactional
    public void poista(int huoneId) {
        Huone h = huoneDao.read(huoneId);
        if (h != null) {
            huoneDao.delete(h);
        }
    }


}

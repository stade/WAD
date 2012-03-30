package wad.huone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.huone.database.HenkiloDao;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;


@Service
public class SimpleHenkiloPalvelu implements HenkiloPalvelu {

    @Autowired
    private HenkiloDao henkiloDao;

    @Override
    @Transactional
    public void lisaa(Henkilo henkilo) {
        henkiloDao.create(henkilo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Henkilo> listaa() {
        return henkiloDao.listHenkilot();
    }

    @Override
    @Transactional
    public void poista(int henkiloId) {
        Henkilo h = henkiloDao.read(henkiloId);
        if (h != null) {
            henkiloDao.delete(h);
        }
    }

    @Override
    @Transactional
    public void lisaaHuone(Integer huoneId, Integer henkiloId) {
         henkiloDao.addHuone(huoneId, henkiloId);
    }

    @Override
    public Huone getHuone() {
        return henkiloDao.getHuone();
    }
}

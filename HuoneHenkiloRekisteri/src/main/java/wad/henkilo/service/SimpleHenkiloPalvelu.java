package wad.henkilo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.henkilo.database.HenkiloDao;

import wad.henkilo.domain.Henkilo;


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
        return henkiloDao.list();
    }

    @Override
    @Transactional
    public void poista(int henkiloId) {
        Henkilo h = henkiloDao.read(henkiloId);
        if (h != null) {
            henkiloDao.delete(h);
        }
    }
}

package wad.olut.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.olut.domain.Olut;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author tatutahv
 */
@Service
public class VerySimpleOlutPalvelu implements OlutPalvelu {

    private List<Olut> olutjono = new ArrayList();


    @Override
    public Olut lisaaOlut(Olut olut) {
        
        
        olutjono.add(olut);
        return olut;

    }

    @Override
    public void poistaOlut(int tunnus) {

        Olut o = null;


        for (Olut olut : olutjono) {

            if (olut.getId() == tunnus) {
                o = olut;
                break;
            }

        }
        if (o != null) {
            olutjono.remove(o);

        }

    }

    @Override
    public Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut) {

        boolean found = false;

        for (Olut o : olutjono) {
            if (o.equals(olut)) {
                o.setId(tunnus);
                olut = o;
                found = true;
                break;
            }

        }

        if (found == false) {
            olutjono.add(olut);

        }
        return olut;


    }

    @Override
    public Olut annaOlut(int tunnus) {

        Olut olut = null;

        for (Olut o : olutjono) {
            if (o.getId() == tunnus) {
                olut = o;
                break;
            }

        }

        return olut;

    }

    @Override
    public List<Olut> listaaOluet() {
        return olutjono;
    }
}

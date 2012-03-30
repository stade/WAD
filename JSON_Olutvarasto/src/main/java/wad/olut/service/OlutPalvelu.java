package wad.olut.service;

import java.util.List;
import wad.olut.domain.Olut;


public interface OlutPalvelu {
    Olut lisaaOlut(Olut olut);
    void poistaOlut(int tunnus);
    Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut);
    Olut annaOlut(int tunnus);
    List<Olut> listaaOluet();
}
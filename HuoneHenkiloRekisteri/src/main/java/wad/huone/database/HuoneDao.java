package wad.huone.database;

import java.util.List;

import wad.huone.domain.Huone;


public interface HuoneDao extends DAO<Huone> {
    public List<Huone> list();

    @Override
    public void create(Huone huone);
}

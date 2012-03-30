package wad.myytavatasunnot.database;


import java.util.List;
import wad.myytavatasunnot.domain.Seller;


public interface SellerDao extends DAO<Seller> {
    public List<Seller> list();


    @Override
    public void create(Seller seller);
    





}

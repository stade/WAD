package wad.myytavatasunnot.service;

import java.util.Queue;
import wad.myytavatasunnot.domain.Seller;



public interface SellerService {
    public void add(Seller seller);
    public Queue<Seller> list();
    public void delete(int sellerId);
}
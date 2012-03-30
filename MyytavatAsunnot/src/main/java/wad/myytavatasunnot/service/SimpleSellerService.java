package wad.myytavatasunnot.service;


import java.util.LinkedList;
import java.util.Queue;
import org.springframework.stereotype.Service;
import wad.myytavatasunnot.domain.Seller;


@Service
public class SimpleSellerService implements SellerService {

    private Queue<Seller> sellers = new LinkedList();

    @Override
    public void add(Seller seller) {
        if (this.sellers.size() < 10) {

            this.sellers.offer(seller);

        } else {
            sellers.remove();
            sellers.offer(seller);
        }
    }
    @Override
    public Queue<Seller> list() {
        return sellers;
    }

    @Override
    public void delete(int sellerId) {
        
        Seller delThisSeller = null;
        
        for (Seller seller : sellers ){
            if (seller.getId() == sellerId) {
                delThisSeller = seller;
                break;
            }
        }
        
        if (delThisSeller != null) {
            sellers.remove(delThisSeller);
        }
    }
}

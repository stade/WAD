package wad.hitcounter;

import org.springframework.stereotype.Service;

@Service
public class SimpleHitCounter implements HitCounter {
    private int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void incrementCount() {
        
        if (count == 100) {
            count = 0;
        }
        else {
        
        count = count + 10;
        }
    }
}
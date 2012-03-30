package wad.olut.domain;

public class Olut {

    private int id;
    private String name;
    //private static int counter = 1;

    public Olut() {
        name = "";
        id = 0;
     
    }
    /*
    public static void setCounter(int counter) {
        Olut.counter = counter;
    }
    
    public static int getCounter() {
        return counter;
    }
    */
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        if (!(obj instanceof Olut)) {
            return false;
        }

        Olut o = (Olut) obj;
        return o.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
    }
}
package charactor;

public class Hero {
    public static final int itemTotalNumber = 6;
    public String name;
    protected float hp;
    int moveSpeed;
    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

    public static void main(String[] args) {
        final Hero h1= new Hero();
        h1.hp = 300;
        Hero h2= new Hero();
        h2.hp = 400;
        Hero h3= new Hero();
        h3.hp = 300;
        Hero h4 = h3;


        System.out.println(Hero.itemTotalNumber);
        System.out.println(h1==h3);
        System.out.println(h4==h3);
        System.out.println(h4.equals(h3));
        System.out.println(h4.getClass());
        System.out.println(h3.getClass());
        System.out.println(h2.getClass());

    }
}
public class ADHero extends Hero implements AD{

    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }

    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);

        }
    }

    public void heal() {
        System.out.println(name + " 进行了自我治疗 " );
    }

    public void heal(Hero heros) {
        System.out.println(name + " 治疗了 " + heros.name);
    }

    public void heal(Hero heros, int hp) {

        System.out.println(name + " 治疗了 " + heros.name + hp + "点血");

    }

    public static void main(String[] args) {
        ADHero bh = new ADHero();
        bh.name = "赏金猎人";

        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 = new Hero();
        h2.name = "提莫";

        bh.attack();
        bh.attack(h1);
        bh.attack(h1, h2);

        bh.heal();
        bh.heal(h1);
        bh.heal(h2, 80);       

    }

}
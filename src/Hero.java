public class Hero {
    public String name =Hero.getName("属性声明") ;

    public Hero(){
        name = Hero.getName("构造方法");
    }
    {
        name = Hero.getName("初始化块");
    }

    public static String getName(String pos){
        String result= "name "+pos;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        new Hero();
    }

}
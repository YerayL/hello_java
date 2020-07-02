package digit;

import java.util.Scanner;

public class TestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("公司地址");
        String Address = scanner.nextLine();

        System.out.println("公司类型、名字");
        String Type = scanner.nextLine();

        System.out.println("老板名字");
        String Boss = scanner.nextLine();

        System.out.println("欠款金额");
        String Money = scanner.nextLine();

        System.out.println("产品");
        String Product = scanner.nextLine();

        System.out.println("计量单位");
        String Unit = scanner.nextLine();

        String Word = "%s最大皮革厂%s倒闭了，王八蛋老板%s吃喝嫖赌，欠下了%s个亿，带着他的小姨子跑了!我们没有办法，拿着%s抵工资!原价都是一%s多、两%s多、三%s多的%s现在全部只卖二十块，统统只要二十块!"+
                "%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，你不发工资，你还我血汗钱，还我血汗钱!";
        System.out.format(Word,Address,Type,Boss,Money,Product,Unit,Unit,Unit,Product,Boss);

    }
}
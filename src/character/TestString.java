package character;

//------------------------------测试----------------------------------
/**
 *  使用Java自带的 StringBuffer 和 这个我们自己开发的MyStringBuffer性能比较。
 参考比较方案:
 1. 生成长度是10的随机字符串
 2. 使用StringBuffer追加1000000次统计时间
 3. 使用MyStringBuffer追加1000000次统计时间

 性能统计办法 参考 比较StringBuffer和String的性能
 如果追加的次数太大，会导致内存不够使用(默认情况下是分配16m)，你会看到OutOfMemoryError 这样的错误。
 调整的方式参考 JVM调试与设置 设置最大内存
 *
 */
public class TestString {
    public static void main(String[] args) {
        String s = randomString(10);
        StringBuffer sb = new StringBuffer(s);
        MyStringBuffer msb = new MyStringBuffer(s);

        //StringBuffer测试性能
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100*10000; i++) {
            sb.append(s);
        }
        long end = System.currentTimeMillis();
        System.out.printf("StringBuffer追加1000000次，消耗了%d毫秒%n",end-start);

        //MyStringBuffer测试性能
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100*10000; i++) {
            msb.append(s);
        }
        long end2 = System.currentTimeMillis();
        System.out.printf("MyStringBuffer追加1000000次，消耗了%d毫秒%n",end2-start2);
    }


    private static String randomString(int length) {
        String link = "";
        for (int i = '0'; i <= '9'; i++) {
            link += (char)i;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            link += (char)i;
        }
        for (int i = 'A'; i <= 'z'; i++) {
            link += (char)i;
        }
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random()*link.length());
            cs[i] = link.charAt(index);
        }
        String result = String.valueOf(cs);
        return result;
    }
}

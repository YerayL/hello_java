package digit;




public class TestChar {


    public static void main(String[] args) {
        String str1 = "the";
        double startTime = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer(str1);

        System.out.println(sb.length()); //内容长度

        System.out.println(sb.capacity());//总空间
        System.out.println(startTime);
    }

}
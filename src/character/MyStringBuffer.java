package character;

public class MyStringBuffer implements IStringBuffer {

    char[] value; // 用于存放字符数组
    int capacity = 16; // 容量
    int length = 0; // 初始化长度为0

    //调用构造方法，同时会创建字符数组，无参的话就直接是16
    public MyStringBuffer() {
        value = new char[capacity];
    }

    //传入字符串的话
    public MyStringBuffer(String str) {
        this();         //传进来空的也会先创建
        if (str == null) {//空的不执行以下操作
            return;
        }
        if (capacity<str.length()) {//如果默认分配容量不够了
            capacity = value.length*2;//扩容*2
            value = new char[capacity];//再创建
        }
        if (capacity>=str.length()) {//容量够的
            //因为是要装进去并留有空间，所以要用数组复制填充
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }
        length = str.length();
    }
    //追加字符串
    @Override
    public void append(String str) {
        insert(length, str);//末尾插入

    }

    //追加字符
    @Override
    public void append(char c) {
        append(String.valueOf(c));//字符转字符串，末尾插入
    }

    //插入字符
    @Override
    public void insert(int pos, char b) {
        insert(pos, String.valueOf(b));//字符转字符串
    }

    //插入字符串
    @Override
    public void insert(int pos, String b) {
        if (pos<0 || pos>length) {    //不存在负数索引
            return;
        }
        if (pos>length) {//也不存在超过长度的
            return;
        }
        if (b==null) {//字符串是空的也不行
            return;
        }
        //超出扩容
        while (length+b.length()>capacity) {
            capacity = (int) ((length+b.length())*1.5f);//扩容1.5倍
            char[] newValue = new char[capacity];
            //扩容只是，把旧数组的元素，装到新扩容的数组里
            System.arraycopy(value, 0, newValue, 0, length);//只是扩容，填充数据不变
            value = newValue;//把旧数组替换掉
        }
        //满足容量，往后移
        char[] cs = b.toCharArray();    //b转字符数组
        System.arraycopy(value, pos, value, pos+cs.length, length-pos);//预留插入空位
        //插入b
        System.arraycopy(cs, 0, value, pos, cs.length);
        length = length+cs.length;
    }

    //删除起始点后所有的元素
    @Override
    public void delete(int start) {
        delete(start, length);//结束位就是整个长度

    }

    //删除起始点到结束点所有的元素
    @Override
    public void delete(int start, int end) {
        //判断边界
        if (start<0 || start>length) {
            return;
        }
        if (end<0 || end>length) {
            return;
        }
        //复制填充至
        System.arraycopy(value, end, value, start, length-end);
        length -= end-start;//减少数组长度
    }

    @Override
    public void reverse() {         //反转
        for (int i = 0; i < length/2; i++) {
            char temp = value[i];
            value[i] = value[length-1-i];
            value[length-1-i] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }
    //重写toString

    public String toString(){

        char[] realValue = new char[length];

        System.arraycopy(value, 0, realValue, 0, length);

        return new String(realValue);

    }
}

package work.wk.mianshi.alimianshi;

/**
 * Created by wkhuahuo on 2017/3/2.
 */
public class AliMianShi {
    public static void main(String[] args){
        int[] num = {56477,56465,51835,63190,44858,62933,40492};
        StringBuffer strb = new StringBuffer();

        byte[] result= new byte[num.length];
        for(int i=0;i<num.length;i++){
            result[i] = decode(num[i]);
        }
        for(byte i=0;i<result.length/2;i++){
            byte tmpb = result[i];
            result[i] = result[result.length-1-i];
            result[result.length-1-i] = tmpb;
        }
        for(byte i=0;i<result.length;i++){
            result[i] = (byte)(~result[i]);
        }
        String str = new String(result);
        System.out.println(str);


    }

    public static byte decode(int num){
        StringBuffer strB = new StringBuffer();
        System.out.println(num);
        byte cha =(byte)(num&0xff);
        System.out.println("cha: "+cha);
        byte fansuiji = (byte)((num>>>8)&0xff);
        System.out.println("fansuiji: "+fansuiji);
        byte suiji = (byte)(fansuiji^0xff );
        System.out.println("suiji: "+suiji);
        byte yuanlai = (byte) (suiji +cha);
        System.out.println("yuanlai: "+yuanlai);

        return yuanlai;
    }


        private static int myReverse(byte input) {
            int result = 0;
            for (int i = 0; i < 8; i++) {      // 一共8位
                if (((input >> i) & 1) == 1) {  // 如果移位后最右位为1
                    int j = 8 - i;             // 判断当前是第几位，并换算成反转后的位数
                    result |= 1 << j;           // 得知是反转后第几位，存入结果result中
                }
            }
            return result;
        }


}

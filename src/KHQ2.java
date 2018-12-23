import java.io.IOException;
import java.util.ArrayList;

public class KHQ2 {
    public static void main(String[] args) throws IOException {
        Student[] stus=FileUtil.parseStudents("./text/students.txt");
        String[] name = new String[18826];
        int[] countArray=new int[18826];
        //拷贝一个名字数组
        for (int i=0;i<stus.length;i++) {
            name[i]=stus[i].getName();
        }
        //得到一个名字出现次数的数组
        for (int j=0;j<stus.length;j++){
            int count=0;
            for (int i=0;i<stus.length;i++) {
                if(stus[i].getName().equals(name[j])){
                count++;
                }
            }
            countArray[j]=count;
//            System.out.println(count+" "+name[j]);
        }
        //得到次数数组最大的元素和其下标
        int max=countArray[0];
        int index=0;
        for (int i = 0; i < countArray.length; i++){
            if (countArray[i] > max){
                max=countArray[i];
                index = i;
            }
        }
        System.out.println("使用最多的名字为"+name[index]+"\n使用的次数为"+max);
    }
}

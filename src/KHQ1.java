import java.io.IOException;
import java.util.Scanner;

public class KHQ1 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入学号:");
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        Student[] stus=FileUtil.parseStudents("./text/students.txt");
        int count=0;
        for (Student sd:stus) {
            if(input.equals(sd.getStuid())){
                System.out.println(sd.getName());
            }else{
                count++;
            }
        }
        if(count==18826){
            System.out.println("该学生不存在");
        }
    }
}

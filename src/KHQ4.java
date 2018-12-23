public class KHQ4 {
    public static Boolean parse(String json){
        char[] array = json.toCharArray();
        char[]array2=new char[100];
        for (int i = 0; i<array.length; i++){
            int chr = json.charAt(i);
            if (chr==91||chr==93||chr==123||chr==125) {
                array2[i] = array[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        parse("{"test":[{"test":"sdf"},{"test":"sdf"},{"test":"sdf"}]}");
    }
}

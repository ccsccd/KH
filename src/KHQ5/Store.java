package KHQ5;

import java.util.ArrayList;

public class Store {
    ArrayList<Good> goods=new ArrayList<>();
    public void getGood(Good good){
        goods.add(good);
    }
    public void buy(Junior junior,int index){
        if(junior.score<goods.get(index).getPrice()){
            System.out.println("积分不足");
        }else {
        junior.score-=goods.get(index).getPrice();

        }
    }
}

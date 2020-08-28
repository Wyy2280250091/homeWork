package com.example.demo.demo05;

import java.util.*;

/**
 * &lt;b&gt;方法名称：&lt;/b&gt;(斗地主)&lt;br/&gt;
 * &lt;b&gt;方法描述：&lt;/b&gt;(这里描述这个方法适用条件 – 可选)&lt;br/&gt;
 * @return
 * @Param
 * @author 王宜勇
 * @exception
 * @since  1.0.0
 */
public class DouDizhu {
    public static void main(String[] args) {
        //1准备牌
        //创建一个map集合 存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();

        //创建一个list集合存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //创建俩个list集合储存牌的花色和序号
      //List<String> colors =List.of("♣","♥","♦","♠");
        //List<String> numbers = List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K");
      //ArrayList<String> numbers =new ArrayList<>["A","2","3","4","5","6","7","8","9","10","J","Q","K"];

        String[] arr1 = new String[]{"♣","♥","♦","♠"};
        String[] arr2 = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};


        List<String> colors = new ArrayList<>();
        colors.addAll(Arrays.asList(arr1));

        System.out.println(colors);
        List<String> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(arr2));
        System.out.println(numbers);

        //把大王小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index ,"小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历俩个集合
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
        System.out.println(poker);
        System.out.println(pokerIndex);

        //洗牌Collections shuff
        Collections.shuffle(pokerIndex);
        System.out.println(pokerIndex);
        
        //发牌 定义四个集合 定义玩家和底盘
        ArrayList<Integer> play01 = new ArrayList<>();
        ArrayList<Integer> play02 = new ArrayList<>();
        ArrayList<Integer> play03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //先判断底牌
            if(i>=51){
                dipai.add(in);
            }else if (i%3 ==0){
                //玩家一
                play01.add(in);
            }else if (i%3 ==1){
                //玩家二
                play02.add(in);
            }else if (i%3 ==2){
                //玩家三
                play03.add(in);
            }
        }
        //排序  collections sort
        Collections.sort(play01);
        Collections.sort(play02);
        Collections.sort(play03);
        Collections.sort(dipai);

        //看牌
        lookPoker("刘德华",poker,play01);
        lookPoker("周星驰",poker,play02);
        lookPoker("周润发",poker,play03);
        lookPoker("底牌",poker,dipai);
    }


    //看牌
    public static  void lookPoker(String name,HashMap<Integer,String>poker,ArrayList<Integer>list){
        //输出玩家名称
        System.out.print(name+": ");

        //遍历玩家底牌集合
        for(Integer key: list){
            String value = poker.get(key);
            System.out.print(value+"");
        }
        System.out.println();//打印完成换行
    }
}

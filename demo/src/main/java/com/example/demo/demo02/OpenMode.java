package com.example.demo.demo02;

import java.util.ArrayList;

public interface OpenMode {

    /**
     * 将totalMoney 分成count份 保存到ArrayList<Integer>中 返回
     * @param totalMoney
     * @param totalCount
     * @return
     */
    ArrayList<Integer> divide(int totalMoney,int totalCount);
}

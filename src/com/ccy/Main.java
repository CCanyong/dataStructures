package com.ccy;

import com.ccy.linearList.MyStack;

public class Main {

    public static void main(String[] args) {
        testStack();
    }

    /**
     * 测试栈的使用
     */
    public static void testStack(){
        MyStack<String> stack = new MyStack();
        for (int i=0;i<20;i++){
            stack.push("wo"+i);
        }
        String s;
        while ((s=stack.pop())!=null){
            System.out.println(stack.size()+"======"+s);
        }
    }

}

package com.ccy.linearList;

import java.util.Objects;

/**
 * 栈的数组实现
 *
 * 功能：
 * 1. push         压栈
 * 2. pop          弹栈
 * 3. clear       清空
 * 4. isEmpty    判断是否为空
 *
 * @author 陈灿勇
 */
public class MyStack<E> {

    // 栈的大小
    private Integer size = 0;

    // 默认初始化栈的大小
    private static final Integer DEFAULT_INIT_SIZE = 10;

    // 栈的数组实现
    private Object[] stack;

    public MyStack() {
        stack = new Object[DEFAULT_INIT_SIZE];
    }

    public MyStack(Integer size) {
        stack = new Object[size];
    }

    /**
     * 将元素压入栈顶
     *
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (stack.length == size) {
            extend();
        }
        this.stack[size++] = e;
        return true;
    }

    /**
     * 将元素从栈顶弹出
     *
     * @return
     */
    public E pop() {
        if (size == 0) {
            return null;
        }
        return (E) stack[--size];
    }

    /**
     * 清空栈
     */
    public void clear() {
        size = 0;
    }

    /**
     * 判断站是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size != 0;
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    public Integer size() {
        return this.size;
    }

    /**
     * 数组扩容
     */
    private void extend() {
        Object[] temp = new Object[stack.length * 3 / 2];
        // 将原数组 copy 到新数组
        System.arraycopy(stack, 0, temp, 0, stack.length);
        stack = temp;
    }


}

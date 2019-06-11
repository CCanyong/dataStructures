package com.ccy.linearList;

import java.util.Iterator;

/**
 * 双向链表的实现
 *
 * @param <E>
 * @author 陈灿勇
 */
public class MyLinkedList<E> implements Iterable<E> {

    /**
     * 节点内部类
     *
     * @param <E>
     */
    private static class Node<E> {

        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    //链表有效长度
    private Integer size;
    //链表头节点
    private Node<E> head;
    //链表尾节点
    private Node<E> tail;

    public Integer size() {
        return size;
    }


    /**
     * 从末尾插入数据
     *
     * @param data 将要插入的数据
     * @return 成功返回true
     */
    public boolean insert(E data) {
        insert(size(), data);
        return true;
    }

    /**
     * 按指定索引插入数据
     *
     * @param index 索引值
     * @param data  将要插入的数据
     * @return 成功返回true
     */
    public boolean insert(Integer index, E data) {
        Node<E> p = getNode(index);
        Node<E> newNode = new Node(data, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        size++;
        return true;
    }

    /**
     * 获取指定索引的数据
     *
     * @param index
     * @return 数据
     */
    public E get(Integer index) {
        return getNode(index).data;
    }

    /**
     *
     * @param index
     * @param val
     * @return
     */
    public E set(Integer index, E val) {
        Node<E> p = getNode(index);
        E old = p.data;
        p.data = val;
        return old;
    }


    /**
     * 获取指定索引的节点
     * 索引从 0 开始
     *
     * @param index
     * @return
     */
    private Node<E> getNode(Integer index) {

        Node<E> temp;

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            temp = head.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail.prev;
            for (int i = size(); i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

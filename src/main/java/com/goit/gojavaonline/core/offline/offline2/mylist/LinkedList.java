package com.goit.gojavaonline.core.offline.offline2.mylist;

public class LinkedList<LT> {

    private Node<LT> root;
    private Node<LT> end;
    private int size;

    public void add(LT a) {
        if(size==0){
            Node<LT> node = new Node<>(a);
            root =  node;
            end = node;
            size = 1;
        }else {
            Node<LT> node = new Node<>(a);
            end.setNext(node);
            end = node;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public LT get(int index) {
        if(index<0 || index>=size) throw new IllegalArgumentException("index out of bounds");
        Node<LT> current = root;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void add(LT object, int index) {
        if(index == 0){
            Node<LT> node = new Node<>(object);
            node.setNext(root);
            root = node;
        }else {
            Node<LT> newNode = new Node<>(object);
            Node<LT> previous = root;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }
        size++;
    }


    // Node<String> node = new Node<>();
    // String s = node.getData()

    static class Node<NT>{
        private NT data;
        private Node<NT> next;

        public Node(NT a) {
            this.data = a;
        }

        public NT getData() {
            return data;
        }

        public void setData(NT data) {
            this.data = data;
        }

        public Node<NT> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

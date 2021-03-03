/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly_linked_list;

/**
 *
 * @author ِABO-DALAL
 */
public class DLList<E>{

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DLList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {  // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public E remove(Node<E> node) {
        if (isEmpty()) {
            return null;
        }
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> delnode = header.getNext();
        Node<E> predecessor = header;
        Node<E> successor = delnode.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return delnode.getElement();
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        return remove(trailer.getPrev());
    }

//------------------ method reverse--------------------------
    public void loopBackword() {
        Node<E> element = trailer.getPrev();
        for (; element.getPrev() != null; element = element.getPrev()) {
            System.out.println("" + element.getElement());
        }
    }
//------------- method search---------------

    public boolean Contains(E element) {
        if (isEmpty()) {
            return false;
        }
        Node<E> pointer = header.getNext();

        for (; pointer.getNext() != null; pointer = pointer.getNext()) {
            if (pointer.getElement() == element) {
                return true;
            }
        }
        return false;
    }
// *********** method Add by index*****************************************

    public E add(int index, E element) {
        if (isEmpty()) {
            return null;
        }
        Node<E> temp = header.getNext();
        int count = 0;
        for (; temp != null; temp = temp.getNext()) {
            if (count == index) {
                Node<E> pred = temp.prev;
                addBetween(element, pred, temp);
                break;
            }
            count++;
        }
        return element;
    }
//----------------------- Inner Class Node -----------------------------------------------
    public class Node<E> {

        public E element;
        public Node<E> prev;
        public Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next) {
            element = e;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
}

public class MyLinkedList<E>{
    private int size;
    private Node<E> head;
    private Node<E> tail;


    public MyLinkedList(){
        head = null;
        tail = null;
    }


    public void addLast(E e){
        Node<E> node = new Node<>(e);
        if(tail==null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public E removeFirst(){
        if(size==0){
            return null;
        }
        else{
            Node<E> formerHeadNode = head;
            head = head.next;
            size--;
            if(head==null){
                tail=null;
            }
            return formerHeadNode.element;
        }
    }

    public E removeLast(){
        if(size==0){
            return null;
        }
        if(size==1){
            Node<E> formerHeadNode = head;
            head=null;
            tail = null;
            size=0;
            return formerHeadNode.element;
        }
        else{
            Node<E> node = head;
            for(int i =0;i<size-2;i++){
                node = node.next;
            }
            Node<E> formerTailNode = tail;
            tail = node;
            tail.next = null;
            size--;
            return formerTailNode.element;
        }
    }

    public int indexOf(E e){
        int index = 0;
        if(e!=null){
            for(Node<E> i = head;i!=null;i=i.next){
                if(e.equals(i.element)){
                    return index;
                }
                index++;
            }
        }else{
            for(Node<E> i = head;i!=null;i=i.next){
                if(i.element==null){
                    return index;
                }
                index++;
            }

        }
        return -1;
    }

    public String toString(){
        StringBuilder toString = new StringBuilder("[");
        Node<E> curNode = head;
        for(int i=0;i<size;i++){
            toString.append(curNode.element);
            curNode = curNode.next;
            if(curNode!=null){
                toString.append(", ");
            }
            else{
                toString.append("]");
            }
        }
        return toString.toString();
    }


    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}

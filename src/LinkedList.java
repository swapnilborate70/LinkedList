public class LinkedList<T> {

    Node<T> head;


    void printLinkedList() {
        Node<T> current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    void add(T element) {
        Node<T> temp = new Node<>(element);

        if (head == null) {
            head = temp;
        } else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        } else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            Node<T> current = head;
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        } else {
            T returnValue;
            if (head.next == null) {
                returnValue = head.data;
                head = null;
            } else {
                returnValue = head.data;
                head = head.next;
            }
            return returnValue;
        }
    }


    public T removeLast() {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        } else {
            T returnValue;
            ;
            if (head.next == null) {
                returnValue = head.data;
                head = null;
            } else {
                Node<T> current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                returnValue = current.next.data;
                current.next = null;
            }

            return returnValue;
        }
    }

    public boolean remove(T element) {
        if (head == null) {
            throw new NullPointerException("The list is empty");

        } else {
            boolean returnValue = false;

            if (head.data.equals(element)) {
                if (head.next == null) {
                    head = null;
                    returnValue = true;
                } else {
                    head = head.next;
                    returnValue = true;
                }

            } else {
                Node<T> current = head;

                while (current.next != null) {
                    if (current.next.data.equals(element)) {
                        if (current.next.next == null) {
                            current.next = null;
                            returnValue = true;
                            break;
                        } else {
                            current.next = current.next.next;
                            returnValue = true;
                            break;
                        }
                    }
                    current = current.next;
                }
            }
            return returnValue;
        }
    }

    public void clear() {
        head = null;
    }

    public boolean contains(T element) {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        } else {
            boolean returnValue = false;
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(element)) {
                    returnValue = true;
                    break;
                }
                current = current.next;
            }
            return returnValue;
        }
    }


    public int indexOf(T element) {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        } else {
            int index = -1;
            boolean isEquals = false;

            Node<T> current = head;
            while (current != null) {
                index++;
                if (current.data.equals(element)) {
                    isEquals = true;
                    break;
                }
                current = current.next;
            }

            if (isEquals) {
                return index;
            } else {
                return -1;
            }
        }
    }

    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T returnValue = null;

        while (current != null) {
            if (index == currentIndex) {
                returnValue = current.data;
                break;
            }
            currentIndex++;
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("provided index is out of list index range");
        }
        return returnValue;
    }
}

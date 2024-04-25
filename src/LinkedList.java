import java.util.Optional;

public class LinkedList {

    Node head;

    void printLinkedList() {
        Node current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    void add(int element) {
        Node temp = new Node(element);

        if (head == null) {
            head = temp;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public int getFirst()
    {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        }
        return head.data;
    }

    public int getLast()
    {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        }
        else {
            Node current = head;
            while (current.next != null)
            {
                current=current.next;
            }
            return current.data;
        }
    }

    public int size()
    {
        if(head == null)
        {
            return 0;
        }
        else {
            Node current = head;
            int count = 0;
            while(current != null)
            {
                count++;
                current=current.next;
            }
            return count;
        }
    }

    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        else
            return false;

    }

    public int removeFirst()
    {
        if(head == null)
        {
            throw new NullPointerException("The list is empty");
        }
        else
        {
            int returnValue = head.data;

            if(head.next==null)
            {
                head=null;
            }
            else
            {
                head = head.next;
            }
            return returnValue;
        }
    }

    public int removeLast()
    {
        if(head == null)
        {
            throw new NullPointerException("The list is empty");
        }
        else
        {
            int returnValue=0;

            Node current = head;

            while(current.next !=null)
            {
                if((current.next.next) == null)
                {
                    returnValue = (current.next).data;
                    current.next=null;
                    break;
                }
                else
                {

                    current=current.next;
                }
            }
            return returnValue;
        }
    }

    public boolean remove(int number)
    {
        if(head == null)
        {
            throw new NullPointerException("The list is empty");
        }
        else {
            boolean response = false;
            if(head.data==number)
            {
                if(head.next == null)
                {
                    head=null;
                    response= true;
                }
                else {
                    head=head.next;
                    response= true;
                }
            }
            else
            {
                Node current = head;
                while(current.next != null)
                {
                    if(current.next.data==number)
                    {
                        if(current.next.next==null)
                        {
                            current.next=null;
                            response = true;
                        }
                        else
                        {
                            current.next=current.next.next;
                            response =  true;
                        }
                    }
                    current=current.next;
                }
            }
            return response;
        }
    }

}

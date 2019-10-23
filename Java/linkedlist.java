public class linkedlist{
    public Node head = null;

    public void insert(Node n){
        n.next = head;
        head = n;
    }

    public void insertAtPos(Node nd, int pos){
        Node current = head;
        int counter = 0;

        if(pos == 0){                   //not sure if this messes with "head"
            nd.next = head;
            head = nd;
            return;     
        }

        while(current != null){
            
            if(counter == pos-1){
                nd.next = current.next;
                current.next = nd;
            }
            current = current.next;
            counter++;
        }
    }

    public void insetAtEnd(Node nd){
        Node current = head;
        
        while(current.next !=null){
            current = current.next; 
        }
        current.next = nd;
        nd.next =null;
    }


    public Node search (int nummer) {
        Node current = head;

        while (current != null){
            if(current.element == nummer) return current;
            current = current.next;
        }
        return null;
    }

    public void output(){       //zum Ausgeben von allen Elementen
        Node current = head;
        int counter =  0;
        while(current != null){
            System.out.println("Element " + counter + ":" + current.element);
            counter++;
            current = current.next;
        }
    }

    public void delete(int nummer){
        Node current = head;

        if(head.element == nummer){         //Sonderfall für das 1.Element
            head = head.next;
            return;
        }

        while(current!=null && current.next != null){       	//Suche nach dem zu löschenden Element
            if(current.next.element == nummer)
            current.next = current.next.next;
            current = current.next;
        }
    }

    public linkedlist inverseList(){
        Node current = head;
        linkedlist l = new linkedlist();
        
        while(current != null){
            l.insert(new Node(current.element));
            current = current.next;
        }
        return l;
    }

    public void combineLists(linkedlist l1, linkedlist l2){
        Node current = l1.head;
        while(current.next !=null){
            current = current.next; 
        }

        current.next = l2.head;
    }
}
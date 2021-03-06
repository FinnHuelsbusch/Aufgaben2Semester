package doubleLinkedList;

public class DoubleLinkedList<D> {

    private Node<D> firstNode = null;
    private Node<D> lastNode = null;

    public void add(D data){
        Node<D> newNode = new Node<D>(data);

        if(this.firstNode == null && this.lastNode == null){
            // Empty List
            this.firstNode = newNode;
            this.lastNode = newNode;
        }else{
            this.lastNode.setNextNode(newNode);
            newNode.setPrevNode(this.lastNode);
            this.lastNode = newNode;
        }
    }

    public void addFirst(D data){
        Node<D> newNode = new Node<D>(data);

        if(this.firstNode == null && this.lastNode == null) {
            // Empty List
            this.firstNode = newNode;
            this.lastNode = newNode;
        }else{
            this.firstNode.setPrevNode(newNode);
            newNode.setNextNode(this.firstNode);
            this.firstNode = newNode;
        }
    }

    public boolean remove(D data){

        if(!(this.firstNode == null && this.lastNode == null)) {
            Node<D> currentNode = this.firstNode;

            do{
                if(currentNode.getData().equals(data)){
                    if(currentNode == firstNode){
                        currentNode.getNextNode().setPrevNode(null);
                        this.firstNode =  currentNode.getNextNode();
                        return true;
                    }

                    if(currentNode == lastNode){
                        currentNode.getPrevNode().setNextNode(null);
                        this.lastNode = currentNode.getPrevNode();
                        return true;
                    }

                    currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
                    currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());

                    return true;
                }
                currentNode = currentNode.getNextNode();
            }while(currentNode.getNextNode() != null);

        }

        return false;
    }


    public boolean contains(D data){
        Node<D> workingNode = firstNode;
        if (workingNode == null) {
            return false;
        }
        while (workingNode.getNextNode() != null && !workingNode.getData().equals(data)) {
            workingNode = workingNode.getNextNode();
        }
        if (workingNode.getData().equals(data)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node workingNode = firstNode;
        if (workingNode == null) {
            return null;
        }
        String ausgabe = "";
        while (workingNode.getNextNode() != null){

                ausgabe = ausgabe + workingNode.getData() + ", ";
                //ausgabe.append(workingNode.getData()).append(", ");

            workingNode = workingNode.getNextNode();
        }
        ausgabe = ausgabe + workingNode.getData();
        //ausgabe.append(workingNode.getData());
        return ausgabe;
        //return ausgabe.toString();
    }


    private class Node<D>{

        private Node<D> prevNode;
        private D data;
        private Node<D> nextNode;

        public Node(D data){
            this.prevNode = null;
            this.data = data;
            this.nextNode = null;
        }

        public D getData(){
            return data;
        }

        public Node<D> getNextNode(){
            return this.nextNode;
        }

        public void setNextNode(Node<D> nextNode){
            this.nextNode = nextNode;
        }

        public Node<D> getPrevNode(){
            return this.prevNode;
        }

        public void setPrevNode(Node<D> prevNode){
            this.prevNode = prevNode;
        }

    }
}

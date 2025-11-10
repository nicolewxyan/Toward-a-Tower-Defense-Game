
package assignment1;

public class SwarmOfHornets {
    private Hornet[] hornets;
    private int numOfHornets;
    private Node first;
    private Node last;
    public static double QUEEN_BOOST = 0.1;


    private static class Node {
        Hornet hornet;
        Node next;

        Node(Hornet hornet) {
            this.hornet = hornet;
            this.next = null;
        }
    }


    public SwarmOfHornets() {
        this.hornets = new Hornet[0];
        this.numOfHornets = 0;
        this.first = null;
        this.last = null;
    }


    public int sizeOfSwarm(){
        return numOfHornets;
    }


    public Hornet[] getHornets(){
        Hornet[] hornetInSwam = new Hornet[numOfHornets];
        Node current = first;
        for (int i = 0; i < numOfHornets; i++) {
            hornetInSwam[i] = current.hornet;
            current = current.next;
        }
        this.hornets = hornetInSwam;
        return hornetInSwam;
    }


    public Hornet getFirstHornet(){
        return (first == null) ? null : first.hornet;
    }


    public void addHornet(Hornet newHornet){
        boolean addingQueen = newHornet.isTheQueen();

        Node newNode = new Node(newHornet);
        if (last == null){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        numOfHornets++;

        if (addingQueen) {
            Node current = first;
            while (current != null) {
                if (current.hornet != newHornet) { 
                    current.hornet.regenerateHealth(QUEEN_BOOST);
                }
                current = current.next;
            }
        }
    }


    public boolean removeHornet(Hornet removingHornet){

        //Empty List
        if(first == null){
            return false;
        }

        //Removing first hornet
        if (first.hornet == removingHornet) {
            first = first.next;
            if(first == null){
                last = null;
            }
            numOfHornets--;
            return true;
        }

        //Removing middle or last hornet
        Node current = first;
        while (current.next != null){
            if (current.next.hornet == removingHornet){
                current.next = current.next.next;
                if (current.next == null){
                    last = current;
                }
                numOfHornets--;
                return true;
            }
            current = current.next;
        }

        //No such hornet found
        return false;
    }

}



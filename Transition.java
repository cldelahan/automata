// Conner Delahanty
// The goal of this is to create a transition between two states
public class Transition implements Comparable{

    private String transition; // String describing transition between two states
    private State from;
    private State to;

    /**
     * @param transition the Transition name
     * @param from the from State
     * @param to the Transition endpoint
     */
    public Transition(String transition, State from, State to) {
        this.setTransition(transition);;
        this.setTo(to);
        this.setFrom(from);
    }
    
    /**
     * @return the from Vertex
     */
    public State getFrom() {
        return from;
    }

    /**
     * @param from the from Vertex to set
     */
    public void setFrom(State from) {
        this.from = from;
    }

    /**
     * @return the to Vertex
     */
    public State getTo() {
        return to;
    }

    /**
     * @param to the to Vertex to set
     */
    public void setTo(State to) {
        this.to = to;
    }

    /**
     * @return the transition
     */
    public String getTransition() {
        return transition;
    }

    /**
     * @param transition the transition to set
     */
    public void setTransition(String transition) {
        this.transition = transition;
    }

    @Override
    public int compareTo(Object newTran) {
        Transition t = (Transition) newTran;
        // sort by From, then transition value, then To
        int compareFrom = this.getFrom().toString().compareTo(t.getFrom().toString());
        int compareTransition = this.getTransition().compareTo(t.getTransition());
        // using DFAs, the compareTo should never have to be used. 
        // including it for more general instances (NFA for example)
        int compareTo = this.getTo().toString().compareTo(t.getTo().toString());
        if (compareFrom != 0) {
            return compareFrom;
        }
        if (compareTransition != 0) {
            return compareTransition;
        }
        if (compareTo != 0) {
            return compareTo;
        }
        return 0;
    }

    public boolean equals(Transition t) {
        return this.compareTo(t) == 0;
    }

    public String toString() {
        String output = "";
        output += this.getFrom().toString() + " ";
        output += this.getTransition() + " ";
        output += this.getTo().toString();
        return output;
    }
}
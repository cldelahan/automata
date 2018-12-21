// Conner Delahanty
// The goal of this is to create a transition between two states
public class Transition {

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

    public String toString() {
        String output = "";
        output += this.getFrom().toString() + " ";
        output += this.getTransition() + " ";
        output += this.getTo().toString();
        return output;
    }
}
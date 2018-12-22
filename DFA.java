// Conner Delahanty
// DFA represents a graph in its formal format
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class DFA {

    // array list for easy use in adjacency matrix
    private ArrayList<State> Q;
    private ArrayList<String> sigma;
    // specific start state
    private State startState;
    // set of accept states
    private Set<State> F;

    DFA() {
        this.Q = new ArrayList<State>();
        this.sigma = new ArrayList<String>();
        this.F = new TreeSet<State>();
    }

    DFA (ArrayList<State> Q, ArrayList<String> sigma, State startState, Set<State> F) {
        this.Q = Q;
        this.sigma = sigma;
        this.startState = startState;
        this.F = F;
    }


    private class State implements Vertex, Comparable { // creating the State class
        private String name;
        private ArrayList<Transition> transitions;

        State(String name) {
            this.name = name;
            transitions = new ArrayList<Transition>();
        }

        public void addTransition(Transition t) {
            transitions.add(t);
        }

        public State getNextState(String s) {
            for (Transition t: this.transitions) {
                if (s.equals(t.getTransition())) {
                    return t.getTo();
                }
            }
            return null;
        }

        public int compareTo(Object o) {
            State s1 = (State) o;
            return this.name.compareTo(s1.name);
        }
    }

    private class Transition implements Edge { // creating a transition class
        private String transition;
        private State from;
        private State to;

        Transition() {}

        Transition(State from, State to, String transition) {
            this.from = from;
            this.to = to;
            this.transition = transition;
        }

        public String getTransition() {
            return this.transition;
        }

        public State getTo() {
            return this.to;
        }
    }

    /**
     * @param name name identifier of a state
     */
    public Vertex addState(String name) {
        State s1 = new State(name);
        Q.add(s1);
        return (Vertex) s1;
    }

    public State convertToState(Vertex v) {
        return (State) v;
    }

    public Edge addTransition(Vertex v1, Vertex v2, String transition) {
        State s1 = this.convertToState(v1);
        State s2 = this.convertToState(v2);
        Transition t1 = new Transition (s1, s2, transition);
        s1.addTransition(t1);
        return (Edge) t1;
    }

    public void addAcceptState(Vertex v1) {
        State s1 = convertToState(v1);
        this.F.add(s1);
    }

    public void setStartState(Vertex v1) {
        State s1 = convertToState(v1);
        this.startState = s1;
    }

    public boolean accepts(String s) {
        State cursor = this.startState;
        for (int i = 0; i < s.length(); i++) {
            cursor = cursor.getNextState(s.charAt(i)+"");
        }
        if (F.contains(cursor)) {
            return true;
        } else {
            return false;
        }

    }


    // should I put State and Transition as inner classes?
    public static void main(String args[]) {
        DFA d1 = new DFA();
        Vertex q0 = d1.addState("q0");
        Vertex q1 = d1.addState("q1");
        Vertex q2 = d1.addState("q2");
        Vertex q3 = d1.addState("q3");

        Edge t1 = d1.addTransition(q0, q1, "1");
        Edge t2 = d1.addTransition(q1, q2, "0");
        Edge t3 = d1.addTransition(q0, q2, "0");
        Edge t4 = d1.addTransition(q2, q3, "1");
        Edge t5 = d1.addTransition(q3, q2, "0");

        d1.addAcceptState(q3);
        d1.addAcceptState(q0);

        d1.setStartState(q0);

        System.out.println(d1.accepts("1010101")); // expected: True
        System.out.println(d1.accepts("10")); // Expected: False
        System.out.println(d1.accepts("1010")); // Expected: False
    }

}
// Conner Delahanty
// Resembles a state of any machine
public class State {
    private String name;


    /**
     * @param name the State's name
     */
    public State(String name){
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the string name
     */
    public String toString() {
        return this.getName().toString();
    }
}
package adopoo;

import java.util.ArrayList;

public class regiao {
    private String name;
    private ArrayList<estado> states;

    public regiao(String name) {
        this.name = name;
        this.states = new ArrayList<estado>();
    }

    public void addState(estado state) {
        this.states.add(state);
    }

    public ArrayList<estado> getStates() {
        return this.states;
    }

    public String getName() {
        return this.name;
    }

    public void fillStates(ArrayList<estado> states) {
        for (estado regionState : this.states) {
            for (estado state : states) {
               
                if (regionState.getID().equals(state.getID())) {
                    regionState.setPib(state.getPib());
                }
            }
        }
    }

    public Double getRegionPib() {
        Double pib = 0.0;
        for (estado state : this.states) {
            pib += state.getPib();
        }

        return pib;
    }
}
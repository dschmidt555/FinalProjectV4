package finalProject;

import java.util.HashMap;

public class StateList {
	
	
	public HashMap<String, String> returnHash(HashMap<String, String> inputHash) {
		
		//HashMap<String, String> menu = new HashMap<String, String>();
		
		return inputHash;
	}
	
	
	
	State emptyBurger;
	State fullBurger;
	State emptySlaw;
	State fullSlaw;
	State emptyFries;
	State fullFries;
	
	State state;
	
	
	public StateList() {
		emptyBurger = new StateEmptyBurger(this);
		fullBurger = new StateFullBurger(this);
		emptySlaw = new StateEmptySlaw(this);
		fullSlaw = new StateFullSlaw(this);
		emptyFries = new StateEmptyFires(this);
		fullFries = new StateFullFires(this);
		
		state = emptyBurger;
	}
	
	
	public void addBurger() {
		state.addBurger();
	}
	public void minusBurger() {
		state.minusBurger();
	}
	public void addSlaw() {
		state.addSlaw();
	}
	public void minusSlaw() {
		state.minusSlaw();
	}
	public void addFries() {
		state.addFries();
	}
	public void minusFries() {
		state.minusFries();
	}
	
	public void setState(State state) {
		this.state=state;
	}
	
	public State getState() {
		return state;
	}
	
	public State getEmptyBurger() {
		return emptyBurger;
	}
	
	public State getFullBurger() {
		return fullBurger;
	}
	
	public State getEmptySlaw() {
		return emptySlaw;
	}
	public State getFullSlaw() {
		return fullSlaw;
	}
	public State getEmptyFries() {
		return emptyFries;
	}
	public State getFullFries() {
		return fullFries;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(state);
		return result.toString();
	}
	
	

}

package finalProject;

public class StateEmptyBurger implements State{
	
	StateList stateList;
	
	public StateEmptyBurger(StateList stateList) {
		this.stateList = stateList;
	}

	@Override
	public void addBurger() {
		stateList.setState(stateList.fullBurger);
		
	}

	@Override
	public void minusBurger() {
		System.out.println("There is no burger to take away");
		
	}

	@Override
	public void addSlaw() {
		
		
	}

	@Override
	public void minusSlaw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFries() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minusFries() {
		// TODO Auto-generated method stub
		
	}

}

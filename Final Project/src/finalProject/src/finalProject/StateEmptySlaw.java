package finalProject;

public class StateEmptySlaw implements State{
	
StateList stateList;
	
	public StateEmptySlaw(StateList stateList) {
		this.stateList = stateList;
	}

	@Override
	public void addBurger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minusBurger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSlaw() {
		stateList.setState(stateList.fullSlaw);
		
	}

	@Override
	public void minusSlaw() {
		System.out.println("No slaw to take away");
		
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

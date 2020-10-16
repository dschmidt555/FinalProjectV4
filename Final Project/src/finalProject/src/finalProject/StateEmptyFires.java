package finalProject;

public class StateEmptyFires implements State{
	
StateList stateList;
	
	public StateEmptyFires(StateList stateList) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minusSlaw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFries() {
		stateList.setState(stateList.fullFries);
		
	}

	@Override
	public void minusFries() {
		System.out.println("No Fries to take away");
		
	}

}

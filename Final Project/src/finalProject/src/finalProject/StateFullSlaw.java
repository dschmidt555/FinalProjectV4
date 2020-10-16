package finalProject;

public class StateFullSlaw implements State{
	
StateList stateList;
	
	public StateFullSlaw(StateList stateList) {
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
		System.out.println("Slaw already full");
		
	}

	@Override
	public void minusSlaw() {
		stateList.setState(stateList.fullSlaw);
		
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

package finalProject;

public class StateFullBurger implements State{
	
StateList stateList;
	
	public StateFullBurger(StateList stateList) {
		this.stateList = stateList;
	}

	@Override
	public void addBurger() {
		System.out.println("Already have a burger");
		
	}

	@Override
	public void minusBurger() {
		stateList.setState(stateList.emptyBurger);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minusFries() {
		// TODO Auto-generated method stub
		
	}

}

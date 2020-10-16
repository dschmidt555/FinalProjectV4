package finalProject;

public class StateFullFires implements State{
	
StateList stateList;
	
	public StateFullFires(StateList stateList) {
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
		System.out.println("Fries alreayd full");
		
	}

	@Override
	public void minusFries() {
		stateList.setState(stateList.emptyFries);
		
	}

}

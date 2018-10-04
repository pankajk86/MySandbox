package consistent.hash;

public class BaseServerImpl implements Server {
	
	private String name;
	
	public BaseServerImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

//	@Override
//	public void setName(String name) {
//		this.name = name;
//	}

}

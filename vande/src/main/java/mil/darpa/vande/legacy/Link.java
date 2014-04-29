package mil.darpa.vande.legacy;





public class Link {

	private Linkable src;
	private Linkable destn;
	private boolean directed;
	private int count = 0;
	private Number value = 0;
	
	
	public Linkable getSrc() {
		return src;
	}


	public void setSrc(Linkable src) {
		this.src = src;
	}


	public Linkable getDestn() {
		return destn;
	}


	public void setDestn(Linkable destn) {
		this.destn = destn;
	}


	public boolean isDirected() {
		return directed;
	}


	public void setDirected(boolean directed) {
		this.directed = directed;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Number getValue() {
		return value;
	}


	public void setValue(Number value) {
		this.value = value;
	}

@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Link))
			return false;
		Link t = (Link) o;
		
		if (t.getSrc().equals(src) && t.getDestn().equals(destn))
			return true;
		else if (directed == false && t.getSrc().equals(destn) && t.getDestn().equals(src)) 
			return true;
		else
			return false;
	}
}

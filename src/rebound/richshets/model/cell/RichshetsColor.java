package rebound.richshets.model.cell;

import javax.annotation.concurrent.Immutable;

//Todo testtttttttt with google sheets' float colors that it does indeed perfectly preserve at least 8 bits in its floats!!

@Immutable
public class RichshetsColor
{
	protected final int r, g, b;  //[0, 256) = [0, 255]  like usual :3
	
	public RichshetsColor(int r, int g, int b)
	{
		if (r < 0)  throw new IllegalArgumentException();
		if (r > 255)  throw new IllegalArgumentException();  //not (r < 0 || r > 255) because this way there's different line numbers :3
		if (g < 0)  throw new IllegalArgumentException();
		if (g > 255)  throw new IllegalArgumentException();
		if (b < 0)  throw new IllegalArgumentException();
		if (b > 255)  throw new IllegalArgumentException();
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public int getR()
	{
		return r;
	}
	
	public int getG()
	{
		return g;
	}
	
	public int getB()
	{
		return b;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + g;
		result = prime * result + r;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichshetsColor other = (RichshetsColor) obj;
		if (b != other.b)
			return false;
		if (g != other.g)
			return false;
		if (r != other.r)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "("+r+", "+g+", "+b+")";
	}
}

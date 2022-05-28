package rebound.richshets.model.cell;

import javax.annotation.concurrent.Immutable;

//Todo testtttttttt with google sheets' float colors that it does indeed perfectly preserve at least 8 bits in its floats!!

/**
 * TODO Note that since this uses floats, care must be taken when *reading* this from a Datashet / Google Sheet, since it might be slightly different than when you last wrote it!!<br>
 * (But I'm pretty sure 0, 1, and simple powers of two in the denominator (like 0.5, 0.25, 0.75, 0.125, etc.) will be preserved perfectly.  And at the very least, can serve as sufficiently broad intervals for reliably interpreting colors.)<br>
 * <br>
 * Mostly, this is meant for *writing* to Datashets (for the benefit of the user), not for reading from them (except to preserve this)!<br>
 * <br>
 * And thus this also doesn't support a proper {@link #hashCode()} or {@link #equals(Object)} because of the floating points; it would be not always reliable.<br>
 */
@Immutable
public class RichshetColor
{
	protected final int r, g, b;  //[0, 256) = [0, 255]  like usual :3
	
	public RichshetColor(int r, int g, int b)
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
		RichshetColor other = (RichshetColor) obj;
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

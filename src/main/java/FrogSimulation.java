public class FrogSimulation
{
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops)
	{
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;  //ignore this, it's used for testing
	}
	//private int hopDistance() 
	//implementation is below, but not important

	//runs a simulation of the new FrogSimulation object
	public boolean simulate() { 
		int dist = 0;
		int hops = 0;
		//while the frog still has hops left, add it to the hopDistance, increment hops to count them
		while(hops < maxHops) {
			dist += hopDistance();
			hops++;
			//return false if the frog is in negative distance, return true if it passed the goal
			if(dist < 0) {
				return false;
			}
			else if(dist >= goalDistance) {
				return true;
			}
		}
		//otherwise return false;
		return false;
	}

	//counts the proportion of successful runs (i think)
	public double runSimulations(int num) { 
		//double so it can be divided later
		double successfulRuns = 0;
		//just literally adds the successful runs
		for(int i = 0; i < num; i++) {
			if(simulate() == true) {
				successfulRuns++;
			}
		}
		//the proportion part
		return successfulRuns/num;
	}
	
	
	//ignore the code below this line
	//-------------------------------------------------------------------------------------
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	
	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 

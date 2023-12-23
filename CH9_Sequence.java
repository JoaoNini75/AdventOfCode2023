package adventOfCode2023;

public class CH9_Sequence {

	private int[] sequence;
	private boolean allZeros;
	
	public CH9_Sequence(int[] sequence, boolean allZeros) {
		this.sequence = sequence;
		this.allZeros = allZeros;
	}

	public int[] getSequence() {
		return sequence;
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public boolean isAllZeros() {
		return allZeros;
	}

	public void setAllZeros(boolean allZeros) {
		this.allZeros = allZeros;
	}
	
}

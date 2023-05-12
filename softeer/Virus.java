package softeer;

import java.io.*;


public class Virus
{
	int k, p, n;

	public static void main(String args[]) throws Exception
	{
		Virus virus = new Virus();
		virus.getInputs();
		long answer = virus.getVirusCounts();
		virus.printAnswer(answer);
	}

	long getVirusCounts(){
		long count = k;

		for(int i = 1; i < n+1; i++){
			count = (count * p) % 1000000007;
		}

		return count;
	}

	void getInputs() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");

		k = Integer.parseInt(inputs[0]);
		p = Integer.parseInt(inputs[1]);
		n = Integer.parseInt(inputs[2]);

	}

	void printAnswer(long answer){
		System.out.println(answer);
	}
}
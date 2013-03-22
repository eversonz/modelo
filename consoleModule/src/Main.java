import com.everson.contole.Vote;


public class Main {

	public static void main(String[] args) {
	    
		Vote vote = new Vote();
		vote.loadClass();
		while (true) {
			vote.mascot();
			vote.input();
		}

	}

}

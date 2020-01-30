//written by park1564 imxxx074

public class Stop{

	public static String[] stopNames = {"Ramp B", "4th & Nicollet", "Anderson Hall", "Jones Hall", "Kasota Circle",
	"Como & Eustis", "Como & Cleveland", "Como & Snelling", "Como & Hamline", "Maryland and Dale", "Maryland and Rice",
	"Front and Lexington", "Front and Dale", "Capitol", "Cedar", "Union Depot"};

	public Stop(){}

	public static String getStopName(int stopNumber) {
		for (int i = 0; i < 16; i++) {
			if (stopNumber == i) {
				return stopNames[i];
			}
		}
		for (int i = 1; i < 15; i++) {
			if (30 - stopNumber == i) {
				return stopNames[i];
			}
		}
		return "";
	}
}// Stop class

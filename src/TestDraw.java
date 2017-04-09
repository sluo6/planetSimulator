
public class TestDraw {
	

	public static double readRadius(String planetsTxtPath) {
		In input = new In(planetsTxtPath);
		input.readInt();
		//input.readDouble();
		double output = input.readDouble();
		return output;
	}
	public static void drawBackground(double radius){
		StdDraw.setXscale(-radius, radius);
		StdDraw.setYscale(-radius, radius);
		StdDraw.picture(0, 0, "starfield.jpg");		
	}
	public static void drawAllplanets(Planet[] planetArray){
		for (Planet p:planetArray){
			p.drawPlanet();			
		}
	}
		
	public static void main(String[] args){
		String planetsTxtPath = "./data/planets.txt";
		double radius = readRadius(planetsTxtPath);
		Planet[] inputPlanets = NBody.readPlanets(planetsTxtPath); 
		
		drawBackground(radius);
		drawAllplanets(inputPlanets);
	}
}

//*Scanner keyBoard = new Scanner(System.in);
//double T = keyBoard.nextDouble();
//double dt = keyBoard.nextDouble();
//String filename = keyBoard.nextLine();
//String planetsTxtPath = "./data/planets.txt";
/*double universeRadius = NBody.readRadius(planetsTxtPath);
Planet[] inputPlanets = NBody.readPlanets(planetsTxtPath); 
drawBackground();
drawAllplanets(inputPlanets);*/
import java.util.Scanner;

public class NBody {

	public static Planet[] readPlanets(String planetsTxtPath) {
		Planet[] planetArray= new Planet[5];
		for(int i = 0; i< planetArray.length; i++){
			planetArray[i] = new Planet(0,0,0,0,0,"0");
		}
			
		In input = new In(planetsTxtPath);
		input.readInt();
		input.readDouble();
		for (int i = 0; i < planetArray.length; i++){
			planetArray[i].xxPos=input.readDouble();
			planetArray[i].yyPos=input.readDouble();
			planetArray[i].xxVel=input.readDouble();
			planetArray[i].yyVel=input.readDouble();
			planetArray[i].mass = input.readDouble();
			planetArray[i].imgFileName=input.readString();
		}
		return planetArray;
	}

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
		Scanner keyBoard = new Scanner(System.in);
		double T = keyBoard.nextDouble();
		double dt = keyBoard.nextDouble();
		//String filename = keyBoard.nextLine();
		String planetsTxtPath = "./data/planets.txt";
		double universeRadius = NBody.readRadius(planetsTxtPath);
		Planet[] inputPlanets = NBody.readPlanets(planetsTxtPath); 
		
		
		
		for(double t = 0; t<=T; t=t+dt){
			double[] xForces = new double[5];
			double[] yForces = new double[5];
			//for(int j = 0; j < inputPlanets.length; j ++){
				for(int i = 0; i < inputPlanets.length; i++){
					xForces[i]=inputPlanets[i].calcNetForceExertedByX(inputPlanets);
					yForces[i]=inputPlanets[i].calcNetForceExertedByY(inputPlanets);
					//System.out.println("xForce+" + i + "=" + xForces[i]);
					//System.out.println("yForce+" + i + "=" +yForces[i]);
	//	}
				inputPlanets[i].update(t, xForces[i], yForces[i]);
				System.out.println("j="+i); 
				System.out.println("Planet" + i  + "xPos" + "=" + inputPlanets[i].xxPos);
				System.out.println("Planet" + i  + "yPos" + "=" + inputPlanets[i].yyPos);
		StdDraw.clear();
		drawBackground(universeRadius);
		drawAllplanets(inputPlanets);
		
		StdDraw.show(100);
		}
		}
	}

}

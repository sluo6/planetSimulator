import java.util.Scanner;

public class NBody {
	static int planetNumber;
	
	
	public static double inputTotaltime(){
		System.out.println("Please enter total simulation time:");
		@SuppressWarnings("resource")
		Scanner keyBoard = new Scanner(System.in);
		double totalTime = keyBoard.nextDouble();
		return totalTime;
	}
	
	public static double inputdt(){
		System.out.println("Please enter fragment time:");
		@SuppressWarnings("resource")
		Scanner keyBoard = new Scanner(System.in);
		double dt = keyBoard.nextDouble();		
		return dt;
	}
	public static String inputPath(){
		System.out.println("Please enter simulation file path:");
		@SuppressWarnings("resource")
		Scanner keyBoard = new Scanner(System.in);
		String path = keyBoard.nextLine();		
		return path;
	}
	
	public static int readNumberofPlanets(String planetsTxtPath) {
		In input = new In(planetsTxtPath);
		int output = input.readInt();
		return output;
	}

	public static Planet[] readPlanets(String planetsTxtPath) {
		Planet[] planetArray= new Planet[planetNumber];
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
		String planetsTxtPath = inputPath();
		double T = inputTotaltime();
		double dt = inputdt();
		
		double universeRadius = NBody.readRadius(planetsTxtPath);
		planetNumber= readNumberofPlanets(planetsTxtPath);
		Planet[] inputPlanets = NBody.readPlanets(planetsTxtPath); 
		
		
		
		for(double t = 0; t<=T; t=t+dt){
			double[] xForces = new double[planetNumber];
			double[] yForces = new double[planetNumber];
			
				for(int i = 0; i < inputPlanets.length; i++){
					xForces[i]=inputPlanets[i].calcNetForceExertedByX(inputPlanets);
					yForces[i]=inputPlanets[i].calcNetForceExertedByY(inputPlanets);
					//System.out.println("xForce+" + i + "=" + xForces[i]);
					//System.out.println("yForce+" + i + "=" +yForces[i]);
	
				inputPlanets[i].update(t, xForces[i], yForces[i]);
				System.out.println("i="+i); 
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

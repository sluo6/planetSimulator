
public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	
	public Planet(double xxPos, double yyPos, double xxVel,
			double yyVel, double mass, String imgFileName){
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;		
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		return java.lang.Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos)+
				(this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
	}
	
	public double calcForceExertedBy(Planet p) {	
		 return ((this.mass * p.mass)*6.67e-11)/
				 ((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos)+
							(this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));		
	}
	public double calcForceExertedByX(Planet p) {		
		return (this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p));
	}
	public double calcForceExertedByY(Planet p) {		
		return (this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p));
	}
	public double calcNetForceExertedByX(Planet[] planets) {		
		double NetForceByX = 0;
		for (Planet p:planets) {
		if (this.equals(p)){
			//do nothing
		}
		else {
			NetForceByX = NetForceByX + calcForceExertedByX(p);
			}
			
	}
	return NetForceByX;
	}
	public double calcNetForceExertedByY(Planet[] planets) {
			double NetForceByY = 0;
			for (Planet p:planets) {
			if (this.equals(p)){
				//do nothing
			}
			else {
				NetForceByY = NetForceByY + calcForceExertedByY(p);
				}
				
		}
		return NetForceByY;
	}
	public void update(double dt, double fx, double fy) {
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel = this.xxVel + dt*ax;
		this.yyVel = this.yyVel + dt*ay;
		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;		
	}
	public void drawPlanet(){
		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
	}
	
}

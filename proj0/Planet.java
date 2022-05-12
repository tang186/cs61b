public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, 
		      double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet b){
		this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
	}
	public double calcDistance(Planet other){
		return Math.sqrt((this.xxPos - other.xxPos) * (this.xxPos - other.xxPos) + (this.yyPos - other.yyPos) * (this.yyPos - other.yyPos));
	}
	public double calcForceExertedBy(Planet other){
		double G = 6.67e-11;
		double F = G * other.mass * this.mass / (this.calcDistance(other) * this.calcDistance(other));
		return F;
	}
	public double calcForceExertedByX(Planet other){
		double F = this.calcForceExertedBy(other);//other对this施加的力，dx就是other-this
		return F * (other.xxPos - this.xxPos) / this.calcDistance(other);
	}
	public double calcForceExertedByY(Planet other){
		double F = this.calcForceExertedBy(other);
		return F * (other.yyPos - this.yyPos) / this.calcDistance(other);
	}
	public double calcNetForceExertedByX(Planet [] all){
		double SumF = 0;
		for(Planet a : all){
			if (this.equals(a)){
				continue;
			}
			SumF = this.calcForceExertedByX(a) + SumF;
		}
		return SumF;
	}
	public double calcNetForceExertedByY(Planet [] all){
		double SumF = 0;
		for(Planet a : all){
			if (this.equals(a)){
				continue;
			}
			SumF = this.calcForceExertedByY(a) + SumF;
		}
		return SumF;
	}
	private boolean equals(Planet other){
		if (other == this){
			return true;
		}
		else return false;
	}
	public void update(double dt,double fX,double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		double NewVx = this.xxVel + dt * aX;
		double NewVy = this.yyVel + dt * aY;
		double NewPx = this.xxPos + dt * NewVx;
		double NewPy = this.yyPos + dt * NewVy; 
		this.xxVel = NewVx;
		this.yyVel = NewVy;
		this.xxPos = NewPx;
		this.yyPos = NewPy;
	}
	public void draw(){
		String path = "./images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, path);
	}
}

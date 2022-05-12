public class NBody {
	public static double readRadius(String address) {
		In in = new In(address);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}
	public static Planet[] readPlanets(String address) {
		In in = new In(address);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
        Planet[] Planets = new Planet[firstItemInFile];
        for (int i = 0; i < firstItemInFile; i++) {
            double xpos = in.readDouble();
            double ypos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Planet P = new Planet(xpos, ypos, xVel, yVel, mass, img);
            Planets[i] = P;
        }
		return Planets;
	}
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String path = args[2];

        Planet[] planets = new Planet[5];
        double radius = readRadius(path);
        planets = readPlanets(path);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        StdDraw.show();
        for(int i = 0; i < 5; i++){
            planets[i].draw();
        }
        StdDraw.show();
        double t = 0;
        while(t <= T){
            double[] xForce = new double[5];
            double[] yForce = new double[5];
            for(int i = 0; i < 5 ; i++){
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < 5 ; i++){
                planets[i].update(dt, xForce[i], yForce[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int i = 0; i < 5; i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(1);
            t = t + dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
} 
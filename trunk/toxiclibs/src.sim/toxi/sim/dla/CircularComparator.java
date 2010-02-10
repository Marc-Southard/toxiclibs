package toxi.sim.dla;

import java.util.Comparator;

import toxi.geom.Line3D;
import toxi.geom.Vec3D;

class CircularComparator implements Comparator<Line3D> {
	public Vec3D origin;

	public CircularComparator() {
		this(new Vec3D());
	}

	public CircularComparator(Vec3D origin) {
		this.origin = origin;
	}

	public int compare(Line3D a, Line3D b) {
		float da = origin.sub(a.getMidPoint()).magSquared();
		float db = origin.sub(b.getMidPoint()).magSquared();
		if (da < db) {
			return -1;
		}
		if (da == db) {
			return 0;
		}
		return 1;
	}
}
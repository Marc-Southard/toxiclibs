package toxi.physics2d;

/* 
 * Copyright (c) 2008 Karsten Schmidt
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * http://creativecommons.org/licenses/LGPL/2.1/
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.awt.Rectangle;

import toxi.geom.Vec2D;
import toxi.physics2d.constraints.Particle2DConstraint;

/**
 * An individual 3D particle for use by the VerletPhysics and VerletSpring
 * classes. A particle has weight, can be locked in space and its position
 * constrained inside an (optional) axis-aligned bounding box.
 * 
 * @author toxi
 */
public class VerletParticle2D extends Vec2D {
	protected Vec2D prev, temp;
	protected boolean isLocked;

	/**
	 * Bounding box, by default set to null to disable
	 */
	public Rectangle bounds;

	/**
	 * An optional particle constraint, called immediately after a particle is
	 * updated (and only used if particle is unlocked (default)
	 */
	public Particle2DConstraint constraint;

	/**
	 * Particle weight, default = 1
	 */
	public float weight = 1.0f;

	/**
	 * Creates particle at position xyz
	 * 
	 * @param x
	 * @param y
	 */
	public VerletParticle2D(float x, float y) {
		super(x, y);
		prev = new Vec2D(this);
		temp = new Vec2D();
	}

	/**
	 * Creates particle at position xyz with weight w
	 * 
	 * @param x
	 * @param y
	 * @param w
	 */
	public VerletParticle2D(float x, float y, float w) {
		this(x, y);
		weight = w;
	}

	/**
	 * Creates particle at the position of the passed in vector
	 * 
	 * @param v
	 *            position
	 */
	public VerletParticle2D(Vec2D v) {
		this(v.x, v.y);
	}

	/**
	 * Creates particle with weight w at the position of the passed in vector
	 * 
	 * @param v
	 *            position
	 * @param w
	 *            weight
	 */
	public VerletParticle2D(Vec2D v, float w) {
		this(v.x, v.y);
		weight = w;
	}

	/**
	 * Creates a copy of the passed in particle
	 * 
	 * @param p
	 */
	public VerletParticle2D(VerletParticle2D p) {
		this(p.x, p.y);
		weight = p.weight;
		isLocked = p.isLocked;
	}

	protected void update(float force) {
		if (!isLocked) {
			temp.set(this);
			addSelf(sub(prev).scaleSelf(force));
			prev.set(temp);
			if (constraint != null)
				constraint.apply(this);
		}
	}

	/**
	 * Locks/immobilizes particle in space
	 * 
	 * @return itself
	 */
	public VerletParticle2D lock() {
		isLocked = true;
		return this;
	}

	/**
	 * Unlocks particle again
	 * 
	 * @return itself
	 */
	public VerletParticle2D unlock() {
		prev.set(this);
		isLocked = false;
		return this;
	}

	protected void applyConstraint() {
		if (constraint != null)
			constraint.apply(this);
	}

	public Vec2D getPreviousPosition() {
		return prev;
	}
}

/*******************************************************************************
 * Copyright (c) 2003, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.osgi.service.resolver;

/**
 * VersionConstraints represent the relationship between two bundles (in the 
 * case of bundle requires) or a bundle and a package (in the case of import/export).
 */
public interface VersionConstraint extends Cloneable {

	/**
	 * Returns this constraint's name.
	 * 
	 * @return this constraint's name
	 */
	public String getName();

	/**
	 * Returns the actual version this constraint was resolved against, or 
	 * <code>null</code> if it is not resolved.
	 * 
	 * @return the version this constraint was resolved against, or <code>null</code>
	 * @see #isResolved()
	 */
	public Version getActualVersion();

	/**
	 * Returns the version range for this constraint.
	 * @return the version range for this constraint, or <code>null</code>
	 */
	public VersionRange getVersionRange();

	/**
	 * Returns the bundle that declares this constraint.
	 * 
	 * @return a bundle description
	 */
	public BundleDescription getBundle();

	/**
	 * Returns the bundle that satisfies this constraint, if it is resolved.
	 *  
	 * @return a bundle description, or <code>null</code> 
	 * @see #isResolved()
	 */
	public BundleDescription getSupplier();

	/**
	 * Returns whether this constraint is resolved. A resolved constraint 
	 * is guaranteed to have its supplier defined. 
	 * 
	 * @return <code>true</code> if this bundle is resolved, <code>false</code> 
	 * otherwise
	 */
	public boolean isResolved();

	/**
	 * Returns whether this constraint could be satisfied by the given version.
	 * This will depend on the required version, the given version, and the 
	 * matching rule. A constraint that does not declare a required version is 
	 * satisfiable by any version. 
	 * 
	 * @param version a version to be tested against this constraint (may be 
	 * <code>null</code>)
	 * @return <code>true</code> if this constraint could be resolved, 
	 * <code>false</code> otherwise 
	 */
	boolean isSatisfiedBy(Version version);
}
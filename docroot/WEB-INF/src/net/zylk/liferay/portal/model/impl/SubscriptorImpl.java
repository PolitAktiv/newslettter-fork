/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.zylk.liferay.portal.model.impl;

/**
 * The extended model implementation for the Subscriptor service. Represents a row in the &quot;ZYLK_Subscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.model.Subscriptor} interface.
 * </p>
 *
 * @author zylk.net
 */
public class SubscriptorImpl extends SubscriptorBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a subscriptor model instance should use the {@link net.zylk.liferay.portal.model.Subscriptor} interface instead.
	 */
	public SubscriptorImpl() {
	}
	
	public String getFullName() {
		
		String fullName = "";
		
		if (getName() != null && !getName().equals("")) {
			fullName += getName();
		}
		
		if (getSurname() != null && !getSurname().equals("")) {
			fullName += " " + getSurname();	
		}
		
		return fullName;
	}
	
}
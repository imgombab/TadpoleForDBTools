/*******************************************************************************
 * Copyright (c) 2013 hangum.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     hangum - initial API and implementation
 ******************************************************************************/
package com.hangum.tadpole.rdb.core.viewers.object.comparator;

import org.eclipse.jface.viewers.Viewer;

import com.hangum.tadpole.sql.dao.mysql.TableDAO;
import com.hangum.tadpole.sql.dao.mysql.TriggerDAO;

/**
 * sort를 위한 최상위 클래서(기본으로 table 사용)
 * 
 * @author hangum
 * 
 */
public class TriggerComparator extends ObjectComparator {

	public TriggerComparator() {
		this.propertyIndex = 0;
		direction = DESCENDING;
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		TriggerDAO tb1 = (TriggerDAO) e1;
		TriggerDAO tb2 = (TriggerDAO) e2;

		int rc = ASCENDING;
		switch (this.propertyIndex) {
		case 0:
			rc = tb1.getName().compareTo(tb2.getName());
			break;
		case 1:
			rc = tb1.getEvent().compareTo(tb2.getEvent());
			break;
		case 2:
			rc = tb1.getTable_name().compareTo(tb2.getTable_name());
			break;
		case 3:
			rc = tb1.getStatement().compareTo(tb2.getStatement());
			break;
		case 4:
			rc = tb1.getTiming().compareTo(tb2.getTiming());
			break;
		case 5:
			rc = tb1.getCreated().compareTo(tb2.getCreated());
			break;
		}
		if (direction == DESCENDING) {
			rc = -rc;
		}
		return rc;
	}
}

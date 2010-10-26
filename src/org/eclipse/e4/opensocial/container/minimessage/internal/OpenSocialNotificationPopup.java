/**
 * Copyright (c) 2010 Sierra Wireless Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *   Contributors:
 *      Benjamin Cabe, Sierra Wireless - initial API and implementation
 */
package org.eclipse.e4.opensocial.container.minimessage.internal;

import org.eclipse.mylyn.internal.provisional.commons.ui.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * @author kartben
 * 
 */
public class OpenSocialNotificationPopup extends AbstractNotificationPopup {

	private String title;
	private String message;

	public OpenSocialNotificationPopup(Display display, String title,
			String message) {
		super(display);
		this.title = title;
		this.message = message;
	}

	@Override
	protected void createContentArea(Composite composite) {
		composite.setLayout(new GridLayout(1, true));
		Label testLabel = new Label(composite, SWT.WRAP);
		testLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		testLabel.setText(message);
		testLabel.setBackground(composite.getBackground());
	}

	@Override
	protected String getPopupShellTitle() {
		return title;
	}

}

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

import org.eclipse.e4.ui.web.BrowserRPCHandler;
import org.eclipse.mylyn.internal.provisional.commons.ui.AbstractNotificationPopup;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;

/**
 * @author kartben
 * 
 */
public class CreateMiniMessageHandler implements BrowserRPCHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.e4.ui.web.BrowserRPCHandler#handle(org.eclipse.swt.browser
	 * .Browser, java.lang.Object[])
	 */
	@Override
	public Object handle(final Browser browser, final Object[] arguments) {
		final String message = (String) arguments[1];
		final String callback = (arguments.length > 2) ? (String) arguments[2]
				: null;
		final int timeout = (arguments.length > 3) ? ((Double) arguments[3])
				.intValue() : 0;

		AbstractNotificationPopup popup = new OpenSocialNotificationPopup(
				browser.getDisplay(), "Module's title", message);
		if (timeout > 0) {
			popup.setDelayClose(timeout * 1000);
		}

		popup.create();

		popup.getShell().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (callback != null) {
					final String script = "(" + callback + ")();\n";
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							browser.execute(script);
						}
					});
				}
			}
		});

		popup.open();

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.e4.ui.web.BrowserRPCHandler#dispose()
	 */
	@Override
	public void dispose() {
		// Nothing

	}

}

var gadgets = gadgets || {};

/**
 * @class MiniMessage class.
 * 
 * @description Used to create messages that will appear to the user within the
 *              gadget.
 * @param {String}
 *            opt_moduleId Optional module Id
 * @param {Element}
 *            opt_container Optional HTML container element where mini-messages
 *            will appear.
 */
gadgets.MiniMessage = function(opt_moduleId, opt_container) {
	this.moduleId_ = opt_moduleId || 0;
	// TODO log the fact that we won't really respect the opt_container given
	// here...
	// TODO in a near future, no opt_container would mean => use Mylyn,
	// opt_container => use standard HTML minimessage
};

/**
 * Creates a dismissible message with an [x] icon that allows users to dismiss
 * the message. When the message is dismissed, it is removed from the DOM and
 * the optional callback function, if defined, is called.
 */
gadgets.MiniMessage.prototype.createDismissibleMessage = function(message,
		opt_callback) {
	e4RPC('e4.opensocial.minimessage.createMiniMessage', message, opt_callback.toString());
	// TODO this is probably against the spec to return null
	return null;
};

/**
 * Creates a message that displays for the specified number of seconds. When the
 * timer expires, the message is dismissed and the optional callback function is
 * executed.
 */
gadgets.MiniMessage.prototype.createTimerMessage = function(message, seconds,
		opt_callback) {
	e4RPC('e4.opensocial.minimessage.createMiniMessage', message, opt_callback.toString(), seconds);
	// TODO this is probably against the spec to return null
	return null;
};

/**
 * Creates a static message that can only be dismissed programmatically (by
 * calling dismissMessage()).
 */
gadgets.MiniMessage.prototype.createStaticMessage = function(message) {
	e4RPC('e4.opensocial.minimessage.createMiniMessage', message);
	
	// TODO this is probably against the spec to return null
	return null;
};

/**
 * Dismisses the specified message.
 * 
 * @param {Element}
 *            message HTML element of the message to remove
 */
gadgets.MiniMessage.prototype.dismissMessage = function(message) {
	e4RPC('e4.opensocial.minimessage.closeMiniMessage', this.messageId_) ;
};

// Legacy alias
var _IG_MiniMessage = gadgets.MiniMessage;

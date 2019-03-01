/**
 * 
 */
package com.util;

import java.util.UUID;

/**
 * @author RMehdi
 *
 */
public final class UtilProcess {
	
	public final static String generateId(){
		return UUID.randomUUID().toString();
	}
	
}

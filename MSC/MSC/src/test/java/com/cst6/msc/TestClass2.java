/**
 * 
 */
package com.cst6.msc;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Page;
import facebook4j.auth.AccessToken;

/**
 * @author SasankaN
 *
 */
public class TestClass2 {

	/**
	 * @param args
	 */
	 public static void main(String[] args) throws FacebookException
	    {
	        // Generate facebook instance.
	        Facebook facebook = new FacebookFactory().getInstance();

	        // access token ...
	        AccessToken at = new AccessToken("CAACEdEose0cBAJk4s3qH8LwZBySwB26mFtwatxZB5uDtuDnYZCf9MhIfNWiSOoWj3qEHOXP2KGxnkbMQytkZB6JMkifXhQ83YDSNDEcZBXFLdaVjb0NlCMzZBIZBFgNQIrha2ZBabcupuzOc3JaZBPZAL4OLq6BMiezFC5Jhcrtrcl8SlK7NZAzkjZAMRiIpjxSZCGWFj2Ft26XEwigZDZD");        

	        // Set access token.
	        facebook.setOAuthAccessToken(at);
	        
	        String userName = "google";     
	        Page pgId = facebook.getPage(userName);
	        System.out.println("Page Likes :" + pgId.getLikes());
	    }

}

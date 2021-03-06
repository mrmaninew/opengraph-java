package org.opengraph.examples;

import org.opengraph.OpenGraph;
import org.opengraph.MetaElement;

public class BackToTheFuture {
	static String uri = "http://www.rottentomatoes.com/m/back_to_the_future/";
	
	public static void main(String [] args)
	{
		try
		{
			OpenGraph movie = new OpenGraph(uri, true);
			System.out.println("Movie: " + movie.getContent("title"));
			for (MetaElement director : movie.getProperties("director"))
			{
				OpenGraph extendedInfo = director.getExtendedData();
				System.out.println("Directed by: " + extendedInfo.getContent("title"));
			}
			
			for (MetaElement member : movie.getProperties("cast"))
			{
				OpenGraph extendedInfo = member.getExtendedData();
				System.out.println("Starring: " + extendedInfo.getContent("title"));
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Comment;
import model.entities.Post;

public class Principal {
	public static void main(String[] args) {
		
		try {
		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that's awesome!");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Post post1 = new Post(sdf1.parse("21/06/2018 13:05:44"), "Traveling to new Zeeland", "I'm going to visit this wonderful country", 12);
				
		post1.addComment(c1);
		post1.addComment(c2);
		
		System.out.println(post1);
		
		}
		
		catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

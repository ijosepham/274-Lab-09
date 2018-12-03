/**
 * @author joey pham
 * @date 7 november 2018
 * this represents a point with coordinates x and y
 */

import java.awt.Point;

public class LinkedStack {

	private static class Node {
		/**
		 *this represents the point in the node
		 */
		private Point data;

		/**
		 *this represents the next point in the list
		 */
		private Node next;
		
		/**
		 *constructor for a node 
		 *@param d point to pass in for the data
		 *		 n node to pass in for the next one
		 */
		public Node ( Point d, Node n ) {
			data = d;
			next = n;
		}
	}
	
	/**
	 *this represents the first node in the list
	 */
	private Node top;
	
	/**
	 *constructor for linked stack
	 */
	public LinkedStack ( ) {
		top = null;
	}
	
	/**
	 *check if the list is empty
	 *@return true or false
	 */
	public boolean isEmpty ( ) {
		return top == null;
	}
	
	/**
	 *add a point 
	 *@param s point to add to the beginning of the list
	 */
	public void push ( Point s ) {
		top = new Node ( s, top );
	}
	
	/**
	 *remove and return the first item in the lniked
	 *@return the person you removed
	 */
	public Point pop ( ) {
		Point rem = new Point ( );
		if ( isEmpty ( ) ) {
			System.out.println ( "Nothing to Remove" );
		} else {
			rem = top.data;
			top = top.next;
		}
		return rem;
	}
	
	/**
	 *return the first thing of the linked
	 *@return the first person in the list
	 */
	public Point peek ( ) {
		Point ret = new Point ( );
		if ( isEmpty ( ) ) {
			System.out.println ( "Stack is Empty" );
		} else {
			ret = top.data;
		}
		return ret;
	}
	
	/**
	 *returns the data of the linked
	 *@returnthe data into a string
	 */
	public String toString ( ) {
		String s = "";
		Node n = top;
		while ( n != null ) {
			s = s + n.data + " ";
			n = n.next;
		}
		return s;
	}
}
/**
 * @author joey pham
 * @date 7 November 2018
 * @description user is prompted to enter coordinates and a plus sign of numbers is placed on a graph
 * 				the newest plus sign will overwrite the old numbers if they overlap
 */

import java.awt.Point;

public class Lab9 {
	public static void main ( String [ ] args) {
		char [ ] [ ] array = new char [ 5 ] [ 5 ]; // create a 5x5 array
		
		for ( int i = 0; i < 5; i++ ) {
			for ( int j = 0; j < 5; j++ ) {
				array [ j ] [ i ] = '.'; // fill the array with periods
			}
		}
		
		LinkedStack stack = new LinkedStack ( ); // initialize stack

		for ( int i = 0; i < 5; i++ ) { // add 5 points to the stack
			System.out.print ( "Enter a number 0-4 for x" + ( i + 1 ) + ":" ); // prompt
			int x = CheckInput.getIntRange ( 0, 4 ); // assign
			System.out.print ( "Enter a number 0-4 for y" + ( i + 1 ) + ":" );
			int y = CheckInput.getIntRange ( 0, 4 );
			stack.push ( new Point ( x, y ) ); 
			// add the point with the given coordinates to the stack
		}
		
		// remove points one at a time and places a number at that point in the array
		for ( int i = 5; i > 0; i-- ) { // start at 5 and count backwards
			Point p = stack.pop ( ); // remove and returns the first point in the stack
			int x = ( int ) p.getX ( ); // grabs the x coordinate of the "popped" point
			int y = ( int ) p.getY ( ); // y coordinate
			// turns the current number to a character
			char c = Character.forDigit ( i, 10 );
			array [ y ] [ x ] = c; // assign the num at the given point
			
			int j = 0; // counter
			while ( j < 4 ) { // check all 4 sides
				try { // make sure to keep checking even if out of bounds
					if ( j == 0 ) {
						array [ y - 1 ] [ x ] = c; // up
					}
					if ( j == 1 ) {
						array [ y + 1 ] [ x ] = c; // down
					}
					if ( j == 2 ) {
						array [ y ] [ x - 1 ] = c; // left
					}
					if ( j == 3 ) {
						array [ y ] [ x + 1 ] = c; // right 
					}
					j = j + 1;
				} catch ( ArrayIndexOutOfBoundsException oob ) {
					j = j + 1; // check the next side
				}
			}
		}
		
		// display the array
		for ( int j = 0; j < 5; j++ ) {
			for ( int i = 0; i < 5; i++ ) {
				System.out.print ( array [ j ] [ i ] + " " );
			}
			System.out.print ( "\n" );
			
		}
	}
}

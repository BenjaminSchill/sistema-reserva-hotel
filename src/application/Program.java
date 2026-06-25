package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try { 
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt(); 
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkin = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkout = LocalDate.parse(sc.next(), formatter);
			
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkout = LocalDate.parse(sc.next(), formatter);
			
			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
		}
		catch (DateTimeParseException e) { 
			System.out.println("Invalid date format!");
		}
		catch (InputMismatchException e) { 
			System.out.println("Invalid room number! Please enter an integer.");
		}
		catch (DomainException e) { 
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) { 
			System.out.println("Unexpected error.");
		}
		
		sc.close();
	}

}

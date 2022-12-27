package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Room number:");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy):");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy):");
		Date checkout = sdf.parse(sc.next());
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date ");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
			Date now = new Date();
			if (checkin.before(now) || checkout.after(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date ");
			} else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);

			}
		}
		sc.close();
	}

}
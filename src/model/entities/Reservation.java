package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	
	private static final DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		if (!checkOut.isAfter(checkIn)) { 
			throw new DomainException("Check-out date must be after check-in date.");
		}
		if (checkIn.isBefore(LocalDate.now())) { 
			throw new DomainException("Reservation dates must be future dates.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() { 
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) { 
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) { 
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkOut.isAfter(checkIn)) { 
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() { 
	return 
	    "Reservation: Room " 
		+ roomNumber
		+ ", check-in: " 
		+ dtf1.format(checkIn)
		+ ", check-out: "
		+ dtf1.format(checkOut)
		+ ", " 
		+ duration()
		+ " nights.";		
	}
}

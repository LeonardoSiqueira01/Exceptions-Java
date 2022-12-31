package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date Checkin;
	private Date Checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.Checkin = checkin;
		this.Checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return Checkin;
	}

	public Date getCheckout() {
		return Checkout;
	}

	public long duration() {
		long diff = Checkout.getTime() - Checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date CheckIn, Date CheckOut) {
		Date now = new Date();
		if (CheckIn.before(now) || CheckOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}  if (!CheckOut.after(CheckIn)) {
			return "Check-out date must be after check-in date ";
		}
		this.Checkin = CheckIn;
		this.Checkout = CheckOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room" + roomNumber + ", check-in: " + sdf.format(Checkin) + ", check-out: " + sdf.format(Checkout)
				+ ", " + duration() + " nights";
	}

}

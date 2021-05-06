package newfeatures;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class F7_DateTime_API {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		LocalTime localtime = LocalTime.of(12, 20);
		System.out.println(localtime);

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		OffsetDateTime offsetNow = OffsetDateTime.now();
		System.out.println(offsetNow);

		ZonedDateTime zoneDate = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(zoneDate);

		// Instant: specific timestamp ant any moment
		Instant instant = Instant.now();
		System.out.println(instant);

		Instant instant2 = instant.plus(Duration.ofMillis(5000));
		System.out.println(instant2);
		Instant instant3 = instant.minus(Duration.ofMillis(5000));
		System.out.println(instant3);
		Instant instant4 = instant.minusSeconds(10);
		System.out.println(instant4);

		// Duration: represents the time difference between two time stamps
		// Duration deals with small unit of time such as milliseconds, seconds, minutes
		// and hour. For interacting with application code.
		Duration duration = Duration.ofMillis(5000);
		System.out.println(duration);
		duration = Duration.ofSeconds(60);
		System.out.println(duration);
		duration = Duration.ofMinutes(10);
		System.out.println(duration);

		// Period: To interact with human, you need to get bigger durations
		Period period = Period.ofDays(6);
		System.out.println(period);
		period = Period.ofMonths(6);
		System.out.println(period);
		period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));
		System.out.println(period);

	}

}

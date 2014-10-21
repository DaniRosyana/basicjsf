package id.co.skyforce.basicjsf.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FreelanceEmployee extends Employee{
	@Column(name ="rate_perhour")
	private int ratePerHour;

	public int getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(int ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
}

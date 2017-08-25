package com.sisga.domain.address;

import com.sisga.domain.IEntity;

/**
 * 
 * @author rafae
 *
 */
public class Address implements IEntity {
	private City city;
	private String number;
	private String neighborhood;

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity( City city ) {
		this.city = city;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber( String number ) {
		this.number = number;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood
	 *            the neighborhood to set
	 */
	public void setNeighborhood( String neighborhood ) {
		this.neighborhood = neighborhood;
	}

}

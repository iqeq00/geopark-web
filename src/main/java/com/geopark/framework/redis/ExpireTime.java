package com.geopark.framework.redis;

/**
 * Expire Time, Supplement @CacheableExpire, In seconds.
 * 
 * @author lichee
 */
public class ExpireTime {

	public static final long MINUTES = 60;
	public static final long FIFTEEN_MINUTES = 60 * 15;
	public static final long HALF_HOURS = 60 * 30;
	public static final long HOURS = 3600;
	public static final long HALF_DAYS = 3600 * 12;
	public static final long DAYS = 3600 * 24;
	public static final long WEEKS = 3600 * 24 * 7;
	public static final long HALF_MONTHS = 3600 * 24 * 15;
	public static final long MONTHS = 3600 * 24 * 30;
	public static final long QUARTER = 3600 * 24 * 90;
	public static final long HALF_YEARS = 3600 * 24 * 180;
	public static final long YEARS = 3600 * 24 * 360;

}
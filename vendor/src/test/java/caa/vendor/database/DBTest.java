package caa.vendor.database;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import caa.vendor.database.DB;

public class DBTest {

	private final String table = "table";
	private DB classUnderTest;

	@Before
	public void setUp() {
		classUnderTest = DB.raw("");
		classUnderTest.setTable("table");
	}

	@Test
	public void testTable() {
		classUnderTest = DB.table(table);
		assertEquals("SELECT * FROM " + table, classUnderTest.getQuery());
	}

	@Test
	public void testRaw() {
		classUnderTest = DB.raw("");
		assertEquals("", classUnderTest.getQuery());
	}

	@Test
	public void testSelectString() {
		String column = "name";
		classUnderTest.select(column);
		assertEquals("SELECT " + column + " FROM " + table, classUnderTest.getQuery());
	}

	@Test
	public void testSelectStringArray() {
		String[] columns = { "name", "stadium" };
		classUnderTest.select(columns);
		assertEquals("SELECT 'name', 'stadium' FROM " + table, classUnderTest.getQuery());
	}

	@Test
	public void testWhereStringString() {
		classUnderTest.where("name", "English Premier League");
		assertEquals(" WHERE (name = 'English Premier League')", classUnderTest.getQuery());
	}

	@Test
	public void testWhereStringStringObject() {
		classUnderTest.where("wins", ">", Integer.valueOf(5));
		assertEquals(" WHERE (wins > '5')", classUnderTest.getQuery());
	}

	@Test
	public void testWhereIn() {
		String[] values = new String[] { "Italian Seria A", "German Bundesliga" };
		classUnderTest.whereIn("name", values);
		assertEquals(" WHERE name IN ('Italian Seria A', 'German Bundesliga')", classUnderTest.getQuery());
	}

	@Test
	public void testAndStringString() {
		classUnderTest.where("name", "Chelsea").and("name", "Everton");
		assertEquals(" WHERE (name = 'Chelsea' AND name = 'Everton')", classUnderTest.getQuery());
	}

	@Test
	public void testAndStringStringObject() {
		classUnderTest.where("league", "Scottish Premiership").and("lossses", "<", 7);
		assertEquals(" WHERE (league = 'Scottish Premiership' AND lossses < '7')", classUnderTest.getQuery());
	}

	@Test
	public void testOrStringString() {
		classUnderTest.where("name", "Juventus").or("name", "Roma");
		assertEquals(" WHERE (name = 'Juventus' OR name = 'Roma')", classUnderTest.getQuery());
	}

	@Test
	public void testOrStringStringObject() {
		classUnderTest.where("name", "Bunley").or("name", "=", "Stoke");
		assertEquals(" WHERE (name = 'Bunley' OR name = 'Stoke')", classUnderTest.getQuery());
	}

	@Test
	public void testAndWhereStringString() {
		classUnderTest.andWhere("name", "Galatasaray");
		assertEquals(" AND (name = 'Galatasaray')", classUnderTest.getQuery());
	}

	@Test
	public void testAndWhereStringStringObject() {
		classUnderTest.andWhere("name", "=", "Viking");
		assertEquals(" AND (name = 'Viking')", classUnderTest.getQuery());
	}

	@Test
	public void testAndWhereIn() {
		String[] values = new String[] { "Celtic", "Hearts" };
		classUnderTest.orWhereIn("name", values);
		assertEquals(" OR (name IN ('Celtic', 'Hearts'))", classUnderTest.getQuery());
	}

	@Test
	public void testOrWhereStringString() {
		classUnderTest.orWhere("name", "Gent");
		assertEquals(" OR (name = 'Gent')", classUnderTest.getQuery());
	}

	@Test
	public void testOrWhereStringStringObject() {
		classUnderTest.orWhere("name", "=", "Benfica");
		assertEquals(" OR (name = 'Benfica')", classUnderTest.getQuery());
	}

	@Test
	public void testOrWhereIn() {
		String[] values = new String[] { "Angers", "Lille" };
		classUnderTest.andWhereIn("name", values);
		assertEquals(" AND (name IN ('Angers', 'Lille'))", classUnderTest.getQuery());
	}

	@Test
	public void testOrderByStringString() {
		classUnderTest.orderBy("name", "asc");
		assertEquals(" ORDER BY name ASC", classUnderTest.getQuery());
	}

	@Test
	public void testOrderByStringArrayString() {
		String[] columns = { "name", "stadium" };
		classUnderTest.orderBy(columns, "desc");
		assertEquals(" ORDER BY 'name', 'stadium' DESC", classUnderTest.getQuery());
	}

}

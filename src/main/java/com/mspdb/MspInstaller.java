package com.mspdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MspInstaller
{
	private Connection connection = null;

	private Statement st = null;

	//Query for creating user table
	public void createUserTable() throws SQLException
	{
		String query = "CREATE TABLE `users` (`id` INT NOT NULL AUTO_INCREMENT,  `email` VARCHAR(45) NOT NULL,  `password` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`), UNIQUE INDEX `email_UNIQUE` (`email` ASC))";
		if ( st != null )
		{
			st.executeUpdate( query );
		}
	}

	//Query for creating company table
	public void createCompanyTable() throws SQLException
	{
		String query = "CREATE TABLE `company` (`id` INT NOT NULL AUTO_INCREMENT, `userId` INT NOT NULL, `companySym` VARCHAR(45) NOT NULL, `deleteFl` INT(1) NOT NULL DEFAULT 0,  PRIMARY KEY (`id`), INDEX `userid_idx` (`userId` ASC), CONSTRAINT `userid`  FOREIGN KEY (`userId`)  REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)";
		if ( st != null )
		{
			st.executeUpdate( query );
		}
	}

	//Query for creating Audit table
	public void createAuditTable() throws SQLException
	{
		String query = "CREATE TABLE `audit` ( `id` INT NOT NULL AUTO_INCREMENT, `userId` INT NOT NULL, `action` VARCHAR(45) NOT NULL, `result` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`), `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, INDEX `userId_idx` (`userId` ASC), CONSTRAINT `uId`   FOREIGN KEY (`userId`)   REFERENCES `users` (`id`)   ON DELETE NO ACTION   ON UPDATE NO ACTION)";
		if ( st != null )
		{
			st.executeUpdate( query );
		}
	}

	public void createDatabaseConnection( String url, String username, String password ) throws ClassNotFoundException, SQLException
	{
		Class.forName( "com.mysql.jdbc.Driver" );
		connection = DriverManager.getConnection( url, username, password );
		st = connection.createStatement();
	}

}

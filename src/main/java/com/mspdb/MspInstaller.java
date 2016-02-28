package com.mspdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MspInstaller
{
	private Connection connection = null;

	private Statement st = null;

	public void createUserTable()
	{
		String query = "CREATE TABLE `users` (`id` INT NOT NULL AUTO_INCREMENT,  `email` VARCHAR(45) NOT NULL,  `password` VARCHAR(45) NOT NULL,  `securityQn` VARCHAR(45) NOT NULL,  `securityAns` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`))";
		if ( st != null )
		{
			try
			{
				st.executeUpdate( query );
			}
			catch ( SQLException e )
			{
				throw new RuntimeException( "Sql Exception", e );
			}
		}
	}

	public void createCompanyTable()
	{
		String query = "CREATE TABLE `company` (`id` INT NOT NULL AUTO_INCREMENT, `userId` INT NOT NULL, `companySym` VARCHAR(45) NOT NULL, `deleteFl` INT(1) NOT NULL DEFAULT 0,  PRIMARY KEY (`id`), INDEX `userid_idx` (`userId` ASC), CONSTRAINT `userid`  FOREIGN KEY (`userId`)  REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)";
		if ( st != null )
		{
			try
			{
				st.executeUpdate( query );
			}
			catch ( SQLException e )
			{
				throw new RuntimeException( "Sql Exception", e );
			}
		}
	}

	public void createDatabaseConnection( String url, String username, String password )
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			connection = DriverManager.getConnection( url, username, password );
			st = connection.createStatement();
		}
		catch ( ClassNotFoundException e )
		{
			throw new RuntimeException( "MySql Drive is not loaded", e );
		}
		catch ( SQLException e )
		{
			throw new RuntimeException( "Cannot connect the database!", e );
		}
	}

}

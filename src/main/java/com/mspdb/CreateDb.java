package com.mspdb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet gets called when execute button is hit. This creates all the tables required for the Monitor-Stock-Price.
 */
@WebServlet( "/CreateDb" )
public class CreateDb extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateDb()
	{
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		MspInstaller installer = new MspInstaller();
		try
		{
			installer.createDatabaseConnection( request.getParameter( "url" ), request.getParameter( "username" ), request.getParameter( "password" ) );
		}
		catch ( ClassNotFoundException e )
		{
			response.getWriter().append( e.getMessage() );
		}
		catch ( SQLException e )
		{
			response.getWriter().append( e.getMessage() );
		}
		try
		{
			installer.createUserTable();
		}
		catch ( SQLException e )
		{
			response.getWriter().append( "exists" );
			e.printStackTrace();
		}
		try
		{
			installer.createCompanyTable();
		}
		catch ( SQLException e )
		{
			response.getWriter().append( "exists" );
			e.printStackTrace();
		}
		try
		{
			installer.createAuditTable();
		}
		catch ( SQLException e )
		{
			response.getWriter().append( "exists" );
			e.printStackTrace();
		}
		response.getWriter().append( "Success" );
	}

}

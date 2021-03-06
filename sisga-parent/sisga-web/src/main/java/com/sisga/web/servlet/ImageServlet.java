package com.sisga.web.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sisga.core.core.util.SaveDirectory;

@WebServlet( "/resources/*" )
public class ImageServlet extends HttpServlet {

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		String filename = URLDecoder.decode( request.getPathInfo().substring( 1 ), "UTF-8" );
		File file = new File( SaveDirectory.IMG_DIR + filename );
		response.setHeader( "Content-Type", getServletContext().getMimeType( filename ) );
		response.setHeader( "Content-Length", String.valueOf( file.length() ) );
		response.setHeader( "Content-Disposition", "inline; filename=\"" + filename + "\"" );
		Files.copy( file.toPath(), response.getOutputStream() );
	}

}

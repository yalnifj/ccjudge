package edu.neumont.ccjudge.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ResourceController extends BaseController {
	private static final long serialVersionUID = -3293592277425337168L;

	public ResourceController() {
		super();
		this.defaultAction = "list";
	}

	public String list(HttpServletRequest request) throws ValidationException {

		List<String> resources = new ArrayList<String>();

		String resourceDir = getServletContext().getInitParameter(
				"resource_directory");
		if (resourceDir != null) {
			File dir = new File(resourceDir);
			if (dir.exists() && dir.isDirectory()) {
				for (String name : dir.list()) {
					resources.add(name);
				}
			}
		}

		request.setAttribute("resources", resources);

		return "/views/resource/list.jsp";
	}

	public String upload(HttpServletRequest request) throws ValidationException {

		String message = "";
		try {
			String resourceDir = getServletContext().getInitParameter(
					"resource_directory");
			if (resourceDir != null) {
				File dir = new File(resourceDir);
				if (dir.exists() && dir.isDirectory()) {
					FileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upper = new ServletFileUpload(factory);
					@SuppressWarnings("unchecked")
					List<FileItem> items = upper.parseRequest(request);
					for (FileItem item : items) {
						File resource = new File(dir, item.getName());
						item.write(resource);
						message += "Resource " + item.getName()
								+ " successfully added.<br />\n";
					}
				}
			}
		} catch (FileUploadException e) {
			message += e.getMessage() + "<br />\n";
			e.printStackTrace();
		} catch (Exception e) {
			message += e.getMessage() + "<br />\n";
			e.printStackTrace();
		}
		request.setAttribute("message", message);

		return list(request);
	}

	public void view(HttpServletRequest request, HttpServletResponse response)
			throws ValidationException, ServletException {
		String[] parts = request.getRequestURI().split("/");
		String name = "";
		boolean afterview = false;
		for (String p : parts) {
			if (afterview)
				name += "/" + p;
			if (p.equals("view"))
				afterview = true;
		}

		String resourceDir = getServletContext().getInitParameter(
				"resource_directory");
		if (!name.isEmpty() && resourceDir != null) {
			File dir = new File(resourceDir);
			if (dir.exists() && dir.isDirectory()) {
				File resource = new File(dir, name);
				if (resource.exists() && resource.isFile()) {
					try {
						response.setContentLength((int) resource.length());
						MimetypesFileTypeMap mime = new MimetypesFileTypeMap();
						response.setContentType(mime.getContentType(resource));
						OutputStream out = response.getOutputStream();
						FileInputStream fis = new FileInputStream(resource);
						BufferedInputStream bis = new BufferedInputStream(fis);
						byte[] buff = new byte[512];
						while (bis.read(buff) != -1)
							out.write(buff);
					} catch (IOException e) {
						e.printStackTrace();
						throw new ServletException(e);
					}
				}
			}
		}
	}

	public String delete(HttpServletRequest request)
			throws ValidationException {
		String[] parts = request.getRequestURI().split("/");
		String name = "";
		boolean afterview = false;
		for (String p : parts) {
			if (afterview)
				name += "/" + p;
			if (p.equals("delete"))
				afterview = true;
		}

		String resourceDir = getServletContext().getInitParameter(
				"resource_directory");
		if (!name.isEmpty() && resourceDir != null) {
			File dir = new File(resourceDir);
			if (dir.exists() && dir.isDirectory()) {
				File resource = new File(dir, name);
				if (resource.exists() && resource.isFile()) {
					resource.delete();
				}
			}
		}
		return list(request);
	}
}

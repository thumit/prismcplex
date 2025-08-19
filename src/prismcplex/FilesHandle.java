package prismcplex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FilesHandle {
	
	
	public FilesHandle() {

	}
	

//    static public String ExportResource(String resourceName) throws Exception {
//    	/**
//         * Export a resource embedded into a Jar file to the local file path.
//         *
//         * @param resourceName ie.: "/SmartLibrary.dll"
//         * @return The path to the exported resource
//         * @throws Exception
//         */
//    	
//        InputStream stream = null;
//        OutputStream resStreamOut = null;
//        String jarFolder;
//        try {
//            stream = Spectrum_Main.class.getResourceAsStream(resourceName);//note that each / is a directory down in the "jar tree" been the jar the root of the tree
//			if (stream == null) {
//				throw new Exception("Cannot get resource \"" + resourceName + "\" from Jar file.");
//			}
//
//			int readBytes;
//			byte[] buffer = new byte[4096];
//			jarFolder = new File(
//					Spectrum_Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())
//							.getParentFile().getPath().replace('\\', '/');
//			resStreamOut = new FileOutputStream(jarFolder + "/Temporary" + resourceName);
//			while ((readBytes = stream.read(buffer)) > 0) {
//				resStreamOut.write(buffer, 0, readBytes);
//			}
//		} catch (Exception ex) {
//			throw ex;
//		} finally {
//			stream.close();
//			resStreamOut.close();
//		}
//		return jarFolder + "/Temporary" + resourceName;
//	}
    
    
	public static File getResourceAsJarFile(String resourcePath) {
		File file_animation = new File(FilesHandle.get_temporaryFolder().getAbsolutePath() + "/" + "animation.jar");
		file_animation.deleteOnExit();
		try {
			InputStream initialStream = Cplex_Wrapper_Main.get_main().getClass().getResourceAsStream("/test.jar");
			byte[] buffer = new byte[initialStream.available()];
			initialStream.read(buffer);

			OutputStream outStream = new FileOutputStream(file_animation);
			outStream.write(buffer);

			initialStream.close();
			outStream.close();
		} catch (FileNotFoundException e1) {
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
		} catch (IOException e2) {
			System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
		}
		return file_animation;
	}
	
	
	public static String get_workingLocation() {
		// Get working location of spectrumLite
		String workingLocation;

		// Get working location of the IDE project, or runnable jar file
		final File jarFile = new File(Cplex_Wrapper_Main.get_main().getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		workingLocation = jarFile.getParentFile().toString();

		// Make the working location with correct name
		try {
			// to handle name with space (%20)
			workingLocation = URLDecoder.decode(workingLocation, "utf-8");
			workingLocation = new File(workingLocation).getPath();
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return workingLocation;
	}
	 
	
	public static File get_projectsFolder() {		
		String workingLocation = get_workingLocation();
		File projectsFolder = new File(workingLocation + "/Projects");
		
//		final File jarFile = new File(Spectrum_Main.mainFrameReturn().getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
//		if (jarFile.isFile()) { // Run with JAR file
//			projectsFolder = new File(":Projects");
//		} else {
//			projectsFolder = new File(workingLocation + "/Projects");
//		}

		// Check if Projects folder exists, if not then create it
		if (!projectsFolder.exists()) {
			projectsFolder.mkdirs();
		} // Create folder Projects if it does not exist
		
		return projectsFolder;
	} 
	 

	public static File get_DatabasesFolder() {		
		String workingLocation = get_workingLocation();
		File databasesFolder = new File(workingLocation + "/Databases");
		
//		final File jarFile = new File(Spectrum_Main.mainFrameReturn().getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
//		if (jarFile.isFile()) { // Run with JAR file
//			databasesFolder = new File(":Databases");
//		} else {
//			databasesFolder = new File(workingLocation + "/Databases");
//		}

		// Check if Databases folder exists, if not then create it
		if (!databasesFolder.exists()) {
			databasesFolder.mkdirs();
		} // Create folder Databases if it does not exist
		
		return databasesFolder;
	}	

	
	public static File get_temporaryFolder() {		
		String workingLocation = get_workingLocation();
		File temporaryFolder = new File(workingLocation + "/Temporary");
		
//		final File jarFile = new File(Spectrum_Main.mainFrameReturn().getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
//		if (jarFile.isFile()) { // Run with JAR file
//			temporaryFolder = new File(":Temporary");
//		} else {
//			temporaryFolder = new File(workingLocation + "/Temporary");
//		}

		// Check if Temporary folder exists, if not then create it
		if (!temporaryFolder.exists()) {
			temporaryFolder.mkdirs();
		} // Create folder Temporary if it does not exist
		
		return temporaryFolder;
	}	

}

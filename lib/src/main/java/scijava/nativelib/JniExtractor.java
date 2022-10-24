
package scijava.nativelib;

import java.io.File;
import java.io.IOException;


public interface JniExtractor {

	/**
	 * Extract a JNI library from the classpath to a temporary file.
	 *
	 * @param libPath library path
	 * @param libname System.loadLibrary() compatible library name
	 * @return the extracted file
	 * @throws IOException when extracting the desired file failed
	 */
	public File extractJni(String libPath, String libname) throws IOException;

	/**
	 * Extract all libraries which are registered for auto-extraction to files in
	 * the temporary directory.
	 * 
	 * @throws IOException when extracting the desired file failed
	 */
	public void extractRegistered() throws IOException;
}

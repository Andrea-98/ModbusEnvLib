
package scijava.nativelib;

import java.io.File;
import java.io.IOException;


public class DefaultJniExtractor extends BaseJniExtractor {

	/**
	 * this is where native dependencies are extracted to (e.g. tmplib/).
	 */
	private File nativeDir;

	public DefaultJniExtractor(final Class<?> libraryJarClass) throws IOException {
		super(libraryJarClass);

		nativeDir = getTempDir();
		// Order of operations is such that we do not error if we are racing with
		// another thread to create the directory.
		nativeDir.mkdirs();
		if (!nativeDir.isDirectory()) {
			throw new IOException(
				"Unable to create native library working directory " + nativeDir);
		}
		nativeDir.deleteOnExit();
	}

	@Override
	public File getJniDir() {
		return nativeDir;
	}

	@Override
	public File getNativeDir() {
		return nativeDir;
	}

}

package com.neverbounce.api;

/**
 * Singleton class to be able to retrieve the current running version of the SDK.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class Version {

  /**
   * Singleton instance of {@code {@link Version}}.
   */
  public static final Version INSTANCE = new Version();

  private static final String MAIN_PACKAGE_NAME = "com.neverbounce.api";

  private final String version;

  private Version() {
    // Locate main package
    Package apiPackage = Package.getPackage(MAIN_PACKAGE_NAME);
    assert apiPackage != null : "Internal error: package com.neverbounce.api couldn't be loaded";

    // Extract SDK version from JAR's MANIFEST.MF
    String version = apiPackage.getImplementationVersion();
    if (version == null || version.length() == 0) {
      version = "Unknown";
    }

    this.version = version;
  }

  /**
   * Retrieves the current running version of the SDK.
   *
   * @return current version
   */
  public String getVersion() {
    return version;
  }

}

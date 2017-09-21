# java9-sort
Sample Java9 source code and resources

Some useful links ...
---------------------
The Internet is flush with information about Java9, including a lot of sample code.  As you peruse
these pages please remember one crucial item: many of them were built based on early releases of
Java 9.  The information is largely reliable, but changes have been made to to the JDK even in the
past few months.  That said, here are some good starting pages: 

  - Oracle JDK 9 Documentation -- Start here!
    * http://docs.oracle.com/javase/9/index.html
  - List of all new features (JCPs)
    * http://openjdk.java.net/projects/jdk9/
  - JDK Module Summary -- list of modules and associated packages
    * http://cr.openjdk.java.net/~mr/jigsaw/ea/module-summary.html
  - JDK API Specification -- module summary
    * http://docs.oracle.com/javase/9/docs/api/overview-summary.html
  - JDK Module System -- deeper dive (18 months old, but still valuable)
    * http://openjdk.java.net/projects/jigsaw/spec/sotms/
  - And to be fair, concerns about Jigsaw implementation
    * https://developer.jboss.org/blogs/scott.stark/2017/04/14/critical-deficiencies-in-jigsawjsr-376-java-platform-module-system-ec-member-concerns


'jmod' tool
-----------
For most development tasks, including deploying modules on the module path or publishing them to
a Maven repository, continue to package modules in modular JAR files. The jmod tool is intended
for modules that have native libraries or other configuration files or for modules you intend to
link, with the jlink tool, to a runtime image.


'toolchains' plugin
-------------------
To run "mvn" from the command line, copy to following file as "toolchains.xml" into
your maven repository (.m2 directory), wherever the "settings.xml" file resides.
Please note that the "jdkHome" should point to the appropriate paths on your machine.

```xml
<toolchains>
  <!-- JDK toolchains -->
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.9</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>C:/Program Files/Java/jdk-9</jdkHome> <!-- JDK 9 home directory-->
    </configuration>
  </toolchain>
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.8</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>C:/Program Files/Java/jdk1.8.0_51</jdkHome> <!-- JDK 8 home directory-->
    </configuration>
  </toolchain>
</toolchains>
```

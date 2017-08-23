# java9-sort
Sample Java9 source code and resources

Some useful links ...

  - http://openjdk.java.net/projects/jdk9/
  - https://docs.oracle.com/javase/9/whatsnew/toc.htm

  - http://cr.openjdk.java.net/~mr/jigsaw/ea/module-summary.html
  - http://download.java.net/java/jdk9/docs/api/overview-summary.html
  - http://openjdk.java.net/projects/jigsaw/spec/sotms/
  - http://openjdk.java.net/projects/jigsaw/quick-start
  - http://openjdk.java.net/projects/jigsaw/spec/sotms
  - http://openjdk.java.net/jeps/261

  - https://www.sitepoint.com/ultimate-guide-to-java-9/
  - https://labs.consol.de/development/2017/02/13/getting-started-with-java9-modules.html


Other Links:
  - https://www.slideshare.net/BhanuPrakashGopulara/jdk9-modules-and-java-linker
  - https://github.com/CodeFX-org/demo-java-9

Concerns about 'Jigsaw':
  - https://mreinhold.org/blog/to-the-jcp-ec
  - https://developer.jboss.org/blogs/scott.stark/2017/04/14/critical-deficiencies-in-jigsawjsr-376-java-platform-module-system-ec-member-concerns?_sscc=t


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
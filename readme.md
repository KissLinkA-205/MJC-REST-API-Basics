<h2 align="center"> 🎓 MJC school : EPAM Systems<br/>Minsk, Belarus (Минск, Беларусь)<br/>module #2. REST API Basics</h2>

<h3>♟ Business requirements</h3>

<ol>
<li>Develop web service for Gift Certificates system with the following entities (many-to-many):
  <ul>
    <li><em>CreateDate</em>, <em>LastUpdateDate</em> - format <em>ISO 8601</em> (<a href="https://en.wikipedia.org/wiki/ISO_8601"rel="nofollow">https://en.wikipedia.org/wiki/ISO_8601</a>). Example: 2018-08-29T06:12:15.156. More discussion here: <a href="https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute" rel="nofollow">https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute</a>
    </li>
    <li> <em>Duration</em> - in days (expiration period)</li>
  </ul>
</li>
<li>The system should expose REST APIs to perform the following operations:
<ul>
<li>CRUD operations for GiftCertificate. If new tags are passed during creation/modification – they should be created in the DB. For update operation - update only fields, that pass in request, others should not be updated. Batch insert is out of scope.</li>
<li>CRD operations for Tag.</li>
<li>Get certificates with tags (all params are optional and can be used in conjunction):
<ul>
<li>by tag name (ONE tag)</li>
<li>search by part of name/description (can be implemented, using DB function call)</li>
<li>sort by date or by name ASC/DESC (extra task: implement ability to apply both sort type at the same time).</li>
</ul>
</li>
</ul>
</li>
</ol>

<h3>📺 Application requirements</h4>

<ol>
  <li>JDK version: 8 – use Streams, java.time.*, etc. where it is possible. (the JDK version can be increased in agreement with the mentor/group coordinator/run coordinator</li>
  <li>Application packages root: com.epam.esm</li>
  <li>Any widely-used connection pool could be used.</li>
  <li>JDBC / Spring JDBC Template should be used for data access.</li>
  <li>Use transactions where it’s necessary.</li>
  <li>Java Code Convention is mandatory (exception: margin size – 120 chars).</li>
  <li>Build tool: Maven/Gradle, latest version. Multi-module project.</li>
  <li>Web server: Apache Tomcat/Jetty.</li>
  <li>Application container: Spring IoC. Spring Framework, the latest version.</li>
  <li>Database: PostgreSQL/MySQL, latest version.</li>
  <li>Testing: JUnit 5.+, Mockito.</li>
  <li>Service layer should be covered with unit tests not less than 80%.</li>
  <li>Repository layer should be tested using integration tests with an in-memory embedded database (all operations with certificates).</li>
</ol>

<h3>🗿 General requirements</h3>

<ol>
  <li>
    Code should be clean and should not contain any “developer-purpose” constructions.
  </li>
  <li>
    App should be designed and written with respect to OOD and SOLID principles.
  </li>
  <li>
    Code should contain valuable comments where appropriate.
  </li>
  <li>
    Public APIs should be documented (Javadoc).
  </li>
  <li>
    Clear layered structure should be used with responsibilities of each application layer defined.
  </li>
  <li>
    JSON should be used as a format of client-server communication messages.
  </li>
  <li>
    Convenient error/exception handling mechanism should be implemented: all errors should be meaningful and localized on backend side. Example: handle 404 error:
<div class="snippet-clipboard-content position-relative overflow-auto"><pre><code> • HTTP Status: 404
 • response body    
 • {
 • “errorMessage”: “Requested resource not found (id = 55)”,
 • “errorCode”: 40401
 • }
</code></pre><div class="zeroclipboard-container position-absolute right-0 top-0"></div>
  where *errorCode” is your custom code (it can be based on http status and requested resource - certificate or tag)
  </li>
  <li>
    Abstraction should be used everywhere to avoid code duplication.
  </li>
  <li>
    Several configurations should be implemented (at least two - dev and prod).
  </li>
</ol>

<h3>⚠ Application restrictions</h3>

<ol>
  <li>Spring Boot.</li>
  <li>Spring Data Repositories.</li>
  <li>JPA.</li>
  <li>Powermock (your application should be testable).</li>
</ol>

<h3>📚 Extra Materials</h3>

<ol>
<li><strong>Java 8</strong>
<ul>
<li><strong>Overview</strong>
<ul>
<li><a href="https://oz.by/books/more10885929.html" rel="nofollow">https://oz.by/books/more10885929.html</a> - Java SE 8 by Cay S. Horstmann (Book I and II)</li>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 3 “Generics and Collections” (“Additions in Java 8” section, Page 152)</li>
</ul>
</li>
<li><strong>Functional Interfaces</strong>
<ul>
<li><a href="https://docs.oracle.com/javase/specs/" rel="nofollow">https://docs.oracle.com/javase/specs/</a> - The Java Language Specification, Java SE 8 Edition, Chapter 9.8 “Functional Interfaces” (Page 321)</li>
<li><a href="https://docs.oracle.com/javase/specs/" rel="nofollow">https://docs.oracle.com/javase/specs/</a> - The Java Language Specification, Java SE 8 Edition, Chapter 9.9 Function Types (Page 325)</li>
<li><a href="http://tutorials.jenkov.com/java-functional-programming/index.html" rel="nofollow">http://tutorials.jenkov.com/java-functional-programming/index.html</a> - Java Functional Programming from Chapter 1 to 4 (Java Functional Programming, Java Higher Order Functions, Java Functional Interfaces, Java Functional Composition)</li>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 4 “Functional Programming” (Page 171 to “Checking Functional Interfaces” section, Page 182)</li>
</ul>
</li>
<li><strong>Lambdas, Method references</strong>
<ul>
<li><a href="https://docs.oracle.com/javase/specs/" rel="nofollow">https://docs.oracle.com/javase/specs/</a> - The Java Language Specification, Java SE 8 Edition, Chapter 15.27 “Lambda Expressions” (page 601)</li>
</ul>
</li>
<li><strong>1.3.Stream API</strong>
<ul>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 4 “Functional Programming” (From “Using Strebams” section, Page 185 – 223)</li>
<li><a href="http://tutorials.jenkov.com/java-functional-programming/streams.html" rel="nofollow">http://tutorials.jenkov.com/java-functional-programming/streams.html</a> - Chapter 5 (Java Stream API)</li>
<li><a href="https://habr.com/ru/company/luxoft/blog/270383/" rel="nofollow">https://habr.com/ru/company/luxoft/blog/270383/</a> - Java Stream API Overview</li>
</ul>
</li>
<li><strong>Optional</strong>
<ul>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 4 “Functional Programming” (“Returning Optional” section, Page 182)</li>
<li><a href="https://habr.com/ru/post/346782/" rel="nofollow">https://habr.com/ru/post/346782/</a></li>
</ul>
</li>
<li><strong>Date/Time API, TemporalAdjuster</strong>
<ul>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 5 “Dates, Strings, and Localization” (“Working with Dates And Times” section, Page 286)</li>
<li><a href="https://habr.com/ru/post/274905/" rel="nofollow">https://habr.com/ru/post/274905/</a></li>
<li><a href="https://www.baeldung.com/java-8-date-time-intro" rel="nofollow">https://www.baeldung.com/java-8-date-time-intro</a></li>
</ul>
</li>
</ul>
</li>
<li><strong>Coding best practices</strong>
<ul>
<li><strong>Overview</strong>
<ul>
<li><a href="https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882" rel="nofollow">https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882</a> - “Clean Code” by Robert C. Martin</li>
<li><a href="https://www.youtube.com/watch?v=otrfSgeK3JI" rel="nofollow">https://www.youtube.com/watch?v=otrfSgeK3JI</a> – good lection about Clean Code</li>
<li><a href="https://learn.epam.com/detailsPage?id=1ad7fd02-311b-4b96-845d-599b177ad928" rel="nofollow">https://learn.epam.com/detailsPage?id=1ad7fd02-311b-4b96-845d-599b177ad928</a> – course on eLearning portal</li>
</ul>
</li>
<li><strong>Java Code Convention</strong>
<ul>
<li><a href="https://www.oracle.com/technetwork/java/codeconventions-150003.pdf" rel="nofollow">https://www.oracle.com/technetwork/java/codeconventions-150003.pdf</a></li>
<li><a href="https://medium.com/@thusharaj/java-code-convention-simplified-f476bd8aa719" rel="nofollow">https://medium.com/@thusharaj/java-code-convention-simplified-f476bd8aa719</a></li>
</ul>
</li>
<li><strong>OOD, SOLID, YAGNI, DRY principles</strong>
<ul>
<li><a href="https://www.baeldung.com/solid-principles" rel="nofollow">https://www.baeldung.com/solid-principles</a> - SOLID Principles</li>
<li><a href="https://youtu.be/rtmFCcjEgEw" rel="nofollow">https://youtu.be/rtmFCcjEgEw</a> - lection by Katerina Trajchevska
Transcription:
1. Single Responsibility Principle: 7:04
2. Open/Closed Principle: 13:53
3. Liskov Substitution Principle: 20:42
4. Interface Segregation Principle: 27:18
5. Dependency Inversion Principle: 31:21</li>
<li><a href="https://habr.com/ru/post/348286/" rel="nofollow">https://habr.com/ru/post/348286/</a> - article in Russian about SOLID</li>
<li><a href="https://habr.com/ru/post/144611/" rel="nofollow">https://habr.com/ru/post/144611/</a>  - article about principles</li>
</ul>
</li>
<li><strong>Comments best practice</strong>
<ul>
<li><a href="https://dzone.com/articles/5-best-practices-commenting" rel="nofollow">https://dzone.com/articles/5-best-practices-commenting</a></li>
<li><a href="https://javarevisited.blogspot.com/2011/08/code-comments-java-best-practices.html" rel="nofollow">https://javarevisited.blogspot.com/2011/08/code-comments-java-best-practices.html</a></li>
</ul>
</li>
</ul>
</li>
<li><strong>Exception handling</strong>
<ul>
<li><strong>Overview</strong>
<ul>
<li><a href="https://oz.by/books/more10885929.html" rel="nofollow">https://oz.by/books/more10885929.html</a> - Java SE 8 by Cay S. Horstmann (Book I) or Java SE 7 by Cay S. Horstmann (Book I), Chapter “Exception Handling”</li>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 5 “Dates, Strings, and Localization” (“Working with Dates And Times” section, Page 286)</li>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 6 “Exceptions and Assertions”, Page 283</li>
<li><a href="https://learn.epam.com/detailsPage?id=be65b7d2-7fb0-45dc-9d1c-db8e2b84a37f" rel="nofollow">https://learn.epam.com/detailsPage?id=be65b7d2-7fb0-45dc-9d1c-db8e2b84a37f</a> – course on eLearning portal</li>
</ul>
</li>
<li><strong>Checked vs. Runtime (Unchecked) Exceptions</strong>
<ul>
<li><a href="https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901" rel="nofollow">https://www.amazon.com/OCP-Certified-Professional-Programmer-1Z0-809/dp/1119067901</a> - Chapter 6 “Exceptions and Assertions”, Page 283 (“Categories of Exceptions” section, Page 285)</li>
<li><a href="https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/" rel="nofollow">https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/</a></li>
<li><a href="https://howtodoinjava.com/java/exception-handling/checked-vs-unchecked-exceptions-in-java/" rel="nofollow">https://howtodoinjava.com/java/exception-handling/checked-vs-unchecked-exceptions-in-java/</a></li>
</ul>
</li>
<li><strong>Exception handling best practices</strong>
<ul>
<li><a href="https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/" rel="nofollow">https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/</a></li>
<li><a href="https://dzone.com/articles/9-best-practices-to-handle-exceptions-in-java" rel="nofollow">https://dzone.com/articles/9-best-practices-to-handle-exceptions-in-java</a></li>
<li><a href="https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/" rel="nofollow">https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/</a></li>
</ul>
</li>
</ul>
</li>
<li><strong>Layered Architecture</strong>
<ul>
<li><a href="https://teams.microsoft.com/l/file/F2772F35-D74A-43EC-B9BA-2E72724C0550?tenantId=b41b72d0-4e9f-4c26-8a69-f949f367c91d&amp;fileType=pptx&amp;objectUrl=https%3A%2F%2Fepam.sharepoint.com%2Fsites%2FJavaEduPrograms%2FShared%20Documents%2FSchool%2FPilot%20run%2C%20May%202020%2FLayered_Arcitecture.pptx&amp;baseUrl=https%3A%2F%2Fepam.sharepoint.com%2Fsites%2FJavaEduPrograms&amp;serviceName=teams&amp;threadId=19:a8c2e7c0a857429b9aafa5587f649beb@thread.skype&amp;groupId=3cf270ee-6fd5-439c-9aa2-34c54596090d" rel="nofollow">https://teams.microsoft.com/l/file/F2772F35-D74A-43EC-B9BA-2E72724C0550?tenantId=b41b72d0-4e9f-4c26-8a69-f949f367c91d&amp;fileType=pptx&amp;objectUrl=https%3A%2F%2Fepam.sharepoint.com%2Fsites%2FJavaEduPrograms%2FShared%20Documents%2FSchool%2FPilot%20run%2C%20May%202020%2FLayered_Arcitecture.pptx&amp;baseUrl=https%3A%2F%2Fepam.sharepoint.com%2Fsites%2FJavaEduPrograms&amp;serviceName=teams&amp;threadId=19:a8c2e7c0a857429b9aafa5587f649beb@thread.skype&amp;groupId=3cf270ee-6fd5-439c-9aa2-34c54596090d</a> – Presentation about Layered Architecture</li>
</ul>
</li>
<li><strong>Spring Framework</strong>
<ul>
<li><strong>Overview:</strong>
<ul>
<li><a href="https://www.youtube.com/watch?v=BmBr5diz8WA" rel="nofollow">https://www.youtube.com/watch?v=BmBr5diz8WA</a> - Spring-потрошитель, часть 1</li>
<li><a href="https://www.youtube.com/watch?v=cou_qomYLNU" rel="nofollow">https://www.youtube.com/watch?v=cou_qomYLNU</a> - Spring-потрошитель, часть 2</li>
<li><a href="https://www.youtube.com/watch?v=nGfeSo52_8A" rel="nofollow">https://www.youtube.com/watch?v=nGfeSo52_8A</a> -  Spring – Глубоко и не очень</li>
</ul>
</li>
<li><strong>Spring Core: Wiring beans</strong>
<ul>
<li><a href="https://www.manning.com/books/spring-in-action-fourth-edition" rel="nofollow">https://www.manning.com/books/spring-in-action-fourth-edition</a></li>
</ul>
</li>
<li><strong>Core concepts – Chapter 2: Wiring beans;</strong></li>
<li><strong>Core concepts –Chapter 3: Advanced Wiring;</strong>
<ul>
<li><a href="https://www.tutorialspoint.com/spring/spring_beans_autowiring.htm" rel="nofollow">https://www.tutorialspoint.com/spring/spring_beans_autowiring.htm</a></li>
</ul>
</li>
<li><strong>Building Spring web applications: Spring MVC</strong>
<ul>
<li><a href="https://www.manning.com/books/spring-in-action-fourth-edition" rel="nofollow">https://www.manning.com/books/spring-in-action-fourth-edition</a>
MVC –  Chapter 5: Building Spring web applications
MVC – Chapter 7: Advanced Spring MVC</li>
</ul>
</li>
</ul>
</li>
<li><strong>REST API Fundamentals</strong>
<ul>
<li><strong>Overview:</strong>
<ul>
<li><a href="https://bookauthority.org/books/best-rest-api-books" rel="nofollow">https://bookauthority.org/books/best-rest-api-books</a> - list of books for additional learning</li>
</ul>
</li>
<li><strong>RESTful Architecture</strong>
<ul>
<li><a href="https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api" rel="nofollow">https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api</a></li>
<li><a href="https://dzone.com/refcardz/rest-foundations-restful?chapter=1" rel="nofollow">https://dzone.com/refcardz/rest-foundations-restful?chapter=1</a></li>
</ul>
</li>
<li><strong>REST APIs with Spring</strong>
<ul>
<li><a href="https://www.manning.com/books/spring-in-action-fourth-edition" rel="nofollow">https://www.manning.com/books/spring-in-action-fourth-edition</a>
REST – Chapter 16: Creating REST APIs with Spring</li>
<li><a href="https://habr.com/ru/post/101342/" rel="nofollow">https://habr.com/ru/post/101342/</a></li>
</ul>
</li>
</ul>
</li>
<li><strong>Connection Pool</strong>
<ul>
<li><a href="https://habr.com/ru/post/101342/" rel="nofollow">https://habr.com/ru/post/101342/</a></li>
</ul>
</li>
<li><strong>Maven</strong>
<ul>
<li><a href="https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html" rel="nofollow">https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html</a></li>
<li><a href="https://habr.com/ru/post/77382/" rel="nofollow">https://habr.com/ru/post/77382/</a></li>
<li><a href="https://www.baeldung.com/maven" rel="nofollow">https://www.baeldung.com/maven</a></li>
</ul>
</li>
<li><strong>Testing</strong>
<ul>
<li><strong>Well-known approaches</strong>
<ul>
<li><a href="https://habr.com/ru/post/81226/" rel="nofollow">https://habr.com/ru/post/81226/</a></li>
<li><a href="https://habr.com/ru/post/358950/" rel="nofollow">https://habr.com/ru/post/358950/</a></li>
<li><a href="https://habr.com/ru/company/jugru/blog/323920/" rel="nofollow">https://habr.com/ru/company/jugru/blog/323920/</a></li>
<li><a href="https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/" rel="nofollow">https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/</a></li>
</ul>
</li>
<li><strong>Junit</strong>
<ul>
<li><a href="https://habr.com/ru/post/120101" rel="nofollow">https://habr.com/ru/post/120101</a></li>
<li><a href="https://junit.org/junit4/" rel="nofollow">https://junit.org/junit4/</a></li>
</ul>
</li>
<li><strong>Mockito</strong>
<ul>
<li><a href="https://www.journaldev.com/21816/mockito-tutorial" rel="nofollow">https://www.journaldev.com/21816/mockito-tutorial</a></li>
<li><a href="https://habr.com/ru/post/444982/" rel="nofollow">https://habr.com/ru/post/444982/</a></li>
<li><a href="https://site.mockito.org/" rel="nofollow">https://site.mockito.org/</a></li>
<li><a href="https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/" rel="nofollow">https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/</a></li>
</ul>
</li>
</ul>
</li>
<li><strong>Postman</strong>
<ul>
<li><a href="https://habr.com/ru/company/kolesa/blog/351250/" rel="nofollow">https://habr.com/ru/company/kolesa/blog/351250/</a></li>
</ul>
</li>
</ol>

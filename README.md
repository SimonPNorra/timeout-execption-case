## Test Scenarios for flipping timeout exception issue

### Test ran on Machine:

- Device: MacBook Pro
- Processor: Apple M1 Pro
- Operating System: macOS 15.1.1 (24B91)
- JDK: azul-21.0.2 (aarch64)

### Scenarios

1. Unit Test
2. Local Startup as Spring Application
3. Via dockerfile and `gcr.io/distroless/java21-debian12` as a execution environment

### Observed behavior:

Output like:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.0)

2024-11-27T12:48:48.396Z  INFO 1 --- [timeout-execption-case] [           main] c.e.t.TimeoutExecptionCaseApplication    : Starting TimeoutExecptionCaseApplication v0.0.1-SNAPSHOT using Java 21.0.5 with PID 1 (/app/app.jar started by root in /app)
2024-11-27T12:48:48.398Z  INFO 1 --- [timeout-execption-case] [           main] c.e.t.TimeoutExecptionCaseApplication    : No active profile set, falling back to 1 default profile: "default"
2024-11-27T12:48:49.061Z  INFO 1 --- [timeout-execption-case] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-11-27T12:48:49.072Z  INFO 1 --- [timeout-execption-case] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-11-27T12:48:49.072Z  INFO 1 --- [timeout-execption-case] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.33]
2024-11-27T12:48:49.089Z  INFO 1 --- [timeout-execption-case] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-11-27T12:48:49.090Z  INFO 1 --- [timeout-execption-case] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 666 ms
2024-11-27T12:48:49.309Z  INFO 1 --- [timeout-execption-case] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-11-27T12:48:49.317Z  INFO 1 --- [timeout-execption-case] [           main] c.e.t.TimeoutExecptionCaseApplication    : Started TimeoutExecptionCaseApplication in 1.125 seconds (process running for 1.348)
2024-11-27T12:48:49.459Z  INFO 1 --- [timeout-execption-case] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-11-27T12:48:49.460Z  INFO 1 --- [timeout-execption-case] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-11-27T12:48:49.460Z  INFO 1 --- [timeout-execption-case] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: java.util.concurrent.CancellationException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: java.util.concurrent.CancellationException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
Exception: org.springframework.web.client.ResourceAccessException
...
```

We see `ResourceAccessException` and `CancellationException` in the logs.

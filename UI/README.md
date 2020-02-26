# 4API UI Demo

The project is a standard Maven project, so you can import it to your IDE of choice. You'll need to have Java 8+ and Node.js 10+ installed.

To run from the command line, use `mvn` and open [http://localhost:8080](http://localhost:8080) in your browser.

## Project structure

| Directory | Description |
| :--- | :--- |
| `frontend/` | Client-side source directory |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.html` | HTML template |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.ts` | Frontend entrypoint, contains the client-side routing setup using [Vaadin Router](https://vaadin.com/router) |
| &nbsp;&nbsp;&nbsp;&nbsp;`main-layout.ts` | Main layout Web Component, contains the navigation menu, uses [App Layout](https://vaadin.com/components/vaadin-app-layout) |
| &nbsp;&nbsp;&nbsp;&nbsp;`views/` | UI views Web Components (TypeScript) |
| &nbsp;&nbsp;&nbsp;&nbsp;`styles/` | Styles directory (CSS) |
| `src/main/java/<groupId>/` | Server-side source directory, contains the server-side Java views |
| &nbsp;&nbsp;&nbsp;&nbsp;`Application.java` | Server entrypoint |

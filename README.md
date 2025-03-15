#Application done with hexagonal architecture for consulting the price

This application is a small technical test that involves different technologies working together for creating a cleand and organized code.

Some of this technologies are the next ones:
*Java
*Spring boot
*Hibernate
*Junit
*Jacoco

And some of the standards used here are:
*SOLID
*Hexagonal Architecture

##Application use
The application retrieves the price following a certain logic. It requires a date, a product id and a brand id. Based in this information, it will check the database to see which price needs to be returned. In case there are more than one possible price, the one with a higher priority will be returned.
This application has no data since its database is h2 but, for testing purposes, four prices have been added when testing. In the tests we can see the funcionality of the application as well as some different scenarios that are handled by the application.

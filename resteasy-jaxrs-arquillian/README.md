This is a sample project to get you started with java based JAX-RS RESTful web services using
- Resteasy-jaxrs 3.0 for RESTful endpoints
- Jackson JSON serialization for marshalling your data
- Arquillian for testing your services.


The project is fully set up, all you have to do is:
- clone the project
- rename packages and classes to reflect your organization and project names
- add your own services

Get started with the code
- FooBarApp class will bootstrap the JaxRS application by registering resources (classes providing restful services).
If you need to add more resources, such as services, this is the place where register them. You should rename this class
to reflect the business domain it addresses, such as UserManagementApp SalesApp or InventoryApp. When you rename your class
you must also make sure to rename the reference to it in web.xml - depending on how smart your IDE is, you may or may not
have to rename that reference manually.
- FooBarService class is a sample service class featuring sample GET, PUT, POST and DELETE services. Your should rename this
class to reflect the business domain it addresses
- Payload is a dummy domain object used in sample services, you should remove it once you create your own domain objects


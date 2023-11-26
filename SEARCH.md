

IntellJ ShortCut User

    Alt+Enter - to fix error
    ctrl+Shift+F10 - to run
    Ctrl+b - to see source code
    atl+inser - to generate constructor, getter, setter,tostring
    ctrl+d - to duplicate/copy the line



spring.jpa.hibernate.ddl-auto=create

    Drops the existing schema and creates a new one.
    This is useful during development when you want to start with a fresh database.

spring.jpa.hibernate.ddl-auto=update

    Updates the existing schema based on the JPA entity classes.
    It adds missing tables, columns, and constraints but does not drop anything.

spring.jpa.hibernate.ddl-auto=validate

    Validates the existing schema against the JPA entity classes.
    It does not make any changes to the database.

spring.jpa.hibernate.ddl-auto=none

    Disables automatic schema generation by Hibernate.
    You are responsible for managing the database schema manually.

spring.jpa.hibernate.ddl-auto=create-drop

    Similar to create, but also drops the schema when the application shuts down.
    This is useful for testing and development.



    


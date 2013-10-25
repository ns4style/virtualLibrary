USE Tomcat v7.0

1. Download https://github.com/ns4style/virtualLibrary.git

2. git checkout TEST (for disable ssl, jaas)

3. Edit WebContent/WEB-INF/classes/hibernate.cfg.xml

        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://10.24.1.172:3306/test</property>
        <property name="hibernate.connection.username">user1</property>
        <property name="hibernate.connection.password">c$awth3b33st</property> 

4. dump.sql placed in WebContent
	4.1 mysql -u root -p
	4.2 create database NAME
	4.3 ctrl+c
	4.4 mysql -u root -p NAME < dump.sql
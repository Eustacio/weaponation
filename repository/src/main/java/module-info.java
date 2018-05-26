module com.weaponation.repository {
    requires com.weaponation.domain;

    requires java.persistence;
    requires java.sql;

    requires spring.context;
    requires spring.data.jpa;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;

    exports com.weaponation.repository;
}

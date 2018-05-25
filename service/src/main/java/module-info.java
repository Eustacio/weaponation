module com.weaponation.service {
    requires com.weaponation.domain;
    requires com.weaponation.repository;

    // Necessary to use @Service annotation
    requires spring.context;

    // Necessary to use @Autowired annotation
    requires spring.beans;

    // Necessary to use spring dao exceptions
    requires spring.tx;
}

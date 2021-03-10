package com.igpgroup17.studentpals.models;

public class Examples {

    public static final Student EXAMPLE = Student.builder()
            .username("johnbernadis93")
            .realName("John Bernadis")
            .age(30)
            .gender("Male")
            .email("johnbernadis93@gmail.com")
            .universityName("University of Bath")
            .year(2)
            .course("Computer Science (BSc) Hons")
            .universityEmail("jbb23@bath.ac.uk")
            .build();

    public static final Organiser EXAMPLE1 = Organiser.builder()
            .email("johnbernadis93@gmail.com")
            .universityName("University of Bath")
            .organisationDesc("John Fan Club <3")
            .profileId("1")
            .uniEmail("john@bath.ac.uk")
            .build();
}

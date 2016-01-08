CREATE TABLE contacts(
    ID INT NOT NULL auto_increment, 
    CONTACT_NAME VARCHAR(100) NOT NULL,
    CONTACT_SURNAME VARCHAR(100) NOT NULL,
    CONTACT_PHONE VARCHAR(100) NOT NULL UNIQUE,
    CONTACT_EMAIL VARCHAR(100) NOT NULL,
    HOBBY_ID VARCHAR(100),
    PRIMARY KEY (ID),
    FOREIGN KEY (HOBBY_ID) REFERENCES hobbies (HOBBY_ID)
);

CREATE TABLE hobbies(
    HOBBY_ID INT NOT NULL auto_increment, 
    HOBBY_NAME VARCHAR(100) NOT NULL,
    PRIMARY KEY (HOBBY_ID)
);


--
-- Database: `anil_db`
--
CREATE TABLE users (    
    "id" NUMBER(38,0),
    "username" VARCHAR2(30 BYTE), 
    "password" VARCHAR2(32 BYTE), 
    "mail" VARCHAR2(32 BYTE), 
    "name" VARCHAR2(32 BYTE), 
    "surname" VARCHAR2(32 BYTE)
);

CREATE UNIQUE INDEX "USERS_PK" ON users ("id") ;
ALTER TABLE users MODIFY ("id" NOT NULL ENABLE);
ALTER TABLE users ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("id") ENABLE;

ALTER TABLE users MODIFY MODIFY ("password" varchar(128));

INSERT INTO users ("id", "username", "password", "mail", "name", "surname") VALUES (1, 'admin', '62f264d7ad826f02a8af714c0a54b197935b717656b80461686d450f7b3abde4c553541515de2052b9af70f710f0cd8a1a2d3f4d60aa72608d71a63a9a93c0f5', '', '', '');

CREATE TABLE roles (	
    "role" VARCHAR2(30 BYTE), 
    "_user" NUMBER(38, 0), 
    "id" NUMBER(38,0)
);

CREATE UNIQUE INDEX "ROLES_PK" ON roles ("id");
ALTER TABLE roles ADD CONSTRAINT "ROLES_PK" PRIMARY KEY ("id");
ALTER TABLE roles MODIFY ("id" NOT NULL ENABLE);
ALTER TABLE roles ADD CONSTRAINT "ROLES_FK1" FOREIGN KEY ("_user")
	  REFERENCES users ("id") ENABLE;

INSERT INTO roles ("role", "_user", "id") VALUES ('ADMIN', '1', 1);


-- ENTITIES

--
-- Struttura della tabella `User`
--

    CREATE TABLE User (	
        "mail" varchar(130),
        "name" varchar(130),
        "password" varchar(130),
        "roles" varchar(130),
        "surname" varchar(130),
        "username" varchar(130),
        
        -- RELAZIONI
        
        "id" NUMBER(38,0)
    );
    
    
    CREATE UNIQUE INDEX "User_PK" ON User ("id");
    ALTER TABLE User ADD CONSTRAINT "User_PK" PRIMARY KEY ("id");
    ALTER TABLE User MODIFY ("id" NOT NULL ENABLE);


-- RELATIONS

    -- RELATIONS TABLE User
    
        
        
        
        




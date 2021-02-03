

CREATE SEQUENCE EMPLOYEE_id_seq
                    START WITH 1
                    INCREMENT BY 1
                    NO MINVALUE
                    NO MAXVALUE
                    CACHE 1;
            
                CREATE TABLE EMPLOYEE (
                    id int DEFAULT nextval('EMPLOYEE_id_seq'::regclass) NOT NULL PRIMARY KEY,
                    first_name varchar(255) default NULL,
last_name  varchar(255) default NULL
                   
                );

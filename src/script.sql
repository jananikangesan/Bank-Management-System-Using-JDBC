BEGIN
   BEGIN
      EXECUTE IMMEDIATE 'DROP TABLE CBC_CUSTOMER_TABLE';
   EXCEPTION
      WHEN OTHERS THEN
         NULL;
   END;

   EXECUTE IMMEDIATE '
      CREATE TABLE cbc_customer_table(
      account_number number(10) NOT NULL,
      customer_name VARCHAR2(45) NOT NULL,
      contact_number number(12) NOT NULL UNIQUE,
      username VARCHAR2(45) NOT NULL,
      password VARCHAR2(45) NOT NULL,
      balance number(15) NOT NULL,
      PRIMARY KEY (account_number))';

   INSERT INTO CBC_CUSTOMER_TABLE VALUES (10001, 'Bilal', 0712345678, 'bilal', 'bilal', 500000.25);
   INSERT INTO CBC_CUSTOMER_TABLE VALUES (10002, 'Pradeep', 0787654321, 'pradeep', 'pradeep', 605010.85);
   INSERT INTO CBC_CUSTOMER_TABLE VALUES (10003, 'Chamindu', 07545678965, 'chamindu', 'chamindu', 793000.75);
   INSERT INTO CBC_CUSTOMER_TABLE VALUES (10004, 'Janani', 0777656743, 'janani', 'janani', 396000.50);
   INSERT INTO CBC_CUSTOMER_TABLE VALUES (10005, 'Pragathy', 0708764379, 'pragathy', 'pragathy', 478000.20);
END;
/
SELECT * FROM CBC_CUSTOMER_TABLE
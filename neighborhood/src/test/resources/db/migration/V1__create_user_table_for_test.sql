CREATE TABLE IF NOT EXISTS user (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  email varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

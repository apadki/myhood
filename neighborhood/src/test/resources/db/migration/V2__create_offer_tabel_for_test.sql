drop table if exists offer;
CREATE TABLE offer (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  offer_type varchar(1) NOT NULL,
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  user_id int(11) DEFAULT NULL,
  PRIMARY KEY (id)  
) ;

ALTER TABLE offer
add CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES user (id);

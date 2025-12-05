create table login (
  id serial not null
  , username character varying(255)
  , fullname character varying(255)
  , password character varying(255)
  , email character varying(255)
  , primary key (id)
);
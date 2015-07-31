insert into USER
  (ID, USER, FIRST_NAME, LAST_NAME, EMAIL, ORGANIZATION)
values
  (toBin(:id), user, :first_name, :last_name, :email, toBin(:organization))
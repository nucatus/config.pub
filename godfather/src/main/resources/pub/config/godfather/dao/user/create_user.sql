insert into USER
  (ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, ORGANIZATION)
values
  (toBin(:id), :user_name, :first_name, :last_name, :email, toBin(:organization))
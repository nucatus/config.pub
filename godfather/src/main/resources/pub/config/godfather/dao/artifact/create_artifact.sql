insert into
  ARTIFACT (ID, NAME, CREATOR, ORGANIZATION)
values
  (toBin(:id), :name, toBin(:creator), toBin(:organization));
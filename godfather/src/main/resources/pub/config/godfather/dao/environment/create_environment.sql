insert into
  ENVIRONMENT (ID, NAME, ARTIFACT, CREATOR, TYPE)
VALUES
  (toBin(:id), :name, toBin(:artifact), toBin(:creator), :type)
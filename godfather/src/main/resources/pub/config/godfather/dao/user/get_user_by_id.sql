select
  toUuid(ID) id,
  USERNAME,
  FIRST_NAME,
  LAST_NAME,
  EMAIL,
  toUuid(ORGANIZATION) organization
from
  USER
where
  id=toBin(:id)
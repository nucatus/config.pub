select
  toUuid(ID) id,
  USER,
  FIRST_NAME,
  LAST_NAME,
  EMAIL,
  toUuid(ORGANIZATION) organization
from
  USER
WHERE
  ORGANIZATION=toBin(:organization)
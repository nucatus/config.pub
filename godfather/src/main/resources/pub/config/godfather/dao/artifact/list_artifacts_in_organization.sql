select
  toUuid(ID) id,
  NAME,
  toUuid(CREATOR) creator,
  toUuid(ORGANIZATION) organization
from
  ARTIFACT
where
  ORGANIZATION=toBin(:organization)
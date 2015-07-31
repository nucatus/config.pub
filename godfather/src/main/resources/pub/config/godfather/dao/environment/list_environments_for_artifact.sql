select
  toUuid(ID) id,
  NAME,
  toUuid(ARTIFACT) artifact,
  toUuid(CREATOR) creator,
  TYPE
from
  ENVIRONMENT
where
  ARTIFACT=toBin(:artifact)
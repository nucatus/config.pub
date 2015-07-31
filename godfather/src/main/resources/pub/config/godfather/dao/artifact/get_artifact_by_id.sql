select
  toUuid(ID) id,
  NAME
from ARTIFACT
where ID=toBin(:id)
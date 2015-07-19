select ID, NAME
from
  ARTIFACT
where
  CREATOR=:creator
  and NAME=:name
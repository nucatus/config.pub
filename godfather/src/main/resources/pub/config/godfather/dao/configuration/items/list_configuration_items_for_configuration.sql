select
  ID,
  K name,
  V value,
  TYPE,
  CONFIGURATION
from
  CONFIGURATION_ITEM
where
  CONFIGURATION=:configuration
select
  toUuid(ci.ID) id,
  ci.K name,
  ci.V value,
  ci.TYPE,
  toUuid(ci.CONFIGURATION) configuration,
  cim.COMMENT
from
  CONFIGURATION_ITEM ci
  left join CONFIGURATION_ITEM_COMMENT cim
    on ci.ID = cim.CONFIGURATION_ITEM
where
  ci.ID=toBin(:id)
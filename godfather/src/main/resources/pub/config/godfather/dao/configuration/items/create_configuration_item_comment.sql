insert into
  CONFIGURATION_ITEM_COMMENT (ID, CONFIGURATION_ITEM, COMMENT)
values
  (toBin(:id), toBin(:configuration_item), :comment)
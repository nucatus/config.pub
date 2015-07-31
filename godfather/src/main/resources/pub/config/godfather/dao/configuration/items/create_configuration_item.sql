insert into
  CONFIGURATION_ITEM (ID, CONFIGURATION, K, V, TYPE)
values
  (toBin(:id), toBin(:configuration), :name, :value, :type)
insert into CONFIGURATION
  (ID, PARENT, NAME, ENVIRONMENT, ARTIFACT, VERSION_MAJOR, VERSION_MINOR, VERSION_PATCH, VERSION_STAGE)
values
  (toBin(:id), toBin(:parent), :name, toBin(:environment), toBin(:artifact), :version_major, :version_minor, :version_patch, :version_stage)
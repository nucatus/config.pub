insert into CONFIGURATION
  (ID, PARENT, NAME, ENVIRONMENT, ARTIFACT, VERSION_MAJOR, VERSION_MINOR, VERSION_PATCH, VERSION_STAGE)
values
  (:id, :parent, :name, :environment, :artifact, :version_major, :version_minor, :version_patch, :version_stage)
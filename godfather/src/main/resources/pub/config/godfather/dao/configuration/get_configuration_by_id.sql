select
  toUuid(ID) id,
  toUuid(PARENT) parent,
  NAME,
  VERSION_MAJOR,
  VERSION_MINOR,
  VERSION_PATCH,
  VERSION_STAGE,
  toUuid(ENVIRONMENT) environment,
  toUuid(ARTIFACT) artifact
from
  CONFIGURATION
where
  ID=toBin(:id)
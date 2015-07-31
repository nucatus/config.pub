select
  toUuid(cfg.ID) id,
  toUuid(cfg.PARENT) parent,
  cfg.NAME,
  cfg.VERSION_MAJOR,
  cfg.VERSION_MINOR,
  cfg.VERSION_PATCH,
  cfg.VERSION_STAGE,
  toUuid(cfg.ENVIRONMENT) environment,
  toUuid(cfg.ARTIFACT) artifact
from
  CONFIGURATION cfg
join
  ARTIFACT artf
  on cfg.ARTIFACT=artf.ID
where
  artf.ORGANIZATION=toBin(:organization)
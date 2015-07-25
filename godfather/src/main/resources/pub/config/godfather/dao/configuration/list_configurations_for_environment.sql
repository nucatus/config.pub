select
  cfg.ID,
  cfg.PARENT,
  cfg.NAME,
  cfg.VERSION_MAJOR,
  cfg.VERSION_MINOR,
  cfg.VERSION_PATCH,
  cfg.VERSION_STAGE,
  cfg.ENVIRONMENT,
  cfg.ARTIFACT
from
  CONFIGURATION cfg
join
  ARTIFACT artf
  on cfg.ARTIFACT=artf.ID
where
  artf.ORGANIZATION=:organization
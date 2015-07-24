select
  env.ID,
  env.NAME,
  env.ARTIFACT,
  env.CREATOR,
  env.TYPE
from
  ENVIRONMENT env
left join
  ARTIFACT artf
  on env.ARTIFACT=artf.ID
where
  artf.ORGANIZATION=:organization
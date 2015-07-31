select
  toUuid(env.ID) id,
  env.NAME,
  toUuid(env.ARTIFACT) artifact,
  toUuid(env.CREATOR) creator,
  env.TYPE
from
  ENVIRONMENT env
left join
  ARTIFACT artf
  on env.ARTIFACT=artf.ID
where
  artf.ORGANIZATION=toBin(:organization)
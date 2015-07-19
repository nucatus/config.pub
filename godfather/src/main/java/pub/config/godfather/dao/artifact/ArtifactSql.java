package pub.config.godfather.dao.artifact;

import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum ArtifactSql implements QueryFeeder
{
    GET_ARTIFACT_BY_ID,
    GET_ARTIFACT_BY_NAME_AND_CREATOR,
    LIST_ARTIFACTS_IN_ORGANIZATION,
    DELETE_ARTIFACT_BY_ID,
    CREATE_ARTIFACT;
}

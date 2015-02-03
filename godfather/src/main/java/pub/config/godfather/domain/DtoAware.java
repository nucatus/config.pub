package pub.config.godfather.domain;

import pub.config.godfather.dto.Dto;

/**
 * Created by alexandru.ionita on 1/25/15.
 */
public interface DtoAware<T extends Dto>
{
    T toDto();
}

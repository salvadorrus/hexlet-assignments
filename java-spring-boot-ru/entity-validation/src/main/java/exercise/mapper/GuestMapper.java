package exercise.mapper;

import exercise.dto.GuestCreateDTO;
import exercise.dto.GuestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import exercise.model.Guest;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class GuestMapper {


    public static Guest map(GuestCreateDTO dto) {
        return null;
    }

    public abstract GuestDTO map(Guest model);
}

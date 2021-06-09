package digital.innovation.one.TestesUnitAPIBera.mapper;

import digital.innovation.one.TestesUnitAPIBera.dto.BeerDTO;
import digital.innovation.one.TestesUnitAPIBera.entity.BeerModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerModel toModel(BeerDTO beerDTO);

    BeerDTO toDTO(BeerModel beer);

}

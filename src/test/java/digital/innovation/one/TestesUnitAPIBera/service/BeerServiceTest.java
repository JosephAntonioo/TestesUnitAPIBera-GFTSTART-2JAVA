package digital.innovation.one.TestesUnitAPIBera.service;

import digital.innovation.one.TestesUnitAPIBera.builder.BeerDTOBuilder;
import digital.innovation.one.TestesUnitAPIBera.dto.BeerDTO;
import digital.innovation.one.TestesUnitAPIBera.entity.BeerModel;
import digital.innovation.one.TestesUnitAPIBera.exception.BeerAlreadyRegisteredException;
import digital.innovation.one.TestesUnitAPIBera.mapper.BeerMapper;
import digital.innovation.one.TestesUnitAPIBera.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {
    public static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShoulBeCreated() throws BeerAlreadyRegisteredException{
        //givven
        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        BeerModel expectedSavedBeer = beerMapper.toModel(expectedBeerDTO);

        //when
        when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSavedBeer)).thenReturn(expectedSavedBeer);

        //then
        BeerDTO createdBeerDTO = beerService.createBeer(expectedBeerDTO);

        assertThat(createdBeerDTO.getId(), is(equalTo(expectedBeerDTO.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(expectedBeerDTO.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(expectedBeerDTO.getQuantity())));
    }
}

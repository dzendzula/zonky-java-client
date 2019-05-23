package org.zhezhela.zonky;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.zhezhela.zonky.dto.ZonkyLoanDto;
import org.zhezhela.zonky.service.ZonkyApiService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZonkyApplicationTests {

    @Autowired
    private ZonkyApiService zonkyService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer server;

    @Before
    public void setUp() throws Exception {

        server = MockRestServiceServer.createServer(restTemplate);

        ZonkyLoanDto loanDto = new ZonkyLoanDto();
        loanDto.setId(1L);
        loanDto.setAmount(BigDecimal.ONE);
        loanDto.setCurrency("CZK");
        String loanString =
                objectMapper.writeValueAsString(Collections.singletonList(loanDto));

        this.server.expect(requestTo("https://api.zonky.cz/loans/marketplace"))
                .andRespond(withSuccess(loanString, MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenCallingGetLoans_thenClientMakesCorrectCall()
            throws Exception {

        List<ZonkyLoanDto> loanDto = zonkyService.getLoans(null);

        assertThat(loanDto.size()).isEqualTo(1);
        assertThat(loanDto.get(0).getId()).isEqualTo(1L);
        assertThat(loanDto.get(0).getAmount()).isEqualTo(BigDecimal.ONE);
        assertThat(loanDto.get(0).getCurrency()).isEqualTo("CZK");
    }

}

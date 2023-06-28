package com.vetrov.wallet;

import com.vetrov.wallet.entity.dto.ProfileDtoConverter;
import com.vetrov.wallet.entity.dto.TransactionDtoConverter;
import com.vetrov.wallet.entity.dto.UserDtoConverter;
import com.vetrov.wallet.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
class CourseworkApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private TransactionsCategoryService transactionsCategoryService;

    @MockBean
    private RegisterService registerService;

    @MockBean
    private TransactionDtoConverter transactionDtoConverter;

    @MockBean
    private UserDtoConverter userDtoConverter;

    @MockBean
    private ProfileDtoConverter profileDtoConverter;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Here you can control your expenses.")));
    }

}

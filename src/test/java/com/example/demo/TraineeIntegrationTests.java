package com.example.demo;

import com.example.demo.common.Constants;
import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TraineeIntegrationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TraineeRepository traineeRepository;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		traineeRepository.deleteAll();
	}

	@Test
	void should_add_trainee_successfully_with_valid_data() throws Exception {
		Trainee trainee = Trainee.builder()
				.name("foo")
				.email("foo@thoughtworks.com")
				.office("foo")
				.github("foo")
				.zoomId("foo")
				.build();
		String traineeStr = objectMapper.writeValueAsString(trainee);

		mockMvc.perform(post("/trainees")
				.content(traineeStr)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id",is(1)))
				.andExpect(jsonPath("$.name",is("foo")))
				.andExpect(jsonPath("$.email",is("foo@thoughtworks.com")))
				.andExpect(jsonPath("$.office",is("foo")))
				.andExpect(jsonPath("$.github",is("foo")))
				.andExpect(jsonPath("$.zoomId",is("foo")));
	}

	@Test
	void should_throw_bad_request_if_trainee_has_empty_data() throws Exception {
		Trainee trainee = Trainee.builder()
				.name("")
				.email("foo@thoughtworks.com")
				.office("foo")
				.github("foo")
				.zoomId("foo")
				.build();
		String traineeStr = objectMapper.writeValueAsString(trainee);

		mockMvc.perform(post("/trainees")
				.content(traineeStr)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message",is(Constants.FIELD_INVALID_EXCEPTION_MESSAGE)))
				.andExpect(jsonPath("$.details.name",is(Constants.TRAINEE_NAME_NULL_EXCEPTION_MESSAGE)));
	}

	@Test
	void should_throw_bad_request_if_email_is_not_valid() throws Exception {
		Trainee trainee = Trainee.builder()
				.name("foo")
				.email("foo")
				.office("foo")
				.github("foo")
				.zoomId("foo")
				.build();
		String traineeStr = objectMapper.writeValueAsString(trainee);

		mockMvc.perform(post("/trainees")
				.content(traineeStr)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message",is(Constants.FIELD_INVALID_EXCEPTION_MESSAGE)))
				.andExpect(jsonPath("$.details.email",is(Constants.EMAIL_FORMAT_INVALID_EXCEPTION_MESSAGE)));
	}

	@Test
	void should_get_all_trainee_records() throws Exception {
		Trainee trainee = Trainee.builder()
				.name("foo")
				.email("foo@thoughtworks.com")
				.office("foo")
				.github("foo")
				.zoomId("foo")
				.build();
		String traineeStr = objectMapper.writeValueAsString(trainee);

		mockMvc.perform(post("/trainees")
				.content(traineeStr)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		mockMvc.perform(get("/trainees"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id",is(2)))
				.andExpect(jsonPath("$[0].name",is("foo")))
				.andExpect(jsonPath("$[0].email",is("foo@thoughtworks.com")))
				.andExpect(jsonPath("$[0].office",is("foo")))
				.andExpect(jsonPath("$[0].github",is("foo")))
				.andExpect(jsonPath("$[0].zoomId",is("foo")));
	}

}

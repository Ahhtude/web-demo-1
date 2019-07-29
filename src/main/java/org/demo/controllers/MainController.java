package org.demo.controllers;

import org.demo.exceptions.ApplicationLogicException;
import org.demo.response.BaseResponse;
import org.demo.response.SuccessResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Controller
public class MainController {
        org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MainController() {
        logger.info("Controller created");
        //System.out.println("Controller created");
    }

    @RequestMapping(value = {"/main/get-some-data", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<String[]> getSomeData(Integer param1, Double param2, String param3) throws ApplicationLogicException {
        logger.info("Controller method invoked");
        if (param1 == null) {
            throw new ApplicationLogicException("Param param1 is null");
        } else if (param2 == null) {
            throw new RuntimeException("Param2 is null");
        }
        List<String> data = jdbcTemplate.query("select * from SOME_DATA", new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("FIELD1");
            }
        });

        int valueTOadd = 9999999;
        jdbcTemplate.update("INSERT INTO SOME_DATA VALUES(?)",Integer.parseInt(param3));
        logger.info("Data was retrieved from dataBase");

        data.stream().forEach(System.out::println);

        SuccessResponse<String[]> response = new SuccessResponse<String[]>();
        response.setData(new String[]{"1111", "2222", "333"});
        return response;
    }



    @ExceptionHandler(ApplicationLogicException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleApplicationLogicException() {
        logger.info("Some error happens.");
        return "Some error happens.";
    }
}

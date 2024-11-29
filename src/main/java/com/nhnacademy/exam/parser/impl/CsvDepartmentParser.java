/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.exam.parser.impl;

import com.nhnacademy.exam.dto.DepartmentData;
import com.nhnacademy.exam.parser.DepartmentParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CsvDepartmentParser implements DepartmentParser {

    @Override
    public String getFileType() {
        return "csv";
    }

    @Override
    public List<DepartmentData> parsing(File file) throws IOException {

        List<DepartmentData> dataList = new ArrayList<>();

        CSVReader csvReader = new CSVReader(new FileReader(file));
        String[] nextLine;
        //헤드 라인
        try {
            csvReader.readNext();
            while (true) {
                nextLine = csvReader.readNext();

                if(nextLine == null || nextLine.length < 4) {
                    break;
                }

                dataList.add(new DepartmentData(
                        nextLine[0].trim(),
                        nextLine[1].trim(),
                        nextLine[2].trim(),
                        nextLine[3].trim()
                ));
            }

        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }
}
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TextDepartmentParser implements DepartmentParser {

    @Override
    public String getFileType() {
        return "txt";
    }

    @Override
    public List<DepartmentData> parsing(File file) throws IOException {
        List<DepartmentData> dataList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            // head 3줄
            for(int i=0; i<3; i++){bufferedReader.readLine();}

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");

                // 마지막 줄인지 검사 |--------|------
                if(data[1].contains("-")){
                    break;
                }

                // |사번             |이름             | 부서            |부서 코드          |
                // |20202201        |김이름            | 백엔드1팀        |L1001           |
                // data[0] 은 "" 이고 data[1]부터 시작
                dataList.add(new DepartmentData(
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        data[4].trim()
                ));

            }

        }



        return dataList;
    }
}

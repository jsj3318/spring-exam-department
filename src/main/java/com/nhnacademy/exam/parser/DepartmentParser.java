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

package com.nhnacademy.exam.parser;

import com.nhnacademy.exam.dto.DepartmentData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DepartmentParser {
     String getFileType();
     List<DepartmentData> parsing (File file) throws IOException;
     default boolean matchFileType(String fileName){
          return fileName.trim().toLowerCase().endsWith(getFileType().toLowerCase());
     }
}

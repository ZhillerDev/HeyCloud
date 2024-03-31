package io.zhiller.infrastructure.constants.common;

import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import java.util.HashMap;

@Data
@Builder
public class AjaxRequest implements Serializable {
  Integer code;
  String msg;
  HashMap<String, Object> data;
}

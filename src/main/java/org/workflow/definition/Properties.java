package org.workflow.definition;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Properties {

	private Map<String,Object> properties = new HashMap<>();
	
}

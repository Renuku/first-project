package org.workflow.definition;

import lombok.Data;

@Data
public class Transition {
	private String id;
	private String name;
	//TODO decide if fromNode is required or not ...
	private String fromNode;
	private String toNode;
	private Properties properties;
}

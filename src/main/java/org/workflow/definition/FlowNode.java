package org.workflow.definition;

import java.util.List;

import lombok.Data;

@Data
public class FlowNode {
	private String id;
	private String name;
	private String type;
	private Properties properties;
	private List<Transition> transitions;

}

package org.workflow.definition;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo( use=Id.NAME, property="type", defaultImpl=FlowNode.class , visible = true )
@JsonSubTypes({  
    @Type( name= "serviceTask", value = ServiceTaskNode.class)
    })
public class FlowNode {
	
	private String id;
	private String name;
	private String type;
	private Properties properties;
	private List<Transition> transitions;

}

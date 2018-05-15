package org.workflow.executor;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.workflow.definition.WorkflowDefinition;

@Repository
public class WorkFlowInstanceRepository {
	private static String COLLECTION_NAME = "workFlowInstance";
	private MongoTemplate mongoTemplate;

	public WorkFlowInstanceRepository(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	public void saveWorkFlowInstance(WorkFlowInstance instance) {
		mongoTemplate.save(instance, COLLECTION_NAME);
	}

	public WorkFlowInstance getWorkFlowInstance(String instanceId) {
		return mongoTemplate.findOne( getIdQuery(instanceId) , WorkFlowInstance.class, COLLECTION_NAME);
	}
	
	Query getIdQuery(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		return query;
	}
	
}

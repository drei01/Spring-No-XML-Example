package org.codefish.blog;

import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 * Object to hold a standard JSON response
 * @author Matthew
 */
public class JsonResponse {
	public enum Status {
		OK("200"), 
		ERROR("404");

		private String statuscode;

		private Status(String c) {
			statuscode = c;
		}

		@Override
		public String toString() {
			return statuscode;
		}
	}
	
	private Status status = Status.OK;
	private String message = "";
	private Map<String,Object> responseBody;

	public void put(String key, Object value){
		responseBody.put(key, value);
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonSerialize(using = JsonStatusSerializer.class)
	public Status getStatus() {
		return status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

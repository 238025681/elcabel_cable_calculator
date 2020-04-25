
package bg.elkabel.calculator.models.bind;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class RequestBindModel {
	
	@NotBlank(message = "error.request.notnull")
	private String cableName;
	
	@NotNull(message = "error.request.notnull")
	private Long length;

	public String getCableName() {
		return cableName;
	}

	public void setCableName(String cableName) {
		this.cableName = cableName;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	
}

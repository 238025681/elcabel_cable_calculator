package bg.elkabel.calculator.utils;

import bg.elkabel.calculator.entity.Material;
import bg.elkabel.calculator.models.view.RequestViewModel;

public class RequestPropertiesBuilder {

	public final int ZERO = 0;
	public final int CORE = 1;
	public final double REDUCE = 0.96;
	public final int REDUCE_PER_CAGE = 100;

	public RequestProperties createRequestProperties(RequestViewModel request) {

		RequestProperties result = null;
		if (request != null) {
			double coreWeight = request.getCable().getConductor().getCore().getWeight();
			int lenght = 0;
			int drumCapacity = request.getCable().getConductor().getMaterial().getCapacity();
			int totalDrums = request.getCable().getNumberOfConductors();
			long totalLenght = request.getLength();
			String conductorName = request.getCable().getConductor().getName();
			String coreName = request.getCable().getConductor().getCore().getName();
			Material material = request.getCable().getConductor().getMaterial();

			double totalWeight = totalLenght * coreWeight;

			int drumLenght = (int) ((drumCapacity / coreWeight) - ((drumCapacity / coreWeight) % 1000));
			if (drumLenght > totalLenght) {
				lenght = (int) totalLenght;
			} else {
				lenght = drumLenght;
			}
			int multiplier = (int) Math.ceil(totalWeight / drumCapacity);

			result = new RequestProperties(lenght, totalLenght, multiplier, totalDrums, conductorName, coreName, material);
		}

		return result;
	}

}

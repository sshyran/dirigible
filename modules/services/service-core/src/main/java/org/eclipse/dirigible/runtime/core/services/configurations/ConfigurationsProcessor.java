package org.eclipse.dirigible.runtime.core.services.configurations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.dirigible.commons.config.Configuration;

public class ConfigurationsProcessor {
	
	public List<List<String>> getConfigurations() {
		
		Map<String, String> runtimeVariables = Configuration.getRuntimeVariables();
		Map<String, String> environmentVariables = Configuration.getEnvironmentVariables();
		Map<String, String> deploymentVariables = Configuration.getDeploymentVariables();
		Map<String, String> moduleVariables = Configuration.getModuleVariables();
		
		List<List<String>> result = new ArrayList<List<String>>();
		for (String parameter : Configuration.getConfigurationParameters()) {
			List<String> row = new ArrayList<String>();
			row.add(parameter);
			row.add(runtimeVariables.get(parameter));
			row.add(environmentVariables.get(parameter));
			row.add(deploymentVariables.get(parameter));
			row.add(moduleVariables.get(parameter));
			result.add(row);
		}
		
		String customDataSourcesList = Configuration.get("DIRIGIBLE_DATABASE_CUSTOM_DATASOURCES");
		if ((customDataSourcesList != null) && !"".equals(customDataSourcesList)) {
			StringTokenizer tokens = new StringTokenizer(customDataSourcesList, ",");
			while (tokens.hasMoreTokens()) {
				String name = tokens.nextToken();
				
				String parameter = name + "_DRIVER";
				List<String> row = new ArrayList<String>();
				row.add(parameter);
				row.add(runtimeVariables.get(parameter));
				row.add(environmentVariables.get(parameter));
				row.add(deploymentVariables.get(parameter));
				row.add(moduleVariables.get(parameter));
				result.add(row);
				
				parameter = name + "_URL";
				row = new ArrayList<String>();
				row.add(parameter);
				row.add(runtimeVariables.get(parameter));
				row.add(environmentVariables.get(parameter));
				row.add(deploymentVariables.get(parameter));
				row.add(moduleVariables.get(parameter));
				result.add(row);
				
				parameter = name + "_USERNAME";
				row = new ArrayList<String>();
				row.add(parameter);
				row.add(runtimeVariables.get(parameter));
				row.add(environmentVariables.get(parameter));
				row.add(deploymentVariables.get(parameter));
				row.add(moduleVariables.get(parameter));
				result.add(row);
				
				parameter = name + "_PASSWORD";
				row = new ArrayList<String>();
				row.add(parameter);
				row.add(runtimeVariables.get(parameter));
				row.add(environmentVariables.get(parameter));
				row.add(deploymentVariables.get(parameter));
				row.add(moduleVariables.get(parameter));
				result.add(row);
			}
		}
		
		return result;
	}

}

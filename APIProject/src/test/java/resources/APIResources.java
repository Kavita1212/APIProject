package resources;

public enum APIResources {

	LoginAPI("api/login"),
	RegisterAPI("api/register"),
	LocationSearchAPI("locations/v2/search"),
	UpdateAPI("api/users/2");
	private String resource;

	APIResources(String resource) {
		
		this.resource=resource;

	}
	
	public String getResource()
	{
		return resource;
	}

}

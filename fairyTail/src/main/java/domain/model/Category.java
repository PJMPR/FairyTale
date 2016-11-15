package domain.model;

public enum Category {

	fantasy,drama,romance,horror,history,travel,dictionaries;
	
	public static Category getByName(String enumName){
   	 for (Category category : Category.values()) {
   		 if (category.toString().equalsIgnoreCase(enumName)){
   			 return category;
   		 }    	 
   	 }
   	 return null;
   }
}

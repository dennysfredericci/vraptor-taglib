# vraptor-taglib

* SelectItems 

	Declare:

		<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
	
	
	Definition and Usage:
		The <vraptor:selectItems> is used to create a drop-down list of HTML.
	
	Attributes: 
		list: 

* Validators support

	Declare:

		<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
	
	
	If error exists:
	
		<vraptor:hasErrors category="some.category">
			<!-- your code here -->
		</vraptor:hasErrors>
		
	Show errors:
	
		<vraptor:showErrors category="some.category" />
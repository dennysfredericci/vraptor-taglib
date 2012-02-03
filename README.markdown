# vraptor-taglib


* Validators support

	** Declare:

		<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
	
	
	** If error exists:
	
		<vraptor:hasErrors category="some.category">
			<!-- your code here -->
		</vraptor:hasErrors>
		
	** Show errors:
	
		<vraptor:showErrors category="some.category" />
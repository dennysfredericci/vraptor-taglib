# vraptor-taglib

Declare:

	<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>

* SelectItems 

	* Definition and Usage:
		The <vraptor:selectItems> is used to create a drop-down list of HTML.
	
	* Attributes:
		* list: Collection which contains the field's items. The field MUST a EL expression.
		* name: Defines a name for the drop-down list of HTML.
		* styleClass: Specifies one or more classnames for a HTML element.
		* value: Specifies the value of <option> elements to be sent to a server.
		* label: Specifies a shorter label for an option.


* Validators support

	Declare:

		<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>
	
	
	If error exists:
	
		<vraptor:hasErrors category="some.category">
			<!-- your code here -->
		</vraptor:hasErrors>
		
	Show errors:
	
		<vraptor:showErrors category="some.category" />
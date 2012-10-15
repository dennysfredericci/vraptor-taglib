# vraptor-taglib

Declare:

	<%@ taglib uri="http://vraptor.caelum.com.br/taglibs" prefix="vraptor" %>

* SelectItems 

	* Definition and Usage:
		The <vraptor:selectItems> is used to create a HTML <select> Tag which is a drop-down list.
	
	* Attributes:
		* list: Collection which contains the field's items. The field MUST a EL expression.
		* name: Defines a name for the <select> element.
		* id: Defines an id for the <select> element.
		* styleClass: Specifies one or more classnames for the <select> element.
		* style: Specifies an inline CSS style for the <select> element.
		* value: Specifies the value of <option> elements to be sent to a server. This value MUST be the atribute name of the list element.
		* label: Specifies a shorter label for the <option> elements. This label MUST be the atribute name of the list element.

	Example:

		<vraptor:selectItems name="user" list="${myUserList}" id="user" value="id" label="name" styleClass="cssClass" style="width: 330px;"/>


* Validators support
	
	If error exists:
	
		<vraptor:hasErrors category="some.category">
			<!-- your code here -->
		</vraptor:hasErrors>
		
	Show errors:
	
		<vraptor:showErrors category="some.category" />


if( !partyId || !firstName || !lastName)
{
    (
            ec.message.addError("Required Parameters missing : partyId,firstName and lastName are mandatory")
    )
    return
}

def party = ec.entity.find("Party")
                      .condition("partyId",partyId)
                        .one()

if(!party)
{
     ec.message.addError(" Valid Party Id required : NO such party exists")
    return
}
Map<String, Object> personFields = [
        partyId  : partyId,
        firstName: firstName,
        lastName : lastName
]

context.each { String key, Object value ->
    if (!personFields.containsKey(key)) {
        personFields.put(key, value)
    }
}

def personValue = ec.entity.makeValue("Person")
.setAll(personFields)
.create()

responseMessage= "Person : ${firstName} ${lastName} created successfully"



package com.tpe.hb02.embeddable;

import javax.persistence.Embeddable;

//  With @Embeddable, a table for Address won't be created, but fields in the Address class will be added to
// the Student02 table as columns
@Embeddable
public class Address {
}

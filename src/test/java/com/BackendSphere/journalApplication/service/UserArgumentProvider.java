package com.BackendSphere.journalApplication.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.BackendSphere.journalApplication.Entity.user;

import com.BackendSphere.journalApplication.Entity.user;

public class UserArgumentProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		// TODO Auto-generated method stub
		return Stream.of(
				Arguments.of(user.builder().username("shyaam").password("shyaam").build()),
				Arguments.of(user.builder().username("ram").password("ram").build())
				
				
				);
		
	}

}

package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Address;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Cidade;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.AddressRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.CidadeRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Component
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;
	
	@Autowired
	private CidadeRepository cRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade cMarcos = new Cidade();
		cMarcos.setName("Machado");
		cMarcos.setState("Minas Gerais");
		
		Cidade cLuiza = new Cidade();
		cLuiza.setName("Alfenas");
		cLuiza.setState("Minas Gerais");
		
		
		cRepo.save(cMarcos);
		cRepo.save(cLuiza);
		cRepo.flush();
		
		Address aMarcos = new Address();
		aMarcos.setPlace("R: ddsdasdfsdf");
		aMarcos.setNumber(60);
		aMarcos.setZipCode("37750-000");
		aMarcos.setCidade(cMarcos);
		
		Address aLuiza = new Address();
		aLuiza.setPlace("B");
		aLuiza.setNumber(2);
		aLuiza.setZipCode("456");
		aLuiza.setCidade(cLuiza);
		
		aRepo.save(aMarcos);
		aRepo.save(aLuiza);
		aRepo.flush();
		
		User Marcos = new User();
		Marcos.setName("Marcos Daniel ");
		Marcos.setEmail("marcos@gmail.com");
		Marcos.setGender("M");
		Marcos.setAddress(aMarcos);
		
		User luiza = new User();
		luiza.setName("Luiza Carvalho");
		luiza.setEmail("lu@mail.com");
		luiza.setGender("F");
		luiza.setAddress(aLuiza);
		
		uRepo.save(Marcos);
		uRepo.save(luiza);
	}
}

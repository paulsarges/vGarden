package formation.sopra.vgarden.services;

import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompteServices implements UserDetailsService{
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PasswordEncoder encoder;


	public Compte save(Compte c) {
		c.setPassword(encoder.encode(c.getPassword()));
		return compteRepo.save(c);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepo.findBylogin(username).orElseThrow(() ->
				new CompteException("compte inexistant"));
	}
}

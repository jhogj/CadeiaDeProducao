package processo.etapas;


import processo.repositorio.UserRepository;

import processo.servico.ProcessContext;

public class ValidateToken extends ProcessStep {

	public ValidateToken(Object... args) {
		super(args);
	}

	@Override
	public ProcessContext execute(ProcessContext context) throws Exception {
		String token = (String) context.get("token");
		String email = token.toLowerCase();
		Object user = UserRepository.getInstance().getUserByEmail(email);
		if(user == null) throw new Exception("Invalid token!");
		
		return next(context, true);
	}

}

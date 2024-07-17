package br.com.alura.forumhub.controller;



import br.com.alura.forumhub.domain.usuario.DadosAutenticacaoUsuario;
import br.com.alura.forumhub.domain.usuario.Usuario;
import br.com.alura.forumhub.infra.security.DadosJwtToken;
import br.com.alura.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DadosAutenticacaoUsuario dadosAutenticacaoUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dadosAutenticacaoUsuario.login(),
                dadosAutenticacaoUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JwtToken = tokenService.generateToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DadosJwtToken(JwtToken));
    }
}

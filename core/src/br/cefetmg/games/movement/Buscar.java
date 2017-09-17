package br.cefetmg.games.movement;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector2;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Buscar  {

    private final float  maxAceleracao;
    private final float  constanteVelocidade;
    public Buscar(float aceleracaoMax, float velocidadeConst) {
        this.maxAceleracao = aceleracaoMax;
        this.constanteVelocidade = velocidadeConst;
    }

    protected Buscar() {
        this.maxAceleracao = 500;
        this.constanteVelocidade=50;
    }

    public Direcionamento guiar(Pose agente, Vector2 alvo) {
        Direcionamento output = new Direcionamento();
        Vector2 aux = alvo;
        //acho q é algo assim
        aux.sub(agente.posicao);
        if(aux.len2()>maxAceleracao*maxAceleracao){//verifica o tamanho do vetor se for mto grande normaliza e multiplica pela maxAceleracao
            aux.nor();
            aux.scl(maxAceleracao);
        }
        output.aceleracao = aux;
        Vector2 auxV = new Vector2(agente.velocidade); 
        output.aceleracao.sub(auxV.scl(constanteVelocidade));//aceleracao = forca/m - kv
        //a rotacao ou direcao do bichinho nos podemos considerar q esta na direcao da velocidade
        //mas por meio da duvida acho q seria algo assim
//        output.rotacao=output.aceleracao.angleRad();
        output.rotacao=0;
        return output;
    }
    
    public Direcionamento chegar(Pose agente, Vector2 alvo, float raioAgente, float raioAlvoDesacelerar,float raioAlvoChegar){
        Direcionamento output = new Direcionamento();
        Vector2 aux = alvo;
        
        return output;
    };

}

package br.exemplo.lista;

import java.util.ArrayList;

/**
 * Exemplo desenvolvido para exemplificar comportamentos existentes em um {@link ArrayList}
 * 
 * @author Fernando God�y
 *
 */
public class ListaAlocacaoDinamica {

	private static final int FIRST_POSITION = 0;

	/**
	 * Capacidade de armazenamento padr�o da lista
	 */
	private static final Integer DEFAULT_VALUE = 10;
	
	/**
	 * Armazena a posi��o do �ltimo item inserido na lista
	 */
    private Integer currentPosition;
    
    /**
     * Armazena a capacidade de armazenamento quantida de posi��es dispon�veis
     */
    private Integer availablePositions;
    
    /**
     * Array onde os itens s�o armazenados
     */
    private String[] array;
    

    /**
     * Construtor padr�o 
     * 
     */
    public ListaAlocacaoDinamica() {
        array = new String[DEFAULT_VALUE];
        availablePositions = DEFAULT_VALUE;
        currentPosition = FIRST_POSITION;
       
    }

    /**
     * Respons�vel pela adi��o de valores a lista.</br>
     * Sempre que um novo item for inserido na lista o valor da posi��o atual
     * ser� incrementado uma posi��o na posi��o atual, que passar� a ter o valor do pr�ximo item a ser inserido, 
     * al�m de diminuir um posi��o dispon�vel.
     * 
     * 
     * @param texto
     * 
     */
    public void add(String value) {
    	checkAvailableLimit();
        array[currentPosition] = value;
        currentPosition++;
        availablePositions--;
    }

    /**
     * Respons�vel pela remo��o de itens da lista e reordena��o do itens posicionados a frente uma casa pra tr�s,
     * desta forma n�o ficar� buracos no meio da lista
     * 
     * @param index  posi��o onde se encontra o item a ser removido
     */
    public void remove(Integer index) {
    	for(int x = index; x < currentPosition; x++){
    		array[x] = array[x + 1];
    	}
    	currentPosition --;
        availablePositions++;
    }

    /**
     * Respons�vel por verificar se ser� necess�rio aumentar a capacidade do array
     */
    private void checkAvailableLimit() {
        if (availablePositions == 0) {
           upgradeCapacity();
        }
    }

    /**
     * Respons�vel por aumentar o tamanho do array sempre que necess�rio a inser��o de um novo item e o array
     * n�o contenha posi��es dispon�veis para armazear o item
     * 
     * @return
     */
    private void upgradeCapacity() {
        array = copyArrayValues();
        availablePositions = + DEFAULT_VALUE;
    }

    /**
     * Copia os valores existente no array, para um novo array
     * 
     * @param newArray array que receber� os valores j� armazenados noa array
     */
	private String[] copyArrayValues() {
		String[] newArray = new String[currentPosition + DEFAULT_VALUE];
		for(int x = FIRST_POSITION; x < currentPosition ; x++){
        	newArray[x] = array[x];
        }
		return newArray;
	}

    /**
     * Respons�vel por validar se a lista est� vazia
     * 
     * @return {@link Boolean#TRUE} se n�o houver mais espa�o para armazenamento na lista
     */
    public Boolean isEmpty() {
        return array.length == availablePositions;
    }

    /**
     * Retorna o valor armazendo na posi��o deseja.
     * 
     * @param index posi��o do item que se deseja
     * 
     * @return item encontrado na posi��o informada
     * 
     */
    public String get(Integer index) {
        return array[index];
    }

    /**
     * Respos�vel por retornar a quantidade de posi��es vazias na lista
     * 
     * @return N�mero de posi��es dispon�veis 
     */
    public Integer size() {
        return availablePositions;
    }
    
    /**
     * Descreve o itens da lista em formato de texto, ordenados por ordem de inser��o
     */
    @Override
    public String toString(){
    	String text = "";
    	if(!isEmpty()){
    		text = arrayPrint();
    	}
    	return text;
    }

    /**
     * Monta o texto a ser retornado
     * 
     * @return texto a ser exibido no {@link ListaAlocacaoDinamica#toString()}
     */
	private String arrayPrint() {
		String text;
		text = "[";
		for (int i = FIRST_POSITION; i < currentPosition; i++) {
			text += array[i] + ", ";
		}
		text = text.substring(0, text.length() - 2);
		text += "]";
		return text;
	}
}
